package loginMethods;

import org.openqa.selenium.WebDriver;
import helpers.Helpers;

public class LoginMethods {

	Helpers helper = new Helpers();
	private String user = "LemonadeTechnicalAssginement";
	private String password = "GiL_rkQzW7&YGuT";
	private String wrongPass = "GiL_rkQzW7&YGuTajodfoasj";
	
	
	public void clickcOnLoginButton(WebDriver driver, String id) {
		this.helper.clickOnElementbyId(driver, id);
	}
	
	public void waitUntilLoginPageIsPresent(WebDriver driver, String id) {
		this.helper.waitUntilElementIsPresentById(driver, id);
	}
	
	public String loadUser() {return this.user;}
	
	
	public String correctPass() {return this.password;}
	
	
	public String wrongPass() {return this.wrongPass;}
	
	public void writeUserAndPassword(WebDriver driver, String user, String idUser, String password, String idPassword) {
		this.helper.fillTextBoxById(driver, idUser, user);
		this.helper.fillTextBoxById(driver, idPassword, password);
	}
	
	public void clickOnLoginAttemptButton(WebDriver driver, String id) {
		this.helper.clickOnElementbyId(driver, id);
	}
	
	
	public void userSuccessfullyLoggedIn (WebDriver driver, String logoutButtonId) {
		this.helper.waitUntilElementIsPresentById(driver, logoutButtonId);
	}
	
	
	public void clickcOnLogoutButton(WebDriver driver, String id) {
		this.helper.clickOnElementbyId(driver, id);
	}
	
	public void userSuccessfullyLoggedOut (WebDriver driver, String loginButtonId) {
		this.helper.waitUntilElementIsPresentById(driver, loginButtonId);
	}
	
	public void userLoginFailedAttempt(WebDriver driver, String errorMessageXpath) {
		this.helper.waitUntilElementIsPresentByXpath(driver, errorMessageXpath);
	}
}
