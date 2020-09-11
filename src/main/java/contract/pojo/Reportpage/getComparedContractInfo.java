package contract.pojo.Reportpage;

import java.util.List;

public class getComparedContractInfo {
    List<String> contracttype;
    List<String> querytype;
    List<getChartBasicInfo> series;

    public getComparedContractInfo(List<String> contracttype, List<String> querytype, List<getChartBasicInfo> series) {
        this.contracttype = contracttype;
        this.querytype = querytype;
        this.series = series;
    }

    public List<String> getContracttype() {
        return contracttype;
    }

    public void setContracttype(List<String> contracttype) {
        this.contracttype = contracttype;
    }

    public List<String> getQuerytype() {
        return querytype;
    }

    public void setQuerytype(List<String> querytype) {
        this.querytype = querytype;
    }

    public List<getChartBasicInfo> getSeries() {
        return series;
    }

    public void setSeries(List<getChartBasicInfo> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "getComparedContractInfo{" +
                "contracttype=" + contracttype +
                ", querytype=" + querytype +
                ", series=" + series +
                '}';
    }
}
