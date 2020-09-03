package contract.pojo.Reportpage;


import java.util.List;

public class FkHtInfoToQt {
    List<String> month;
    List<String> yfkhtcount;
    List<String> yfkhtje;
    List<String> wfkhtcount;
    List<String> wfkhtje;


    public FkHtInfoToQt(List<String> month, List<String> yfkhtcount, List<String> yfkhtje, List<String> wfkhtcount, List<String> wfkhtje) {
        this.month = month;
        this.yfkhtcount = yfkhtcount;
        this.yfkhtje = yfkhtje;
        this.wfkhtcount = wfkhtcount;
        this.wfkhtje = wfkhtje;
    }

    public List<String> getMonth() {
        return month;
    }

    public void setMonth(List<String> month) {
        this.month = month;
    }

    public List<String> getYfkhtcount() {
        return yfkhtcount;
    }

    public void setYfkhtcount(List<String> yfkhtcount) {
        this.yfkhtcount = yfkhtcount;
    }

    public List<String> getYfkhtje() {
        return yfkhtje;
    }

    public void setYfkhtje(List<String> yfkhtje) {
        this.yfkhtje = yfkhtje;
    }

    public List<String> getWfkhtcount() {
        return wfkhtcount;
    }

    public void setWfkhtcount(List<String> wfkhtcount) {
        this.wfkhtcount = wfkhtcount;
    }

    public List<String> getWfkhtje() {
        return wfkhtje;
    }

    public void setWfkhtje(List<String> wfkhtje) {
        this.wfkhtje = wfkhtje;
    }

    @Override
    public String toString() {
        return "FkHtInfoToQt{" +
                "month=" + month +
                ", yfkhtcount=" + yfkhtcount +
                ", yfkhtje=" + yfkhtje +
                ", wfkhtcount=" + wfkhtcount +
                ", wfkhtje=" + wfkhtje +
                '}';
    }
}
