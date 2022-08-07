package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commoms.AbtractTest;
import pageObjects.AddressPage;
import pageObjects.ChangePasswordPage;
import pageObjects.CustomerInforPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyProductReviewPage;

public class MyAccount extends AbtractTest {
	WebDriver driver;
	CustomerInforPage customerInforPageObject;
	HomePage homePageObject;
	LoginPage loginPageObject;
	AddressPage addressPageObject;
	ChangePasswordPage changePasswordPageObject;
	MyProductReviewPage myProductReviewPageObject;

	@Parameters({ "browser", "url", "emailLogin" })
	@BeforeClass
	public void BeforeClass(String browserName, String urlValues, String emailLogin) {
		driver = getBrowserDriver(browserName, urlValues,emailLogin);
	}
	
	@Test
	public void TC_01_Login_Success() {
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);
		loginPageObject = homePageObject.clickLoginLink();
		loginPageObject.inputToEmailTextbox(email);
		loginPageObject.inputToPassword(password);
		homePageObject= loginPageObject.clickToLoginButton();
		Assert.assertTrue(loginPageObject.verifyMyaccountLinkDisplay());
	}
	
	@Test
	public void TC_02_Verify_Customer_Infor() {
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);
		customerInforPageObject = homePageObject.clickToMyAccountLink();
		Assert.assertTrue(customerInforPageObject.verifyGenderMaleCheckbox());
		Assert.assertTrue(customerInforPageObject.verifyFirstNameTextbox(firstName));
		Assert.assertTrue(customerInforPageObject.verifyLastNameTextbox(lastName));
		Assert.assertTrue(customerInforPageObject.verifyDayDropdown(day));
		Assert.assertTrue(customerInforPageObject.verifyMonthDropdown(month));
		Assert.assertTrue(customerInforPageObject.verifyYearDropdown(year));
		Assert.assertTrue(customerInforPageObject.verifyEmailTextbox(email));
		Assert.assertTrue(customerInforPageObject.verifyCompanyNameTextbox(companyName));
	}
	
	@Test
	public void TC_03_Add_Address() {
		customerInforPageObject =pageObjects.PageGeneratorManage.getCustomerInforPage(driver);
		addressPageObject = customerInforPageObject.clickToAddressLink();
		addressPageObject.clickToAddNewButton();
		addressPageObject.inputToAddressFirstNameTextbox(firstName);
		addressPageObject.inputToAddressLastNameTextbox(lastName);
		addressPageObject.inputToAddressEmailTextbox(email);
		addressPageObject.inputToAddressCompanyTextbox(companyName);
		addressPageObject.inputToAddressCountryDropdown(country);
		addressPageObject.inputToAddressStateDropdown(state);
		addressPageObject.inputToAddressCityTextbox(city);
		addressPageObject.inputToAddress1Textbox(address1);
		addressPageObject.inputToAddress2Textbox(address2);
		addressPageObject.inputToZipCodeTextbox(zipcode);
		addressPageObject.inputToPhoneNumberTextbox(phoneNumber);
		addressPageObject.inputToFaxNumberTextbox(faxNumber);
		addressPageObject.clickToSaveButton();
		Assert.assertTrue(addressPageObject.isInforTableDisplaysed());;
	}
	
	@Test
	public void TC_04_Change_Password() {
		customerInforPageObject =pageObjects.PageGeneratorManage.getCustomerInforPage(driver);
		changePasswordPageObject = customerInforPageObject.clickToChangePasswordLink();
		changePasswordPageObject.inputToOldPasswordTextbox(password);
		changePasswordPageObject.inputToNewPasswordTextbox(password);
		changePasswordPageObject.inputToConfirmPasswordTextbox(password);
		changePasswordPageObject.clickToChangePasswordButton();
		Assert.assertTrue(changePasswordPageObject.verifyChangePasswordMessageError("You entered the password that is the same as one of the last passwords you used. Please create a new password."));
		
		changePasswordPageObject.inputToOldPasswordTextbox(password);
		changePasswordPageObject.inputToNewPasswordTextbox(newpassword);
		changePasswordPageObject.inputToConfirmPasswordTextbox(newpassword);
		changePasswordPageObject.clickToChangePasswordButton();
		Assert.assertTrue(changePasswordPageObject.verifyChangePasswordSuccess());
	}
	
	@Test
	public void TC_05_My_Product_Review() {
		changePasswordPageObject=pageObjects.PageGeneratorManage.getChangePasswordPageOject(driver);
		myProductReviewPageObject = changePasswordPageObject.clickToMyProductReviewLink();
		myProductReviewPageObject.moveToComputerLink();
		myProductReviewPageObject.clickToDestopLink();
		myProductReviewPageObject.clickToProductReview("Build your own computer");
		myProductReviewPageObject.clickToAddYourReviewLink();
		myProductReviewPageObject.inputToReviewTitleTextbox("Product in techinical");
		myProductReviewPageObject.inputToReviewTextTextArea("good quality");
		myProductReviewPageObject.selectRatingCheckbox();
		myProductReviewPageObject.clickToSubmitReview();
		myProductReviewPageObject.clickToMyAcountLinkInFooter("My account");
		myProductReviewPageObject.clickToMyProductReviewLink1();
		
		Assert.assertTrue(myProductReviewPageObject.isProductReviewTitleDisplayed("Product in techinical"));
		Assert.assertTrue(myProductReviewPageObject.isProductReviewTextDisplayed("good quality"));
		Assert.assertTrue(myProductReviewPageObject.isProductReviewDisplayed("Build your own computer"));
		
		
		
	}
}
