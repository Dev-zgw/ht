package contract.pojo;


public class Chart5 {
    String htfl;
    String count;
    String percent;

    public Chart5(String htfl, String count, String percent) {
        this.htfl = htfl;
        this.count = count;
        this.percent = percent;
    }

    public Chart5() {
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

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Chart5{" +
                "htfl='" + htfl + '\'' +
                ", count='" + count + '\'' +
                ", percent='" + percent + '\'' +
                '}';
    }
}
