package contract.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.sun.org.apache.bcel.internal.generic.IFNULL;
import contract.pojo.Message.FkMessage;
import contract.pojo.Message.HtMessage;
import contract.service.HtService;
import contract.service.MessageService;
import contract.service.impl.MessageServiceImpl;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import sun.nio.cs.ext.SJIS;

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
        try {
            System.out.println("start fk");
            String sjhm = "";
            String fzr = "";
            String ht = "";
            String sysj = "";
            String jzsj = "";
            String yf= "";
            String je = "";
            for (int i = 0; i < fkMessages.size(); i++) {
                try{
                    sjhm = fkMessages.get(i).getSjhm();
                }catch (NullPointerException e){
                    System.out.print("无手机号");
                    e.printStackTrace();
                }
                try{
                    ht = fkMessages.get(i).getHtmc();
                }catch (NullPointerException e){
                    System.out.print("无合同名称");
                    e.printStackTrace();
                }
                try{
                    sysj = fkMessages.get(i).getSysj();
                }catch (NullPointerException e){
                    System.out.print("无剩余时间");
                    e.printStackTrace();
                }
                try{
                    jzsj = fkMessages.get(i).getSj();
                }catch (NullPointerException e){
                    System.out.print("无截止日期");
                    e.printStackTrace();
                }
                try{
                    yf = fkMessages.get(i).getYf();
                }catch (NullPointerException e){
                    System.out.print("无乙方");
                    e.printStackTrace();
                }
                try{
                    fzr = fkMessages.get(i).getFzr();
                }catch (NullPointerException e){
                    System.out.print("无负责人");
                    e.printStackTrace();
                }
                try{
                    je = fkMessages.get(i).getJe();
                }catch (NullPointerException e){
                    System.out.print("无金额");
                    e.printStackTrace();
                }
                if (sjhm.equals("") || sjhm == null) {

                } else {
                    if (ht.equals("") || ht == null) {
                        ht="";
                    }
                    if (fzr.equals("") || fzr == null) {
                        fzr="";
                    }
                    if(yf.equals("") || yf==null){
                        yf="";
                    }
                    if(je.equals("") || je==null){
                        je="";
                    }else{
                        je+="万";
                    }
                    if(yf.length()>20){
                        yf= yf.substring(0,17)+"...";
                    }
                    if(ht.length()>20){
                        ht= ht.substring(0,17)+"...";
                    }
                    if (sysj.equals("3")) {
                        //response = messageServiceImpl.sendFkdqtx2(sjhm,fzr,yf, ht, "3天", jzsj,je);
                        System.out.println("response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, \"3天\", jzsj)");
                    } else if (sysj.equals("7")) {
                        //response = messageServiceImpl.sendFkdqtx2(sjhm,fzr,yf, ht, "1周", jzsj,je);
                        System.out.println("response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, \"1周\", jzsj)");
                    } else if (sysj.equals("14")) {
                        //response = messageServiceImpl.sendFkdqtx2(sjhm,fzr,yf, ht, "2周", jzsj,je);
                        System.out.println("response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, \"2周\", jzsj)");
                    } else if (sysj.equals("30")) {
                        //response = messageServiceImpl.sendFkdqtx2(sjhm,fzr,yf, ht, "一个月", jzsj,je);
                        System.out.println("response = messageServiceImpl.sendFkdqtx(sjhm, fzr, ht, \"一个月\", jzsj)");
                    } else if (sysj.equals("-1")) {
                        response = messageServiceImpl.sendFkyq2(sjhm,fzr,yf,ht,jzsj,je);
                        System.out.println("response = messageServiceImpl.sendFkyq(sjhm, fzr, ht, jzsj)");
                    }else{
                        System.out.println(sysj);
                    }
                }

            }
            System.out.println("end fk");
        } catch (Exception e) {
            System.out.print("付款短信发送存在错误");
            e.printStackTrace();
        }
        try {
            System.out.println("start ht");
            String sjhm = "";
            String ht = "";
            String fzr = "";
            String sysj = "";
            String jzsj = "";
            String yf = "";
            for (int j = 0; j < htMessages.size(); j++) {
                try{
                    sjhm = htMessages.get(j).getSjhm();
                }catch (Exception e){
                    System.out.print("无手机号");
                    //e.printStackTrace();
                }
                try{
                    ht = htMessages.get(j).getHtmc();
                }catch (Exception e){
                    System.out.print("无合同名称");
                    //e.printStackTrace();
                }
                try{
                    sysj = htMessages.get(j).getSysj();
                }catch (Exception e){
                    System.out.print("无剩余时间");
                    //e.printStackTrace();
                }
                try{
                    jzsj = htMessages.get(j).getZzrq();
                }catch (Exception e){
                    System.out.print("无截止日期");
                    //e.printStackTrace();
                }
                try{
                    yf = htMessages.get(j).getYf();
                }catch (Exception e){
                    System.out.print("无乙方");
                    //e.printStackTrace();
                }
                try{
                    fzr = htMessages.get(j).getFzr();
                }catch (NullPointerException e){
                    System.out.print("无负责人");
                    e.printStackTrace();
                }
                if (sjhm.equals("") || sjhm == null) {

                } else {
                    if (ht.equals("") || ht == null) {
                        ht="";
                    }
                    if (fzr.equals("") || fzr == null) {
                        fzr="";
                    }
                    if (yf.equals("") || yf == null) {
                        yf="";
                    }
                    if(yf.length()>20){
                        yf= yf.substring(0,17)+"...";
                    }
                    if(ht.length()>20){
                        ht= ht.substring(0,17)+"...";
                    }
                    if (sysj.equals("7")) {
                        //response = messageServiceImpl.sendHtdqz2(sjhm, fzr,yf,ht,jzsj,"1");
                        System.out.println("response = messageServiceImpl.sendHtdqz(sjhm, fzr, ht, jzsj, \"1\")");
                    } else if (sysj.equals("30")) {
                        //response = messageServiceImpl.sendHtdqy2(sjhm,fzr,yf,ht,jzsj,"1");
                        System.out.println("response = messageServiceImpl.sendHtdqy(sjhm, fzr, ht, jzsj, \"1\")");
                    } else if (sysj.equals("60")) {
                        //response = messageServiceImpl.sendHtdqy2(sjhm, fzr, yf, ht, jzsj, "2");
                        System.out.print("response = messageServiceImpl.sendHtdqy(sjhm, fzr, ht, jzsj, \"2\")");
                    } else if (sysj.equals("90")) {
                        //response = messageServiceImpl.sendHtdqy2(sjhm, fzr, yf, ht, jzsj, "3");
                        System.out.println("response = messageServiceImpl.sendHtdqy(sjhm, fzr, ht, jzsj, \"3\")");
                    }
                    else{
                        //System.out.println(sysj);
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
            System.out.print("合同短信发送存在错误");
            e.printStackTrace();
        }
        System.out.print("已结束定时器");
    }
}
