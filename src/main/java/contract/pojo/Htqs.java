package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Htqs {
    private BigDecimal id;

    private String htbh;

    private Long qs;

    private BigDecimal je;

    private Date yjsj;

    private String sgyq;

    private String sfskwc;

    private BigDecimal skje;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private Date sj;

    private String ssfzr;

    private BigDecimal ssfzrid;

    private String bz;

    public Htqs(BigDecimal id, String htbh, Long qs, BigDecimal je, Date yjsj, String sgyq, String sfskwc, BigDecimal skje, String createBy, String updateBy, Date createTime, Date updateTime, Date sj, String ssfzr, BigDecimal ssfzrid, String bz) {
        this.id = id;
        this.htbh = htbh;
        this.qs = qs;
        this.je = je;
        this.yjsj = yjsj;
        this.sgyq = sgyq;
        this.sfskwc = sfskwc;
        this.skje = skje;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sj = sj;
        this.ssfzr = ssfzr;
        this.ssfzrid = ssfzrid;
        this.bz = bz;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getSsfzr() {
        return ssfzr;
    }

    public void setSsfzr(String ssfzr) {
        this.ssfzr = ssfzr;
    }

    public BigDecimal getSsfzrid() {
        return ssfzrid;
    }

    public void setSsfzrid(BigDecimal ssfzrid) {
        this.ssfzrid = ssfzrid;
    }

    public Htqs() {
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

    public Long getQs() {
        return qs;
    }

    public void setQs(Long qs) {
        this.qs = qs;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public Date getYjsj() {
        return yjsj;
    }

    public void setYjsj(Date yjsj) {
        this.yjsj = yjsj;
    }

    public String getSgyq() {
        return sgyq;
    }

    public void setSgyq(String sgyq) {
        this.sgyq = sgyq == null ? null : sgyq.trim();
    }

    public String getSfskwc() {
        return sfskwc;
    }

    public void setSfskwc(String sfskwc) {
        this.sfskwc = sfskwc == null ? null : sfskwc.trim();
    }

    public BigDecimal getSkje() {
        return skje;
    }

    public void setSkje(BigDecimal skje) {
        this.skje = skje;
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

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

}
