package pageObjects;

import org.openqa.selenium.WebDriver;

import commoms.AbtractPage;
import pageUIs.SearchPageUI;

public class SearchPage extends AbtractPage{
WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver,SearchPageUI.SEARCH_BUTTON);
	}

	public boolean verifyMessageErrorDisplayed(String messageError) {
		waitToElementVisible(driver, SearchPageUI.MESSAGE_ERROR_SEARCH);
		return messageError.equals(getElementText(driver,SearchPageUI.MESSAGE_ERROR_SEARCH));
	}

	public void inputToSearchKeywordTextbox(String searchKeywordTextbox) {
		waitToElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		senKeysToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, searchKeywordTextbox);
	}

	public boolean verifyProductItemDisplayed(int productItem) {
		waitToElementVisible(driver, SearchPageUI.PRODUCT_ITEM);
		return productItem==countElementSize(driver, SearchPageUI.PRODUCT_ITEM);
	}

	public boolean verifyProductNameDisplayed(String productName) {
		waitToElementVisible(driver, SearchPageUI.PRODUCT_NAME);
		return productName.equals(getElementText(driver, SearchPageUI.PRODUCT_NAME));
	}

	public void checkToAdvancedSearch() {
		waitToElementVisible(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		checkToCheckBox(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void selectCategoryDropdown(String categoryCheckbox, String advancedSearchName) {
		waitToElementVisible(driver, SearchPageUI.ADVANCED_SEARCH_NAME_CHECKBOX,advancedSearchName);
		selectItemInDropdown(driver, SearchPageUI.ADVANCED_SEARCH_NAME_CHECKBOX, categoryCheckbox,advancedSearchName);
	}
	
	public void unCheckSubCategoryCheckbox() {
		waitToElementVisible(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);
		unCheckToCheckBox(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);
	}

	public void CheckSubCategoryCheckbox() {
		waitToElementVisible(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);
		checkToCheckBox(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);
	}

	
}
