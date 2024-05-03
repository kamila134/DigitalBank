
@Regression
Feature: Growing Tomatoes

  Background:
    Given the garden is prepared for planting
    And the gardener is ready to grow tomatoes

    @Smoke
  Scenario Outline: Planting Tomatoes
    Given the gardener has "<tomato_quantity>" tomato seeds
    And the gardener prepares the soil with "<soil_preparation>"
    When the gardener plants the tomato seeds at a depth of "<planting_depth>" inches
    And the gardener waters the seeds
    Then the "<tomato_quantity>" tomato seeds are planted successfully

    Examples:
      | tomato_quantity | soil_preparation | planting_depth |
      | 20             | compost          | 1.5           |
      | 50             | organic matter   | 1.0           |
      | 30             | rich compost     | 2.0           |

  Scenario Outline: Nurturing Tomato Plants
    Given the tomato plants have sprouted
    And the gardener applies fertilizer priced at $"<fertilizer_price>"
    And the gardener monitors for "<potential_issues>"
    When the tomato plants reach a height of "<plant_height>" inches
    Then the tomato plants are well-nurtured

    Examples:
      | fertilizer_price | potential_issues   | plant_height |
      | 10              | aphids, blight     | 12           |
      | 15              | whiteflies, mold   | 15           |
      | 12              | yellowing leaves   | 18           |

    @IGNORE
  Scenario Outline: Harvesting Tomatoes
    Given the tomato plants bear ripe fruit
    And the gardener picks "<ripe_tomato_quantity>" ripe tomatoes
    And the gardener avoids "<insects_to_avoid>"
    When the "<ripe_tomato_quantity>" tomatoes are harvested
    Then the harvest is successful

    Examples:
      | ripe_tomato_quantity | insects_to_avoid          |
      | 50                 | aphids, hornworms          |
      | 75                 | whiteflies, fruit flies   |
      | 60                 | mold, tomato worms        |

