package contract.service;

import contract.pojo.Result;
import contract.pojo.Users;
import contract.utils.ServerResponse;

import java.util.List;

public interface ResultService {

    //分页查看日志信息
    ServerResponse<List<Result>> query(Users user, int pageNum, int pageSize,String htbh,String startTime,
                                       String endTime);

}
