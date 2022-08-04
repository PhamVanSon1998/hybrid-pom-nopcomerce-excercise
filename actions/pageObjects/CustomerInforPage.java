package pageObjects;

import org.openqa.selenium.WebDriver;

import commoms.AbtractPage;
import pageUIs.CustomerInforPageUI;

public class CustomerInforPage extends AbtractPage {
	WebDriver driver;

	public CustomerInforPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyGenderMaleCheckbox() {
		waitToElementVisible(driver, CustomerInforPageUI.GENDER_MALE_CHECKBOX);
		return isElementSelected(driver, CustomerInforPageUI.GENDER_MALE_CHECKBOX);
	}

	public boolean verifyFirstNameTextbox(String firstNameTextbox) {
		waitToElementVisible(driver, CustomerInforPageUI.FIRTNAME_TEXTBOX);
		return firstNameTextbox.equals(getElementAttribute(driver, CustomerInforPageUI.FIRTNAME_TEXTBOX, "value"));
	}

	public boolean verifyLastNameTextbox(String lastnameTextbox) {
		waitToElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
		return lastnameTextbox.equals(getElementAttribute(driver, CustomerInforPageUI.LASTNAME_TEXTBOX, "value"));
	}

	public boolean verifyDayDropdown(String dayDropdown) {
		waitToElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
		return dayDropdown.equals(getFirstSelectedTextInDropdown(driver, CustomerInforPageUI.DAY_DROPDOWN));
	}

	public boolean verifyMonthDropdown(String monthDropdown) {
		waitToElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		return monthDropdown.equals(getFirstSelectedTextInDropdown(driver, CustomerInforPageUI.MONTH_DROPDOWN));
	}

	public boolean verifyYearDropdown(String yearDropdown) {
		waitToElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
		return yearDropdown.equals(getFirstSelectedTextInDropdown(driver, CustomerInforPageUI.YEAR_DROPDOWN));
	}

	public boolean verifyEmailTextbox(String emailTextbox) {
		waitToElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		return emailTextbox.equals(getElementAttribute(driver, CustomerInforPageUI.EMAIL_TEXTBOX, "value"));
	}

	public boolean verifyCompanyNameTextbox(String companyNameTetbox) {
		waitToElementVisible(driver, CustomerInforPageUI.COMPANYNAME_TEXTBOX);
		return companyNameTetbox.equals(getElementAttribute(driver, CustomerInforPageUI.COMPANYNAME_TEXTBOX, "value"));
	}

	public AddressPage clickToAddressLink() {
		waitToElementClickable(driver, CustomerInforPageUI.ADDRESS_LINK);
		clickToElement(driver, CustomerInforPageUI.ADDRESS_LINK);
		return PageGeneratorManage.getAddressPageOject(driver);
	}

	public ChangePasswordPage clickToChangePasswordLink() {
		waitToElementClickable(driver, CustomerInforPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, CustomerInforPageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManage.getChangePasswordPageOject(driver);
	}
}
