package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@title='Proceed to checkout']")));
	}
}