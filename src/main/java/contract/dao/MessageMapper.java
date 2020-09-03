package contract.dao;

import contract.pojo.Ht;
import contract.pojo.Message.FkMessage;
import contract.pojo.Message.HtMessage;
import contract.pojo.Reportpage.FkhtSimpleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/9/3 14:18
 */
public interface MessageMapper {

    List<FkMessage> selectFkMessageInfo();

    List<HtMessage> selectHtMessageInfo();

}
