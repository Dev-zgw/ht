package contract.pojo.Message;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/9/3 14:23
 */
public class HtMessage {
    String htbh;
    String zzrq;
    String fzr;
    String sysj;
    String sjhm;
    String xxmc;

    public HtMessage(String htbh, String zzrq, String fzr, String sysj, String sjhm, String xxmc) {
        this.htbh = htbh;
        this.zzrq = zzrq;
        this.fzr = fzr;
        this.sysj = sysj;
        this.sjhm = sjhm;
        this.xxmc = xxmc;
    }


    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public String getZzrq() {
        return zzrq;
    }

    public void setZzrq(String zzrq) {
        this.zzrq = zzrq;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getSysj() {
        return sysj;
    }

    public void setSysj(String sysj) {
        this.sysj = sysj;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    @Override
    public String toString() {
        return "HtMessage{" +
                "htbh='" + htbh + '\'' +
                ", zzrq='" + zzrq + '\'' +
                ", fzr='" + fzr + '\'' +
                ", sysj='" + sysj + '\'' +
                ", sjhm='" + sjhm + '\'' +
                '}';
    }

    public String getXxmc() {
        return xxmc;
    }

    public void setXxmc(String xxmc) {
        this.xxmc = xxmc;
    }
}
