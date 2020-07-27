package contract.dao;

import contract.pojo.Department;
import java.math.BigDecimal;

public interface DepartmentMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}