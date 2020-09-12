package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import contract.dao.*;
import contract.pojo.*;
import contract.service.HtService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("htService")
public class HtServiceImpl implements HtService {

    @Autowired
    private HtMapper htMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UsersMapper userMapper;

    @Autowired
    private ResultMapper resultMapper;


    @Autowired
    private HtqsMapper htqsMapper;

    @Autowired
    private HtflMapper htflMapper;

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    //查询合同信息
    @Override
    public ServiceResponsebg<List<Ht>> query(Users user, int pageNum, int pageSize, String htfl, String qsrq,
                                          String fzr,String ssfzr,String htzt,String dqsheng,String dqshi,String je,
                                             String htbh,String sfjxfw) {
        String htjemin="";
        String htjemax="";
        if(("0").equals(je)){
            htjemin="0";
            htjemax="10";
        }else if(("1").equals(je)){
            htjemin="10";
            htjemax="30";
        }else if(("2").equals(je)){
            htjemin="30";
            htjemax="50";
        }else if(("3").equals(je)){
            htjemin="50";
            htjemax="100";
        }else if(("4").equals(je)){
            htjemin="100";
        }
        String startTime="";
        String endTime="";
        if(qsrq!=""&&qsrq!=null ) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
        }

        Role role=roleMapper.selectByPrimaryKey(user.getJsid());
        PageHelper.startPage(pageNum,pageSize);
        List<Ht> list=new ArrayList<>();
        //管理员查询所有合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ADMIN){
            list=htMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin,htbh,sfjxfw);
        }

        //总经理权限查看合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ZJL){
            list=htMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin,htbh,sfjxfw);
        }

        //部门经理只能查看该部门的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_BMJL){
            //分别查询每个用户的合同
            list=htMapper.selectyh(user.getSsbm(),htfl,startTime,endTime,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin,htbh,sfjxfw);
        }

        //普通用户只能查看自己的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_CUSTOMER){
            list=htMapper.selectfzr(user.getId(),htfl,startTime,endTime,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin,htbh,sfjxfw);
        }

        //实施用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_SSYH){
            list=htMapper.selectss(user.getId(),htfl,startTime,endTime,fzr,htzt,dqsheng,dqshi,htjemax,htjemin,htbh,sfjxfw);
        }
        //财务用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_CWQX){
          list=htMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin,htbh,sfjxfw);
        }
        PageInfo<Ht> pageInfo = new PageInfo<Ht>(list);
        return ServiceResponsebg.createBySuccess(role.getQxid().longValue(),pageInfo.getTotal(),list);
    }

    //修改合同信息
    @Override
    public ServerResponse update(Users users, Ht ht){
        ht.setUpdateTime(new Date());
        ht.setUpdateBy(users.getXm());
        int i=htMapper.updateByPrimaryKeySelective(ht);
        if (i <= 0) {
            Result result=new Result();
            result.setHtbh(ht.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同修改");
            result.setBz("合同修改失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createByErrorMessage("修改合同失败");
        }
        Result result=new Result();
        result.setHtbh(ht.getHtbh());
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("合同修改");
        result.setBz("合同修改成功");
        resultMapper.insertSelective(result);
        return ServerResponse.createBySuccessMessage("修改合同成功");
    }


    //新增合同
    @Override
    public ServerResponse xinzeng(Users users,Ht ht){
        Ht hts=htMapper.selects(ht.getHtbh());
        if(hts!=null){
            return ServerResponse.createByErrorMessage("合同编号已存在");
        }
        ht.setCreateTime(new Date());
        ht.setCreateBy(users.getXm());
        ht.setHtzt(String.valueOf(Const.HtState.TO_BE_CONFIRMED));
        int i=htMapper.insertSelective(ht);
        if (i <= 0) {
            Result result=new Result();
            result.setHtbh(ht.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同录入");
            result.setBz("合同录入失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createByErrorMessage("合同录入失败");
        }
        Result result=new Result();
        result.setHtbh(ht.getHtbh());
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("合同录入");
        result.setBz("合同录入成功");
        int j=resultMapper.insertSelective(result);
        try {
            //管理员完成合同录入-合同负责人收到 -- 合同确认短信
            messageServiceImpl.sendHtqr(userMapper.queryxm(ht.getFzr()).getSjhm(), ht.getFzr(),ht.getHtmc());
        }catch (Exception e){
            e.printStackTrace();
        }
        return ServerResponse.createBySuccessMessage("合同录入成功");
    }

    //删除合同
    @Override
    public ServerResponse delete(Users users,int id){
        Ht ht=htMapper.selectByPrimaryKey(new BigDecimal(id));
        if("1".equals(ht.getHtzt())||"2".equals(ht.getHtzt())){
            return ServerResponse.createByErrorMessage("合同状态为进行中或已完成，不能删除");
        }else{
            int i=htMapper.deleteByPrimaryKey(new BigDecimal(id));
            if (i <= 0) {
                Result result=new Result();
                result.setHtbh(ht.getHtbh());
                result.setUserid(users.getId());
                result.setXm(users.getXm());
                result.setCzsj(new Date());
                result.setCznr("合同删除");
                result.setBz("合同删除失败");
                resultMapper.insertSelective(result);
                return ServerResponse.createByErrorMessage("删除合同失败");
            }
            Result result=new Result();
            result.setHtbh(ht.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同删除");
            result.setBz("合同删除成功");
            resultMapper.insertSelective(result);
            return ServerResponse.createBySuccessMessage("删除合同成功");
        }
    }

    //修改合同状态
    @Override
    public ServerResponse updatezt(Users users, int id, String htzt) {
        Ht ht=htMapper.selectByPrimaryKey(new BigDecimal(id));
        Users usersbmjl=userMapper.querybmjl(users.getBmid(),new BigDecimal(3));
        List<Htqs> htqsList=htqsMapper.query(ht.getHtbh());
        if(("2").equals(htzt)) {
            int sk = 0;
            for (int j = 0; j < htqsList.size(); j++) {
                if (htqsList.get(j).getSfskwc().equals("1")) {
                    sk = sk + 1;
                }
            }
            if (sk >=1) {
                return ServerResponse.createByErrorMessage("有付款周期未完成收款，不能验收");
            }
        }
        int i=htMapper.updatezt(new BigDecimal(id),htzt);
        if(i>0){
            Result result=new Result();
            result.setHtbh(ht.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            if(htzt=="3"){
                result.setCznr("合同驳回");
                result.setBz("合同驳回成功");
            }else if(htzt=="1"){
                result.setCznr("合同确认");
                result.setBz("合同确认成功");
            }
            else if(htzt=="2"){
                result.setCznr("合同验收");
                result.setBz("合同验收成功");
            }
            resultMapper.insertSelective(result);
            if(htzt=="1"){
                try {
                    //合同负责人确认合同后 -- 部门经理收到 -- 合同签订短信
                    messageServiceImpl.sendHtqd(usersbmjl.getSjhm(),usersbmjl.getXm(),ht.getFzr(),ht.getHtmc());
                    //合同负责人确认合同后 -- 实施负责人收到 -- 通知短信
                    String a=ht.getFzr()+" ,联系方式："+users.getSjhm();
                    messageServiceImpl.sendTz(userMapper.queryxm(ht.getSsfzr()).getSjhm(),ht.getSsfzr(),ht.getYymc(),a);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if(htzt=="2"){
                try {
                    //财务确认合同款结清，合同负责人收到合同款结清短信
                    messageServiceImpl.sendHtkjq(userMapper.queryxm(ht.getFzr()).getSjhm(),ht.getFzr(),ht.getHtmc());
                    //财务确认合同款结清，部门经理收到合同款结清短信
                    String a=ht.getFzr()+" 所签约合同"+ht.getHtmc();
                    messageServiceImpl.sendHtkjq(usersbmjl.getSjhm(),usersbmjl.getXm(),a);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
        return ServerResponse.createBySuccessMessage("操作成功");
    }

    @Override
    public ServerResponse<List<Users>> queryfzr() {
        List<Users> users= userMapper.query();
        return ServerResponse.createBySuccess(users);
    }

    @Override
    public ServerResponse<List<Users>> queryssfzr() {
        List<Users> users= userMapper.queryss();
        return ServerResponse.createBySuccess(users);
    }

    //定时查询所有进行中的合同
    @Override
    public List<Ht> queryAll() {
        return htMapper.queryAll("1");
    }

    //定时器更改逾期状态
    @Override
    public int updateyqzt(int id, String htzt) {
        int i=htMapper.updatezt(new BigDecimal(id),htzt);
        return i;
    }

    //定时器更改逾期天数
    @Override
    public int updateyqts(int id, String yqts,String htsyts) {
        int i=htMapper.updateyqts(new BigDecimal(id),yqts,htsyts);
        return i;
    }

    @Override
    public ServerResponse daoru(List<Map<String, Object>> list) throws Exception {
        Ht ht=new Ht();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        //将excel表格中的数据写入到ht表中
        if(!list.isEmpty()){
            for (int i=0;i<list.size();i++) {
                Map<String, Object> map = list.get(i);
                if (isObjectNotEmpty(map.get("htbh"))) {
                    ht.setHtbh(map.get("htbh").toString());
                }
                if (isObjectNotEmpty(map.get("htmc"))) {
                    ht.setHtmc(map.get("htmc").toString());
                }
                if (isObjectNotEmpty(map.get("yymc"))) {
                    ht.setYymc(map.get("yymc").toString());
                }
                if (isObjectNotEmpty(map.get("dqsheng"))) {
                    ht.setDqsheng(map.get("dqsheng").toString());
                }
                if (isObjectNotEmpty(map.get("dqshi"))) {
                    ht.setDqsheng(map.get("dqshi").toString());
                }
                if (isObjectNotEmpty(map.get("htfl"))) {
                    ht.setHtfl(htflMapper.query(map.get("htfl").toString()).getId());
                }
                if (isObjectNotEmpty(map.get("yyjb"))) {
                    ht.setYyjb(map.get("yyjb").toString());
                }
                if (isObjectNotEmpty(map.get("qsrq"))) {
                    ht.setQsrq(sf.parse(map.get("qsrq").toString()));
                }
                if (isObjectNotEmpty(map.get("htqsrq"))) {
                    ht.setHtqsrq(sf.parse(map.get("htqsrq").toString()));
                }
                if (isObjectNotEmpty(map.get("htzzrq"))) {
                    ht.setHtzzrq(sf.parse(map.get("htzzrq").toString()));
                }
                if (isObjectNotEmpty(map.get("fzr"))) {
                    ht.setFzr(map.get("fzr").toString());
                    ht.setFzrid(userMapper.queryxm(map.get("fzr").toString()).getId());
                }
                if (isObjectNotEmpty(map.get("ssfzr"))) {
                    ht.setSsfzr(map.get("ssfzr").toString());
                    ht.setSsfzrid(userMapper.queryxm(map.get("ssfzr").toString()).getId());
                }
                if (isObjectNotEmpty(map.get("nywfje"))) {
                    ht.setNywfje(new BigDecimal(map.get("nywfje").toString()));
                }
                if (isObjectNotEmpty(map.get("xxkxm"))) {
                    ht.setXxkxm(map.get("xxkxm").toString());
                }
                if (isObjectNotEmpty(map.get("xxklxfs"))) {
                    ht.setXxklxfs(map.get("xxklxfs").toString());
                }
                if (isObjectNotEmpty(map.get("cwkxm"))) {
                    ht.setCwkxm(map.get("cwkxm").toString());
                }
                if (isObjectNotEmpty(map.get("cwklxfs"))) {
                    ht.setCwklxfs(map.get("cwklxfs").toString());
                }
                if (isObjectNotEmpty(map.get("ywdjr"))) {
                    ht.setYwdjr(map.get("ywdjr").toString());
                }
                if (isObjectNotEmpty(map.get("ywdjrlxfs"))) {
                    ht.setYwdjrlxfs(map.get("ywdjrlxfs").toString());
                }
                if (isObjectNotEmpty(map.get("sfgb"))) {
                    ht.setSfgb(map.get("sfgb").toString());
                }
                if (isObjectNotEmpty(map.get("sfjxfw"))) {
                    ht.setSfjxfw(map.get("sfjxfw").toString());
                }
                if (isObjectNotEmpty(map.get("yjqysj"))) {
                    ht.setYjqysj(sf.parse(map.get("yjqysj").toString()));
                }
                if (isObjectNotEmpty(map.get("xmqksm"))) {
                    ht.setXmqksm(map.get("xmqksm").toString());
                }
                if (isObjectNotEmpty(map.get("bz"))) {
                    ht.setBz(map.get("bz").toString());
                }
                if (isObjectNotEmpty(map.get("htzt"))) {
                    ht.setHtzt(map.get("htzt").toString());
                }
                htMapper.insertSelective(ht);
            }
        }
        return ServerResponse.createBySuccess("文件导入成功");
    }

    /**
     * 判断Object对象为空或空字符串
     * @param obj
     * @return
     */
    public static Boolean isObjectNotEmpty(Object obj) {
        String str = ObjectUtils.toString(obj, null);
        return StringUtils.isNotBlank(str);
    }
}
