package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;
import java.util.Map;

public class SmartphoneSteps {
    String operatingSystem = "";
    double displayMax = 0;
    String display = "";
    int ramMax = 0;
    String ram = "";
    int storageMax = 0;
    String storage = "";
    int priceMin = 10000;
    String price = "";

    @Given("a list of smartphones with their characteristics:")
    public void a_list_of_smartphones_with_their_characteristics(List<Map<String,String>> phoneList) {
        for (Map<String,String> mapVar: phoneList) {
            if (mapVar.get("Smartphone").contains("-")) {
                continue;
            }
            double displaySizeMap = Double.parseDouble(mapVar.get("Display Size (inches)"));
            int ramMap = Integer.parseInt(mapVar.get("RAM (GB)"));
            int storageMap = Integer.parseInt(mapVar.get("Storage (GB)"));
            int priceMap = Integer.parseInt(mapVar.get("Price ($)"));
            if(mapVar.get("Operating System").equals("iOS")) {
                operatingSystem = mapVar.get("Smartphone");
            } if (displaySizeMap > displayMax) {
                displayMax = displaySizeMap;
                display = mapVar.get("Smartphone");
            } if (ramMap > ramMax) {
                ramMax = ramMap;
                ram = mapVar.get("Smartphone");
            } if (storageMap > storageMax) {
                storageMax = storageMap;
                storage = mapVar.get("Smartphone");
            } if (priceMin > priceMap) {
                priceMap = priceMin;
                price = mapVar.get("Smartphone");
            }
        }


    }
    @When("the user compares the smartphones based on the following characteristics:")
    public void the_user_compares_the_smartphones_based_on_the_following_characteristics(List<Map<String,String>> phoneList) {

    }
    @Then("the user should be able to make comparisons between the smartphones and determine which smartphone has:")
    public void the_user_should_be_able_to_make_comparisons_between_the_smartphones_and_determine_which_smartphone_has(List<Map<String,String>> phoneList) {
        System.out.println("The latest operating system: " + operatingSystem);
        System.out.println("The largest display size: " + display);
        System.out.println("The most RAM: " + ram);
        System.out.println("The highest storage capacity: " + storage);
        System.out.println("The lowest price: " + price);
    }
}
