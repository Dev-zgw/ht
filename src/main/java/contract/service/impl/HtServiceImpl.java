package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import contract.dao.*;
import contract.pojo.*;
import contract.service.HtService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private HtflMapper htflMapper;

    @Autowired
    private HtqsMapper htqsMapper;


    //查询合同信息
    @Override
    public ServiceResponsebg<List<Ht>> query(Users user, int pageNum, int pageSize, String htfl, String qsrq,
                                          String fzr,String ssfzr,String htzt,String dqsheng,String dqshi,String je) {
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
            list=htMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }

        //总经理权限查看合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ZJL){
            list=htMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }

        //部门经理只能查看该部门的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_BMJL){
            //先查询该部门的所有用户
            List<Users> listUser=userMapper.select(user.getSsbm());

            for(int i=0;i<listUser.size();i++){
                //分别查询每个用户的合同
                List<Ht> htList=htMapper.selectyh(listUser.get(i).getId(),htfl,startTime,endTime,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
                for(int j=0;j<htList.size();j++){
                    //查询出的数据放入一个list集合中分页使用
                    list.add(htList.get(j));
                }
            }
        }

        //普通用户只能查看自己的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_CUSTOMER){
            list=htMapper.selectyh(user.getId(),htfl,startTime,endTime,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }

        //实施用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_SSYH){
            list=htMapper.selectss(user.getId(),htfl,startTime,endTime,fzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }
        //财务用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_CWQX){
            list=htMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
            for(int i=0;i<list.size();i++){
                list.get(i).setHtfl(htflMapper.selectByPrimaryKey(new BigDecimal(list.get(i).getHtfl())).getFlmc());
            }
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
        resultMapper.insertSelective(result);
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
}
