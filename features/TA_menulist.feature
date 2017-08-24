Feature: Verify TA menu items
Scenario: Product Menu
Given I am in the page "https://www.transamerica.com" 
When I click PRODUCTS from the menu link
Then verify all the Sub menus "Insurance" "MutualFunds" "Annuites" "Retirement solutions" are listed correctly

Scenario: ABOUT US
Given I am in the page "https://www.transamerica.com" 
When I click About US from the menu link
Then verify all the Sub menus "Careers" "Who We Are" "Resources" "Sponsorships" are listed correctly

Scenario: Contact Menu
Given I am in the page "https://www.transamerica.com" 
When I click Contact from the menu link
Then verify all the Sub menus "Insurance" "MutualFunds" "Annuites" "Retirement solutions" are listed correctly


Scenario: SEARCH
Given I am in the page "https://www.transamerica.com" 
When I click SEARCH from the menu link
Then verify all the Sub menus "Find a Form" "Need Help" "Prospectus" "Find a Document" are listed correctly


