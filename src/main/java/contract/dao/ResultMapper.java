package contract.dao;

import contract.pojo.Result;
import java.math.BigDecimal;

public interface ResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Result record);

    int insertSelective(Result record);

    Result selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKey(Result record);
}