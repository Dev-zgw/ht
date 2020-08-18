package contract.dao;

import contract.pojo.Ht;
import contract.pojo.Report;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/13 16:52
 */
public interface ReportMapper {

    List<Report> selectBasicInfo(@Param("htCount") int htCount, @Param("htTotalPrice") int htTotalPrice,
                                 @Param("departmentPeopleNum") int departmentPeopleNum, @Param("totalPeopleNum") int totalPeopleNum
                              );
}
