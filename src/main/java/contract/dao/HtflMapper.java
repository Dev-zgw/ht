package contract.dao;

import contract.pojo.Htfl;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface HtflMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Htfl record);

    int insertSelective(Htfl record);

    Htfl selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Htfl record);

    int updateByPrimaryKey(Htfl record);

    List<Htfl> select();

    Htfl query(@Param("flmc") String flmc);
}
