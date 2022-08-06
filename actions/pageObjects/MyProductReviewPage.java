package pageObjects;

import org.openqa.selenium.WebDriver;

import commoms.AbtractPage;
import pageUIs.MyProductReviewPageUI;

public class MyProductReviewPage extends AbtractPage{
	WebDriver driver;
	public MyProductReviewPage(WebDriver driver) {
		this.driver = driver;
	}

	public void moveToComputerLink() {
		waitToElementVisible(driver, MyProductReviewPageUI.COMPUTER_LINK);
		hoverMouseToElement(driver, MyProductReviewPageUI.COMPUTER_LINK);
	}

	public void clickToDestopLink() {
		waitToElementClickable(driver, MyProductReviewPageUI.DESTOP_LINK);
		clickToElement(driver, MyProductReviewPageUI.DESTOP_LINK);
	}

	public void clickToProductReview(String productReview) {
		waitToElementClickable(driver, MyProductReviewPageUI.PRODUCT_REVIEW,productReview);
		clickToElement(driver, MyProductReviewPageUI.PRODUCT_REVIEW,productReview);
	}

	public void clickToAddYourReviewLink() {
		waitToElementClickable(driver, MyProductReviewPageUI.ADD_YOUR_REVIEW);
		clickToElement(driver, MyProductReviewPageUI.ADD_YOUR_REVIEW);
	}

	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitToElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		senKeysToElement(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void inputToReviewTextTextArea(String reviewTextArea) {
		waitToElementVisible(driver, MyProductReviewPageUI.REVIEW_TEXT_TEXTAREA);
		senKeysToElement(driver, MyProductReviewPageUI.REVIEW_TEXT_TEXTAREA, reviewTextArea);
	}

	public void selectRatingCheckbox() {
		waitToElementVisible(driver, MyProductReviewPageUI.RATING_CHECKBOX);
		checkToCheckBox(driver, MyProductReviewPageUI.RATING_CHECKBOX);
	}

	public void clickToSubmitReview() {
		waitToElementClickable(driver, MyProductReviewPageUI.SUBMIT_REVIEW_BUTTOB);
		clickToElement(driver, MyProductReviewPageUI.SUBMIT_REVIEW_BUTTOB);
	}

	public void clickToMyAcountLinkInFooter(String linkInFooter) {
		waitToElementClickable(driver, MyProductReviewPageUI.LINK_IN_FOOTER,linkInFooter);
		clickToElement(driver, MyProductReviewPageUI.LINK_IN_FOOTER,linkInFooter);
	}

	public void clickToMyProductReviewLink1() {
		waitToElementClickable(driver, MyProductReviewPageUI.MYPRODUCT_REVIEW_LINK);
		clickToElement(driver, MyProductReviewPageUI.MYPRODUCT_REVIEW_LINK);
	}

	public boolean isProductReviewDisplayed(String productReview) {
		waitToElementVisible(driver, MyProductReviewPageUI.PRODUCT_REVIEW_DISPLAY);
		return productReview.equals(getElementText(driver, MyProductReviewPageUI.PRODUCT_REVIEW_DISPLAY));
	}

	public boolean isProductReviewTitleDisplayed(String productReviewTitle) {
		waitToElementVisible(driver, MyProductReviewPageUI.PRODUCT_REVIEW_TITLE_DISPLAY);
		return productReviewTitle.equals(getElementText(driver, MyProductReviewPageUI.PRODUCT_REVIEW_TITLE_DISPLAY));
	}

	public boolean isProductReviewTextDisplayed(String productReviewText) {
		waitToElementVisible(driver, MyProductReviewPageUI.PRODUCT_REVIEW_TEXT_DISPLAY);
		return productReviewText.equals(getElementText(driver, MyProductReviewPageUI.PRODUCT_REVIEW_TEXT_DISPLAY));
	}

}
