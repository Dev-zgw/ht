package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Htqs {
    private BigDecimal id;

    private String htbh;

    private Long qs;

    private Long je;

    private Date yjsj;

    private String sgyq;

    private String sfskwc;

    private Long skje;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    public Htqs(BigDecimal id, String htbh, Long qs, Long je, Date yjsj, String sgyq, String sfskwc, Long skje, String createBy, String updateBy, Date createTime, Date updateTime) {
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

    public Long getJe() {
        return je;
    }

    public void setJe(Long je) {
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

    public Long getSkje() {
        return skje;
    }

    public void setSkje(Long skje) {
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
}