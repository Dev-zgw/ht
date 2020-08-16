package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import contract.dao.RoleMapper;
import contract.pojo.Role;
import contract.service.RoleService;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zgh
 * @create 2020/7/30 22:25
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 分页查询所有role
     * @return
     */
    @Override
    public ServiceResponsebg<List<Role>> selectRoleList() {
        List<Role> roles = roleMapper.selectRoleList();
        return ServiceResponsebg.createBySuccess(roles);
    }
}
