package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import contract.dao.ResultMapper;
import contract.dao.RoleMapper;
import contract.dao.UsersMapper;
import contract.pojo.Result;
import contract.pojo.Role;
import contract.pojo.Users;
import contract.service.ResultService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultMapper resultMapper;

    /**
     * 分页查询日志信息
     * @param pageNum
     * @param pageSize
     * @param htbh
     * @param startTime
     * @param endTime
     * @param xm
     * @return
     */
    @Override
    public ServiceResponsebg<List<Result>> query(int pageNum, int pageSize, String htbh,
                                                 String startTime, String endTime, String xm) {
        PageHelper.startPage(pageNum, pageSize);
        List<Result> list = resultMapper.query(htbh, startTime, endTime, xm);
        PageInfo<Result> resultPageInfo = new PageInfo<>(list);
        return ServiceResponsebg.createBySuccess(resultPageInfo.getTotal(),list);
    }

    @Override
    public ServerResponse deleteAll() {
        int i = resultMapper.deleteAll();
        if (i == 1){
            return ServerResponse.createBySuccessMessage("已清空日志");
        }
        return ServerResponse.createByErrorMessage("清空日志失败");
    }
}
