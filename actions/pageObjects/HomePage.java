package pageObjects;

import org.openqa.selenium.WebDriver;

import commoms.AbtractPage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

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

	public LoginPage clickLoginLink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManage.getLoginPageOject(driver);
	}

	public CustomerInforPage clickToMyAccountLink() {
		waitToElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManage.getCustomerInforPage(driver);
	}
}
