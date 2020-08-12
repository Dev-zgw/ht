package contract.service;

import contract.pojo.Result;
import contract.pojo.Users;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;

import java.util.List;

public interface ResultService {

    //分页查看日志信息
    ServiceResponsebg<List<Result>> query(Users user, int pageNum, int pageSize, String htbh, String sj,
                                          String xm);

}
