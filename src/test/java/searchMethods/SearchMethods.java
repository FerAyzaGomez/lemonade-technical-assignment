package searchMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helpers.Helpers;
import org.junit.Assert;



public class SearchMethods {
	
	Helpers helper = new Helpers();

	public void fillSearchTextBox(WebDriver driver, String searchBoxId, String textToSearch) {
		driver.findElement(By.id(searchBoxId)).sendKeys(textToSearch);
	}
	
	
	public void clickOnSearchButton(WebDriver driver, String searchButtonId) {
		driver.findElement(By.id(searchButtonId)).click();
	}
	
	
	public void waitUntilSearchIsDone(WebDriver driver, String elementToWaitId) {
		this.helper.waitUntilElementIsPresentById(driver, elementToWaitId);
	}
	
	
	public String storeFirstHeading(WebDriver driver, String elementToReadId) {return driver.findElement(By.id(elementToReadId)).getText();}
	
	public void compareNames (String targetName, String foundName) {
		Assert.assertSame(targetName, foundName);
	}
}
