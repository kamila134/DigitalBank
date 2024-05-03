Feature: Smartphone
Scenario: Compare Smartphones Based on Characteristics
Given a list of smartphones with their characteristics:
| Smartphone        | Manufacturer | Operating System | Display Size (inches) | RAM (GB) | Storage (GB) | Price ($) |
|-------------------|--------------|------------------|------------------------|----------|--------------|-----------|
| iPhone 13         | Apple        | iOS              | 6.1                    | 6        | 128          | 799       |
| Samsung Galaxy S21| Samsung      | Android          | 6.2                    | 8        | 256          | 899       |
| Google Pixel 6    | Google       | Android          | 6.4                    | 8        | 128          | 699       |
| OnePlus 9 Pro     | OnePlus      | Android          | 6.7                    | 12       | 256          | 799       |
When the user compares the smartphones based on the following characteristics:
|Operating System|
|Display Size (inches)|
|RAM (GB)|
|Storage (GB)|
|Price ($)|
Then the user should be able to make comparisons between the smartphones and determine which smartphone has:
|The latest operating system|
|The largest display size|
|The most RAM|
|The highest storage capacity|
|The lowest price|