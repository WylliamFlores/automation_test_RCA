package pages;

import core.BasePage;

public class PaymentPage extends BasePage {

	public String verifyTotalBuyValue() {
		return getText("//span[@id='total_price']");
	}

	public void selectPaymentMethod(String option) {
		click_xpath("//div[@id='HOOK_PAYMENT']//*[@title='" + option + "']");
	}

	public void clickConfirmMyOrder() {
		click_xpath("//button[@class='button btn btn-default button-medium']");
	}

	public String verifyBuyWasSuccessful() {
		return getText("//p[@class='alert alert-success']");
	}
}