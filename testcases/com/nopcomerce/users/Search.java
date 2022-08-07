package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
import pageObjects.SearchPage;

public class Search extends AbtractTest {
	WebDriver driver;
	CustomerInforPage customerInforPageObject;
	HomePage homePageObject;
	LoginPage loginPageObject;
	SearchPage searchPageObject;

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
	public void TC_02_Search_With_Empty_Data() {
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);
		searchPageObject = homePageObject.clickSearchLink("Search");
		searchPageObject.clickToSearchButton();
		Assert.assertTrue(searchPageObject.verifyMessageErrorDisplayed("Search term minimum length is 3 characters"));
	}
	
	@Test
	public void TC_03_Search_With_Data_Not_Exist() {
		searchPageObject.inputToSearchKeywordTextbox("Macbook 1234556");
		searchPageObject.clickToSearchButton();
		Assert.assertTrue(searchPageObject.verifyMessageErrorDisplayed("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_04_Search_With_Data_Relative() {
		searchPageObject.inputToSearchKeywordTextbox("Lenovo");
		searchPageObject.clickToSearchButton();
		Assert.assertTrue(searchPageObject.verifyProductItemDisplayed(2));
	}
	
	@Test
	public void TC_05_Search_With_Data_Absolute() {
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro 13-inch");
		searchPageObject.clickToSearchButton();
		Assert.assertTrue(searchPageObject.verifyProductItemDisplayed(1));
		Assert.assertTrue(searchPageObject.verifyProductNameDisplayed("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void TC_06_Advanced_Search_With_Parent_Categories() {
		searchPageObject.checkToAdvancedSearch();
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro");
		searchPageObject.selectCategoryDropdown("Computers","Category:");
		searchPageObject.unCheckSubCategoryCheckbox();
		searchPageObject.clickToSearchButton();
		Assert.assertTrue(searchPageObject.verifyMessageErrorDisplayed("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_07_Advanced_Search_With_Sub_Categories() {
		searchPageObject.checkToAdvancedSearch();
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro");
		searchPageObject.selectCategoryDropdown("Computers","Category:");
		searchPageObject.CheckSubCategoryCheckbox();
		searchPageObject.clickToSearchButton();
		Assert.assertTrue(searchPageObject.verifyProductItemDisplayed(1));
		Assert.assertTrue(searchPageObject.verifyProductNameDisplayed("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void TC_08_Advanced_Search_With_Incorect_Manufacturer() {
		searchPageObject.checkToAdvancedSearch();
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro");
		searchPageObject.selectCategoryDropdown("Computers","Category:");
		searchPageObject.CheckSubCategoryCheckbox();
		searchPageObject.selectCategoryDropdown("HP","Manufacturer:");
		searchPageObject.clickToSearchButton();
		Assert.assertTrue(searchPageObject.verifyMessageErrorDisplayed("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_09_Advanced_Search_With_Incorect_Manufacturer() {
		searchPageObject.checkToAdvancedSearch();
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro");
		searchPageObject.selectCategoryDropdown("Computers","Category:");
		searchPageObject.CheckSubCategoryCheckbox();
		searchPageObject.selectCategoryDropdown("Apple","Manufacturer:");
		searchPageObject.clickToSearchButton();
		Assert.assertTrue(searchPageObject.verifyProductItemDisplayed(1));
		Assert.assertTrue(searchPageObject.verifyProductNameDisplayed("Apple MacBook Pro 13-inch"));
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
