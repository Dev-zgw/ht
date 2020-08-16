package contract.service;

import contract.pojo.Role;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;

import java.util.List;

/**
 * @author zgh
 * @create 2020/7/30 22:20
 */
public interface RoleService {
    ServiceResponsebg<List<Role>> selectRoleList();
}
