package contract.dao;

import contract.pojo.Ht;
import java.math.BigDecimal;

public interface HtMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Ht record);

    int insertSelective(Ht record);

    Ht selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Ht record);

    int updateByPrimaryKey(Ht record);
}