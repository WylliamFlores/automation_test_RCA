package pages;

import core.BasePage;

public class ProductPage extends BasePage {

	public void setQuantity(String value) {
		write_id("quantity_wanted", value);
	}

	public void selectSize(String text) {
		selectCombo_id("group_1", text);
	}

	public void clickButtonAddToCart() {
		click_id("add_to_cart");
	}

	public void clickButtonProccedCheckout() {
		click_xpath("//a[@title='Proceed to checkout']");
	}

	public void waitCartProcessing() {
		wait_visibilityOfAllElementsLocatedBy("//a[@title='Proceed to checkout']");
	}

	public void waitProductProcessing() {
		wait_visibilityOfAllElementsLocatedBy("//div[@class='primary_block row']");
	}
}