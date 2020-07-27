package contract.dao;

import contract.pojo.Htfl;
import java.math.BigDecimal;

public interface HtflMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Htfl record);

    int insertSelective(Htfl record);

    Htfl selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Htfl record);

    int updateByPrimaryKey(Htfl record);
}