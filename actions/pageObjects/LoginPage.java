package pageObjects;

import org.openqa.selenium.WebDriver;

import commoms.AbtractPage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPage extends AbtractPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManage.getHomePageOject(driver);
	}

	public boolean verifyEmailMessageError(String emailMessageError) {
		waitToElementVisible(driver, LoginPageUI.EMAIL_MESSAGE_ERROR);
		String elementText = getElementText(driver, LoginPageUI.EMAIL_MESSAGE_ERROR);
		return elementText.equals(emailMessageError);
	}

	public void inputToEmailTextbox(String emailError) {
		waitToElementVisible(driver, LoginPageUI.EMAIL_TEXBOX);
		senKeysToElement(driver, LoginPageUI.EMAIL_TEXBOX, emailError);
	}

	public boolean verifyEmailNotRegisterMessage(String emailNotRegisterMessage) {
		waitToElementVisible(driver, LoginPageUI.EMAIL_NOT_REGISTER_MESSAGE_ERROR);
		String element = getElementText(driver, LoginPageUI.EMAIL_NOT_REGISTER_MESSAGE_ERROR);
		return element.contains(emailNotRegisterMessage);
	}

	public void inputToPassword(String passwordError) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXBOX);
		senKeysToElement(driver, LoginPageUI.PASSWORD_TEXBOX, passwordError);
	}

	public boolean verifyMyaccountLinkDisplay() {
		waitToElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	}

}
