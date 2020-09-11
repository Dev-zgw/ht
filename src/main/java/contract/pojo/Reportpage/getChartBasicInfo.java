package contract.pojo.Reportpage;


import java.util.List;

public class getChartBasicInfo {
    String name;
    String stack;
    String type;
    List<String> data;

    public getChartBasicInfo(String name, String stack, String type, List<String> data) {
        this.name = name;
        this.stack = "总量";
        this.type = "bar";
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "getchart6info{" +
                "name='" + name + '\'' +
                ", stack='" + stack + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
