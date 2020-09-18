package contract.pojo.Message;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/9/3 14:10
 */
public class FkMessage {
    String fzr;
    String htbh;
    String htmc;
    String sj;
    String sjhm;
    String sysj;
    String yf;
    String je;

    public FkMessage(String fzr, String htbh, String htmc, String sj, String sjhm, String sysj, String yf, String je) {
        this.fzr = fzr;
        this.htbh = htbh;
        this.htmc = htmc;
        this.sj = sj;
        this.sjhm = sjhm;
        this.sysj = sysj;
        this.yf = yf;
        this.je = je;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public String getHtmc() {
        return htmc;
    }

    public void setHtmc(String htmc) {
        this.htmc = htmc;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public String getSysj() {
        return sysj;
    }

    public void setSysj(String sysj) {
        this.sysj = sysj;
    }

    public String getYf() {
        return yf;
    }

    public void setYf(String yf) {
        this.yf = yf;
    }

    public String getJe() {
        return je;
    }

    public void setJe(String je) {
        this.je = je;
    }

    @Override
    public String toString() {
        return "FkMessage{" +
                "fzr='" + fzr + '\'' +
                ", htbh='" + htbh + '\'' +
                ", htmc='" + htmc + '\'' +
                ", sj='" + sj + '\'' +
                ", sjhm='" + sjhm + '\'' +
                ", sysj='" + sysj + '\'' +
                ", yf='" + yf + '\'' +
                ", je='" + je + '\'' +
                '}';
    }
}
