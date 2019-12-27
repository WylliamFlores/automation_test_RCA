package pages;

import core.BasePage;

public class ShippingPage extends BasePage {

	public void checkTermsOfService() {
		clickCheck_id("cgv");
	}

	public void clickProceedCheckout() {
		click_xpath("//button[@name='processCarrier']");
	}
}