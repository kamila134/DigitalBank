package models;

public class AccountUpdate {

    private String firstName;
    private String lastName;
    private String address;
    private String locality;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;

    public AccountUpdate(String firstName, String lastName, String address, String locality, String region, String postalCode, String country, String homePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.locality = locality;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.homePhone = homePhone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getLocality() {
        return locality;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getHomePhone() {
        return homePhone;
    }
}
