package pageObjects;

import org.openqa.selenium.WebDriver;

import com.nopcomerce.users.MyAccount;

import commoms.AbtractPage;
import pageUIs.AddressPageUI;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class AddressPage extends AbtractPage {
	WebDriver driver;

	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitToElementClickable(driver, AddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
	}

	public void inputToAddressFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, AddressPageUI.FIRTNAME_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.FIRTNAME_TEXTBOX, firstName);
	}

	public void inputToAddressLastNameTextbox(String lastName) {
		waitToElementVisible(driver, AddressPageUI.LASTNAME_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void inputToAddressEmailTextbox(String email) {
		waitToElementVisible(driver, AddressPageUI.EMAIL_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToAddressCompanyTextbox(String companyName) {
		waitToElementVisible(driver, AddressPageUI.COMPANYNAME_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.COMPANYNAME_TEXTBOX, companyName);
	}

	public void inputToAddressCountryDropdown(String country) {
		waitToElementVisible(driver, AddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, AddressPageUI.COUNTRY_DROPDOWN, country);
	}

	public void inputToAddressStateDropdown(String state) {
		waitToElementVisible(driver, AddressPageUI.STATE_DROPDOWN);
		selectItemInDropdown(driver, AddressPageUI.STATE_DROPDOWN, state);
	}

	public void inputToAddress1Textbox(String address1) {
		waitToElementVisible(driver, AddressPageUI.ADDRESS_1_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.ADDRESS_1_TEXTBOX, address1);
	}

	public void inputToAddressCityTextbox(String city) {
		waitToElementVisible(driver, AddressPageUI.CITY_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.CITY_TEXTBOX, city);
	}

	public void inputToAddress2Textbox(String address2) {
		waitToElementVisible(driver, AddressPageUI.ADDRESS_2_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.ADDRESS_2_TEXTBOX, address2);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitToElementVisible(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToZipCodeTextbox(String zipcode) {
		waitToElementVisible(driver, AddressPageUI.ZIP_CODE_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.ZIP_CODE_TEXTBOX, zipcode);
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitToElementVisible(driver, AddressPageUI.FAX_NUMBER_TEXTBOX);
		senKeysToElement(driver, AddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitToElementClickable(driver, AddressPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_BUTTON);
	}

	public boolean isInforTableDisplaysed() {
		waitToElementVisible(driver, AddressPageUI.INFO_TABLE);
		return isElementDisplayed(driver, AddressPageUI.INFO_TABLE);
	}
}
