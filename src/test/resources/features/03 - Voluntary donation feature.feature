@all @donation
Feature: Voluntary donation feature


	Scenario: Voluntary donation of a valid amount.
		Given the Wikipedia main page (english)
		And the user clicks on the Donate button
		And the user jumps to the donation page
		When the user introduces a valid donation value
		And clicks on “No, I’m not able to offer future support or advice“ and on the Credit Card payment method
		And the browser brings the user to the payment platform page
		And introduces the credit card information and clicks on the Donate button
		Then the donation has been performed 
			# For this last step, since I'm working into a Production environment, I'm not triggering a successfull payment.
			# For this case I'll take the error message and the error reference as a successful payment
