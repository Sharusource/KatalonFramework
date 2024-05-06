Feature: Check Signup
  verify the user can able signup with valid username and password

  Scenario Outline: Login with valid username and password
    Given I click on SignUpHeader from SignUpPage
    When I type <username> to the UserName field in SignUpPage
    And I type <password> to the Password field in SignUpPage
    And I click on SignUpButton from SignUpPage
    Then I verify alertpopup contains This user already exist. text

    Examples: 
      | username   | password     |
      | sharumathi | Sharusara@20 |

  Scenario Outline: Login with blank username and password
    When I type <username> to the UserName field in SignUpPage
    And I type <password> to the Password field in SignUpPage
    And I click on SignUpButton from SignUpPage
    Then I verify alertpopup contains Please fill out Username and Password. text

    Examples: 
      | username | password |
      |          |          |

  Scenario Outline: Verify user can able to signup with new credentials
    When I type <username> to the UserName field in SignUpPage
    And I type <password> to the Password field in SignUpPage
    And I click on SignUpButton from SignUpPage
    Then I verify alertpopup contains Sign up successful. text

    Examples: 
      | username   | password     |
      | zucisystem | Sharusara@20 |
