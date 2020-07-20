package com.amazon.app.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.app.utils.Utils;

public class AmazonProductDetailsPage {

	public WebDriver driver;

	public AmazonProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id = 'averageCustomerReviews_feature_div']")
	WebElement ratingStars;

	@FindBy(xpath = "//span[@data-hook='acr-average-stars-rating-text']")
	WebElement ratingStarsText;

	@FindBy(xpath = "//div[@id='imgTagWrapperId']")
	WebElement productBigImage;

	@FindBy(xpath = "//ul[@class='a-unordered-list a-nostyle a-button-list a-vertical a-spacing-top-micro']")
	WebElement productVerticalImagesBar;

	public void printAvgStarsRate() throws Exception {
		Thread.sleep(3000);
		String ratingTextValue = ratingStarsText.getText();
		Utils.highLightElement(driver, ratingStarsText);

		if (ratingTextValue.contains(".")) {
			System.out.println("===>> RATING VALUE ==>> : " + ratingTextValue.substring(0, 3));
		} else {
			System.out.println("===>> RATING VALUE ==>> : " + ratingTextValue.charAt(0));
		}

	}

	public void hoverRatingStars() throws Exception {
		Utils.highLightElement(driver, ratingStars);
		Actions act = new Actions(driver);
		act.moveToElement(ratingStars);
		act.build().perform();
	}

	public void verifyProductDetailsPage() throws Exception {
		assertTrue(productBigImage.isDisplayed());
		Utils.highLightElement(driver, productBigImage);

		assertTrue(productVerticalImagesBar.isDisplayed());
		Utils.highLightElement(driver, productVerticalImagesBar);
	}

}
