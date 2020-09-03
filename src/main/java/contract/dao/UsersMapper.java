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

    List<Users> query();

    List<Users> queryss();

    List<Users> querybybm(@Param("ssbm") String ssbm);

    List<Users> queryssbybm(@Param("ssbm") String ssbm);

    //登录
    Users selectByUP(@Param("name") String name, @Param("password") String password);

    //验证用户
    int selectOne(@Param("name") String name);

    //查询所有用户
    List<Users> selectUserList(@Param("xm") String xm, @Param("bmid") Integer bmid, @Param("zzzt") String zzzt);

    Users selectByID(@Param("id")BigDecimal id);

    Users queryxm(@Param("xm") String xm);
}
