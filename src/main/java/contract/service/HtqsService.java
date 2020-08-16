package contract.service;

import contract.pojo.Htqs;
import contract.pojo.Users;
import contract.utils.ServerResponse;

import java.util.List;

public interface HtqsService {

    //根据合同编号查询合同期数
    ServerResponse<List<Htqs>> query(Users users, String htbh);

    //修改合同期数
    ServerResponse update(Users users, Htqs htqs);

    //新增合同期数
    ServerResponse xinzeng(Users users,Htqs htqs);

    //删除合同期数
    ServerResponse delete(Users users,int id);
}
