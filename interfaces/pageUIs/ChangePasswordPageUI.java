package pageUIs;

public class ChangePasswordPageUI {
	public static final String OLD_PASSWORD_TEXTBOX = "//input[@id='OldPassword']";
	public static final String NEW_PASSWORD_TEXTBOX = "//input[@id='NewPassword']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmNewPassword']";
	public static final String CHANGE_PASSWORD_BUTTON = "//button[contains(@class,'change-password-button')]";
	public static final String CHANGE_PASSWORD_MESSAGE_ERROR= "//div[contains(@class,'essage-error') ]";
	public static final String CHANGE_PASSWORD_MESSAGE_SUCCESS= "//p[@class='content' and text()='Password was changed']";
	
	public static final String MYPRODUCT_REVIEW_LINK= "//li[contains(@class,'customer-reviews')]";
}
