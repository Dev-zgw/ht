package contract.service;

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

    //查询所有进行中的合同
    List<Ht> queryAll();
    //定时器更改逾期状态
    int updateyqzt(int id,String htzt);
    //定时器更改逾期天数
    int updateyqts(int id, String yqts,String htsyts);
}
