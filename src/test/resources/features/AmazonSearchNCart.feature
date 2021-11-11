@Test
Feature: Add items to shopping cart

Scenario outline: As a Customer when I search for Alexa, I want to see if the third option on the second page is available for purchase and can be added to the cart.
    Given the user navigates to www.amazon.com
    And searches for <ItemName>
    And navigates to the page <PageNumber>
    And selects the item <ItemNumber>
    Then assert that the item would be available for purchase

    Examples:
        | ItemName | PageNumber | ItemNumber |
        | Alexa    | 2          | 3          |
        | Kindle   | 3          | 5          |