package contract.pojo.Reportpage;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/9/1 14:26
 */
public class CurrentMonthSimpleInfo {
    String qdhtcount;       //已签订合同数量
    String qdhtje;          //已签订合同金额
    String qdhtdqcount;     //已签订合同覆盖地区数量
    String fkhtcount;       //已付款合同数量
    String fkhtje;          //已付款合同金额
    String wfkhtcount;      //未付款合同数量
    String wfkhtje;        //未付款合同金额

    public CurrentMonthSimpleInfo(String qdhtcount, String qdhtje, String qdhtdqcount, String fkhtcount, String fkhtje, String wfkhtcount, String wfkhtje) {
        this.qdhtcount = qdhtcount;
        this.qdhtje = qdhtje;
        this.qdhtdqcount = qdhtdqcount;
        this.fkhtcount = fkhtcount;
        this.fkhtje = fkhtje;
        this.wfkhtcount = wfkhtcount;
        this.wfkhtje = wfkhtje;
    }

    public String getQdhtcount() {
        return qdhtcount;
    }

    public void setQdhtcount(String qdhtcount) {
        this.qdhtcount = qdhtcount;
    }

    public String getQdhtje() {
        return qdhtje;
    }

    public void setQdhtje(String qdhtje) {
        this.qdhtje = qdhtje;
    }

    public String getQdhtdqcount() {
        return qdhtdqcount;
    }

    public void setQdhtdqcount(String qdhtdqcount) {
        this.qdhtdqcount = qdhtdqcount;
    }

    public String getFkhtcount() {
        return fkhtcount;
    }

    public void setFkhtcount(String fkhtcount) {
        this.fkhtcount = fkhtcount;
    }

    public String getFkhtje() {
        return fkhtje;
    }

    public void setFkhtje(String fkhtje) {
        this.fkhtje = fkhtje;
    }

    public String getWfkhtcount() {
        return wfkhtcount;
    }

    public void setWfkhtcount(String wfkhtcount) {
        this.wfkhtcount = wfkhtcount;
    }

    public String getWfkhtje() {
        return wfkhtje;
    }

    public void setWfkhtje(String wfkhtje) {
        this.wfkhtje = wfkhtje;
    }

    @Override
    public String toString() {
        return "CurrentMonthSimpleInfo{" +
                "qdhtcount='" + qdhtcount + '\'' +
                ", qdhtje='" + qdhtje + '\'' +
                ", qdhtdqcount='" + qdhtdqcount + '\'' +
                ", fkhtcount='" + fkhtcount + '\'' +
                ", fkhtje='" + fkhtje + '\'' +
                ", wfkhtcount='" + wfkhtcount + '\'' +
                ", wfkhtje='" + wfkhtje + '\'' +
                '}';
    }
}
