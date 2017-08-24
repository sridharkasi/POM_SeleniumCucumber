Feature: Create New Contact in TA site

Scenario:
When I Navigate the application "https://www.transamerica.com" using browser "firefox"

Scenario Outline: create contact
Given I am in transamerica home page
When I click the Contact page
And enter the contact details "<firstname>" "<lastname>" "<email>" "<city>" "<state>" "<topic>" "<Message>"
Then Verify the contact details sumbited

Examples:
|firstname|lastname|email|city|state|topic|Message|
|Don|Dav|test@email.com|New York|New York|General Comments|test message|