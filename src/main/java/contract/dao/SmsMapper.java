package contract.dao;

import contract.pojo.Sms;
import java.math.BigDecimal;

public interface SmsMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Sms record);

    int insertSelective(Sms record);

    Sms selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Sms record);

    int updateByPrimaryKey(Sms record);
}