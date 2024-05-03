package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.ArrayList;
import java.util.List;

//ex. 16.21.2
public class Xpath_CustomersList {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");
        Thread.sleep(3000);

        //table/tbody/tr/td[1]

        List<CustomerNew> customerNewList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String firstNameX = "//table/tbody/tr[" + i + "]/td[1]";
            String lastNameX = "//table/tbody/tr[" + i + "]/td[2]";
            String postCodeX = "//table/tbody/tr[" + i + "]/td[3]";
            String accNumX = "//table/tbody/tr[" + i + "]/td[4]";

            WebElement firstNameTxt = driver.findElement(By.xpath(firstNameX));
            WebElement lastNameTxt = driver.findElement(By.xpath(lastNameX));
            WebElement postCodeTxt = driver.findElement(By.xpath(postCodeX));
            WebElement accNumTxt = driver.findElement(By.xpath(accNumX));

            Thread.sleep(1000);
            String firstName = firstNameTxt.getText();
            String lastName = lastNameTxt.getText();
            String postCode = postCodeTxt.getText();
            String accNum = accNumTxt.getText();
            Thread.sleep(1000);

            System.out.println(firstName + " " + lastName + " " + postCode + " " + accNum);

            CustomerNew customer = new CustomerNew(firstName,lastName,postCode,accNum);
            customerNewList.add(customer);
            Thread.sleep(1000);
        }


        Xpath_CustomersList.customerWithOddNumbers(customerNewList);

    }

    public static void customerWithOddNumbers (List<CustomerNew> customerList) {
        System.out.println("The following customers's account numbers end with an odd digit:");
        for (CustomerNew customer: customerList) {
            long num = Long.parseLong(customer.getAccNum().replaceAll(" ", ""));
            if (num%2 != 0) {
                System.out.println(customer.getFirstName() + " " + customer.getLastName());
            }
        }
    }

}

class CustomerNew {
    private String firstName;
    private String lastName;
    private String postCode;
    private String accNum;

    public CustomerNew(String firstName, String lastName, String postCode, String accNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
        this.accNum = accNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getAccNum() {
        return accNum;
    }
    //First Name	Last Name	Post Code	Account Number
}



