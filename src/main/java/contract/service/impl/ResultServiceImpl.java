package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import contract.dao.ResultMapper;
import contract.pojo.Result;
import contract.pojo.Users;
import contract.service.ResultService;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("resultService")
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultMapper resultMapper;

    /**
     * 分页查询日志信息
     * @param user
     * @param pageNum
     * @param pageSize
     * @param htbh
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public ServerResponse<List<Result>> query(Users user, int pageNum, int pageSize, String htbh, String startTime,
                                              String endTime) {
        PageHelper.startPage(pageNum,pageSize);
        List<Result> list=resultMapper.query(htbh,startTime,endTime);
        PageInfo<Result> pageInfo = new PageInfo<Result>(list);
        return ServerResponse.createBySuccess(pageInfo.getTotal(),list);
    }
}
