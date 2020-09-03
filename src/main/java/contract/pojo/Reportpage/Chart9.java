package contract.pojo.Reportpage;

public class Chart9 {
    String htfl;
    String count;
    String sum;
    String avg;

    public Chart9(String htfl, String count, String sum, String avg) {
        this.htfl = htfl;
        this.count = count;
        this.sum = sum;
        this.avg = avg;
    }

    public Chart9() {
    }

    public String getHtfl() {
        return htfl;
    }

    public void setHtfl(String htfl) {
        this.htfl = htfl;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Chart9{" +
                "htfl='" + htfl + '\'' +
                ", count='" + count + '\'' +
                ", sum='" + sum + '\'' +
                ", avg='" + avg + '\'' +
                '}';
    }
}
