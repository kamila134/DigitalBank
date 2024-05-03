Feature: F1 Team Representatives and Car Specifications

  Scenario Outline: Explore F1 Teams, Compare, and Explore Car Specifications
    Given there are <total_teams> F1 teams in the championship
    Given the <team_type> team <team_name> is an F1 team

    When I check the main representatives of the <team_name> <team_role>
    Then I should see their <representative_title> is <representative_name>

    And I compare the <team1_name> and <team2_name> teams
    Then I should see the comparison results

    And I explore the specifications of <team_name>'s F1 car
    Then I should see details about its engine, chassis, and performance

    Examples:
      | total_teams | team_type    | team_name       | team_role         | representative_title | representative_name   | team1_name  | team2_name     |
      | 10          | "leading"    | "Mercedes"      | "management"      | "Team Principal"     | "Toto Wolff"         | "Mercedes"  | "Red Bull"     |
      | 10          | "top"        | "Ferrari"       | "executive"       | "Team Principal"     | "Mattia Binotto"     | "Ferrari"   | "McLaren"      |
      | 10          | "challenger" | "Red Bull"      | "leadership"      | "Team Principal"     | "Christian Horner"   | "Red Bull"  | "Aston Martin" |
      | 10          | "promising"  | "McLaren"       | "management"      | "CEO"                 | "Zak Brown"          | "McLaren"   | "AlphaTauri"   |
      | 10          | "rising"     | "Alpine"        | "executive"       | "CEO"                 | "Laurent Rossi"      | "Alpine"    | "Williams"     |
      | 10          | "rebranded"  | "Aston Martin"  | "leadership"      | "Team Principal"     | "Otmar Szafnauer"    | "Aston Martin" | "Haas"       |
      | 10          | "rising"     | "AlphaTauri"    | "management"      | "Team Principal"     | "Franz Tost"         | "AlphaTauri"| "Alfa Romeo"   |
      | 10          | "historic"   | "Williams"      | "executive"       | "CEO"                 | "Jost Capito"        | "Williams"  | "Mercedes"     |
      | 10          | "underdog"   | "Haas"          | "leadership"      | "Team Principal"     | "Guenther Steiner"   | "Haas"      | "Ferrari"      |
      | 10          | "persistent" | "Alfa Romeo"    | "management"      | "Team Principal"     | "Frederic Vasseur"   | "Alfa Romeo"| "McLaren"      |



  #Write Java Step Definitions:
  # Implement the Java step definitions for the optimized scenario.
  # You will need to create a Java class for step definitions,
  # and within that class, define methods that correspond to each step in the scenario.

