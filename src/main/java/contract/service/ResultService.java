package contract.service;

import contract.pojo.Result;
import contract.pojo.Users;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;

import java.util.List;

public interface ResultService {

    //分页查看日志信息
    ServiceResponsebg<List<Result>> query(int pageNum, int pageSize, String htbh, String startTime, String endTime, String xm);

    //删除所有记录
    ServerResponse deleteAll();
}
