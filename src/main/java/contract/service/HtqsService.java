package contract.service;

import contract.pojo.Htqs;
import contract.pojo.Users;
import contract.utils.ServerResponse;

import java.util.List;
import java.util.Map;

public interface HtqsService {

    //根据合同编号查询合同期数
    ServerResponse<List<Htqs>> query(Users users, String htbh);

    //修改合同期数
    ServerResponse update(Users users, Htqs htqs);

    //新增合同期数
    ServerResponse xinzeng(Users users, Htqs htqs);

    //删除合同期数
    ServerResponse delete(Users users,int id);

    //修改本期合同状态
    ServerResponse htqsxg(Users users,int id,String htfqzt);

    //批量新增（导入）
    ServerResponse daoru(List<Map<String, Object>> list) throws Exception;
}
