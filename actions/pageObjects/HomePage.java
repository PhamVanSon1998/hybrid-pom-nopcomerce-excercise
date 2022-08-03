package pageObjects;

import org.openqa.selenium.WebDriver;

import commoms.AbtractPage;
import pageUIs.HomePageUI;

public class HomePage extends AbtractPage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPage clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return pageObjects.PageGeneratorManage.getRegisterPageOject(driver);
	}
}
