package helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helpers {
	
	String projectPath = System.getProperty("user.dir");
	
	public void setDriverProperties() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	}
	
	public WebDriver initializeDriver(WebDriver driver) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public void openURL(WebDriver driver, String URL) {
		driver.navigate().to(URL);
		
	}
	
	public void closeDriver(WebDriver driver) {
		driver.close();
		driver.quit();
	}
	
	
	public void waitUntilElementIsPresentById(WebDriver driver, String id) {
		WebElement element = null;
		boolean isPresent = false;
		do {
		element = driver.findElement(By.id(id));
		isPresent = element.isDisplayed();
		}while (! isPresent);
		Assert.assertEquals(true, isPresent);
		
	}
	
	
	public void waitUntilElementIsPresentByXpath(WebDriver driver, String xpath) {
		WebElement element = null;
		boolean isPresent = false;
		do {
		element = driver.findElement(By.xpath(xpath));
		isPresent = element.isDisplayed();
		}while (! isPresent);
		Assert.assertEquals(true, isPresent);
		
	}
	
	
	public void waitUntilElementIsPresentByTag(WebDriver driver, String tag) {
		WebElement element = null;
		boolean isPresent = false;
		do {
		element = driver.findElement(By.tagName(tag));
		isPresent = element.isDisplayed();
		}while (! isPresent);
		Assert.assertEquals(true, isPresent);
		
	}
	
	
	
	public void waitUntilElementIsPresentByText(WebDriver driver, String text) {
		WebElement element = null;
		boolean isPresent = false;
		do {
		element = driver.findElement(By.linkText(text));
		isPresent = element.isDisplayed();
		}while (! isPresent);
		Assert.assertEquals(true, isPresent);
		
	}
	
	
	public void clickOnElementbyId(WebDriver driver, String id) {
		this.waitUntilElementIsPresentById(driver, id);
		driver.findElement(By.id(id)).click();
		
	}
	
	
	public void clickOnElementbyXpath(WebDriver driver, String xpath) {
		this.waitUntilElementIsPresentByXpath(driver, xpath);
		driver.findElement(By.xpath(xpath)).click();
	}
	
	
	public void clickOnElementbyText(WebDriver driver, String text) {
		this.waitUntilElementIsPresentByText(driver, text);
		driver.findElement(By.linkText(text)).click();
	}
	
	
	public void fillTextBoxById(WebDriver driver, String id, String text) {
		driver.findElement(By.id(id)).sendKeys(text);
	}
	
	
	public void fillTextBoxByXpath(WebDriver driver, String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	
}
