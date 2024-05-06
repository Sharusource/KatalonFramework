Feature: Read data from excel and login the application
  verify the user can able to login the application using excel data
  
  #it will read the data from excel and pass in a input field - tried for one data , if multiple data use forloop 
  Scenario: Login the application using excel data
  	Given I click on LoginHeader from LoginPage
  	When Read username from excel and pass it to the UsernameField in LoginPage 
  	And Read password data from excel and pass it to the PasswordField in LoginPage 
  	And I click on LoginButton from LoginPage
  	Then I can see that WelcomeText from LoginPage contains Welcome sharumathi