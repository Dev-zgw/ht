package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Result {
    private BigDecimal id;

    private String htbh;

    private BigDecimal userid;

    private String xm;

    private Date czsj;

    private String cznr;

    private String bz;

    private String createBy;

    private Date createTime;

    public Result(BigDecimal id, String htbh, BigDecimal userid, String xm, Date czsj, String cznr, String bz, String createBy, Date createTime) {
        this.id = id;
        this.htbh = htbh;
        this.userid = userid;
        this.xm = xm;
        this.czsj = czsj;
        this.cznr = cznr;
        this.bz = bz;
        this.createBy = createBy;
        this.createTime = createTime;
    }

    public Result() {
        super();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh == null ? null : htbh.trim();
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Date getCzsj() {
        return czsj;
    }

    public void setCzsj(Date czsj) {
        this.czsj = czsj;
    }

    public String getCznr() {
        return cznr;
    }

    public void setCznr(String cznr) {
        this.cznr = cznr == null ? null : cznr.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}