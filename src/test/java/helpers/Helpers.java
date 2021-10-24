package helpers;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
	
	private static final int WAIT_TIME = 10;
	
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
		boolean isPresent = false;
		new WebDriverWait (driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		if (driver.findElement(By.id(id)).isDisplayed()) isPresent = true;
		Assert.assertEquals(true, isPresent);		
	}
	
	public void waitUntilElementIsClickableById(WebDriver driver, String id) {
		boolean isPresent = false;
		new WebDriverWait (driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.elementToBeClickable(By.id(id)));
		if (driver.findElement(By.id(id)).isDisplayed()) isPresent = true;
		Assert.assertEquals(true, isPresent);		
	}
	
	public void waitUntilElementIsPresentByXpath(WebDriver driver, String xpath) {
		boolean isPresent = false;
		new WebDriverWait (driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		if (driver.findElement(By.xpath(xpath)).isDisplayed()) isPresent = true;
		Assert.assertEquals(true, isPresent);
	}
	
	public void waitUntilElementIsClickableByXpath(WebDriver driver, String xpath) {
		boolean isPresent = false;
		new WebDriverWait (driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		if (driver.findElement(By.xpath(xpath)).isDisplayed()) isPresent = true;
		Assert.assertEquals(true, isPresent);
	}
	
	
	public void waitUntilElementIsPresentByTag(WebDriver driver, String tag) {
		boolean isPresent = false;
		new WebDriverWait (driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tag)));
		if (driver.findElement(By.tagName(tag)).isDisplayed()) isPresent = true;
		Assert.assertEquals(true, isPresent);
	}
	
	
	
	public void waitUntilElementIsPresentByLinkText(WebDriver driver, String text) {
		boolean isPresent = false;
		new WebDriverWait (driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
		if (driver.findElement(By.linkText(text)).isDisplayed()) isPresent = true;
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
	
	
	public void clickOnElementbyLinkText(WebDriver driver, String text) {
		this.waitUntilElementIsPresentByLinkText(driver, text);
		driver.findElement(By.linkText(text)).click();
	}
	
	
	public void fillTextBoxById(WebDriver driver, String id, String text) {
		this.waitUntilElementIsPresentById(driver, id);
		driver.findElement(By.id(id)).sendKeys(text);
	}
	
	
	public void fillTextBoxByXpath(WebDriver driver, String xpath, String text) {
		this.waitUntilElementIsPresentByXpath(driver, xpath);
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	
	public String textReaderByXpath(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
		}
	
	public void switchBackFromIframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void waitAndSwitchIntoIframe (WebDriver driver, String xpath) {
		new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(xpath)));
	}
	
}
