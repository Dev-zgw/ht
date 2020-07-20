package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private BigDecimal id;

    private String name;

    private String password;

    private String xm;

    private String xb;

    private String ywm;

    private String zw;

    private BigDecimal bmid;

    private String ssbm;

    private BigDecimal jsid;

    private String jsmc;

    private String sjhm;

    private String yx;

    private String zzzt;

    private String zt;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    public User(BigDecimal id, String name, String password, String xm, String xb, String ywm, String zw, BigDecimal bmid, String ssbm, BigDecimal jsid, String jsmc, String sjhm, String yx, String zzzt, String zt, String createBy, String updateBy, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.xm = xm;
        this.xb = xb;
        this.ywm = ywm;
        this.zw = zw;
        this.bmid = bmid;
        this.ssbm = ssbm;
        this.jsid = jsid;
        this.jsmc = jsmc;
        this.sjhm = sjhm;
        this.yx = yx;
        this.zzzt = zzzt;
        this.zt = zt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    public String getYwm() {
        return ywm;
    }

    public void setYwm(String ywm) {
        this.ywm = ywm == null ? null : ywm.trim();
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw == null ? null : zw.trim();
    }

    public BigDecimal getBmid() {
        return bmid;
    }

    public void setBmid(BigDecimal bmid) {
        this.bmid = bmid;
    }

    public String getSsbm() {
        return ssbm;
    }

    public void setSsbm(String ssbm) {
        this.ssbm = ssbm == null ? null : ssbm.trim();
    }

    public BigDecimal getJsid() {
        return jsid;
    }

    public void setJsid(BigDecimal jsid) {
        this.jsid = jsid;
    }

    public String getJsmc() {
        return jsmc;
    }

    public void setJsmc(String jsmc) {
        this.jsmc = jsmc == null ? null : jsmc.trim();
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm == null ? null : sjhm.trim();
    }

    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx == null ? null : yx.trim();
    }

    public String getZzzt() {
        return zzzt;
    }

    public void setZzzt(String zzzt) {
        this.zzzt = zzzt == null ? null : zzzt.trim();
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