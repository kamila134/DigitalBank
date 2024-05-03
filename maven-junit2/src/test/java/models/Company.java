package models;

public class Company {
    private String data;
    private String value;

    public Company(String data, String value) {
        this.data = data;
        this.value = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
