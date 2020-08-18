package contract.service;

import contract.pojo.CalReport;
import contract.pojo.Ht;
import contract.pojo.Users;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;

import java.util.List;

public interface HtService {

    //个权限查询合同
    ServiceResponsebg<List<Ht>> query(Users user, int pageNum, int pageSize, String htfl, String qsrq,
                                      String fzr,String ssfzr, String htzt, String dqsheng, String dqshi, String je);
    //修改合同
    ServerResponse update(Users users, Ht ht);
    //新增合同
    ServerResponse xinzeng(Users users,Ht ht);
    //删除合同
    ServerResponse delete(Users users,int id);
    //修改合同状态
    ServerResponse updatezt(Users users,int id,String htzt);
    //查询用户
    ServerResponse<List<Users>> queryfzr();
    //查询实施用户
    ServerResponse<List<Users>> queryssfzr();

    ServerResponse<List<CalReport>> selectReport(Users user,String qsrq);

    ServerResponse<List<CalReport>> selectReportavg(Users user,String qsrq);

    ServerResponse<List<CalReport>> selectReportcount(Users user,String qsrq);
}
