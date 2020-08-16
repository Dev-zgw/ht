package contract.dao;

import contract.pojo.Ht;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

public interface HtMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Ht record);

    int insertSelective(Ht record);

    Ht selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Ht record);

    int updateByPrimaryKey(Ht record);

    List<Ht> select(@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                    @Param("fzr") String fzr, @Param("htzt") String htzt, @Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi);

    List<Ht> selectyh(@Param("fzrid") BigDecimal fzrid,@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                      @Param("htzt") String htzt,@Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi);

    List<Ht> selectreport(@Param("fzrid") BigDecimal fzrid,@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                      @Param("htzt") String htzt,@Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi,@Param("htnrhtnr")  int htnrhtnr);
}
