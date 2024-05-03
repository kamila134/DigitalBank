@Building
Feature: Hotels
  Scenario: Manage Hotels
    Given a list of hotels with the following details:
      | hotelName         | location         | starRating | roomTypes             | avgGuestRating |
      | Grand Plaza Hotel | Downtown         | 4          | Single, Double, Suite | 4.5            |
      | Beachfront Resort | Beachfront       | 5          | Deluxe, Ocean View    | 4.8            |
      | City Center Inn   | City Center      | 3          | Standard, Family      | 3.9            |
      | Mountain Lodge    | Mountain Retreat | 4          | Cabin, Chalet         | 4.7            |
    When the hotel management team needs to access and modify hotel details
    Then the team should be able to manage information about each hotel, including its name, location, star rating, available room types, and average guest rating.

  #Print all the cities sorted alphabetically
  #Print names of the hotel depending on the rating ascending
  #Print total average of all hotels offered