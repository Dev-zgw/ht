package contract.dao;

import contract.pojo.Result;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Result record);

    int insertSelective(Result record);

    Result selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKey(Result record);

    List<Result> query(@Param("htbh") String htbh,@Param("startTime") String startTime,
                       @Param("endTime") String endTime,@Param("xm") String xm);

    int deleteAll();
}
