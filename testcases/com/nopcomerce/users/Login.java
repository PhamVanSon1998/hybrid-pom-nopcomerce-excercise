package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commoms.AbtractTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Login extends AbtractTest {
	WebDriver driver;
	HomePage homePageOject;
	LoginPage loginPageOject;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String urlValues) {
		driver = getBrowserDriver(browserName, urlValues);
	}

	@Test
	public void TC_01_Login_With_Empty_Data() {
		homePageOject = pageObjects.PageGeneratorManage.getHomePageOject(driver);
		loginPageOject = homePageOject.clickLoginLink();
		loginPageOject.clickToLoginButton();
		Assert.assertTrue(loginPageOject.verifyEmailMessageError("Please enter your email"));
	}
	
	@Test
	public void TC_02_Login_With_InvalidEmail() {
		loginPageOject.inputToEmailTextbox(emailError);
		loginPageOject.clickToLoginButton();
		Assert.assertTrue(loginPageOject.verifyEmailMessageError("Wrong email"));
	}
	
	@Test
	public void TC_03_Login_With_Email_Not_Register() {
		loginPageOject.inputToEmailTextbox(emailNotRegister);
		loginPageOject.clickToLoginButton();
		Assert.assertTrue(loginPageOject.verifyEmailNotRegisterMessage("Login was unsuccessful. Please correct the errors and try again."));
	}
	
	@Test
	public void TC_04_Login_With_Password_Empty() {
		loginPageOject.inputToEmailTextbox(email);
		loginPageOject.clickToLoginButton();
		Assert.assertTrue(loginPageOject.verifyEmailNotRegisterMessage("The credentials provided are incorrect"));
	}
	
	@Test
	public void TC_05_Login_With_Password_Error() {
		loginPageOject.inputToEmailTextbox(email);
		loginPageOject.inputToPassword(passwordError);
		loginPageOject.clickToLoginButton();
		Assert.assertTrue(loginPageOject.verifyEmailNotRegisterMessage("The credentials provided are incorrect"));
	}

	@Test
	public void TC_06_Login_Success() {
		loginPageOject.inputToEmailTextbox(email);
		loginPageOject.inputToPassword(password);
		homePageOject= loginPageOject.clickToLoginButton();
		Assert.assertTrue(loginPageOject.verifyMyaccountLinkDisplay());
	}

	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
