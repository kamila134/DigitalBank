Feature: Analyzing Data of US Trading Companies

  Scenario Outline: Analyze Data of US Trading Companies
    Given there are <total_companies> US trading companies in the market
    And the company "<company_name>" is headquartered in "<headquarters>"
    And the company manages assets worth $<company_assets> billion
    And the company holds shares in <top_shares> top companies
    And there are <company_employees> employees working at the company
    And the company is represented by "<representative_name>"
    And the company was established in <establishment_year>

    When I analyze the assets, shares, employees, headquarters, representatives, and establishment year of "<company_name>"

    Then I should see the following data for "<company_name>":
      | data           | value              |
      | Assets         | $<expected_assets> billion |
      | Top Shares     | <expected_top_shares> companies |
      | Employees      | <expected_employees> employees |
      | Headquarters   | <expected_headquarters> |
      | Representative | <expected_representative> |
      | Establishment Year | <expected_establishment_year> |

    And I calculate the total value of shares held by "<company_name>"
    And I identify the highest-paid employee at "<company_name>"
    And I check the total assets managed by "<company_name>"
    And I verify the number of top shares held by "<company_name>"
    And I determine the number of employees at "<company_name>"
    And I look into the headquarters of "<company_name>"
    And I find the representative's name at "<company_name>"
    And I estimate the year of establishment of "<company_name>"

    Then I should see the additional data for "<company_name>":
      | data                        | value              |
      | Total Share Value           | $<expected_share_value> billion |
      | Highest Paid Employee       | "<expected_highest_paid>" |
      | Total Managed Assets        | $<expected_total_assets> billion |
      | Number of Top Shares Held   | <expected_top_shares> companies |
      | Number of Employees         | <expected_employees> employees |
      | Headquarters                 | "<expected_headquarters>" |
      | Representative                | "<expected_representative>" |
      | Establishment Year           | <expected_establishment_year> |

    Examples:
      | company_name  | headquarters        | company_assets | top_shares | company_employees | representative_name | establishment_year | expected_assets | expected_top_shares | expected_employees | expected_headquarters | expected_representative | expected_establishment_year | expected_share_value | expected_highest_paid | expected_total_assets |
      | "Company A"   | "New York"         | 100            | 10        | 1000              | "John Smith"        | 1995              | 100              | 10                   | 1000                | "New York"             | "John Smith"             | 1995                      | 50                   | "John Smith"          | 100                   |
      | "Company B"   | "Chicago"          | 75             | 8         | 800               | "Emily Johnson"     | 2000              | 75               | 8                    | 800                 | "Chicago"              | "Emily Johnson"          | 2000                      | 40                   | "Emily Johnson"       | 75                    |
      | "Company C"   | "Los Angeles"      | 50             | 5         | 500               | "Michael Brown"     | 2005              | 50               | 5                    | 500                 | "Los Angeles"          | "Michael Brown"          | 2005                      | 30                   | "Michael Brown"       | 50                    |