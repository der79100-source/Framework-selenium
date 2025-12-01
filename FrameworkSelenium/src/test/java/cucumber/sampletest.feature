
@tag
Feature: Purchase ordrer from ecommerce website 

Background:
Given I landed on ecommerce page

@tag2
Scenario Outline: Positive Test for order
Given Login with username <name> and password <password>
When I add the Product <productname> from cart
And checkout <productname> and submit order
Then "THANKYOU FOR THE ORDER." message is diplayed

Examples:
|name                   |  password         |  productname          |
|sample.users@abc.com   |  20Autumn@25#     |  ADIDAS ORIGINAL      |

