package contract.service;

import contract.pojo.Ht;
import contract.pojo.Users;
import contract.utils.ServerResponse;

import java.util.List;

public interface HtService {

    //个权限查询合同
    ServerResponse<List<Ht>> query(Users user, int pageNum, int pageSize, String htfl, String startTime,
                                   String endTime, String fzr, String htzt,String dqsheng,String dqshi,int htjemax,int htjemin);
    //修改合同
    ServerResponse update(Users users,Ht ht);
    //新增合同
    ServerResponse xinzeng(Users users,Ht ht);
    //删除合同
    ServerResponse delete(Users users,int id);
}
