package contract.dao;

import contract.pojo.Htqs;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface HtqsMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Htqs record);

    int insertSelective(Htqs record);

    Htqs selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Htqs record);

    int updateByPrimaryKey(Htqs record);

    List<Htqs> query(@Param("htbh") String htbh);

    int updatezt(@Param("id") BigDecimal id,@Param("htfqzt") String htfqzt);

    int delete(@Param("htbh") String htbh);
}
