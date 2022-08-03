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

	public static MyAccountPage getMyAccountPageOject(WebDriver driver) {
		return new MyAccountPage(driver);
	}
	
	
}
