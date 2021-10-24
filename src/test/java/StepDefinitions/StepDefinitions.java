package StepDefinitions;



import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import helpers.Helpers;
import loginMethods.LoginMethods;
import searchMethods.SearchMethods;
import donationMethods.DonationMethods;


public class StepDefinitions {

	WebDriver driver = null;
	Helpers helper = new Helpers();
	LoginMethods loginMethods = new LoginMethods();
	SearchMethods searchMethods = new SearchMethods();
	DonationMethods donationMethods = new DonationMethods();
	String URL = "https://en.wikipedia.org/wiki/Main_Page";
	String user = null;
	String password = null;
	String nameToSearch = null;
	String searchedName= null;
	String firstName = "testFirstName";
	String lastName = "testLastName";
	String email = "test@gmail.com";
	String card = "4111111111111111";
	String expiryDate ="10/22";
	String cvv ="123";
	String paymentReference = "";
	
	//Element definitions by id
	String welcome = "mp-welcome";
	String loginButton = "pt-login";
	String usernameTextBox = "wpName1";
	String passwordTextbox = "wpPassword1";
	String loginAttemptButton = "wpLoginAttempt";
	String logoutButton = "pt-logout";
	String logOutText = "firstHeading";
	String searchTextInut = "searchInput";
	String searchButton = "searchButton";
	String textFirstHeading = "firstHeading";
	String donateButton = "n-sitesupport";
	String donationPageWikiLogo = "p-logo";
	String otherDonationBox = "input_amount_other_box";
	String noOptionOnDonationPage = "optin-no";
	String paymentPlatform = "payment-form";
	String paymentFirstName = "first_name";
	String paymentLastName = "last_name";
	String paymentEmail = "email";
	String visaButton = "submethod-visa";
	String cardNumberField = "cardNumber";
	String expiryDateField = "expiryDate";
	String cvvField = "cvv";
	String submitDonationButton = "primaryButton";
	String cancellationButton = "secondaryButton";
	
	
	//Element definitions by xpath
	String loginErrorMessage = "//div[@class='errorbox']";
	String creditCardButton = "//div[@class='payment-method-div monthly-capable paymentmethod-cc cctypes-vmaj']";
	String referenceNumber = "//div[@id='mw-content-text']//p[3]";
	String paymentErrorMessage = "//div[@id='mw-content-text']";
	String paymentIframe = "//iframe[@name='ingenico-iFrame']";
	
	
	//Element definitions by Link contained text
	String donationLink = "Donate";
	String tryAgain = "try again";
	
	@Given("the Wikipedia main page \\(english)")
	public void the_wikipedia_main_page_english() {
		
		this.helper.setDriverProperties();
		this.driver = this.helper.initializeDriver(this.driver);
		this.helper.openURL(this.driver, this.URL);
		this.helper.waitUntilElementIsPresentById(this.driver, welcome);		
	}


	@Given("a correct Wikipedia registered user")
	public void a_correct_wikipedia_registered_user() {
		this.user = this.loginMethods.loadUser();
		this.password = this.loginMethods.correctPass();
	}


	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		this.loginMethods.clickcOnLoginButton(this.driver, this.loginButton);
	}


	@When("enters the User and Password and clicks on the Log In button")
	public void enters_the_user_and_password_and_clicks_on_the_Log_In_button() {
		this.loginMethods.writeUserAndPassword(this.driver, this.user, this.usernameTextBox, this.password, this.passwordTextbox);
		this.loginMethods.clickOnLoginAttemptButton(this.driver, this.loginAttemptButton);
		
	}


	@Then("the user has been successfully logged in")
	public void the_user_has_been_successfully_logged_in() {
		this.loginMethods.userSuccessfullyLoggedIn(this.driver, this.logoutButton);
		this.helper.closeDriver(this.driver);
	}


	@Given("correct logged in into the website")
	public void correct_logged_in_into_the_website() {
		this.loginMethods.clickcOnLoginButton(this.driver, this.loginButton);
		this.loginMethods.writeUserAndPassword(this.driver, this.user, this.usernameTextBox, this.password, this.passwordTextbox);
		this.loginMethods.clickOnLoginAttemptButton(this.driver, this.loginAttemptButton);
	}


	@When("the user clicks on the log out button")
	public void the_user_clicks_on_the_log_out_button() {
		this.loginMethods.clickcOnLogoutButton(this.driver, this.logoutButton);
	}


	@Then("the user has been successfully logged out")
	public void the_user_has_been_successfully_logged_out() {
		this.loginMethods.userSuccessfullyLoggedOut(this.driver, this.logOutText);
		this.helper.closeDriver(this.driver);
	}


	@Given("a correct user but an incorrect password")
	public void a_correct_user_but_an_incorrect_password() {
		this.user = this.loginMethods.loadUser();
		this.password = this.loginMethods.wrongPass();
	}


	@Then("the user can’t be successfully logged in")
	public void the_user_can_t_be_successfully_logged_in() {
		this.loginMethods.userLoginFailedAttempt(this.driver, this.loginErrorMessage);
		this.helper.closeDriver(this.driver);
	}
	

	@When("^the user introduces a (.*) into the search field$")
	public void the_user_introduces_a_name_into_the_search_field(String name) {
		this.nameToSearch = name;
		this.searchMethods.fillSearchTextBox(this.driver, this.searchTextInut, this.nameToSearch);
	}
	
	
	@When("clicks on the search button")
	public void clicks_on_the_search_button() {
		this.searchMethods.clickOnSearchButton(this.driver, this.searchButton);
	}
	
	
	@Then("the application brings the user to the specific searched page")
	public void the_application_brings_the_user_to_the_specific_searched_page() {
		this.searchedName = this.searchMethods.storeFirstHeading(this.driver, this.textFirstHeading);
		this.helper.closeDriver(this.driver);
	}
	

	@Given("the user clicks on the Donate button")
	public void the_user_clicks_on_the_donate_button() {
		
		
		this.donationMethods.clickOnDonateButton(this.driver, this.donationLink);
	}


	@Given("the user jumps to the donation page")
	public void the_user_jumps_to_the_donation_page() {
		this.donationMethods.waitUntilDonationPageIsLoaded(this.driver, this.donationPageWikiLogo);
	}


	@When("the user introduces a valid donation value")
	public void the_user_introduces_a_valid_donation_value() {
		this.donationMethods.fillDonationWithOneEuro(this.driver, this.otherDonationBox);
	}


	@When("clicks on “No, I’m not able to offer future support or advice“ and on the Credit Card payment method")
	public void clicks_on_no_i_m_not_able_to_offer_future_support_or_advice_and_on_the_credit_card_payment_method() {
		this.donationMethods.clickOnNoOption(this.driver, this.noOptionOnDonationPage);
		this.donationMethods.clickOnCreditCardButton(this.driver, this.creditCardButton);
	}


	@When("the browser brings the user to the payment platform page")
	public void the_browser_brings_the_user_to_the_payment_platform_page() {
		this.donationMethods.waitUntilPaymentPlatformIsLoaded(this.driver, this.paymentPlatform);
	}


	@When("introduces the credit card information and clicks on the Donate button")
	public void introduces_the_credit_card_information_and_clicks_on_the_donate_button() {
		this.donationMethods.fillTextBox(this.driver, this.paymentFirstName, this.firstName);
		this.donationMethods.fillTextBox(this.driver, this.paymentLastName, this.lastName);
		this.donationMethods.fillTextBox(this.driver, this.paymentEmail, this.email);
		this.donationMethods.clickOnVisaButton(this.driver, this.visaButton);
		this.donationMethods.waitAndSwitchIntoPaymentIframe(this.driver, this.paymentIframe);
		this.donationMethods.fillTextBox(this.driver, this.cardNumberField, this.card);
		this.donationMethods.fillTextBox(this.driver, this.expiryDateField, this.expiryDate);
		this.donationMethods.fillTextBox(this.driver, this.cvvField, this.cvv);
		this.donationMethods.waitUntilSubmitPaymentButtonIsClickable(this.driver, this.submitDonationButton);
		this.donationMethods.clickOnSubmitDonation(this.driver, this.submitDonationButton);
		this.donationMethods.switchBackFromPaymentIframe(this.driver);
	}


	@Then("the donation has been performed")
	public void the_donation_has_been_performed() {
		this.donationMethods.waitUntilPaymentIsPerformed(this.driver, this.tryAgain);
		this.referenceNumber = this.donationMethods.storePaymentReference(this.driver, this.referenceNumber);
		this.donationMethods.printRefNumber(this.referenceNumber);
		this.helper.closeDriver(this.driver);
	}
	
	
}
