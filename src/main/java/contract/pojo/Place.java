package contract.pojo;


public class Place {
    String place;

    public Place(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Sheng{" +
                "place='" + place + '\'' +
                '}';
    }
}
