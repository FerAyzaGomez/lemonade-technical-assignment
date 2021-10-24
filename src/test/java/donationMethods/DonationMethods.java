package donationMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helpers.Helpers;


public class DonationMethods {
	Helpers helper = new Helpers();
	
	public void clickOnDonateButton(WebDriver driver, String text) {
		this.helper.clickOnElementbyLinkText(driver, text);
	}
	
	
	public void waitUntilDonationPageIsLoaded(WebDriver driver, String donatePageLogoId) {
		this.helper.waitUntilElementIsPresentById(driver, donatePageLogoId);
	}
	
	
	public void fillDonationWithOneEuro(WebDriver driver, String otherDonationBoxId) {
		driver.findElement(By.id(otherDonationBoxId)).sendKeys("1");
	}

	
	public void clickOnNoOption(WebDriver driver, String noOptionId) {
		this.helper.clickOnElementbyId(driver, noOptionId);
	}
	
	
	public void clickOnCreditCardButton(WebDriver driver, String CCButonXpath) {
		this.helper.clickOnElementbyXpath(driver, CCButonXpath);
	}
	
	
	public void waitUntilPaymentPlatformIsLoaded (WebDriver driver, String donationAmountText) {
		this.helper.waitUntilElementIsPresentById(driver, donationAmountText);
	}
	
	
	
	public void fillTextBox(WebDriver driver, String idLocator, String textToBeFilled){
		this.helper.fillTextBoxById(driver, idLocator, textToBeFilled);
	}
	
	
	public void clickOnVisaButton(WebDriver driver, String id) {
		this.helper.clickOnElementbyId(driver, id);
	}
	
	
	public void waitUntilCreditCardIsLoaded(WebDriver driver, String creditCardId) {
		this.helper.waitUntilElementIsPresentById(driver, creditCardId);
	}
	
	
	public void clickOnSubmitDonation(WebDriver driver, String id) {
		this.helper.clickOnElementbyId(driver, id);
	}
	
	public void waitUntilPaymentIsPerformed(WebDriver driver, String text) {
		this.helper.waitUntilElementIsPresentByLinkText(driver, text);
	}
	
	public void waitUntilCancellationButtonIsClickable(WebDriver driver, String id) {
		this.helper.waitUntilElementIsClickableById(driver, id);
	}
	
	public void waitUntilSubmitPaymentButtonIsClickable(WebDriver driver, String id) {
		this.helper.waitUntilElementIsClickableById(driver, id);
	}
	
	public void switchBackFromPaymentIframe(WebDriver driver) {
		this.helper.switchBackFromIframe(driver);
	}
	
	public String storePaymentReference(WebDriver driver, String xpath) {
		return this.helper.textReaderByXpath(driver, xpath).replace("Error reference: ", "");
	}
	
	public void printRefNumber (String refNum) {
		System.out.println("Reference transaction number: "+refNum);
	}
	
	public void waitAndSwitchIntoPaymentIframe(WebDriver driver, String xpath) {
		this.helper.waitAndSwitchIntoIframe(driver, xpath);
	}
}
