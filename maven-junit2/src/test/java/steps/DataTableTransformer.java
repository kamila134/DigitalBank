package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en_old.Ac;
import io.cucumber.java.it.Ma;
import models.*;

import java.util.Map;

public class DataTableTransformer {

    @DataTableType
    public Order orderEntry(Map<String,String> entry){
        String hotelName = entry.get("hotelName");
        String location = entry.get("location");
        int starRating = Integer.parseInt(entry.get("starRating"));
        String roomTypes = entry.get("roomTypes");
        double avgGuestRating = Double.parseDouble(entry.get("avgGuestRating"));
        return new Order(hotelName,location,starRating,roomTypes,avgGuestRating);
    }

    @DataTableType
    public Email emailEntry(Map<String,String> entry) {
        String emailType = entry.get("emailType");
        String scheduleFrequency = entry.get("scheduleFrequency");
        String sendTime = entry.get("sendTime");
        return new Email(emailType,scheduleFrequency,sendTime);
    }

    @DataTableType
    public Employee employeeEntry(Map<String,String > entry) {
        String employeeID = entry.get("employeeID");
        String firstName = entry.get("firstName");
        String lastName = entry.get("lastName");
        String department = entry.get("department");
        String position = entry.get("position");
        int salary = Integer.parseInt(entry.get("salary").replaceAll("[$,]",""));
        return new Employee(employeeID,firstName, lastName, department, position, salary);

    }

    @DataTableType
    public OnlineOrder onlineOrderEntry(Map<String,String> entry) {
         String orderId = entry.get("orderId");
         String customerName = entry.get("customerName");
         String shippingAddress = entry.get("shippingAddress");
         String productName = entry.get("productName");
         int quantity = Integer.valueOf(entry.get("quantity"));
         double unitPrice = Double.parseDouble(entry.get("unitPrice"));
         double subtotal = Double.parseDouble(entry.get("subtotal"));
         double taxRate = Double.parseDouble(entry.get("taxRate").replaceAll("%",""));
         double taxAmount = Double.parseDouble(entry.get("taxAmount"));
         double totalAmount = Double.parseDouble(entry.get("totalAmount"));
         return new OnlineOrder(orderId,customerName,shippingAddress,productName,quantity,unitPrice,subtotal,taxRate,taxAmount,totalAmount);
    }

    @DataTableType
    public OnlineOrderGiven onlineOrderGivenEntry(Map<String,String> entry) {
        String orderId = entry.get("orderId");
        String customerName = entry.get("customerName");
        String shippingAddress = entry.get("shippingAddress");
        String productName = entry.get("productName");
        int quantity = Integer.valueOf(entry.get("quantity"));
        double totalAmount = Double.parseDouble(entry.get("totalAmount"));
        return new OnlineOrderGiven(orderId,customerName,shippingAddress,productName,quantity,totalAmount);
    }

    @DataTableType
    public Shoe shoeEntry(Map<String,String> entry) {
        int orderId = Integer.parseInt(entry.get("orderId"));
        String customerName = entry.get("customerName");
        String shippingAddress = entry.get("shippingAddress");
        String shoeModel = entry.get("shoeModel");
        int quantity = entry.get("quantity") != null ? Integer.valueOf(entry.get("quantity")) : 0;
        double unitPrice = entry.get("unitPrice") != null ? Double.parseDouble(entry.get("unitPrice")) : 0.0;
        double subtotal = entry.get("subtotal") != null ? Double.parseDouble(entry.get("subtotal")) : 0.0;
        double taxRate = entry.get("taxRate") != null ? Double.parseDouble(entry.get("taxRate").replaceAll("%","")) : 0.0;
        double taxAmount = entry.get("taxAmount") != null ? Double.parseDouble(entry.get("taxAmount")) : 0.0;
        double totalAmount = entry.get("totalAmount") != null ? Double.parseDouble(entry.get("totalAmount")) : 0.0;
        return new Shoe(orderId,customerName,shippingAddress,shoeModel,quantity,unitPrice,subtotal,taxRate,taxAmount,totalAmount);
    }

    @DataTableType
    public Company companyEntry (Map<String,String> entry) {
        String data = entry.get("data");
        String value = entry.get("value");
        return new Company(data,value);
    }

    @DataTableType
    public CheckingAccount checkingAccountEntry (Map<String,String> entry) {
         String accountType = entry.get("accountType");
         String ownershipType = entry.get("ownershipType");
         String accountName = entry.get("accountName");
         double initialDepositAmount = Double.parseDouble(entry.get("initialDepositAmount"));

         return new CheckingAccount(accountType,ownershipType,accountName,initialDepositAmount);
    }
    
    @DataTableType
    public AccountDetails accountDetailsEntry(Map<String,String> entry) {
         String firstName = entry.get("firstName");
         String lastName = entry.get("lastName");
         char gender = entry.get("gender").charAt(0);
         String dateOfBirth = entry.get("dateOfBirth");
         String ssn = entry.get("ssn");
         String email = entry.get("email");
         String password = entry.get("password");
         String address = entry.get("address");
         String locality = entry.get("locality");
         String region = entry.get("region");
         String postalCode = entry.get("postalCode");
         String country = entry.get("country");
         String homePhone = entry.get("homePhone");

         return new AccountDetails( firstName,  lastName,  gender,  dateOfBirth,  ssn,  email,  password,  address,
                 locality,  region,  country,  postalCode,  homePhone);
    }

    @DataTableType
    public AccountUpdate accountDetailsUpdateEntry(Map<String,String> entry) {
        String firstName = entry.get("firstName");
        String lastName = entry.get("lastName");
        String address = entry.get("address");
        String locality = entry.get("locality");
        String region = entry.get("region");
        String postalCode = entry.get("postalCode");
        String country = entry.get("country");
        String homePhone = entry.get("homePhone");

        return new AccountUpdate( firstName,  lastName, address,
                locality,  region,  country,  postalCode,  homePhone);
    }

}
