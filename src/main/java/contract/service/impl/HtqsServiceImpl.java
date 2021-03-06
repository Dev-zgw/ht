package contract.service.impl;

import contract.dao.HtMapper;
import contract.dao.HtqsMapper;
import contract.dao.ResultMapper;
import contract.dao.UsersMapper;
import contract.pojo.Ht;
import contract.pojo.Htqs;
import contract.pojo.Result;
import contract.pojo.Users;
import contract.service.HtqsService;
import contract.utils.ServerResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("htqsService")
public class HtqsServiceImpl implements HtqsService {

    @Autowired
    private HtqsMapper htqsMapper;

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private UsersMapper userMapper;

    @Autowired
    private HtMapper htMapper;

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    /**
     * 根据合同编码查询合同期数
     * @param users
     * @param htbh
     * @return
     */
    @Override
    public ServerResponse<List<Htqs>> query(Users users, String htbh) {
        List<Htqs> htqsList=htqsMapper.query(htbh);
        return ServerResponse.createBySuccess(htqsList);
    }

    /**
     * 合同期数修改
     * @param users
     * @param htqs
     * @return
     */
    @Override
    public ServerResponse update(Users users, Htqs htqs) {
        htqs.setUpdateTime(new Date());
        htqs.setUpdateBy(users.getXm());
        int i=htqsMapper.updateByPrimaryKeySelective(htqs);
        if(i <= 0){
            Result result=new Result();
            result.setHtbh(htqs.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同期数修改");
            result.setBz("合同期数修改失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createByErrorMessage("修改合同期数失败");
        }
        Result result=new Result();
        result.setHtbh(htqs.getHtbh());
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("合同期数修改");
        result.setBz("合同期数修改成功");
        resultMapper.insertSelective(result);
        return ServerResponse.createBySuccessMessage("合同期数修改成功");
    }

    /**
     * 合同期数录入
     * @param users
     * @param htqs
     * @return
     */
    @Override
    public ServerResponse xinzeng(Users users, Htqs htqs) {
        htqs.setCreateTime(new Date());
        htqs.setCreateBy(users.getXm());
        htqs.setSfskwc("1");
        htqs.setSgyq("1");
        int i=htqsMapper.insertSelective(htqs);
        if(i<=0){
            Result result=new Result();
            result.setHtbh(htqs.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同期数录入");
            result.setBz("合同期数录入失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createByErrorMessage("合同期数录入失败");
        }
        Result result=new Result();
        result.setHtbh(htqs.getHtbh());
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("合同期数录入");
        result.setBz("合同期数录入成功");
        resultMapper.insertSelective(result);
        return ServerResponse.createBySuccessMessage("合同期数录入成功");
    }

    /**
     * 合同期数删除
     * @param users
     * @param id
     * @return
     */
    @Override
    public ServerResponse delete(Users users, int id) {
        Htqs htqs=htqsMapper.selectByPrimaryKey(new BigDecimal(id));
        if("2".equals(htqs.getSfskwc())){
            return ServerResponse.createByErrorMessage("该分期已收款完成，不能删除");
        }else{
            int i=htqsMapper.deleteByPrimaryKey(new BigDecimal(id));
            if(i<=0){
                Result result=new Result();
                result.setHtbh(htqs.getHtbh());
                result.setUserid(users.getId());
                result.setXm(users.getXm());
                result.setCzsj(new Date());
                result.setCznr("合同期数删除");
                result.setBz("合同期数删除失败");
                resultMapper.insertSelective(result);
                return ServerResponse.createByErrorMessage("合同期数删除失败");
            }
            Result result=new Result();
            result.setHtbh(htqs.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同期数删除");
            result.setBz("合同期数删除成功");
            resultMapper.insertSelective(result);
            return ServerResponse.createBySuccessMessage("合同期数删除成功");
        }
    }

    @Override
    public ServerResponse htqsxg(Users users, int id, String htfqzt) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年");
        Htqs htqs=htqsMapper.selectByPrimaryKey(new BigDecimal(id));
        Ht ht= htMapper.selects(htqs.getHtbh());
        Users user=userMapper.queryxm(ht.getFzr());
        Users usersbmjl=userMapper.querybmjl(user.getBmid(),new BigDecimal(3));
        int i=htqsMapper.updatezt(new BigDecimal(id),htfqzt);
        if(i<=0){
            Result result=new Result();
            result.setHtbh(htqs.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同期数验收失败");
            result.setBz("合同期数验收失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createBySuccessMessage("操作失败");
        }
        try{
            //财务确认合同款结清，合同负责人收到合同款结清短信
            String a=ht.getHtmc()+sf.format(htqs.getYjsj());
            String b=ht.getHtnrhtnr().toString()+"万元";
            messageServiceImpl.sendHtkjq4(userMapper.queryxm(ht.getFzr()).getSjhm(),ht.getFzr(),ht.getYymc(),a,b);
            //财务确认合同款结清，部门经理收到合同款结清短信
            String c=ht.getHtmc()+"第"+sf.format(htqs.getYjsj())+"期";
            String d=ht.getHtnrhtnr().toString()+"万元";
            messageServiceImpl.sendHtkjq3(usersbmjl.getSjhm(),usersbmjl.getXm(),ht.getFzr(),ht.getYymc(),c,d);
        }catch (Exception e){
            e.printStackTrace();
        }

        Result result=new Result();
        result.setHtbh(htqs.getHtbh());
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("合同期数验收成功");
        result.setBz("合同期数验收成功");
        resultMapper.insertSelective(result);
        return ServerResponse.createBySuccessMessage("操作成功");
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
    @Override
    public ServerResponse daoru(List<Map<String, Object>> list) throws Exception {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        //将excel表格中的数据写入到htqs表中
        if(!list.isEmpty()){
            for (int i=0;i<list.size();i++){
                Map<String, Object> map=list.get(i);
                Htqs htqs=new Htqs();
                if (isObjectNotEmpty(map.get("htbh"))) {
                    htqs.setHtbh(map.get("htbh").toString());
                }
                if (isObjectNotEmpty(map.get("je"))) {
                    htqs.setJe(new BigDecimal(map.get("je").toString()));
                }else{
                    continue;
                }
                if (isObjectNotEmpty(map.get("yjsj"))) {
                    htqs.setYjsj(sf.parse(map.get("yjsj").toString()));
                }
                if (isObjectNotEmpty(map.get("ssfzr"))) {
                    htqs.setSsfzr(map.get("ssfzr").toString());
                    htqs.setSsfzrid(userMapper.queryxm(map.get("ssfzr").toString()).getId());
                }
                if (isObjectNotEmpty(map.get("bz"))) {
                    htqs.setBz(map.get("bz").toString());
                }
                if (isObjectNotEmpty(map.get("sfskwc"))) {
                    htqs.setSfskwc(map.get("sfskwc").toString());
                }
                htqsMapper.insertSelective(htqs);
            }
        }
        return ServerResponse.createBySuccess("文件导入成功");
    }
}
