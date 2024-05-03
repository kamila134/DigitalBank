package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

//#find the best places with wifi and parking and print the most expensive and cheapest ones accordingly.

public class HousesSteps {

    double expensive = 0;
    String expHouse = "";
    double cheap = 100000;
    String cheapHouse = "";

    @Given("a list of houses held by a rental agency with the following details:")
    public void a_list_of_houses_held_by_a_rental_agency_with_the_following_details(List<Map<String,String>> houseList) {
        for (Map<String,String> mapVar: houseList) {
            if (mapVar.get("House Name").contains("-")){
                continue;
            } else if (mapVar.get("Wi-Fi").contains("Yes") && mapVar.get("Parking").contains("Yes")) {
                String priceStr = mapVar.get("Price per Night").replaceAll("\\$","");
                double pricePerNight = Double.parseDouble(priceStr);
                if(pricePerNight > expensive) {
                    expensive = pricePerNight;
                    expHouse = mapVar.get("House Name");
                } if (cheap > pricePerNight) {
                    cheap = pricePerNight;
                    cheapHouse = mapVar.get("House Name");
                }
            }
        }
    }
    @When("the agency needs to manage the houses' details")
    public void the_agency_needs_to_manage_the_houses_details() {

    }
    @Then("the agency should be able to access and modify information about each house, including price per night, number of rooms, maximum guests, Wi-Fi availability, parking availability, address, and check-in\\/check-out times.")
    public void the_agency_should_be_able_to_access_and_modify_information_about_each_house_including_price_per_night_number_of_rooms_maximum_guests_wi_fi_availability_parking_availability_address_and_check_in_check_out_times() {
        System.out.println("Best cheapest option: " + cheapHouse);
        System.out.println("Best most expenisve option: " + expHouse);
    }
}
