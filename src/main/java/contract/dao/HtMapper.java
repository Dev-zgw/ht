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
                    @Param("fzr") String fzr,@Param("ssfzr") String ssfzr, @Param("htzt") String htzt, @Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi
                    ,@Param("htjemax") String htjemax,@Param("htjemin") String htjemin);

    List<Ht> selectyh(@Param("fzrid") BigDecimal fzrid,@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                      @Param("ssfzr") String ssfzr,@Param("htzt") String htzt,@Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi
                     ,@Param("htjemax") String htjemax,@Param("htjemin") String htjemin);

    List<Ht> selectss(@Param("ssfzrid") BigDecimal ssfzrid,@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                    @Param("fzr") String fzr, @Param("htzt") String htzt, @Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi
                    ,@Param("htjemax") String htjemax,@Param("htjemin") String htjemin);

    int updatezt(@Param("id") BigDecimal id,@Param("htzt") String htzt);
}
