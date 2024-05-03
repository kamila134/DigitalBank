package models;

public class Order {
    private String hotelName;
    private String location;
    private int starRating;
    private  String roomTypes;
    private  double avgGuestRating;

    public Order(String hotelName, String location, int starRating, String roomTypes, double avgGuestRating) {
        this.hotelName = hotelName;
        this.location = location;
        this.starRating = starRating;
        this.roomTypes = roomTypes;
        this.avgGuestRating = avgGuestRating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(String roomTypes) {
        this.roomTypes = roomTypes;
    }

    public double getAvgGuestRating() {
        return avgGuestRating;
    }

    public void setAvgGuestRating(double avgGuestRating) {
        this.avgGuestRating = avgGuestRating;
    }
}
