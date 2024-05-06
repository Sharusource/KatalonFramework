Feature: Check login credentials
  verify the user can able login with valid username and password

  Scenario Outline: Login with valid username and password
    Given I click on LoginHeader from LoginPage
    When I type <username> to the UsernameField field in LoginPage
    And I type <password> to the PasswordField field in LoginPage
    And I click on LoginButton from LoginPage
    Then I can see that WelcomeText from LoginPage contains Welcome sharumathi
    And I click on Logout from LoginPage

    Examples:
      | username   | password     |
      | sharumathi | Sharusara@20 |

  Scenario Outline: Login with blank username and password
    Given I click on LoginHeader from LoginPage
    When I type <username> to the UsernameField field in LoginPage
    And I type <password> to the PasswordField field in LoginPage
    And I click on LoginButton from LoginPage
    Then I verify alertpopup contains Please fill out Username and Password. text

    Examples: 
      | username | password |
      |          |          |

  Scenario Outline: Login with valid username and invalid password
    When I type <username> to the UsernameField field in LoginPage
    And I type <password> to the PasswordField field in LoginPage
    And I click on LoginButton from LoginPage
    Then I verify alertpopup contains Wrong password. text

    Examples: 
      | username   | password      |
      | sharumathi | Sharumathi@20 |

