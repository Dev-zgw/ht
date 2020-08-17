package contract.dao;

import contract.pojo.Role;
import java.math.BigDecimal;
import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //查询所有角色
    List<Role> selectRoleList();
}
