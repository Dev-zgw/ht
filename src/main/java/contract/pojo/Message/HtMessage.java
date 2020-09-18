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
    String htmc;
    String yf;

    public HtMessage(String htbh, String zzrq, String fzr, String sysj, String sjhm, String htmc, String yf) {
        this.htbh = htbh;
        this.zzrq = zzrq;
        this.fzr = fzr;
        this.sysj = sysj;
        this.sjhm = sjhm;
        this.htmc = htmc;
        this.yf = yf;
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


    public String getHtmc() {
        return htmc;
    }

    public void setHtmc(String htmc) {
        this.htmc = htmc;
    }

    public String getYf() {
        return yf;
    }

    public void setYf(String yf) {
        this.yf = yf;
    }

    @Override
    public String toString() {
        return "HtMessage{" +
                "htbh='" + htbh + '\'' +
                ", zzrq='" + zzrq + '\'' +
                ", fzr='" + fzr + '\'' +
                ", sysj='" + sysj + '\'' +
                ", sjhm='" + sjhm + '\'' +
                ", htmc='" + htmc + '\'' +
                ", yf='" + yf + '\'' +
                '}';
    }
}
