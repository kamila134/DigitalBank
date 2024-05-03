package models;

public class AccountDetails {

    private String firstName;
    private String lastName;
    private char gender;
    private String dateOfBirth;
    private String ssn;
    private String email;
    private String password;
    private String address;
    private String locality;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;

    public AccountDetails(String firstName, String lastName, char gender, String dateOfBirth, String ssn, String email, String password, String address, String locality, String region, String postalCode, String country, String homePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
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

    public char getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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
