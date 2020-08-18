package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Permission {
    private BigDecimal id;

    private String qxmc;

    private String qxzt;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private String qxm;

    public Permission(BigDecimal id, String qxmc, String qxzt, String createBy, String updateBy, Date createTime, Date updateTime, String qxm) {
        this.id = id;
        this.qxmc = qxmc;
        this.qxzt = qxzt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.qxm = qxm;
    }

    public Permission() {
        super();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getQxmc() {
        return qxmc;
    }

    public void setQxmc(String qxmc) {
        this.qxmc = qxmc == null ? null : qxmc.trim();
    }

    public String getQxzt() {
        return qxzt;
    }

    public void setQxzt(String qxzt) {
        this.qxzt = qxzt == null ? null : qxzt.trim();
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

    public String getQxm() {
        return qxm;
    }

    public void setQxm(String qxm) {
        this.qxm = qxm == null ? null : qxm.trim();
    }
}