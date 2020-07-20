package contract.dao;

import contract.pojo.Ht;
import java.math.BigDecimal;
import java.util.List;

public interface HtMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Ht record);

    int insertSelective(Ht record);

    Ht selectByPrimaryKey(BigDecimal id);

    List<Ht> select();

    int updateByPrimaryKeySelective(Ht record);

    int updateByPrimaryKey(Ht record);
}
