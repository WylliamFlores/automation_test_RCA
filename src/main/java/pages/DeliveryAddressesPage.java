package pages;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class DeliveryAddressesPage extends BasePage {

	public void addCommentAboutOrder(String text) {
		write_xpath("//textarea[@class='form-control']", text);
	}

	public void clickProceedCheckout() {
		click_xpath("//button[@name='processAddress']");
	}

	public List<String> verifyDeliveryAddress() {
		List<WebElement> errors = getDriver().findElements(By.xpath("//ul[@id='address_delivery']//li"));
		List<String> variable = new ArrayList<String>();
		for (WebElement error : errors) {
			variable.add(error.getText());
		}
		return variable;
	}
}