package contract.pojo;

import java.math.BigDecimal;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/13 16:53
 */
public class Report {
    private BigDecimal id;
    private int htCount;
    private int htTotalPrice;
    private int departmentPeopleNum;
    private int totalPeopleNum;

    public Report(BigDecimal id, int htCount, int htTotalPrice, int departmentPeopleNum, int totalPeopleNum) {
        this.id = id;
        this.htCount = htCount;
        this.htTotalPrice = htTotalPrice;
        this.departmentPeopleNum = departmentPeopleNum;
        this.totalPeopleNum = totalPeopleNum;
    }

    public BigDecimal getId() {
        return id;
    }

    public int getHtCount() {
        return htCount;
    }

    public int getHtTotalPrice() {
        return htTotalPrice;
    }

    public int getDepartmentPeopleNum() {
        return departmentPeopleNum;
    }

    public int getTotalPeopleNum() {
        return totalPeopleNum;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setHtCount(int htCount) {
        this.htCount = htCount;
    }

    public void setHtTotalPrice(int htTotalPrice) {
        this.htTotalPrice = htTotalPrice;
    }

    public void setDepartmentPeopleNum(int departmentPeopleNum) {
        this.departmentPeopleNum = departmentPeopleNum;
    }

    public void setTotalPeopleNum(int totalPeopleNum) {
        this.totalPeopleNum = totalPeopleNum;
    }

    public Report() {
        super();
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", htCount=" + htCount +
                ", htTotalPrice=" + htTotalPrice +
                ", departmentPeopleNum=" + departmentPeopleNum +
                ", totalPeopleNum=" + totalPeopleNum +
                '}';
    }
}
