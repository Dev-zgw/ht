package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Htfl {
    private BigDecimal id;

    private String flmc;

    private String zt;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    public Htfl(BigDecimal id, String flmc, String zt, String createBy, String updateBy, Date createTime, Date updateTime) {
        this.id = id;
        this.flmc = flmc;
        this.zt = zt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Htfl() {
        super();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFlmc() {
        return flmc;
    }

    public void setFlmc(String flmc) {
        this.flmc = flmc == null ? null : flmc.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
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