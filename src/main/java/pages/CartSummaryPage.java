package pages;

import core.BasePage;

public class CartSummaryPage extends BasePage {

	public String checkProductCart() {
		return getText("//table[@id='cart_summary']//*[text()='Printed Chiffon Dress']");
	}

	public void clickProceedCheckout() {
		click_xpath("//*[@class='button btn btn-default standard-checkout button-medium']");
	}
}
