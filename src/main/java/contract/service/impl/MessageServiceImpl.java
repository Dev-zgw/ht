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
    static final String accessKeyId = "LTAI4GGeDXmKHYKQyhXpqymY";
    static final String accessKeySecret = "URKSLWlSHd8hzCauseKIuPAGRjKLc1";

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
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    /**
     *
     * @param telephone
     * @param fzr
     * @param yf
     * @param je
     * @param ht
     * @return
     * @throws ClientException
     */
    //${fzr}你好，你与${yf}签订的金额为${je}的合同${ht}已录入，请尽快至系统中进行确认！
    public SendSmsResponse sendHtqr2(String telephone, String fzr,String yf,String je,String ht) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202805104");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"yf\":\""+yf+"\", \"je\":\""+je+"\",\"ht\":\""+ht+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
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
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    /**
     *
     * @param telephone
     * @param jl
     * @param fzr
     * @param ht
     * @param yf
     * @param je
     * @return
     * @throws ClientException
     */
    //${jl}经理你好，${fzr}负责的合同：${ht}已完成签订，业务合作方为${yf}，合同金额为${je}
    public SendSmsResponse sendHtqd2(String telephone, String jl,String fzr,String ht,String yf,String je) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202815104");
        request.setTemplateParam("{\"jl\":\""+jl+"\",\"fzr\":\""+fzr+"\",\"ht\":\""+ht+"\",\"yf\":\""+yf+"\", \"je\":\""+je+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
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
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    /**
     *
     * @param telephone
     * @param ss
     * @param yf
     * @param fzr
     * @param phone
     * @return
     * @throws ClientException
     */
    //${ss}你好，与${yf}的合同已确认，请尽快开展实施工作，如有问题，请联系合同负责人${fzr}，${phone}。
    public SendSmsResponse sendTz2(String telephone, String ss,String yf,String fzr,String phone) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202815107");
        request.setTemplateParam("{\"ss\":\""+ss+"\",\"yf\":\""+yf+"\",\"fzr\":\""+fzr+"\", \"phone\":\""+phone+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
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
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    /**
     *
     * @param telephone
     * @param fzr
     * @param yf
     * @param ht
     * @param sj
     * @param jzsj
     * @param je
     * @return
     * @throws ClientException
     */
    //${fzr}你好，你与${yf}签订的合同：${ht}将在${sj}内到期，付款截止时间为${jzsj}，付款金额为${je}，请尽快确认！
    public SendSmsResponse sendFkdqtx2(String telephone, String fzr,String yf,String ht,String sj,String jzsj,String je) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202810952");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"yf\":\""+yf+"\",\"ht\":\""+ht+"\",\"sj\":\""+sj+"\",\"jzsj\":\""+jzsj+"\", \"je\":\""+je+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //超出付款期限，合同负责人收到付款逾期短信
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
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    /**
     *
     * @param telephone
     * @param fzr
     * @param yf
     * @param ht
     * @param sj
     * @param je
     * @return
     * @throws ClientException
     */
    //${fzr}你好，与${yf}签订的合同：${ht}已在${sj}到期，合同金额为${je}，请尽快处理！
    public SendSmsResponse sendFkyq2(String telephone, String fzr,String yf,String ht,String sj,String je) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202805148");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"yf\":\""+yf+"\",\"ht\":\""+ht+"\",\"sj\":\""+sj+"\", \"je\":\""+je+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //合同结束日期提前三个月、两个月、一个月、一周，合同负责人收到合同到期短信
    //${fzr}你好，你的${ht}将于${time}到期，距离合同结束还有${sysj}个月，请尽快确认！
    //${fzr}你好，你的${ht}将于${time}到期，距离合同结束还有${sysj}周，请尽快确认！
    //${fzr}你好，你的合同：${ht}，将于${time}到期，距离合同结束还有${sysj}周，请尽快确认！
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
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
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
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
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
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //${fzr}你好，与${yf}签订的合同：${ht}将于${sj}到期，距离合同结束还有${sysj}个月，请尽快确认！
    //${fzr}你好，与${yf}签订的${ht}将于${time}到期，距离合同结束还有${sysj}周，请尽快确认！
    //${fzr}你好，与${yf}签订的合同：${ht}，将于${time}到期，距离合同结束还有${sysj}天，请尽快确认！

    /**
     *
     * @param telephone
     * @param fzr
     * @param yf
     * @param ht
     * @param sj
     * @param sysj
     * @return
     * @throws ClientException
     */
    public SendSmsResponse sendHtdqy2(String telephone, String fzr,String yf,String ht,String sj,String sysj) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202820124");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"yf\":\""+yf+"\",\"ht\":\""+ht+"\",\"sj\":\""+sj+"\", \"sysj\":\""+sysj+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    /**
     *
     * @param telephone
     * @param fzr
     * @param yf
     * @param ht
     * @param time
     * @param sysj
     * @return
     * @throws ClientException
     */
    public SendSmsResponse sendHtdqz2(String telephone, String fzr,String yf,String ht,String time,String sysj) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202810126");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"yf\":\""+yf+"\",\"ht\":\""+ht+"\",\"time\":\""+time+"\", \"sysj\":\""+sysj+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    /**
     *
     * @param telephone
     * @param fzr
     * @param yf
     * @param ht
     * @param time
     * @param sysj
     * @return
     * @throws ClientException
     */
    public SendSmsResponse sendHtdqt2(String telephone, String fzr,String yf,String ht,String time,String sysj) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202820126");
        request.setTemplateParam("{\"fzr\":\""+fzr+"\",\"yf\":\""+yf+"\",\"ht\":\""+ht+"\",\"time\":\""+time+"\", \"sysj\":\""+sysj+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //财务确认合同款结清，合同负责人收到合同款结清短信
    //财务确认合同款结清，部门经理收到合同款结清短信
    //${name}你好，${fzr}的${ht}的合同款已结清。
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
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }
    //${name}你好，${fzr}的${ht}的合同款已结清。
    public SendSmsResponse sendHtkjq2(String telephone, String name,String ht,String fzr) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202562443");
        request.setTemplateParam("{\"name\":\""+name+"\",\"fzr\":\""+fzr+"\", \"ht\":\""+ht+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //${name}你好，${fzr}与${yf}签订的合同：${ht}的合同款已结清，合同金额为${je}。
    /**
     *
     * @param telephone
     * @param name
     * @param fzr
     * @param yf
     * @param ht
     * @param je
     * @return
     * @throws ClientException
     */
    public SendSmsResponse sendHtkjq3(String telephone, String name,String fzr,String yf,String ht,String je) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202810167");
        request.setTemplateParam("{\"name\":\""+name+"\",\"fzr\":\""+fzr+"\",\"yf\":\""+yf+"\",\"ht\":\""+ht+"\", \"je\":\""+je+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //${name}你好，与${yf}签订的合同：${ht}的合同款已结清，合同金额为${je}。
    /**
     *
     * @param telephone
     * @param name
     * @param yf
     * @param ht
     * @param je
     * @return
     * @throws ClientException
     */
    public SendSmsResponse sendHtkjq4(String telephone, String name,String yf,String ht,String je) throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("茵岢科技");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_202817007");
        request.setTemplateParam("{\"name\":\""+name+"\",\"yf\":\""+yf+"\",\"ht\":\""+ht+"\", \"je\":\""+je+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.print(MessageHandle(sendSmsResponse.getCode()));
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

    private static String MessageHandle(String str)
    {
        String result = "";
        switch (str)
        {
            case "OK":
                result = "短信发送成功！";
                break;
            case "isp.RAM_PERMISSION_DENY":
                result = "RAM权限DENY";
                break;
            case "isv.OUT_OF_SERVICE":
                result = "业务停机";
                break;
            case "isv.PRODUCT_UN_SUBSCRIPT":
                result = "未开通云通信产品的阿里云客户";
                break;
            case "isv.PRODUCT_UNSUBSCRIBE":
                result = "产品未开通";
                break;
            case "isv.ACCOUNT_NOT_EXISTS":
                result = "账户不存在";
                break;
            case "isv.ACCOUNT_ABNORMAL":
                result = "账户异常    ";
                break;
            case "isv.SMS_TEMPLATE_ILLEGAL":
                result = "短信模板不合法";
                break;
            case "isv.SMS_SIGNATURE_ILLEGAL":
                result = "短信签名不合法";
                break;
            case "isv.INVALID_PARAMETERS":
                result = "参数异常";
                break;
            case "isv.MOBILE_NUMBER_ILLEGAL":
                result = "非法手机号";
                break;
            case "isv.MOBILE_COUNT_OVER_LIMIT":
                result = "手机号码数量超过限制";
                break;
            case "isv.TEMPLATE_MISSING_PARAMETERS":
                result = "模板缺少变量";
                break;
            case "isv.BUSINESS_LIMIT_CONTROL":
                result = "业务限流";
                break;
            case "isv.INVALID_JSON_PARAM":
                result = "JSON参数不合法，只接受字符串值";
                break;
            case "isv.PARAM_LENGTH_LIMIT":
                result = "参数超出长度限制";
                break;
            case "isv.PARAM_NOT_SUPPORT_URL":
                result = "不支持URL";
                break;
            case "isv.AMOUNT_NOT_ENOUGH":
                result = "账户余额不足";
                break;
            case "isv.TEMPLATE_PARAMS_ILLEGAL":
                result = "模板变量里包含非法关键字";
                break;
        }
        return result;
    }


}
