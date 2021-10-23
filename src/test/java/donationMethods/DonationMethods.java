package donationMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helpers.Helpers;
import org.junit.Assert;


public class DonationMethods {
	Helpers helper = new Helpers();
	
	public void clickOnDonateButton(WebDriver driver, String text) {
		this.helper.clickOnElementbyText(driver, text);
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
	
	public void waitUntilErrorDonationMessageIsShown(WebDriver driver, String id) {
		this.helper.waitUntilElementIsPresentById(driver, id);
	}
}
