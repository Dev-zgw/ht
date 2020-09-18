package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import contract.dao.*;
import contract.pojo.*;
import contract.pojo.Reportpage.*;
import contract.service.ReportService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.calendar.BaseCalendar;

import java.io.Console;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
    private HtflMapper htflMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public ServerResponse<List<SignedContractFeeInfo>> selectChart4(Users user, String htfl, String qsrq,
                                                                    String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        Role role = roleMapper.selectByPrimaryKey(user.getJsid());
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1, date[0].toString().length()-1 );
            endTime = date[1].toString().substring(1, date[1].toString().length()-1);
        }
        List<SignedContractFeeInfo> list = new ArrayList<SignedContractFeeInfo>();
        //管理员/总经理查询所有合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_ADMIN || role.getQxid().longValue() == Const.Role.ROLE_ZJL) {
            list = reportMapper.selectChart4(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        }
        //部门经理只能查看该部门的合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_BMJL) {
            list = reportMapper.selectChart4(htfl, startTime, endTime, fzr, user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
        }

        //普通用户只能查看自己的合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_CUSTOMER) {
            list = reportMapper.selectChart4(htfl, startTime, endTime, user.getXm(), user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
        }
        //实施用户权限
        if (role.getQxid().longValue() == Const.Role.ROLE_SSYH) {
            list = reportMapper.selectChart4(htfl, startTime, endTime, fzr, fzrbm, user.getXm(), user.getSsbm(), dqsheng, dqshi);
        }
        //财务用户权限
        if (role.getQxid().longValue() == Const.Role.ROLE_CWQX) {
            list = reportMapper.selectChart4(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        }
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<List<getchart9info>> selectChart9(Users user, String htfl, String qsrq,
                                                            String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1, date[0].toString().length() - 1);
            endTime = date[1].toString().substring(1, date[1].toString().length() - 1);
        }
        List<SignedContractTypeInfo> list = reportMapper.selectChart9(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        List<getchart9info> list1 = new ArrayList<getchart9info>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).getHtfl();
            String value = list.get(i).getCount();
            Boolean selected = false;
            if (i == 0) {
                selected = true;
            }
            list1.add(new getchart9info(name, value, selected));
            System.out.print("list1          " + list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }



    @Override
    public ServerResponse<List<getchart9info>> selectChart9_sum(Users user, String htfl, String qsrq,
                                                                String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1, date[0].toString().length() - 1);
            endTime = date[1].toString().substring(1, date[1].toString().length() - 1);
        }
        List<SignedContractTypeInfo> list = reportMapper.selectChart9(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        List<getchart9info> list1 = new ArrayList<getchart9info>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).getHtfl();
            String value = list.get(i).getSum();
            Boolean selected = false;
            if (i == 0) {
                selected = true;
            }
            list1.add(new getchart9info(name, value, selected));
            System.out.print("list1 sum         " + list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }

    @Override
    public ServerResponse<List<getchart9info>> selectChart9_count(Users user, String htfl, String qsrq,
                                                                  String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1, date[0].toString().length() - 1);
            endTime = date[1].toString().substring(1, date[1].toString().length() - 1);
        }
        List<SignedContractTypeInfo> list = reportMapper.selectChart9(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        List<getchart9info> list1 = new ArrayList<getchart9info>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).getHtfl();
            String value = list.get(i).getCount();
            Boolean selected = false;
            if (i == 0) {
                selected = true;
            }
            list1.add(new getchart9info(name, value, selected));
            System.out.print("list1 count         " + list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }

    @Override
    public ServerResponse<List<getchart9info>> selectChart9_avg(Users user, String htfl, String qsrq,
                                                                String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1, date[0].toString().length() - 1);
            endTime = date[1].toString().substring(1, date[1].toString().length() - 1);
        }
        List<SignedContractTypeInfo> list = reportMapper.selectChart9(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        List<getchart9info> list1 = new ArrayList<getchart9info>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).getHtfl();
            String value = list.get(i).getAvg();
            Boolean selected = false;
            if (i == 0) {
                selected = true;
            }
            list1.add(new getchart9info(name, value, selected));
            System.out.print("list1 avg         " + list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }

    @Override
    public ServerResponse<List<String>> selectChart9_htfl(Users user, String htfl, String qsrq,
                                                          String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");
            startTime = date[0].toString().substring(1, date[0].toString().length() - 1);
            endTime = date[1].toString().substring(1, date[1].toString().length() - 1);
        }
        List<SignedContractTypeInfo> list = reportMapper.selectChart9(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        List<String> list1 = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).getHtfl();
            list1.add(name);
            System.out.print("list1 htfl         " + list1.get(i));
        }
        return ServerResponse.createBySuccess(list1);
    }

    @Override
    public ServerResponse<List<CurrentMonthSimpleInfo>> selectCurrentMonthSimpleInfo(Users user) {
        Role role = roleMapper.selectByPrimaryKey(user.getJsid());
        List<SimpHt> qdhtlist = new ArrayList<SimpHt>();
        List<SimpHtqs> fkhtlist = new ArrayList<SimpHtqs>();
        List<CurrentMonthSimpleInfo> currentMonthSimpleInfos = new ArrayList<CurrentMonthSimpleInfo>();
        int qdhtcount = 0, qdhtdqcount = 0, fkhtcount = 0, wfkhtcount = 0;
        double qdhtsum = 0.0d, fkhtsum = 0.0d, wfkhtsum = 0.0d;
        Date date = new Date();
        String currentmonth = new SimpleDateFormat("yyyy-MM").format(date);
        //查询本月合同基本信息
        if (role.getQxid().longValue() == Const.Role.ROLE_ZJL || role.getQxid().longValue() == Const.Role.ROLE_ADMIN || role.getQxid().longValue() == Const.Role.ROLE_CWQX) { //总经理&财务&管理员看到的是本月公司所有合同基本信息
            System.out.print(role.getQxid().longValue());
            qdhtlist = reportMapper.selectMonthHtInfo(currentmonth, "", "", "");
            fkhtlist = reportMapper.selectMonthFkInfo(currentmonth, "", "", "");
        } else if (role.getQxid().longValue() == Const.Role.ROLE_BMJL) {//部门经理看到的部门合同基本信息
            qdhtlist = reportMapper.selectMonthHtInfo(currentmonth, "", "", user.getXm());
            fkhtlist = reportMapper.selectMonthFkInfo(currentmonth, "", "", user.getXm());
        } else if (role.getQxid().longValue() == Const.Role.ROLE_SSYH) {//实施看到的是是自己部署的合同的基本信息
            qdhtlist = reportMapper.selectMonthHtInfo(currentmonth, "", user.getXm(), "");
            fkhtlist = reportMapper.selectMonthFkInfo(currentmonth, "", user.getXm(), "");
        } else {//其他权限的普通用户 看到的都是自己为负责人的合同的基本信息（）
            qdhtlist = reportMapper.selectMonthHtInfo(currentmonth, user.getXm(), "", "");
            fkhtlist = reportMapper.selectMonthFkInfo(currentmonth, user.getXm(), "", "");
        }
        qdhtcount = qdhtlist.size();
        List<String> dq = new ArrayList<String>();
        System.out.print("statr               " + " start");
        for (int j = 0; j < qdhtlist.size(); j++) {
            if (!dq.contains(qdhtlist.get(j).getDqsheng() + "_" + dq.contains(qdhtlist.get(j).getDqshi()))) {
                dq.add(qdhtlist.get(j).getDqsheng() + "_" + dq.contains(qdhtlist.get(j).getDqshi()));
            }
            if (qdhtlist.get(j).getHtje() == null || qdhtlist.get(j).getHtje() == "") {

            } else {
                qdhtsum += Double.parseDouble(qdhtlist.get(j).getHtje());
            }
        }
        for (int m = 0; m < fkhtlist.size(); m++) {
            if (("2").equals(fkhtlist.get(m).getIfsk())) { //已收款
                fkhtcount++;
                System.out.print(fkhtlist.get(m).getFkje());
                if (fkhtlist.get(m).getFkje() == null || ("").equals(fkhtlist.get(m).getFkje())) {

                } else {
                    fkhtsum += Double.parseDouble(fkhtlist.get(m).getFkje());
                }
            } else {//未收款
                wfkhtcount++;
                if (fkhtlist.get(m).getFkje() == null || ("").equals(fkhtlist.get(m).getFkje())) {

                } else {
                    wfkhtsum += Double.parseDouble(fkhtlist.get(m).getFkje());
                }
            }
        }
        qdhtdqcount = dq.size();

        currentMonthSimpleInfos.add(new CurrentMonthSimpleInfo(String.valueOf(qdhtcount), String.valueOf(qdhtsum), String.valueOf(qdhtdqcount), String.valueOf(fkhtcount), String.valueOf(fkhtsum), String.valueOf(wfkhtcount), String.valueOf(wfkhtsum)));
        return ServerResponse.createBySuccess(currentMonthSimpleInfos);
    }


    @Override
    public ServerResponse<List<FkHtInfoToQt>> selectFkhtSimpleInfo(Users user, String htfl, String qsrq,
                                                                   String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");

            startTime = date[0].toString().substring(1, date[0].toString().length() - 1);
            endTime = date[1].toString().substring(1, date[1].toString().length() - 1);
            System.out.println(startTime);
            System.out.println(endTime);
        }
        Role role = roleMapper.selectByPrimaryKey(user.getJsid());
        List<FkhtSimpleInfo> fkhtSimpleInfos = new ArrayList<FkhtSimpleInfo>();
        List<FkHtInfoToQt> fkHtInfoToQts = new ArrayList<FkHtInfoToQt>();

        //查询本月合同基本信息
        if (role.getQxid().longValue() == Const.Role.ROLE_ZJL || role.getQxid().longValue() == Const.Role.ROLE_ADMIN || role.getQxid().longValue() == Const.Role.ROLE_CWQX) { //总经理&财务&管理员看到的是本月公司所有合同基本信息
            fkhtSimpleInfos = reportMapper.selectFkHtInfo(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        } else if (role.getQxid().longValue() == Const.Role.ROLE_BMJL) {//部门经理看到的部门合同基本信息
            fkhtSimpleInfos = reportMapper.selectFkHtInfo(htfl, startTime, endTime, fzr, user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
        } else if (role.getQxid().longValue() == Const.Role.ROLE_SSYH) {//实施看到的是是自己部署的合同的基本信息
            fkhtSimpleInfos = reportMapper.selectFkHtInfo(htfl, startTime, endTime, fzr, fzrbm, user.getXm(), user.getSsbm(), dqsheng, dqshi);
        } else {//其他权限的普通用户 看到的都是自己为负责人的合同的基本信息（）
            fkhtSimpleInfos = reportMapper.selectFkHtInfo(htfl, startTime, endTime, user.getXm(), user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
        }
        List<String> httimes = new ArrayList<String>();
        List<String> yfkhtcounts = new ArrayList<String>();
        List<String> yfkhtjes = new ArrayList<String>();
        List<String> wfkhtcounts = new ArrayList<String>();
        List<String> wfkhtjes = new ArrayList<String>();
        for (int m = 0; m < fkhtSimpleInfos.size(); m++) {
            if (!httimes.contains(fkhtSimpleInfos.get(m).getHttime())) {
                if(fkhtSimpleInfos.get(m).getHttime()!=null)
                    httimes.add(fkhtSimpleInfos.get(m).getHttime());
            }
        }
        for (int k = 0; k < httimes.size(); k++) {
            String time = httimes.get(k);
            int yfkhtcount = 0, wfkhtcount = 0;
            double yfkhtje = 0.0d, wfkhtje = 0.0d;
            for (int j = 0; j < fkhtSimpleInfos.size(); j++) {
                try {
                    if (time.equals(fkhtSimpleInfos.get(j).getHttime())){
                        if (("2").equals(fkhtSimpleInfos.get(j).getIfsk())) { //已收款
                            yfkhtcount++;
                            if (fkhtSimpleInfos.get(j).getFkje() == null || ("").equals(fkhtSimpleInfos.get(j).getFkje())) {

                            }else{
                                yfkhtje+=Double.parseDouble(fkhtSimpleInfos.get(j).getFkje());
                            }

                        }else{
                            wfkhtcount++;
                            if (fkhtSimpleInfos.get(j).getFkje() == null || ("").equals(fkhtSimpleInfos.get(j).getFkje())) {

                            }else{
                                wfkhtje+=Double.parseDouble(fkhtSimpleInfos.get(j).getFkje());
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            yfkhtcounts.add(String.valueOf(yfkhtcount));
            yfkhtjes.add(String.valueOf(yfkhtje));
            wfkhtcounts.add(String.valueOf(wfkhtcount*-1));
            if(wfkhtje==0){
                wfkhtjes.add(String.valueOf(wfkhtje));
            }else{
                wfkhtjes.add(String.valueOf(wfkhtje*-1));
            }
        }
        fkHtInfoToQts.add(new FkHtInfoToQt(httimes,yfkhtcounts,yfkhtjes,wfkhtcounts,wfkhtjes));
        return ServerResponse.createBySuccess(fkHtInfoToQts);

    }

    @Override
    public ServiceResponsebg<List<ComplexHtqs>> selecthtqs(Users user, int pageNum, int pageSize, String htfl, String htbh, String qsrq, String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");

            startTime = date[0].toString().substring(1, date[0].toString().length() - 1);
            endTime = date[1].toString().substring(1, date[1].toString().length() - 1);
        }
        Role role = roleMapper.selectByPrimaryKey(user.getJsid());
        PageHelper.startPage(pageNum, pageSize);
        List<ComplexHtqs> list = new ArrayList<>();
        //总经理权限查看合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_ZJL || role.getQxid().longValue() == Const.Role.ROLE_ADMIN) {
            list = reportMapper.selecthtqs(htfl,htbh, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        }

        //部门经理只能查看该部门的合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_BMJL) {
            list = reportMapper.selecthtqs(htfl,htbh, startTime, endTime, fzr, user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
        }

        //普通用户只能查看自己的合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_CUSTOMER) {
            list = reportMapper.selecthtqs(htfl,htbh, startTime, endTime, user.getXm(), user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
        }

        //实施用户权限
        if (role.getQxid().longValue() == Const.Role.ROLE_SSYH) {
            list = reportMapper.selecthtqs(htfl,htbh, startTime, endTime, fzr, fzrbm, user.getXm(), user.getSsbm(), dqsheng, dqshi);
        }
        //财务用户权限
        if (role.getQxid().longValue() == Const.Role.ROLE_CWQX) {
            list = reportMapper.selecthtqs(htfl,htbh, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        }
        PageInfo<ComplexHtqs> pageInfo = new PageInfo<ComplexHtqs>(list);
        return ServiceResponsebg.createBySuccess(role.getQxid().longValue(), pageInfo.getTotal(), list);
    }


    @Override
    public ServiceResponsebg<List<ComplexHt>> queryPersonaltable(Users user, int pageNum, int pageSize, String htfl, String qsrq, String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");

            startTime = date[0].toString().substring(1, date[0].toString().length() - 1);
            endTime = date[1].toString().substring(1, date[1].toString().length() - 1);
        }
        Role role = roleMapper.selectByPrimaryKey(user.getJsid());
        PageHelper.startPage(pageNum, pageSize);
        List<ComplexHt> list = new ArrayList<>();
        //总经理权限查看合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_ZJL || role.getQxid().longValue() == Const.Role.ROLE_ADMIN) {
            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        }

        //部门经理只能查看该部门的合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_BMJL) {
            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, fzr, user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
        }

        //普通用户只能查看自己的合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_CUSTOMER) {
            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, user.getXm(), user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
        }

        //实施用户权限
        if (role.getQxid().longValue() == Const.Role.ROLE_SSYH) {
            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, fzr, fzrbm, user.getXm(), user.getSsbm(), dqsheng, dqshi);
        }
        //财务用户权限
        if (role.getQxid().longValue() == Const.Role.ROLE_CWQX) {
            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
        }
        PageInfo<ComplexHt> pageInfo = new PageInfo<ComplexHt>(list);
        return ServiceResponsebg.createBySuccess(role.getQxid().longValue(), pageInfo.getTotal(), list);
    }

    @Override
    public ServiceResponsebg<List<getComparedContractInfo>> queryComparedContractInfo(Users user, String htfl, String qsrq, String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi) {
        String startTime = "";
        String endTime = "";
        if (qsrq != "" && qsrq != null) {
            String date[] = qsrq.split(",");

            startTime = date[0].toString().substring(1, date[0].toString().length() - 1);
            endTime = date[1].toString().substring(1, date[1].toString().length() - 1);
        }
        Role role = roleMapper.selectByPrimaryKey(user.getJsid());
        List<ComplexHt> list = new ArrayList<>();
        List<String> contractType = new ArrayList<String>();
        List<String> queryType = new ArrayList<String>();
        List<getChartBasicInfo> series = new ArrayList<getChartBasicInfo>();
        List<Htfl> htfls=htflMapper.select();
        List<getComparedContractInfo> getComparedContractInfos = new ArrayList<getComparedContractInfo>();
        for(int n =0;n<htfls.size();n++){
            contractType.add(htfls.get(n).getFlmc());
        }
        //总经理权限查看部门的信息
        if (role.getQxid().longValue() == Const.Role.ROLE_ZJL || role.getQxid().longValue() == Const.Role.ROLE_ADMIN || role.getQxid().longValue() == Const.Role.ROLE_CWQX) {
            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
            List<Users> users = usersMapper.querybybm(user.getSsbm());
            List<Department> departments = departmentMapper.selectAll();
            for(int m = 0;m<departments.size();m++){
                if(departments.get(m).getPid().toString().equals("1"))
                    queryType.add(departments.get(m).getBmmc());
            }
            for(int k = 0;k<htfls.size();k++){
                List<String> data = new ArrayList<String>();
                for(int l =0;l<departments.size();l++){
                    Double personalSum=0.0d;
                    if(departments.get(l).getPid().toString().equals("1")) {
                        for (int q = 0; q < list.size(); q++) {
                            try {
                                if (usersMapper.selectByPrimaryKey(list.get(q).getFzrid()).getSsbm().equals(departments.get(l).getBmmc())) {
                                    if (list.get(q).getHtfl().equals(htfls.get(k).getFlmc()))
                                        if (list.get(q).getHtnrhtnr() != null)
                                            personalSum += list.get(q).getHtnrhtnr().doubleValue();
                                }
                            }catch (Exception e){
                                System.out.print("usersMapper.selectByPrimaryKey(list.get(q).getFzrid()).getSsbm().equals(departments.get(l).getBmmc())报错");
                                //e.printStackTrace();
                            }
                        }
                        data.add(personalSum.toString());
                    }
                }
                series.add(new getChartBasicInfo(htfls.get(k).getFlmc(),"总量","bar",data));
            }

            getComparedContractInfos.add(new getComparedContractInfo(contractType,queryType,series));
        }

        //部门经理只能查看该部门的合同信息
        if (role.getQxid().longValue() == Const.Role.ROLE_BMJL) {
            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, fzr, user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
            List<Users> users = usersMapper.querybybm(user.getSsbm());

            for(int m = 0;m<users.size();m++){
                if(users.get(m).getJsid().toString().equals("4"))
                    queryType.add(users.get(m).getXm());
            }
            for(int k = 0;k<htfls.size();k++){
                List<String> data = new ArrayList<String>();
                for(int l =0;l<users.size();l++){
                    Double personalSum=0.0d;
                    if(users.get(l).getJsid().toString().equals("4")) {
                        for (int q = 0; q < list.size(); q++) {
                            try {
                                if (list.get(q).getFzrid().equals(users.get(l).getId()) && list.get(q).getHtfl().equals(htfls.get(k).getFlmc())) {
                                    personalSum += list.get(q).getHtnrhtnr().doubleValue();
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        data.add(String.format("%.2f", personalSum).toString());
                    }
                }
                System.out.print(data);
                series.add(new getChartBasicInfo(htfls.get(k).getFlmc(),"总量","bar",data));
            }
            getComparedContractInfos.add(new getComparedContractInfo(contractType,queryType,series));
        }
//        //普通用户
//        if (role.getQxid().longValue() == Const.Role.ROLE_CUSTOMER) {
//            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, user.getXm(), user.getSsbm(), ssfzr, ssfzrbm, dqsheng, dqshi);
//            List<Users> users = usersMapper.querybybm(user.getSsbm());
//
//            for(int m = 0;m<users.size();m++){
//                queryType.add(users.get(m).getXm());
//            }
//            for(int k = 0;k<htfls.size();k++){
//                List<String> data = new ArrayList<String>();
//                for(int l =0;l<users.size();l++){
//                    Double personalSum=0.0d;
//                    for(int q=0;q<list.size();q++){
//                        try {
//                            if(list.get(q).getFzr().equals(users.get(l).getXm()))
//                                personalSum+=list.get(q).getHtnrhtnr().doubleValue();
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//                    }
//                    data.add(personalSum.toString());
//                }
//                series.add(new getChartBasicInfo(htfls.get(k).getFlmc(),"总量","bar",data));
//            }
//
//            getComparedContractInfos.add(new getComparedContractInfo(contractType,queryType,series));
//        }
//
//        //实施用户
//        if (role.getQxid().longValue() == Const.Role.ROLE_SSYH) {
//            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, fzr, fzrbm, user.getXm(), user.getSsbm(), dqsheng, dqshi);
//            List<Users> users = usersMapper.querybybm(user.getSsbm());
//
//            for(int m = 0;m<users.size();m++){
//                queryType.add(users.get(m).getXm());
//            }
//            for(int k = 0;k<htfls.size();k++){
//                List<String> data = new ArrayList<String>();
//                for(int l =0;l<users.size();l++){
//                    Double personalSum=0.0d;
//                    for(int q=0;q<list.size();q++){
//                        if(list.get(q).getFzr().equals(users.get(l).getXm()))
//                            personalSum+=list.get(q).getHtnrhtnr().doubleValue();
//                    }
//                    data.add(personalSum.toString());
//                }
//                series.add(new getChartBasicInfo(htfls.get(k).getFlmc(),"总量","bar",data));
//            }
//
//            getComparedContractInfos.add(new getComparedContractInfo(contractType,queryType,series));
//        }
//        //财务用户
//        if (role.getQxid().longValue() == Const.Role.ROLE_CWQX) {
//            list = reportMapper.selectPersonalTable(htfl, startTime, endTime, fzr, fzrbm, ssfzr, ssfzrbm, dqsheng, dqshi);
//            List<Users> users = usersMapper.querybybm(user.getSsbm());
//
//            for(int m = 0;m<users.size();m++){
//                queryType.add(users.get(m).getXm());
//            }
//            for(int k = 0;k<htfls.size();k++){
//                List<String> data = new ArrayList<String>();
//                for(int l =0;l<users.size();l++){
//                    Double personalSum=0.0d;
//                    for(int q=0;q<list.size();q++){
//                        if(list.get(q).getFzr().equals(users.get(l).getXm()))
//                            personalSum+=list.get(q).getHtnrhtnr().doubleValue();
//                    }
//                    data.add(personalSum.toString());
//                }
//                series.add(new getChartBasicInfo(htfls.get(k).getFlmc(),"总量","bar",data));
//            }
//
//            getComparedContractInfos.add(new getComparedContractInfo(contractType,queryType,series));
//        }
        return ServiceResponsebg.createBySuccess(getComparedContractInfos);
    }


    @Override
    public ServerResponse<List<Department>> querybm() {
        List<Department> departments = departmentMapper.selectDepartment1();
        return ServerResponse.createBySuccess(departments);
    }

    @Override
    public ServerResponse<List<Users>> queryfzrbybm(String bm) {
        List<Users> users = usersMapper.querybybm(bm);
        return ServerResponse.createBySuccess(users);
    }

    @Override
    public ServerResponse<List<Users>> queryssfzrbybm(String bm) {
        List<Users> users = usersMapper.queryssbybm(bm);
        return ServerResponse.createBySuccess(users);
    }

}
