package contract.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import contract.dao.MessageMapper;
import contract.pojo.Message.FkMessage;
import contract.pojo.Message.HtMessage;
import contract.service.MessageService;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/9/3 11:19
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;
    /**
     * 阿里云短信服务：
     * 需要 签名名称、模版CODE 以及 RAM访问控制中的 AccessKeyID 和 AccessKeySecret
     */
    //产品名称:云通信短信API产品,无需替换
    static final String product = "Dysmsapi";
    //产品域名,无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
    //传入github需要先删除
    static final String accessKeyId = "";
    static final String accessKeySecret = "";

    //管理员完成合同录入-合同负责人收到 -- 合同确认短信
    //${name}你好，你的合同${ht}已录入，请尽快至系统中进行确认！
    public SendSmsResponse sendHtqr(String telephone, String name,String ht) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_201470498");
        request.setTemplateParam("{\"name\":\""+name+"\", \"ht\":\""+ht+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //合同负责人确认合同后 -- 部门经理收到 -- 合同签订短信
    //${bm}经理你好，${name}的合同${ht}已完成签订
    public SendSmsResponse sendHtqd(String telephone, String bm,String name,String ht) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_201470535");
        request.setTemplateParam("{\"bm\":\""+bm+"\",\"name\":\""+name+"\", \"ht\":\""+ht+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //合同负责人确认合同后 -- 实施负责人收到 -- 通知短信
    //${name}你好，与${yyname}的合同已确认，请尽快开展实施工作，如有问题，请联系合同负责人${fzr}
    public SendSmsResponse sendTz(String telephone, String name,String yyname,String fzr) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_201450588");
        request.setTemplateParam("{\"name\":\""+name+"\",\"yyname\":\""+yyname+"\", \"fzr\":\""+fzr+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //提前付款期限一个月、两周、一周、三天，合同负责人收到付款到期提醒短信
    //${fzr}你好，你的${ht}将在${time}内到期，付款截止时间为${jzsj}，请尽快确认！
    public SendSmsResponse sendFkdqtx(String telephone, String fzr,String ht,String time,String jzsj) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_201480475");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"ht\":\""+ht+"\", \"time\":\""+time+"\",\"jzsj\":\""+jzsj+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //超出付款期限，合同负责人收到付款逾期短信
    //暂未通过审批
    //${fzr}你好，你的合同：${ht}，已在${time}逾期，请尽快处理！
    public SendSmsResponse sendFkyq(String telephone, String fzr,String ht,String time) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_201480481");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"ht\":\""+ht+"\", \"time\":\""+time+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //合同结束日期提前三个月、两个月、一个月、一周，合同负责人收到合同到期短信
    //${fzr}你好，你的${ht}将于${time}到期，距离合同结束还有${sysj}个月，请尽快确认！
    //${fzr}你好，你的${ht}将于${time}到期，距离合同结束还有${sysj}周，请尽快确认！
    //${fzr}你好，你的合同：${ht}，将于${time}到期，距离合同结束还有${sysj}周，请尽快确认！
    //模板申请错了，重新申请
    public SendSmsResponse sendHtdqy(String telephone, String fzr,String ht,String time,String sysj) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_201470522");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"ht\":\""+ht+"\",\"time\":\""+time+"\", \"sysj\":\""+sysj+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }
    public SendSmsResponse sendHtdqz(String telephone, String fzr,String ht,String time,String sysj) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_201480606");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"ht\":\""+ht+"\",\"time\":\""+time+"\", \"sysj\":\""+sysj+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }
    public SendSmsResponse sendHtdqt(String telephone, String fzr,String ht,String time,String sysj) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_201450729");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"ht\":\""+ht+"\",\"time\":\""+time+"\", \"sysj\":\""+sysj+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //财务确认合同款结清，合同负责人收到合同款结清短信
    //财务确认合同款结清，部门经理收到合同款结清短信
    //${name}你好，${ht}的合同款已结清。
    public SendSmsResponse sendHtkjq(String telephone, String name,String ht) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_201480494");
        request.setTemplateParam("{\"name\":\""+name+"\", \"ht\":\""+ht+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    @Override
    public List<FkMessage> queryFkMessage() {
        List<FkMessage> fkMessages = messageMapper.selectFkMessageInfo();
        return fkMessages;
    }

    @Override
    public List<HtMessage> queryHtMessage() {
        List<HtMessage> htMessages = messageMapper.selectHtMessageInfo();
        return htMessages;
    }
}
