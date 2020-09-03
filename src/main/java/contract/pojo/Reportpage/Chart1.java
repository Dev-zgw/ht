package contract.pojo.Reportpage;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/21 11:35
 */
public class Chart1 {
    String httime;
    String count;
    String sum;
    String avg;


    public Chart1(String httime, String count, String sum, String avg) {
        this.httime = httime;
        this.count = count;
        this.sum = sum;
        this.avg = avg;
    }

    public Chart1() {
    }

    public String gethttime() {
        return httime;
    }

    public void sethttime(String httime) {
        this.httime = httime;
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
        return "Chart1{" +
                "httime='" + httime + '\'' +
                ", count='" + count + '\'' +
                ", sum='" + sum + '\'' +
                ", avg='" + avg + '\'' +
                '}';
    }
}
