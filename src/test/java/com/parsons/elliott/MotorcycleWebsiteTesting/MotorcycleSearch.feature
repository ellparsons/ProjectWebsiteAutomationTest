Feature: Search for motorcycle on a website
  As a person
  I want to search for motorcycles on a website
  So that I can find motorcycles i want
  
Scenario: Browse the items available on the website
  Given the correct web address
  When I navigate to the 'Search' page
  Then I can browse all the motorcycles.

Scenario: Use search parameters to find motorcycle
  Given the correct web address
  When I input a motorcycle and click the search button
  Then I am shown motorcycles relating to my search

 