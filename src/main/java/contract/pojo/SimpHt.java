package contract.pojo;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/9/1 13:49
 */
public class SimpHt {
    String httime;
    String htje;
    String dqsheng;
    String dqshi;

    public SimpHt(String httime, String htje, String dqsheng, String dqshi) {
        this.httime = httime;
        this.htje = htje;
        this.dqsheng = dqsheng;
        this.dqshi = dqshi;
    }


    public String getHttime() {
        return httime;
    }

    public void setHttime(String httime) {
        this.httime = httime;
    }

    public String getHtje() {
        return htje;
    }

    public void setHtje(String htje) {
        this.htje = htje;
    }


    public String getDqsheng() {
        return dqsheng;
    }

    public void setDqsheng(String dqsheng) {
        this.dqsheng = dqsheng;
    }

    public String getDqshi() {
        return dqshi;
    }

    public void setDqshi(String dqshi) {
        this.dqshi = dqshi;
    }

    @Override
    public String toString() {
        return "SimpHt{" +
                "httime='" + httime + '\'' +
                ", htje='" + htje + '\'' +
                ", dqsheng='" + dqsheng + '\'' +
                ", dqshi='" + dqshi + '\'' +
                '}';
    }
}

