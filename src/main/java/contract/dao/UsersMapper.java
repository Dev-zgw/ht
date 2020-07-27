package contract.dao;

import contract.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> select(@Param("ssbm") String ssbm);
}
