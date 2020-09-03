package contract.pojo.Reportpage;

public class FkhtSimpleInfo {
    String httime;
    String ifsk;
    String fkje;
    String yymc;
    String htbh;
    String fzr;
    String dqsheng;
    String dqshi;
    String ssfzr;
    String flmc;

    public FkhtSimpleInfo(String httime, String ifsk, String fkje, String yymc, String htbh, String fzr, String dqsheng, String dqshi, String ssfzr, String flmc) {
        this.httime = httime;
        this.ifsk = ifsk;
        this.fkje = fkje;
        this.yymc = yymc;
        this.htbh = htbh;
        this.fzr = fzr;
        this.dqsheng = dqsheng;
        this.dqshi = dqshi;
        this.ssfzr = ssfzr;
        this.flmc = flmc;
    }

    public String getHttime() {
        return httime;
    }

    public void setHttime(String httime) {
        this.httime = httime;
    }

    public String getIfsk() {
        return ifsk;
    }

    public void setIfsk(String ifsk) {
        this.ifsk = ifsk;
    }

    public String getFkje() {
        return fkje;
    }

    public void setFkje(String fkje) {
        this.fkje = fkje;
    }

    public String getYymc() {
        return yymc;
    }

    public void setYymc(String yymc) {
        this.yymc = yymc;
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getDqsheng() {
        return dqsheng;
    }

    public void setDqsheng(String dqsheng) {
        this.dqsheng = dqsheng;
    }

    public String getDqshi() {
        return dqshi;
    }

    public void setDqshi(String dqshi) {
        this.dqshi = dqshi;
    }

    public String getSsfzr() {
        return ssfzr;
    }

    public void setSsfzr(String ssfzr) {
        this.ssfzr = ssfzr;
    }

    public String getFlmc() {
        return flmc;
    }

    public void setFlmc(String flmc) {
        this.flmc = flmc;
    }

    @Override
    public String toString() {
        return "FkhtSimpleInfo{" +
                "httime='" + httime + '\'' +
                ", ifsk='" + ifsk + '\'' +
                ", fkje='" + fkje + '\'' +
                ", yymc='" + yymc + '\'' +
                ", htbh='" + htbh + '\'' +
                ", fzr='" + fzr + '\'' +
                ", dqsheng='" + dqsheng + '\'' +
                ", dqshi='" + dqshi + '\'' +
                ", ssfzr='" + ssfzr + '\'' +
                ", flmc='" + flmc + '\'' +
                '}';
    }
}
