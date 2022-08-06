package pageObjects;

import org.openqa.selenium.WebDriver;

import commoms.AbtractPage;
import pageUIs.ChangePasswordPageUI;

public class ChangePasswordPage extends AbtractPage{
	WebDriver driver;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTextbox(String password) {
		waitToElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		senKeysToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
	}

	public void inputToNewPasswordTextbox(String newpassword) {
		waitToElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		senKeysToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newpassword);
	}

	public void inputToConfirmPasswordTextbox(String newpassword) {
		waitToElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senKeysToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newpassword);
	}

	public void clickToChangePasswordButton() {
		waitToElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public boolean verifyChangePasswordSuccess() {
		waitToElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_MESSAGE_SUCCESS);
		return isElementDisplayed(driver,ChangePasswordPageUI.CHANGE_PASSWORD_MESSAGE_SUCCESS);
	}

	public boolean verifyChangePasswordMessageError(String mesageError) {
		waitToElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_MESSAGE_ERROR);
		return mesageError.equals(getElementText(driver, ChangePasswordPageUI.CHANGE_PASSWORD_MESSAGE_ERROR));
	}

	public MyProductReviewPage clickToMyProductReviewLink() {
		waitToElementVisible(driver, ChangePasswordPageUI.MYPRODUCT_REVIEW_LINK);
		clickToElement(driver,ChangePasswordPageUI.MYPRODUCT_REVIEW_LINK);
		return PageGeneratorManage.getMyProductReviewPageOject(driver);
	}

}
