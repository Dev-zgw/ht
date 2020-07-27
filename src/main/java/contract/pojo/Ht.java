package contract.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Ht {
    private BigDecimal id;

    private String htbh;

    private Date qsrq;

    private String fzr;

    private String yymc;

    private String htnr;

    private Long htnrhtnr;

    private Long fkzq;

    private Long nywfje;

    private Date nywfsj;

    private String xxkxm;

    private String xxklxfs;

    private String cwkxm;

    private String cwklxfs;

    private String ywdjr;

    private String ywdjrlxfs;

    private String sfskwc;

    private Long skje;

    private String htsfdq;

    private String htzt;

    private String bz;

    private String yyjb;

    private String dqsheng;

    private String dqshi;

    private String htfl;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private BigDecimal fzrid;

    public Ht(BigDecimal id, String htbh, Date qsrq, String fzr, String yymc, String htnr, Long htnrhtnr, Long fkzq, Long nywfje, Date nywfsj, String xxkxm, String xxklxfs, String cwkxm, String cwklxfs, String ywdjr, String ywdjrlxfs, String sfskwc, Long skje, String htsfdq, String htzt, String bz, String yyjb, String dqsheng, String dqshi, String htfl, String createBy, String updateBy, Date createTime, Date updateTime, BigDecimal fzrid) {
        this.id = id;
        this.htbh = htbh;
        this.qsrq = qsrq;
        this.fzr = fzr;
        this.yymc = yymc;
        this.htnr = htnr;
        this.htnrhtnr = htnrhtnr;
        this.fkzq = fkzq;
        this.nywfje = nywfje;
        this.nywfsj = nywfsj;
        this.xxkxm = xxkxm;
        this.xxklxfs = xxklxfs;
        this.cwkxm = cwkxm;
        this.cwklxfs = cwklxfs;
        this.ywdjr = ywdjr;
        this.ywdjrlxfs = ywdjrlxfs;
        this.sfskwc = sfskwc;
        this.skje = skje;
        this.htsfdq = htsfdq;
        this.htzt = htzt;
        this.bz = bz;
        this.yyjb = yyjb;
        this.dqsheng = dqsheng;
        this.dqshi = dqshi;
        this.htfl = htfl;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.fzrid = fzrid;
    }

    public Ht() {
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

    public Date getQsrq() {
        return qsrq;
    }

    public void setQsrq(Date qsrq) {
        this.qsrq = qsrq;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr == null ? null : fzr.trim();
    }

    public String getYymc() {
        return yymc;
    }

    public void setYymc(String yymc) {
        this.yymc = yymc == null ? null : yymc.trim();
    }

    public String getHtnr() {
        return htnr;
    }

    public void setHtnr(String htnr) {
        this.htnr = htnr == null ? null : htnr.trim();
    }

    public Long getHtnrhtnr() {
        return htnrhtnr;
    }

    public void setHtnrhtnr(Long htnrhtnr) {
        this.htnrhtnr = htnrhtnr;
    }

    public Long getFkzq() {
        return fkzq;
    }

    public void setFkzq(Long fkzq) {
        this.fkzq = fkzq;
    }

    public Long getNywfje() {
        return nywfje;
    }

    public void setNywfje(Long nywfje) {
        this.nywfje = nywfje;
    }

    public Date getNywfsj() {
        return nywfsj;
    }

    public void setNywfsj(Date nywfsj) {
        this.nywfsj = nywfsj;
    }

    public String getXxkxm() {
        return xxkxm;
    }

    public void setXxkxm(String xxkxm) {
        this.xxkxm = xxkxm == null ? null : xxkxm.trim();
    }

    public String getXxklxfs() {
        return xxklxfs;
    }

    public void setXxklxfs(String xxklxfs) {
        this.xxklxfs = xxklxfs == null ? null : xxklxfs.trim();
    }

    public String getCwkxm() {
        return cwkxm;
    }

    public void setCwkxm(String cwkxm) {
        this.cwkxm = cwkxm == null ? null : cwkxm.trim();
    }

    public String getCwklxfs() {
        return cwklxfs;
    }

    public void setCwklxfs(String cwklxfs) {
        this.cwklxfs = cwklxfs == null ? null : cwklxfs.trim();
    }

    public String getYwdjr() {
        return ywdjr;
    }

    public void setYwdjr(String ywdjr) {
        this.ywdjr = ywdjr == null ? null : ywdjr.trim();
    }

    public String getYwdjrlxfs() {
        return ywdjrlxfs;
    }

    public void setYwdjrlxfs(String ywdjrlxfs) {
        this.ywdjrlxfs = ywdjrlxfs == null ? null : ywdjrlxfs.trim();
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

    public String getHtsfdq() {
        return htsfdq;
    }

    public void setHtsfdq(String htsfdq) {
        this.htsfdq = htsfdq == null ? null : htsfdq.trim();
    }

    public String getHtzt() {
        return htzt;
    }

    public void setHtzt(String htzt) {
        this.htzt = htzt == null ? null : htzt.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getYyjb() {
        return yyjb;
    }

    public void setYyjb(String yyjb) {
        this.yyjb = yyjb == null ? null : yyjb.trim();
    }

    public String getDqsheng() {
        return dqsheng;
    }

    public void setDqsheng(String dqsheng) {
        this.dqsheng = dqsheng == null ? null : dqsheng.trim();
    }

    public String getDqshi() {
        return dqshi;
    }

    public void setDqshi(String dqshi) {
        this.dqshi = dqshi == null ? null : dqshi.trim();
    }

    public String getHtfl() {
        return htfl;
    }

    public void setHtfl(String htfl) {
        this.htfl = htfl == null ? null : htfl.trim();
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

    public BigDecimal getFzrid() {
        return fzrid;
    }

    public void setFzrid(BigDecimal fzrid) {
        this.fzrid = fzrid;
    }
}