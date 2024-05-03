package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static java.lang.Math.*;

public class CalculationsSteps {
    double initialDouble = 0;
    int anotherNum = 0;
    double result = 0;

    @Given("the initial value is {double}")
    public void setInitialValue(double initialValue) {
        initialDouble = initialValue;
    }

    @Given("another number is {int}")
    public void setAnotherNumber(int anotherNumber) {
        anotherNum = anotherNumber;
    }

    @When("the system adds the two numbers")
    public void addTwoNumbers() {
        result = initialDouble + anotherNum;
    }

    @Then("the result should be {double}")
    public void verifyResult(double expected) {
        // Assuming expected is double; adjust if it's an integer
        assert result == expected : "Actual result: " + result;
    }

    @When("the system subtracts the second number from the initial value")
    public void subtractSecondNumber() {
        result = initialDouble - anotherNum;
    }

    @When("the system multiplies the two numbers")
    public void multiplyTwoNumbers() {
        result = initialDouble * anotherNum;
    }

    @When("the system divides the initial value by the second number")
    public void divideBySecondNumber() {
        result = initialDouble / anotherNum;
    }

    @When("the system calculates the square root of the initial value")
    public void calculateSquareRoot() {
        result = sqrt(initialDouble);
    }

    @When("the system calculates the square of the initial value")
    public void calculateSquare() {
        result = pow(initialDouble, 2);
    }

    @When("the system calculates the cube of the initial value")
    public void calculateCube() {
        result = pow(initialDouble, 3);
    }

    @When("rounds it to the nearest integer")
    public void roundToNearestInteger() {
        result = round(result);
    }

    @When("the system calculates the initial value raised to the power of the second number")
    public void calculatePower() {
        result = pow(initialDouble, anotherNum);
    }

    @When("the system calculates the initial value raised to the power of {int}")
    public void calculatePowerWithExponent(int exponent) {
        result = pow(initialDouble, exponent);
    }
}
