package contract.dao;

import contract.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/13 16:52
 */
public interface ReportMapper {

    List<Chart1> selectChart1(@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                              @Param("fzr") String fzr,@Param("fzrbm") String fzrbm,@Param("ssfzr") String ssfzr,@Param("ssfzrbm") String ssfzrbm,
                              @Param("dqsheng") String dqsheng, @Param("dqshi")  String dqshi);

    List<Chart5> selectChart5(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Chart6> selectChart6(@Param("startTime") String startTime, @Param("endTime") String endTime,@Param("fzr") String fzr,@Param("fzrbm") String fzrbm,
                              @Param("dqsheng") String dqsheng, @Param("dqshi")  String dqshi  );

    List<Chart9> selectChart9(@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                              @Param("fzr") String fzr,@Param("fzrbm") String fzrbm,@Param("ssfzr") String ssfzr,@Param("ssfzrbm") String ssfzrbm,
                              @Param("dqsheng") String dqsheng, @Param("dqshi")  String dqshi);

    List<Place> selectSheng();

    List<Currentinfo> selectPersonalcurrentinfo(@Param("fzr") String fzr);

    List<Currentinfo> selectPersonalsscurrentinfo(@Param("ssfzr") String ssfzr);

    List<Currentinfo> selectDepartmentcurrentinfo(@Param("fzr") String fzr);

    List<Currentinfo> selectCompanycurrentinfo();

    List<Ht> selectPersonalTable(@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                    @Param("fzr") String fzr,@Param("fzrbm") String fzrbm,@Param("ssfzr") String ssfzr,@Param("ssfzrbm") String ssfzrbm,
                         @Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi);

    List<Ht> select(@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                    @Param("fzr") String fzr,@Param("ssfzr") String ssfzr, @Param("htzt") String htzt, @Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi
            ,@Param("htjemax") String htjemax,@Param("htjemin") String htjemin);

    List<Ht> selectyh(@Param("fzrid") BigDecimal fzrid,@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                      @Param("ssfzr") String ssfzr,@Param("htzt") String htzt,@Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi
            ,@Param("htjemax") String htjemax,@Param("htjemin") String htjemin);

    List<Ht> selectss(@Param("ssfzrid") BigDecimal ssfzrid,@Param("htfl") String htfl, @Param("startTime") String startTime, @Param("endTime") String endTime,
                      @Param("fzr") String fzr, @Param("htzt") String htzt, @Param("dqsheng") String dqsheng,@Param("dqshi")  String dqshi
            ,@Param("htjemax") String htjemax,@Param("htjemin") String htjemin);
}
