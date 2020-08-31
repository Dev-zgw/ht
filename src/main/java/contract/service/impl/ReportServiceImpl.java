package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import contract.dao.*;
import contract.pojo.*;
import contract.service.ReportService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/7 16:35
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private HtflMapper htflMapper;

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public ServerResponse<List<Chart1>> selectChart1(Users user, String htfl, String qsrq,
                                                     String fzr, String fzrbm, String ssfzr, String ssfzrbm,String dqsheng,String dqshi) {
        String startTime="";
        String endTime="";
        Role role=roleMapper.selectByPrimaryKey(user.getJsid());
        if(qsrq!=""&&qsrq!=null ) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
        }
        List<Chart1> list = new ArrayList<Chart1>();
        //管理员/总经理查询所有合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ADMIN || role.getQxid().longValue()== Const.Role.ROLE_ZJL){
            list = reportMapper.selectChart1(htfl,startTime, endTime,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
        }
        //部门经理只能查看该部门的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_BMJL){
            list = reportMapper.selectChart1(htfl,startTime, endTime,fzr,user.getSsbm(),ssfzr,ssfzrbm,dqsheng,dqshi);
        }

        //普通用户只能查看自己的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_CUSTOMER){
            list = reportMapper.selectChart1(htfl,startTime, endTime,user.getXm(),user.getSsbm(),ssfzr,ssfzrbm,dqsheng,dqshi);
        }
            //实施用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_SSYH){
            list = reportMapper.selectChart1(htfl,startTime, endTime,fzr,fzrbm,user.getXm(),user.getSsbm(),dqsheng,dqshi);
        }
        //财务用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_CWQX){
            list = reportMapper.selectChart1(htfl,startTime, endTime,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
        }
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<List<Chart5>> selectChart5(Users user, String qsrq) {
        String startTime="";
        String endTime="";
        if(qsrq!=""&&qsrq!=null ) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
        }
        List<Chart5> list = reportMapper.selectChart5(startTime,endTime);

        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<List<getchart9info>> selectChart9(Users user, String htfl, String qsrq,
                                                            String fzr, String fzrbm, String ssfzr, String ssfzrbm,String dqsheng,String dqshi) {
        String startTime="";
        String endTime="";
        if(qsrq!=""&&qsrq!=null ) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
        }
        List<Chart9> list = reportMapper.selectChart9(htfl,startTime, endTime,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
        List<getchart9info> list1  = new ArrayList<getchart9info>();
        for(int i = 0;i<list.size();i++){
            String name = list.get(i).getHtfl();
            String value = list.get(i).getCount();
            Boolean selected = false;
            if(i==0){
                selected = true;
            }
            list1.add(new getchart9info(name,value,selected));
            System.out.print("list1          "+list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }

//    @Override
//    public ServerResponse<List<Chart6>> selectChart6(Users user, String qsrq,String htfl,String fzr, String fzrbm,String dqsheng,String dqshi){
//        String startTime="";
//        String endTime="";
//        if(qsrq!=""&&qsrq!=null ) {
//            String date[] = qsrq.split(",");
//            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
//            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
//        }
//        //List<Chart6> list = reportMapper.selectChart6(startTime,endTime);
//        List<Htfl> htfls = htflMapper.select();
//        for(int i =0;i<htfls.size();i++){
//            String flmc = htfls.get(i).getFlmc();
//            List<String> value = new ArrayList<String>();
//            List<Department> departments = departmentMapper.selectAll();
//            List<getchart6info> info = new ArrayList<getchart6info>();
//            for(int j =0;j<departments.size();j++){
//                List<Chart6> list2 = reportMapper.selectChart6(startTime,endTime,"",departments.get(j).getBmmc(),"","");
//                if(list2.size()>0){
//                    value.add(list2.get(j).getSum());
//                }
//            }
//            info.add(new getchart6info(flmc,"bar","bar",value));
//        }
//        //return ServerResponse.createBySuccess(list2);
//        return null;
//    }
//
//    @Override
//    public ServerResponse<List<String>> selectChart6_htfl(Users user, String qsrq, String htfl, String fzr, String fzrbm, String dqsheng, String dqshi) {
//        return null;
//    }
//
//    @Override
//    public ServerResponse<List<String>> selectChart6_sum(Users user, String qsrq, String htfl, String fzr, String fzrbm, String dqsheng, String dqshi) {
//        return null;
//    }


    @Override
    public ServerResponse<List<getchart9info>> selectChart9_sum(Users user, String htfl, String qsrq,
                                                                String fzr, String fzrbm, String ssfzr, String ssfzrbm,String dqsheng,String dqshi) {
        String startTime="";
        String endTime="";
        if(qsrq!=""&&qsrq!=null ) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
        }
        List<Chart9> list = reportMapper.selectChart9(htfl,startTime, endTime,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
        List<getchart9info> list1  = new ArrayList<getchart9info>();
        for(int i = 0;i<list.size();i++){
            String name = list.get(i).getHtfl();
            String value = list.get(i).getSum();
            Boolean selected = false;
            if(i==0){
                selected = true;
            }
            list1.add(new getchart9info(name,value,selected));
            System.out.print("list1 sum         "+list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }

    @Override
    public ServerResponse<List<getchart9info>> selectChart9_count(Users user, String htfl, String qsrq,
                                                                  String fzr, String fzrbm, String ssfzr, String ssfzrbm,String dqsheng,String dqshi) {
        String startTime="";
        String endTime="";
        if(qsrq!=""&&qsrq!=null ) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
        }
        List<Chart9> list = reportMapper.selectChart9(htfl,startTime, endTime,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
        List<getchart9info> list1  = new ArrayList<getchart9info>();
        for(int i = 0;i<list.size();i++){
            String name = list.get(i).getHtfl();
            String value = list.get(i).getCount();
            Boolean selected = false;
            if(i==0){
                selected = true;
            }
            list1.add(new getchart9info(name,value,selected));
            System.out.print("list1 count         "+list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }

    @Override
    public ServerResponse<List<getchart9info>> selectChart9_avg(Users user, String htfl, String qsrq,
                                                                String fzr, String fzrbm, String ssfzr, String ssfzrbm,String dqsheng,String dqshi) {
        String startTime="";
        String endTime="";
        if(qsrq!=""&&qsrq!=null ) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
        }
        List<Chart9> list = reportMapper.selectChart9(htfl,startTime, endTime,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
        List<getchart9info> list1  = new ArrayList<getchart9info>();
        for(int i = 0;i<list.size();i++){
            String name = list.get(i).getHtfl();
            String value = list.get(i).getAvg();
            Boolean selected = false;
            if(i==0){
                selected = true;
            }
            list1.add(new getchart9info(name,value,selected));
            System.out.print("list1 avg         "+list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }

    @Override
    public ServerResponse<List<String>> selectChart9_htfl(Users user, String htfl, String qsrq,
                                                                String fzr, String fzrbm, String ssfzr, String ssfzrbm,String dqsheng,String dqshi) {
        String startTime="";
        String endTime="";
        if(qsrq!=""&&qsrq!=null ) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
        }
        List<Chart9> list = reportMapper.selectChart9(htfl,startTime, endTime,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
        List<String> list1 = new ArrayList<String>();
        for(int i = 0;i<list.size();i++){
            String name = list.get(i).getHtfl();
            list1.add(name);
            System.out.print("list1 htfl         "+list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }

    @Override
    public ServerResponse<List<Place>> selectSheng() {
        List<Place> sheng= reportMapper.selectSheng();
        return ServerResponse.createBySuccess(sheng);
    }

    @Override
    public ServerResponse<List<Currentinfo>> selectPersonalcurrentinfo(Users user) {
        Role role=roleMapper.selectByPrimaryKey(user.getJsid());
        List<Currentinfo> list = new ArrayList<Currentinfo>();
        //总经理权限查看合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ZJL || role.getQxid().longValue()== Const.Role.ROLE_ADMIN || role.getQxid().longValue()== Const.Role.ROLE_CWQX){
            list = reportMapper.selectCompanycurrentinfo();
        }else if(role.getQxid().longValue()== Const.Role.ROLE_BMJL){
            list = reportMapper.selectDepartmentcurrentinfo(user.getXm());
        }else if(role.getQxid().longValue()== Const.Role.ROLE_SSYH){
            list = reportMapper.selectPersonalsscurrentinfo(user.getXm());
        }else{
            list = reportMapper.selectPersonalcurrentinfo(user.getXm());
        }
        if(list.size()<=0){
            Currentinfo a = new Currentinfo();
            a.setAvg("0");
            a.setCount("0");
            a.setSum("0");
            list.add(a);
        }
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<List<Currentinfo>> selectDepartmentcurrentinfo(String fzr) {
        List<Currentinfo> list = reportMapper.selectDepartmentcurrentinfo(fzr);
        if(list.size()<=0){
            Currentinfo a = new Currentinfo();
            a.setAvg("0");
            a.setCount("0");
            a.setSum("0");
            list.add(a);
        }
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<List<Currentinfo>> selectCompanycurrentinfo() {
        List<Currentinfo> list = reportMapper.selectCompanycurrentinfo();
        if(list.size()<=0){
            Currentinfo a = new Currentinfo();
            a.setAvg("0");
            a.setCount("0");
            a.setSum("0");
            list.add(a);
        }
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServiceResponsebg<List<Ht>> queryPersonaltable(Users user, int pageNum, int pageSize, String htfl, String qsrq, String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        System.out.print("                         qsrq"+qsrq);
        String startTime="";
        String endTime="";
        if(qsrq!=""&&qsrq!=null ) {
            String date[] = qsrq.split(",");

            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
            System.out.println(startTime);
            System.out.println(endTime);
        }
        Role role=roleMapper.selectByPrimaryKey(user.getJsid());
        PageHelper.startPage(pageNum,pageSize);
        List<Ht> list=new ArrayList<>();
        //总经理权限查看合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ZJL || role.getQxid().longValue()== Const.Role.ROLE_ADMIN){
            list=reportMapper.selectPersonalTable(htfl,startTime,endTime,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
        }

        //部门经理只能查看该部门的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_BMJL){
            list=reportMapper.selectPersonalTable(htfl,startTime,endTime,fzr,user.getSsbm(),ssfzr,ssfzrbm,dqsheng,dqshi);
        }

        //普通用户只能查看自己的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_CUSTOMER){
            list=reportMapper.selectPersonalTable(htfl,startTime,endTime,user.getXm(),user.getSsbm(),ssfzr,ssfzrbm,dqsheng,dqshi);
        }

        //实施用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_SSYH){
            list=reportMapper.selectPersonalTable(htfl,startTime,endTime,fzr,fzrbm,user.getXm(),user.getSsbm(),dqsheng,dqshi);
        }
        //财务用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_CWQX){
            list=reportMapper.selectPersonalTable(htfl,startTime,endTime,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
        }
        PageInfo<Ht> pageInfo = new PageInfo<Ht>(list);
        return ServiceResponsebg.createBySuccess(role.getQxid().longValue(),pageInfo.getTotal(),list);
    }

    //查询合同信息
    @Override
    public ServiceResponsebg<List<Ht>> query(Users user, int pageNum, int pageSize, String htfl, String qsrq,
                                             String fzr, String ssfzr, String htzt, String dqsheng, String dqshi, String je) {
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
            list=reportMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }

        //总经理权限查看合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ZJL){
            list=reportMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }

        //部门经理只能查看该部门的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_BMJL){
            //先查询该部门的所有用户
            List<Users> listUser=usersMapper.select(user.getSsbm());

            for(int i=0;i<listUser.size();i++){
                //分别查询每个用户的合同
                List<Ht> htList=reportMapper.selectyh(listUser.get(i).getId(),htfl,startTime,endTime,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
                list.addAll(htList);
            }
        }

        //普通用户只能查看自己的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_CUSTOMER){
            list=reportMapper.selectyh(user.getId(),htfl,startTime,endTime,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }

        //实施用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_SSYH){
            list=reportMapper.selectss(user.getId(),htfl,startTime,endTime,fzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }
        //财务用户权限
        if(role.getQxid().longValue()== Const.Role.ROLE_CWQX){
            list=reportMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }
        PageInfo<Ht> pageInfo = new PageInfo<Ht>(list);
        return ServiceResponsebg.createBySuccess(role.getQxid().longValue(),pageInfo.getTotal(),list);
    }

    //查询合同信息
    @Override
    public ServiceResponsebg<List<Ht>> queryall(Users user, int pageNum, int pageSize, String htfl, String qsrq,
                                             String fzr, String ssfzr, String htzt, String dqsheng, String dqshi, String je) {
        String htjemin="";
        String htjemax="";
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
        //总经理权限查看合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ZJL){
            list=reportMapper.select(htfl,startTime,endTime,fzr,ssfzr,htzt,dqsheng,dqshi,htjemax,htjemin);
        }
        PageInfo<Ht> pageInfo = new PageInfo<Ht>(list);
        return ServiceResponsebg.createBySuccess(role.getQxid().longValue(),pageInfo.getTotal(),list);
    }

    @Override
    public ServerResponse<List<Department>> querybm() {
        List<Department> departments= departmentMapper.selectAll();
        return ServerResponse.createBySuccess(departments);
    }

    @Override
    public ServerResponse<List<Users>> queryfzrbybm(String bm) {
        List<Users> users= usersMapper.querybybm(bm);
        return ServerResponse.createBySuccess(users);
    }

    @Override
    public ServerResponse<List<Users>> queryssfzrbybm(String bm) {
        List<Users> users= usersMapper.queryssbybm(bm);
        return ServerResponse.createBySuccess(users);
    }

}
