package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commoms.AbtractPage;
import commoms.AbtractTest;
import java_cup.runtime.virtual_parse_stack;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class Register extends AbtractTest {

	WebDriver driver;
	HomePage homePageOject;
	RegisterPage registerPageOject;
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String urlValues) {
		driver = getBrowserDriver(browserName, urlValues);
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {
		homePageOject = pageObjects.PageGeneratorManage.getHomePageOject(driver);
		registerPageOject = homePageOject.clickToRegisterLink();
		registerPageOject.clickToRegisterButton();
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(registerPageOject.verifyFirstNameError("First name is required."));
		Assert.assertTrue(registerPageOject.verifyLastNameError("Last name is required."));
		Assert.assertTrue(registerPageOject.verifyEmailError("Email is required."));
		Assert.assertTrue(registerPageOject.verifyPasswordError("Password is required."));
		Assert.assertTrue(registerPageOject.verifyConfirmPasswordError("Password is required."));
	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		registerPageOject.clickGenderMaleCheckbox();
		registerPageOject.inputToFirstNameTextbox(firstName);
		registerPageOject.inputToLastNameTextbox(lastName);
		registerPageOject.selectDayDropdown(day);
		registerPageOject.selectMonthDropdown(month);
		registerPageOject.selectYearDropdown(year);
		registerPageOject.inputToEmailTextbox(emailError);
		registerPageOject.inputToCompanyNameTextbox(companyName);
		registerPageOject.inputToPasswordTextbox(password);
		registerPageOject.inputToConfirmPasswordTextbox(password);
		registerPageOject.clickToRegisterButton();
		Assert.assertTrue(registerPageOject.verifyEmailError("Wrong email"));
	}
	
	@Test
	public void TC_03_Register_Succsess() {
		registerPageOject.clickGenderMaleCheckbox();
		registerPageOject.inputToFirstNameTextbox(firstName);
		registerPageOject.inputToLastNameTextbox(lastName);
		registerPageOject.selectDayDropdown(day);
		registerPageOject.selectMonthDropdown(month);
		registerPageOject.selectYearDropdown(year);
		registerPageOject.inputToEmailTextbox(email);
		registerPageOject.inputToCompanyNameTextbox(companyName);
		registerPageOject.inputToPasswordTextbox(password);
		registerPageOject.inputToConfirmPasswordTextbox(password);
		registerPageOject.clickToRegisterButton();
		Assert.assertTrue(registerPageOject.verifyRegisterSuccess("Your registration completed"));
	}

	@Test
	public void TC_04_Register_With_Email_existed() {
		homePageOject = registerPageOject.clickLogoutLink();
		registerPageOject = homePageOject.clickToRegisterLink();
		registerPageOject.clickGenderMaleCheckbox();
		registerPageOject.inputToFirstNameTextbox(firstName);
		registerPageOject.inputToLastNameTextbox(lastName);
		registerPageOject.selectDayDropdown(day);
		registerPageOject.selectMonthDropdown(month);
		registerPageOject.selectYearDropdown(year);
		registerPageOject.inputToEmailTextbox(email);
		registerPageOject.inputToCompanyNameTextbox(companyName);
		registerPageOject.inputToPasswordTextbox(password);
		registerPageOject.inputToConfirmPasswordTextbox(password);
		registerPageOject.clickToRegisterButton();
		Assert.assertTrue(registerPageOject.verifyEmailExist("The specified email already exists"));
	}
	
	@Test
	public void TC_05_Register_With_Password_Less_06_Character() {
		registerPageOject.inputToPasswordTextbox(passwordLow);
		registerPageOject.inputToConfirmPasswordTextbox(passwordLow);
		registerPageOject.clickToRegisterButton();
		Assert.assertTrue(registerPageOject.verifyPasswordError("must have at least 6 characters"));
	}
	
	@Test
	public void TC_06_Register_With_Password_And_Confirm_Not_Match() {
		registerPageOject.inputToPasswordTextbox(password);
		registerPageOject.inputToConfirmPasswordTextbox(confirmPassword);
		registerPageOject.clickToRegisterButton();
		Assert.assertTrue(registerPageOject.verifyConfirmPasswordError("The password and confirmation password do not match."));
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
