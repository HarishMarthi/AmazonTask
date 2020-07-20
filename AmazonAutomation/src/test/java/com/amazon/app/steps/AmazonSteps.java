package com.amazon.app.steps;

import org.openqa.selenium.WebDriver;

import com.amazon.app.pages.AmazonHomepage;
import com.amazon.app.pages.AmazonProductDetailsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSteps {

	public WebDriver driver = Hooks.driver;

	AmazonHomepage homePage = new AmazonHomepage(driver);
	AmazonProductDetailsPage productDetailsPage = new AmazonProductDetailsPage(driver);

	@When("User land on Home page of amazon application")
	public void User_land_on_Home_page_of_amazon_application() throws Exception {
		homePage.verifyUserLandOnHomepgae();
	}

	@Then("verify page title contains (.*) on the amazon application")
	public void verify_page_title_contains_amzonTitle_on_the_amazon_application(String title) throws Exception {
		homePage.verifyAmazonTitleAndUrl(title);
	}

	@Then("verify that header bar got displayed in amazon home page")
	public void verify_that_header_bar_got_displayed_in_amazon_home_page() throws Exception {
		homePage.verifyHeaderBar();
	}

	@Then("user enter search product name as (.*) in the search bar")
	public void user_enter_search_product_name_in_the_search_bar(String productSearch) throws Exception {
		homePage.enterSearchProduct(productSearch);
	}

	@Then("print the name and title of the third phone from the results")
	public void print_the_name_and_title_of_the_third_phone_from_the_results() throws Exception {
		homePage.printThirdProductDetails();
	}

	@Then("verify that user is landed on product details page")
	public void veriry_that_user_is_landed_on_product_details_page() throws Exception {
		productDetailsPage.verifyProductDetailsPage();
	}

	@Then("user hover the rating stars in product details section")
	public void user_hover_the_rating_stars_in_product_details_section() throws Exception {
		productDetailsPage.hoverRatingStars();
	}

	@Then("read and print the avg stars rate from the product details section")
	public void read_and_print_the_avg_stars_rate_from_the_product_details_section() throws Exception {
		productDetailsPage.printAvgStarsRate();
	}

	@Then("user click on the third phone from the search results")
	public void user_click_on_the_third_phone_from_the_search_results() throws Exception {
		homePage.productClick();
	}

	@When("user click on delivery to location icon in home page")
	public void user_click_on_delivery_to_location_icon_in_home_page() throws Exception {
		homePage.deliveryToIconClick();
	}

	@When("verify that choose location pop up dispayed in home page")
	public void verify_that_choose_location_pop_up_dispayed_in_home_page() throws Exception {
		homePage.locationChangePopUP();
	}

	@When("In the pop up which open click on change button")
	public void in_the_pop_up_whichc_open_click_on_chnage_button() throws Exception {
		homePage.zipCodeChangeButtonClick();
	}

	@When("user selects deliver country as (.*) from country list")
	public void user_selects_deliver_country_from_country_list(String deliveryCountry) throws Exception {
		homePage.selectNewDeliveryCountry(deliveryCountry);
	}

	@When("user enter new zip code as (.*) in popup")
	public void user_enter_new_zip_code_as_in_popup(String zipcode) throws Exception {
		homePage.enterNewZipCode(zipcode);
	}

	@When("user click on done button in bottom of the popup")
	public void user_click_on_done_button_in_bottom_of_the_popup() throws Exception {
		homePage.doneButtonClick();
	}

	@When("user click on apply button in choose location popup")
	public void user_click_on_apply_button_in_choose_location_popup() throws Exception {
		homePage.applyButtonClick();
	}
	
	@When("user click on change address button in the pop up")
	public void use_click_on_change_address_button_in_the_pop_up () throws Exception {
		homePage.changeAddressButtonClick();
	}

	@When("user click on continue button in another pop up")
	public void user_click_on_continue_button_in_another_pop_up() throws Exception {
		homePage.continueButtonInLocationChangeClick();
	}

	@When("verify that user land on homepage with new delivery address as (.*)")
	public void verify_that_user_land_on_homepage_with_new_delivery_address(String newDeliveryAddress)
			throws Exception {
		homePage.userLandOnHomepageWithNewAddress(newDeliveryAddress);
	}

	@When("user clear existing zipcode and enter new zip code as (.*) in popup")
	public void user_clear_existing_zipcode_and_enter_new_zip_code_in_popup(String newZipCode) throws Exception {
		homePage.elaseAndenterNewZipCode(newZipCode);
	}

}
