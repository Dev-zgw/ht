package contract.pojo;


public class getchart9info {
    String name;
    String value;
    Boolean selected;

    public getchart9info(String name, String value, Boolean selected) {
        this.name = name;
        this.value = value;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Chart9{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", selected=" + selected +
                '}';
    }
}
