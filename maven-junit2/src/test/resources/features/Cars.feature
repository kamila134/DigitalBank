Feature: Cars
Scenario: Compare Cars Based on Characteristics
Given a list of cars with their characteristics:
| Car            | Manufacturer   | Type         | Fuel Type   | Engine Size (L)    | Horsepower   | Price ($)   |
| Toyota Camry   | Toyota         | Sedan        | Gasoline    | 2.5                | 203          | 25000      |
| Honda Civic    | Honda          | Sedan        | Gasoline    | 2.0                | 158          | 22000      |
| Ford Mustang   | Ford           | Sports Car   | Gasoline    | 5.0                | 450          | 45000      |
| Tesla Model 3  | Tesla          | Electric     | Electric    | N/A                | 283          | 40000      |

When the user compares the cars based on the following characteristics:
| Type            |
| Fuel Type       |
| Engine Size (L) |
| Horsepower      |
| Price ($)       |
Then the user should be able to make comparisons between the cars and determine which car has:
| The smallest engine size |
| The highest horsepower   |
| The lowest price         |



