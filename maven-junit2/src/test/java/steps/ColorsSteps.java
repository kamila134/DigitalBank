package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.Objects;

public class ColorsSteps {
    static String firstColor = "";
    static String secondColor = "";
    static String result = "";

    @Given("the first color is {string}")
    public void the_first_color_is(String string) {
        firstColor = string;
        System.out.println("The first color is " + firstColor);
    }
    @Given("the second color is {string}")
    public void the_second_color_is(String string) {
        secondColor = string;
        System.out.println("The second color is " + secondColor);
    }
    @When("the system mixes the two colors")
    public void the_system_mixes_the_two_colors() {
        System.out.println("Mixing the colors ...");
        if (Objects.equals(firstColor, "red")) {
            switch (secondColor) {
                case "blue":
                    result = "purple";
                    break;
                case "green":
                    result = "brown";
                    break;
                case "yellow":
                    result = "orange";
                    break;
                case "purple":
                    result = "unknown";
                    break;
            }
        } else if (Objects.equals(firstColor, "yellow") && Objects.equals(secondColor, "greem")){
            result = "yellow-green";
        } else if (Objects.equals(firstColor, "orange") && Objects.equals(secondColor, "blue")){
            result = "brown";
        } else if (firstColor.equals("blue") && secondColor.equalsIgnoreCase("blue")) {
            result = "blue";
        }
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String string) {
        System.out.println("The result is " + result);
    }
}
