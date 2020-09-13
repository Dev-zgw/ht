package contract.pojo.Reportpage;

import java.math.BigDecimal;
import java.util.Date;


public class ComplexHtqs {
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

    private String sj;

    private String ssfzr;

    private BigDecimal ssfzrid;

    private String bz;

    private String flmc;

    private String sheng;

    private String shi;

    private String fzr;

    private String yymc;


    public ComplexHtqs(BigDecimal id, String htbh, Long qs, BigDecimal je, Date yjsj, String sgyq, String sfskwc, BigDecimal skje, String createBy, String updateBy, Date createTime, Date updateTime, String sj, String ssfzr, BigDecimal ssfzrid, String bz, String flmc, String sheng, String shi, String fzr, String yymc) {
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
        this.flmc = flmc;
        this.sheng = sheng;
        this.shi = shi;
        this.fzr = fzr;
        this.yymc = yymc;
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
        this.htbh = htbh;
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
        this.sgyq = sgyq;
    }

    public String getSfskwc() {
        return sfskwc;
    }

    public void setSfskwc(String sfskwc) {
        this.sfskwc = sfskwc;
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
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
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

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getFlmc() {
        return flmc;
    }

    public void setFlmc(String flmc) {
        this.flmc = flmc;
    }

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getYymc() {
        return yymc;
    }

    public void setYymc(String yymc) {
        this.yymc = yymc;
    }

    @Override
    public String toString() {
        return "ComplexHtqs{" +
                "id=" + id +
                ", htbh='" + htbh + '\'' +
                ", qs=" + qs +
                ", je=" + je +
                ", yjsj=" + yjsj +
                ", sgyq='" + sgyq + '\'' +
                ", sfskwc='" + sfskwc + '\'' +
                ", skje=" + skje +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sj='" + sj + '\'' +
                ", ssfzr='" + ssfzr + '\'' +
                ", ssfzrid=" + ssfzrid +
                ", bz='" + bz + '\'' +
                ", flmc='" + flmc + '\'' +
                ", sheng='" + sheng + '\'' +
                ", shi='" + shi + '\'' +
                ", fzr='" + fzr + '\'' +
                ", yymc='" + yymc + '\'' +
                '}';
    }
}
