Feature: User can able to buy product
  verify the user can able to buy product
  
  
  #Login the application with valid credentials
  Scenario: Login the application
  	Given I click on LoginHeader from LoginPage
  	When I type sharumathi to the UsernameField field in LoginPage
  	And I type Sharusara@20 to the PasswordField field in LoginPage
  	And I click on LoginButton from LoginPage
  	Then I can see that WelcomeText from LoginPage contains Welcome sharumathi
  	
  	
  #buy laptop	
  Scenario: Buy Product
    Given I click on Laptops from CategoriesSection
    When I minimize the browser window
    And I mouseover to the FirstItemImage from CategoriesSection
    And I click on LaptopFirstItem from CategoriesSection
    #it will get the name and store in propertyfile
    And Get the ProductName from CategoriesSection and store in propertyFile
    And Get the ProductPrice from CategoriesSection and store in propertyFile
    And I click on AddToCart from CategoriesSection
    Then I verify alertpopup contains Product added. text
    And I click on CartHeader from CartPage
    Then I can see that Title from CartPage contains ProductName
    Then I can see that Price from CartPage contains ProductPrice
    Then I can see that TotalPrice from CartPage contains ProductPrice
    And I click on PlaceOrder from CartPage
    And I type randomName to the Name field in CartPage
    And I use ctrl+backspace to delete the text field
    #type randomname string
    And I type randomName to the Name field in CartPage
    #type random nunmber
    And I type randomNumber to the CreditCard field in CartPage
    And I click on Purchase from CartPage
    Then I can see that SuccessMessage from CartPage contains Thank you for your purchase!
    And I click on ConfirmButton from CartPage
    And I click on Logout from CartPage
