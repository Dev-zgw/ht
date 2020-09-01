package contract.pojo;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/9/1 15:04
 */
public class SimpHtqs {
    String httime;
    String ifsk;
    String fkje;
    String htbh;
    String fzr;
    String ssfzr;

    public SimpHtqs(String httime, String ifsk, String fkje, String htbh, String fzr, String ssfzr) {
        this.httime = httime;
        this.ifsk = ifsk;
        this.fkje = fkje;
        this.htbh = htbh;
        this.fzr = fzr;
        this.ssfzr = ssfzr;
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

    public String getSsfzr() {
        return ssfzr;
    }

    public void setSsfzr(String ssfzr) {
        this.ssfzr = ssfzr;
    }

    @Override
    public String toString() {
        return "SimpleHtqs{" +
                "httime='" + httime + '\'' +
                ", ifsk='" + ifsk + '\'' +
                ", fkje='" + fkje + '\'' +
                ", htbh='" + htbh + '\'' +
                ", fzr='" + fzr + '\'' +
                ", ssfzr='" + ssfzr + '\'' +
                '}';
    }
}
