package contract.service;

import contract.pojo.Message.FkMessage;
import contract.pojo.Message.HtMessage;

import java.util.List;



public interface MessageService {
    //需要发送付款短信的list
    List<FkMessage> queryFkMessage();

    //需要发送合同短信的list
    List<HtMessage> queryHtMessage();
}
