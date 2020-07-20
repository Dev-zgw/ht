package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Department {
    private BigDecimal id;

    private String bmmc;

    private String bmzt;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    public Department(BigDecimal id, String bmmc, String bmzt, String createBy, String updateBy, Date createTime, Date updateTime) {
        this.id = id;
        this.bmmc = bmmc;
        this.bmzt = bmzt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Department() {
        super();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc == null ? null : bmmc.trim();
    }

    public String getBmzt() {
        return bmzt;
    }

    public void setBmzt(String bmzt) {
        this.bmzt = bmzt == null ? null : bmzt.trim();
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