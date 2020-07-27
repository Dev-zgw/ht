package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Role {
    private BigDecimal id;

    private String jsmc;

    private BigDecimal qxid;

    private String jsqx;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    public Role(BigDecimal id, String jsmc, BigDecimal qxid, String jsqx, String createBy, String updateBy, Date createTime, Date updateTime) {
        this.id = id;
        this.jsmc = jsmc;
        this.qxid = qxid;
        this.jsqx = jsqx;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Role() {
        super();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getJsmc() {
        return jsmc;
    }

    public void setJsmc(String jsmc) {
        this.jsmc = jsmc == null ? null : jsmc.trim();
    }

    public BigDecimal getQxid() {
        return qxid;
    }

    public void setQxid(BigDecimal qxid) {
        this.qxid = qxid;
    }

    public String getJsqx() {
        return jsqx;
    }

    public void setJsqx(String jsqx) {
        this.jsqx = jsqx == null ? null : jsqx.trim();
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