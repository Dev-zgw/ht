package contract.dao;

import contract.pojo.Role;
import java.math.BigDecimal;

public interface RoleMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}