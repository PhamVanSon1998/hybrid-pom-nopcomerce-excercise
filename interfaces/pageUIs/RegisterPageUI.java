package pageUIs;

public class RegisterPageUI {
		public static final String REGISTER_BUTTON = "//button[@id='register-button']";
		
		public static final String FIRST_ERROR = "//span[@id='FirstName-error']";
		public static final String LASTNAME_ERROR = "//span[@id='LastName-error']";
		public static final String EMAIL_ERROR = "//span[@id='Email-error']";
		public static final String PASSWORD_ERROR = "//span[@id='Password-error']";
		public static final String CONFIRM_PASSWORD_ERROR = "//span[@id='ConfirmPassword-error']";
		public static final String TEXBOX_NAME_ERROR = "//span[@id='%s-error' and text()='$s is required.']";
		
		public static final String GENDER_MALE_CHECKBOX = "//input[@id='gender-male']";
		public static final String FIRTNAME_TEXTBOX = "//input[@id='FirstName']";
		public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
		public static final String DAY_DROPDOWN= "//select[@name='DateOfBirthDay']";
		public static final String MONTH_DROPDOWN= "//select[@name='DateOfBirthMonth']";
		public static final String YEAR_DROPDOWN= "//select[@name='DateOfBirthYear']";
		public static final String EMAIL_TEXTBOX= "//input[@id='Email']";
		public static final String COMPANYNAME_TEXTBOX= "//input[@id='Company']";
		public static final String PASSWORD_TEXTBOX= "//input[@id='Password']";
		public static final String CONFIRM_PASSWORD_TEXTBOX= "//input[@id='ConfirmPassword']";
		
		public static final String REGISTER_SUCCESS_TEXT= "//div[@class='result']";
		public static final String EMAIL_EXIST_TEXT= "//div[contains(@class,'message-error')]";
}
