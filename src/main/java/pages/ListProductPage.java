package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import core.BasePage;

public class ListProductPage extends BasePage {

	public void selectProductAndOptions(String product, String option) {
		Actions action = new Actions(getDriver());
		WebElement products = getDriver()
				.findElement(By.xpath("//div[@class='right-block']//a[@title='" + product + "']"));
		action.moveToElement(products).perform();
		click_xpath(
				"//div[@class='right-block']//a[@title='" + product + "']/../../..//a//span[text()='" + option + "']");
	}
}