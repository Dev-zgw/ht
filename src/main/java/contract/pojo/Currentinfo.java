package contract.pojo;

public class Currentinfo {
    String httime;
    String count;
    String sum;
    String avg;

    public Currentinfo(String httime, String count, String sum, String avg) {
        this.httime = httime;
        this.count = count;
        this.sum = sum;
        this.avg = avg;
    }
    public Currentinfo() {
    }

    public String getHttime() {
        return httime;
    }

    public void setHttime(String httime) {
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
        return "Currentinfo{" +
                "httime='" + httime + '\'' +
                ", count='" + count + '\'' +
                ", sum='" + sum + '\'' +
                ", avg='" + avg + '\'' +
                '}';
    }
}
