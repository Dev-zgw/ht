package contract.dao;

import contract.pojo.User;
import java.math.BigDecimal;

public interface UserMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}