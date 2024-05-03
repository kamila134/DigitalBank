Feature: Growing Carrots

  Background:
    Given the garden is prepared for planting
    And the gardener is ready to grow carrots

  Scenario Outline: Growing Carrot Seeds
    Given the gardener has "<carrot_quantity>" carrot seeds
    And the gardener prepares the soil with "<soil_preparation>"
    When the gardener grows carrot seeds at a depth of "<planting_depth>" inches
    And the gardener waters the seeds
    Then the "<carrot_quantity>" carrot seeds are grown successfully

    Examples:
      | carrot_quantity | soil_preparation | planting_depth |
      | 100            | compost          | 1.0           |
      | 80             | organic matter   | 0.8           |
      | 120            | rich compost     | 1.2           |

  Scenario Outline: Caring for Carrot Plants
    Given the carrot plants emerge from the soil
    And the gardener applies organic fertilizer priced at $"<fertilizer_price>"
    And the gardener inspects for "<potential_issues>"
    When the carrot tops are lush
    Then the carrot plants are well-cared for

    Examples:
      | fertilizer_price | potential_issues   |
      | 18              | pests, soil erosion |
      | 20              | root rot, weevils   |
      | 15              | yellowing leaves   |

  Scenario Outline: Harvesting Carrots
    Given the carrot roots are mature
    And the gardener pulls up "<mature_carrot_quantity>" mature carrots
    And the gardener avoids "<insects_to_avoid>"
    When the "<mature_carrot_quantity>" carrots are harvested
    Then the harvest is successful

    Examples:
      | mature_carrot_quantity | insects_to_avoid |
      | 90                   | nematodes, aphids |
      | 75                   | weevils, carrot flies |
      | 105                  | root-knot nematodes |


