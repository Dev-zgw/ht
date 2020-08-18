package Message;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/14 14:02
 */
public class Message {
    private String mobile;
    private String signName;
    private String TemplateCode;
    private String TemplateParam;

    public Message(String mobile, String signName, String templateCode, String templateParam) {
        this.mobile = mobile;
        this.signName = signName;
        TemplateCode = templateCode;
        TemplateParam = templateParam;
    }

    public Message() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return TemplateCode;
    }

    public void setTemplateCode(String templateCode) {
        TemplateCode = templateCode;
    }

    public String getTemplateParam() {
        return TemplateParam;
    }

    public void setTemplateParam(String templateParam) {
        TemplateParam = templateParam;
    }
}
