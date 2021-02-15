Feature: Login Feature



#Scenario: SFDC Valid Login Test Scenario
#
#Given user is already on Login Page
#When title of login page is
#Then user enters "naveenk" and "test@123"
#Then user clicks on login button
#Then user is on home page


#with Examples Keyword
  Scenario Outline: SFDC Valid Login Test Scenario

    Given user is already on Login Page
    When title of login page is Login Salesorce
    Then user enters "<username>" and "<password>"
    Then user clicks on login button
    Then user is on home page
    Then Close the browser

    Examples:
      | username | password |
      | 123ela@gmail.com  | test@234 |