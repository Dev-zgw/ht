package contract.service;

import contract.pojo.*;
import contract.pojo.Reportpage.*;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;

import java.util.List;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/7 16:34
 */
public interface ReportService {

        ServerResponse<List<Chart4>> selectChart4(Users user, String htfl, String qsrq,
                                                  String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi);

        ServerResponse<List<Chart5>> selectChart5(Users user, String qsrq);

        ServerResponse<List<getchart6info>> selectChart6(Users user, String qsrq, String htfl, String fzr, String fzrbm, String dqsheng, String dqshi);
        ServerResponse<List<String>> selectChart6_htfl(Users user, String qsrq,String htfl,String fzr, String fzrbm,String dqsheng,String dqshi);
        ServerResponse<List<String>> selectChart6_sum(Users user, String qsrq,String htfl,String fzr, String fzrbm,String dqsheng,String dqshi);

        ServerResponse<List<getchart9info>> selectChart9(Users user, String htfl, String qsrq,
                                                         String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi);

        ServerResponse<List<getchart9info>> selectChart9_sum(Users user, String htfl, String qsrq,
                                                             String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi);

        ServerResponse<List<getchart9info>> selectChart9_count(Users user, String htfl, String qsrq,
                                                               String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi);

        ServerResponse<List<getchart9info>> selectChart9_avg(Users user, String htfl, String qsrq,
                                                             String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi);

        ServerResponse<List<String>> selectChart9_htfl(Users user, String htfl, String qsrq,
                                                             String fzr,String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi);

        ServerResponse<List<Currentinfo>> selectPersonalcurrentinfo(Users user);


        ServerResponse<List<Currentinfo>> selectDepartmentcurrentinfo(String fzr);

        ServerResponse<List<Currentinfo>> selectCompanycurrentinfo();

        //本月签署合同信息
        ServerResponse<List<CurrentMonthSimpleInfo>> selectCurrentMonthSimpleInfo(Users user);

        //按条件筛选付款合同信息
        ServerResponse<List<FkHtInfoToQt>> selectFkhtSimpleInfo(Users user, String htfl, String qsrq,
                                                                String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi);

        //查询合同htqs
        ServiceResponsebg<List<ComplexHtqs>> selecthtqs(Users user, int pageNum, int pageSize, String htfl, String htbh, String qsrq,
                                                        String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi);


        //个人查询合同
        ServiceResponsebg<List<ComplexHt>> queryPersonaltable(Users user, int pageNum, int pageSize, String htfl, String qsrq,
                                                              String fzr, String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi);

        //查询部门
        ServerResponse<List<Department>> querybm();

        //查询用户
        ServerResponse<List<Users>> queryfzrbybm(String  bm);
        //查询实施用户
        ServerResponse<List<Users>> queryssfzrbybm(String bm);
}
