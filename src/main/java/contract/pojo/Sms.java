package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Sms {
    private BigDecimal id;

    private String sjr;

    private String sjhm;

    private String dxnr;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    public Sms(BigDecimal id, String sjr, String sjhm, String dxnr, String createBy, String updateBy, Date createTime, Date updateTime) {
        this.id = id;
        this.sjr = sjr;
        this.sjhm = sjhm;
        this.dxnr = dxnr;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Sms() {
        super();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSjr() {
        return sjr;
    }

    public void setSjr(String sjr) {
        this.sjr = sjr == null ? null : sjr.trim();
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm == null ? null : sjhm.trim();
    }

    public String getDxnr() {
        return dxnr;
    }

    public void setDxnr(String dxnr) {
        this.dxnr = dxnr == null ? null : dxnr.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}