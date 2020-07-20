package contract.dao;

import contract.pojo.Htqs;
import java.math.BigDecimal;

public interface HtqsMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Htqs record);

    int insertSelective(Htqs record);

    Htqs selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Htqs record);

    int updateByPrimaryKey(Htqs record);
}