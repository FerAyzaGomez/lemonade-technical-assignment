@all @login
Feature: Page login and logout


	Scenario: Logging in successfully
		Given the Wikipedia main page (english)
		And a correct Wikipedia registered user
		When the user clicks on the login button
		And enters the User and Password and clicks on the Log In button
		Then the user has been successfully logged in

	Scenario: Logging out successfully
		Given the Wikipedia main page (english)
		And a correct Wikipedia registered user
		And correct logged in into the website
		When the user clicks on the log out button
		Then the user has been successfully logged out


	Scenario: Wrong attempt of logging in (wrong password)
		Given the Wikipedia main page (english)
		And a correct user but an incorrect password
		When the user clicks on the login button
		And enters the User and Password and clicks on the Log In button
		Then the user can’t be successfully logged in