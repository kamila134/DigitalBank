package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Order;

import java.util.*;

//        Print all the cities sorted alphabetically
//        Print names of the hotel depending on the rating ascending
//        Print total average of all hotels offered

public class HotelsSteps {

    @Given("a list of hotels with the following details:")
    public void a_list_of_hotels_with_the_following_details(List<Order> orders) {
        String[] citiesList = new String[orders.size()];
        Set<Integer> ratingSet = new TreeSet<>();
        int n = 0;
        double avgGuestRating = 0;
        for (Order ord: orders) {
            citiesList[n++] = ord.getLocation();
            ratingSet.add(ord.getStarRating());
            avgGuestRating+=ord.getAvgGuestRating();
        } Arrays.sort(citiesList);
        avgGuestRating/= orders.size();
        System.out.println("Cities: " + Arrays.toString(citiesList));

        n = 1;
        for (Integer rating: ratingSet) {
            for (Order order: orders) {
                if (rating == order.getStarRating()){
                    System.out.println(n++ + ". " + order.getHotelName());
                }
            }
        } System.out.printf("Average guest rating for all hotels: %.1f", avgGuestRating);

    }
    @When("the hotel management team needs to access and modify hotel details")
    public void the_hotel_management_team_needs_to_access_and_modify_hotel_details() {

    }
    @Then("the team should be able to manage information about each hotel, including its name, location, star rating, available room types, and average guest rating.")
    public void the_team_should_be_able_to_manage_information_about_each_hotel_including_its_name_location_star_rating_available_room_types_and_average_guest_rating() {

    }

}
