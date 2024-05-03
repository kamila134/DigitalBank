@Shopping
Feature: Shopping Website

  Background:
    Given the customer is on the shopping website
    And the customer is logged in

  Scenario: Positive Shopping Experience with Shipping
    And the customer puts the item "Product A" into the cart with quantity 2
    When the customer proceeds to checkout with shipping to "New York, USA"
    And the customer enters shipping information
    And the customer makes a payment with a total price of $50.00
    Then the customer receives an order confirmation for shipping

  Scenario: Positive Shopping Experience with Pickup

    And the customer puts the item "Product B" into the cart with quantity 1
    When the customer proceeds to checkout with pickup at "London, UK"
    And the customer makes a payment with a total price of $25.00
    Then the customer receives an order confirmation for pickup

  Scenario: Negative Shopping Experience with No Card

    And the customer puts the item "Product C" into the cart with quantity 1
    When the customer proceeds to checkout with no payment card
    And the customer enters shipping information
    And the customer makes a payment with a total price of $30.00
    Then the customer receives an error message about the missing payment card

  Scenario: Negative Shopping Experience with Out of Stock Item

    And the customer puts the item "Product D" into the cart with quantity 1
    When the customer proceeds to checkout with shipping to "Los Angeles, USA"
    And the customer enters shipping information
    And the customer makes a payment with a total price of $20.00
    Then the customer receives an error message about an out-of-stock item

    @IGNORE
  Scenario: Negative Shopping Experience with Unavailable Item

    And the customer puts the item "Product E" into the cart with quantity 1
    When the customer proceeds to checkout with shipping to "Edinburgh, UK"
    And the customer enters shipping information
    And the customer makes a payment with a total price of $15.00
    Then the customer receives an error message about the item being unavailable in this town
