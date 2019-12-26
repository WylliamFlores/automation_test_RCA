package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import core.BasePage;
import core.DriverFactory;

public class MenuHorizontalPage extends BasePage {

	public void moveMouseOpenMenu(String text) {
		Actions action = new Actions(DriverFactory.getDriver());
		WebElement menu = DriverFactory.getDriver()
				.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/a[text()='" + text + "']"));
		action.moveToElement(menu).perform();
	}

	public void menuWomenSelectOption(String text) {
		click_xpath("//ul//a[text()='" + text + "']");
	}
}