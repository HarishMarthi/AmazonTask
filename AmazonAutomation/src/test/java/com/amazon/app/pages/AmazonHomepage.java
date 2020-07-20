package com.amazon.app.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.app.config.Config;
import com.amazon.app.utils.Utils;

public class AmazonHomepage {

	public WebDriver driver;

	public AmazonHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='nav-belt']")
	WebElement topHeaderBar;

	@FindBy(xpath = "//div[@id='nav-tools']")
	WebElement leftTools;

	@FindBy(xpath = "//input[@id = 'twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(xpath = "//input[@value = 'Go']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class = 'a-section a-spacing-medium']")
	List<WebElement> searchProductsList;

	@FindBy(xpath = "//a[@class='nav-a nav-a-2 a-popover-trigger a-declarative']")
	WebElement deliveryToLocationIcon;

	@FindBy(xpath = "//div[@class='glow-toaster-footer']/span[2]/span")
	WebElement changeAddressButton;

	// @FindBy(xpath = "//a[@class='nav-a nav-a-2 a-popover-trigger
	// a-declarative']/div[2]/span[2]")
	// WebElement existingZipCodeText;

	@FindBy(xpath = "//div[@class='a-popover-wrapper']")
	WebElement locationChoosePopUP;

	@FindBy(xpath = "//a[text() = 'Change']")
	WebElement zipCodeChangeLink;

	@FindBy(xpath = "//input[@id='GLUXZipUpdateInput']")
	WebElement zipCodeInputField;

	@FindBy(xpath = "//select[@id='GLUXCountryList']")
	WebElement deliveryCountryList;

	@FindBy(xpath = "//button[text() = 'Done']/..")
	WebElement doneButton;

	@FindBy(xpath = "//span[@id='GLUXZipUpdate-announce']/..")
	WebElement applyButton;

	@FindBy(xpath = "//span[@id = 'glow-ingress-line2']")
	WebElement newDeliveryCountryHomePage;

	@FindBy(xpath = "//div[@class='a-popover-footer']")
	WebElement outClick;

	@FindBy(xpath = "//h4[contains(text(), 'now shopping')]/../../div[2]/span/span")
	WebElement continueButtonInLocationChange;
	
	@FindBy(xpath = "//span[contains(text() ,\"Don't Change\")]/..")
	WebElement dontChangeButton;

	WebElement thirdPhone;
	WebElement thirdPhoneTitleElement;
	String addlpath = "/div[2]/div[2]/div/div[1]/div[1]/div/div[1]/h2/a/span";
	String finalXpath;
	String selectProductTitle;

	public void verifyUserLandOnHomepgae() throws Exception {
		assertTrue(topHeaderBar.isDisplayed());
		Utils.highLightElement(driver, topHeaderBar);

		assertTrue(leftTools.isDisplayed());
		Utils.highLightElement(driver, leftTools);
	}

	public void verifyAmazonTitleAndUrl(String title) throws Exception {
		assertEquals(Config.AppUrl, driver.getCurrentUrl());
		assertTrue(driver.getTitle().contains(title));
	}

	public void verifyHeaderBar() throws Exception {
		assertTrue(topHeaderBar.isDisplayed());
		Utils.highLightElement(driver, topHeaderBar);
	}

	public void enterSearchProduct(String productName) throws Exception {
		assertTrue(searchBox.isDisplayed());
		Utils.highLightElement(driver, leftTools);
		searchBox.sendKeys(productName);

		Utils.highLightElement(driver, searchButton);
		searchButton.click();
	}

	public void printThirdProductDetails() throws Exception {
		selectProduct();
		System.out.println("===>> THIRD PHONE TITLE ===>> : " + selectProductTitle);
	}

	public void productClick() throws Exception {
		selectProduct();
		thirdPhoneTitleElement.click();
	}

	public void selectProduct() throws Exception {
		Thread.sleep(2000);
		if (searchProductsList != null && searchProductsList.size() > 0) {
			for (int i = 0; i < searchProductsList.size(); i++) {
				if (i == 2) {
					thirdPhone = searchProductsList.get(i);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", thirdPhone);

					Utils.highLightElement(driver, thirdPhone);

					finalXpath = Utils.getElementXPath(driver, thirdPhone) + addlpath;
					thirdPhoneTitleElement = driver.findElement(By.xpath(finalXpath));

					selectProductTitle = thirdPhoneTitleElement.getText();
					Utils.highLightElement(driver, thirdPhoneTitleElement);
					break;
				}
			}
		}
	}

	public void deliveryToIconClick() throws Exception {
		Thread.sleep(5000);
		assertTrue(deliveryToLocationIcon.isDisplayed());
		Utils.highLightElement(driver, deliveryToLocationIcon);
		deliveryToLocationIcon.click();
	}

	public void locationChangePopUP() throws Exception {
		assertTrue(locationChoosePopUP.isDisplayed());
		Utils.highLightElement(driver, locationChoosePopUP);
	}

	public void zipCodeChangeButtonClick() throws Exception {
		try {
			Utils.highLightElement(driver, zipCodeChangeLink);
			zipCodeChangeLink.click();
		} catch (Exception e) {
			doneButton.click();
			Thread.sleep(3000);
			deliveryToLocationIcon.click();
		}

	}

	public void enterNewZipCode(String zipcode) throws Exception {
		assertTrue(zipCodeInputField.isDisplayed());
		Utils.highLightElement(driver, zipCodeInputField);
		zipCodeInputField.clear();
		zipCodeInputField.sendKeys(zipcode);
	}

	public void elaseAndenterNewZipCode(String zipcode) throws Exception {
		assertTrue(zipCodeInputField.isDisplayed());
		Utils.highLightElement(driver, zipCodeInputField);
		zipCodeInputField.clear();
		zipCodeInputField.sendKeys(zipcode);
	}

	public void selectNewDeliveryCountry(String deliveryCountry) throws Exception {
		assertTrue(deliveryCountryList.isDisplayed());
		Utils.highLightElement(driver, deliveryCountryList);
		Select sel = new Select(deliveryCountryList);
		sel.selectByVisibleText(deliveryCountry);

		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		outClick.click();
	}

	public void doneButtonClick() throws Exception {
		assertTrue(doneButton.isDisplayed());
		Utils.highLightElement(driver, doneButton);
		doneButton.click();
	}

	public void applyButtonClick() throws Exception {
		assertTrue(applyButton.isDisplayed());
		Utils.highLightElement(driver, applyButton);
		applyButton.click();
	}

	public void changeAddressButtonClick() throws Exception {
		Thread.sleep(2000);
		assertTrue(changeAddressButton.isDisplayed());
		Utils.highLightElement(driver, changeAddressButton);
		changeAddressButton.click();
	}

	public void continueButtonInLocationChangeClick() throws Exception {
		assertTrue(continueButtonInLocationChange.isDisplayed());
		Utils.highLightElement(driver, continueButtonInLocationChange);
		continueButtonInLocationChange.click();
		Thread.sleep(5000);
	}

	public void userSetNewDeliveryAddress(String newDeliveryCountry) throws Exception {
		assertTrue(newDeliveryCountryHomePage.isDisplayed());
		Utils.highLightElement(driver, newDeliveryCountryHomePage);
	}
	
	public void userLandOnHomepageWithNewAddress(String newDeliveryCountry ) throws Exception {
		dontChangeButton.click();
		assertEquals(newDeliveryCountry, newDeliveryCountryHomePage.getText());
		Utils.highLightElement(driver, newDeliveryCountryHomePage);
	}

}
