package Message;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import Message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

import java.util.Random;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/14 14:12
 */
@Controller
@RequestMapping("/sendmessage/")
public class SendMessageUtil {
    /**
     * 阿里云短信服务：
     * 需要 签名名称、模版CODE 以及 RAM访问控制中的 AccessKeyID 和 AccessKeySecret
     */
    //产品名称:云通信短信API产品,无需替换
    static final String product = "Dysmsapi";
    //产品域名,无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
    static final String accessKeyId = "";
    static final String accessKeySecret = "";

    //管理员完成合同录入-发送短信 -- 通用短信
    @RequestMapping(value = "sendmail_htlr.do", method = RequestMethod.POST)
    @ResponseBody
    public static SendSmsResponse sendSms(String telephone, String name,String htnumber) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("合同管理系统");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_199791438");
        //${name}，${htnumber}已完成录入，请至系统进行确认！
        //request.setTemplateParam("{\"name\":\""+name+"\", \"contractname\":\""+contractname+"\",, \"time\":\""+time+"\"}");
        request.setTemplateParam("{\"name\":\""+name+"\", \"htnumber\":\""+htnumber+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //合同到期前三天-发送短信 -- 通用短信
    @RequestMapping(value = "sendmail_htqs.do", method = RequestMethod.POST)
    @ResponseBody
    public static SendSmsResponse sendSms2(String telephone, String name,String htnumber,String time) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("合同管理系统");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_199806446");
        //${name}，${htnumber}将于${time}到期，请尽快确认！
        request.setTemplateParam("{\"name\":\""+name+"\", \"htnumber\":\""+htnumber+"\", \"time\":\""+time+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //合同到期当天-发送短信 -- 通用短信
    @RequestMapping(value = "sendmail_htdt.do", method = RequestMethod.POST)
    @ResponseBody
    public static SendSmsResponse sendSms3(String telephone, String name,String htnumber,String time) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("合同管理系统");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_199771586");
        //${name},${htnumber}将于今日${time}到期，请尽快确认！
        request.setTemplateParam("{\"name\":\""+name+"\", \"htnumber\":\""+htnumber+"\", \"time\":\""+time+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //合同逾期-发送短信 -- 通用短信
    @RequestMapping(value = "sendmail_htyq.do", method = RequestMethod.POST)
    @ResponseBody
    public static SendSmsResponse sendSms4(String telephone, String name,String htnumber,String time) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("合同管理系统");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_199796356");
        //${name},${htnumber}已于${time}到期，请确认！
        request.setTemplateParam("{\"name\":\""+name+"\", \"htnumber\":\""+htnumber+"\", \"time\":\""+time+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    //财务付款确认-发送短信 -- 通用短信
    @RequestMapping(value = "sendmail_cwqr.do", method = RequestMethod.POST)
    @ResponseBody
    public static SendSmsResponse sendSms5(String telephone, String name,String htnumber) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName("合同管理系统");    // 这是验证码的短信签名，发送通用短信需要再申请签名
        request.setTemplateCode("SMS_199791506");
        //${name},财务已确认${htnumber}的付款。
        request.setTemplateParam("{\"name\":\""+name+"\", \"htnumber\":\""+htnumber+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }
}
