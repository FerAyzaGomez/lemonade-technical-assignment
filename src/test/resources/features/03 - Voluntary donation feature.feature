@all @donation
Feature: Voluntary donation feature

	@dev
	Scenario: Voluntary donation of a valid amount.
		Given the Wikipedia main page (english)
		And the user clicks on the Donate button
		And the user jumps to the donation page
		When the user introduces a valid donation value
		And clicks on “No, I’m not able to offer future support or advice“ and on the Credit Card payment method
		And the browser brings the user to the payment platform page
		And introduces the credit card information and clicks on the Donate button
		Then the donation has been performed


	Scenario: Negative case for non valid amount donation
		Given the Wikipedia main page (english)
		And the user clicks on the Donate button
		And the user jumps to the donation page
		When the user introduces a non valid donation value out of 0.84€ and 9977.31€
		And the amount selection error is shown
		And clicks on “No, I’m not able to offer future support or advice“ and on the Credit Card payment method
		Then the user cannot jump to the payment platform page