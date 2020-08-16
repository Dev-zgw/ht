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
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("resultService")
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UsersMapper userMapper;

    /**
     * 分页查询日志信息
     *
     * @param pageNum
     * @param pageSize
     * @param htbh
     * @return
     */
    @Override
    public ServiceResponsebg<List<Result>> query(int pageNum, int pageSize, String htbh, String sj,
                                                 String xm) {

        return ServiceResponsebg.createBySuccess();
    }
}
