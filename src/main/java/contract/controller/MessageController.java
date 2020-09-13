package contract.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.sun.org.apache.bcel.internal.generic.IFNULL;
import contract.pojo.Message.FkMessage;
import contract.pojo.Message.HtMessage;
import contract.service.HtService;
import contract.service.MessageService;
import contract.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/9/3 13:16
 */
//每日中午十二点
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageServiceImpl messageServiceImpl;

    //提前付款期限一个月/两周/一周/三天，合同负责人收到合同到期提醒短信
    //超出付款期限，合同负责人收到付款逾期短信
    //合同结束日期前三个月/两个月/一个月/一周 合同负责人收到合同到期短信
    public void test() throws ClientException {
        System.out.print("已进入定时器");
        List<HtMessage> htMessages = messageService.queryHtMessage();
        List<FkMessage> fkMessages = messageService.queryFkMessage();
        SendSmsResponse response = null;
        response = messageServiceImpl.sendTz("1586805616", "金若妮","杭州第一人民医院", "金若妮");
        try {
            System.out.println("start fk");
            for (int i = 0; i < fkMessages.size(); i++) {
                String sjhm = fkMessages.get(i).getSjhm();
                String fzr = fkMessages.get(i).getFzr();
                String ht = "";
                String sysj = fkMessages.get(i).getSysj();
                String jzsj = fkMessages.get(i).getSj();
                if (sjhm.equals("") || sjhm == null) {

                } else {
                    if (fkMessages.get(i).getHtmc() == null) {
                        if (fkMessages.get(i).getHtbh() == null) {

                        } else {
                            ht += fkMessages.get(i).getHtbh();
                        }
                    } else {
                        if (fkMessages.get(i).getHtbh() == null) {
                            ht += fkMessages.get(i).getHtbh();
                        } else {
                            ht += fkMessages.get(i).getHtbh() + "-" + fkMessages.get(i).getHtmc();
                        }
                    }
                    //System.out.print(sjhm + " " + fzr + " " + ht + " " + sysj + " " + jzsj);
                    if (sysj.equals("3")) {
                        //response = messageServiceImpl.sendFkdqtx(sjhm, fzr, "合同"+ht, "3天", jzsj);
                        System.out.println("response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, \"3天\", jzsj)");
                    } else if (sysj.equals("7")) {
                        //response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, "合同"+"1周", jzsj);
                        System.out.println("response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, \"1周\", jzsj)");
                    } else if (sysj.equals("14")) {
                        //response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, "合同"+"2周", jzsj);
                        System.out.println("response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, \"2周\", jzsj)");
                    } else if (sysj.equals("30")) {
                        //response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, "合同"+"一个月", jzsj);
                        System.out.println("response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, \"一个月\", jzsj)");
                    } else if (sysj.equals("-1")) {
                        response = messageServiceImpl.sendFkyq(sjhm, fzr, ht, jzsj);
                        System.out.println("response = messageServiceImpl.sendFkyq(sjhm, fzr, ht, jzsj)");
                    }
                    else{
                        System.out.println(sysj);
                    }
                }

            }
            System.out.println("end fk");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("start ht");
            for (int j = 0; j < htMessages.size(); j++) {
                String sjhm = htMessages.get(j).getSjhm();
                String ht = "";
                String fzr = htMessages.get(j).getFzr();
                String sysj = htMessages.get(j).getSysj();
                String jzsj = htMessages.get(j).getZzrq();
                if (sjhm.equals("") || sjhm == null) {

                } else {
                    if (htMessages.get(j).getXxmc() == null) {
                        if (htMessages.get(j).getHtbh() == null) {

                        } else {
                            ht = htMessages.get(j).getHtbh();
                        }
                    } else {
                        if (htMessages.get(j).getHtbh() == null) {
                            ht = htMessages.get(j).getHtbh();
                        } else {
                            ht = htMessages.get(j).getHtbh() + "-" + htMessages.get(j).getXxmc();
                        }
                    }
                    if (sysj.equals("7")) {
                        //response = messageServiceImpl.sendHtdqz(sjhm, fzr, "合同"+ht+"的付款", jzsj, "1");
                        System.out.println("response = messageServiceImpl.sendHtdqz(sjhm, fzr, ht, jzsj, \"1\")");
                    } else if (sysj.equals("30")) {
                        //response = messageServiceImpl.sendHtdqy(sjhm, fzr, "合同"+ht+"的付款", jzsj, "1");
                        System.out.println("response = messageServiceImpl.sendHtdqy(sjhm, fzr, ht, jzsj, \"1\")");
                    } else if (sysj.equals("60")) {
                        //response = messageServiceImpl.sendHtdqy(sjhm, fzr, "合同"+ht+"的付款", jzsj, "2");
                        System.out.print("response = messageServiceImpl.sendHtdqy(sjhm, fzr, ht, jzsj, \"2\")");
                    } else if (sysj.equals("90")) {
                        //response = messageServiceImpl.sendHtdqy(sjhm, fzr, "合同"+ht+"的付款", jzsj, "3");
                        System.out.println("response = messageServiceImpl.sendHtdqy(sjhm, fzr, ht, jzsj, \"3\")");
                    }
                    else{
                        System.out.println(sysj);
                    }
//                    System.out.println("短信接口返回的数据----------------");
//                    System.out.println("Code=" + response.getCode());
//                    System.out.println("Message=" + response.getMessage());
//                    System.out.println("RequestId=" + response.getRequestId());
//                    System.out.println("BizId=" + response.getBizId());
                }
            }
            System.out.println("end ht");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("已结束定时器");
    }
}
