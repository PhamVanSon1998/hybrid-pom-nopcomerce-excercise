package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManage {
	
	public static HomePage getHomePageOject(WebDriver driver) {
		return new HomePage(driver);
	}
	
	public static RegisterPage getRegisterPageOject(WebDriver driver) {
		return new RegisterPage(driver);
	}
	
	public static LoginPage getLoginPageOject(WebDriver driver) {
		return new LoginPage(driver);
	}
	
	public static CustomerInforPage getCustomerInforPage(WebDriver driver) {
		return new CustomerInforPage(driver);
	}
	
	public static AddressPage getAddressPageOject(WebDriver driver) {
		return new AddressPage(driver);
	}
	
	public static ChangePasswordPage getChangePasswordPageOject(WebDriver driver) {
		return new ChangePasswordPage(driver);
	}
	
	public static MyProductReviewPage getMyProductReviewPageOject(WebDriver driver) {
		return new MyProductReviewPage(driver);
	}

	public static SearchPage getSearchPageOject(WebDriver driver) {
		return new SearchPage(driver);
	}
	
	
}
