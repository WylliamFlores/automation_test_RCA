package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void write_id(String id, String text) {
		DriverFactory.getDriver().findElement(By.id(id)).clear();
		getDriver().findElement(By.id(id)).sendKeys(text);
	}

	public void selectCombo_id(String id, String value) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(value);
	}

	public void click_id(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void click_xpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public String getText(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getText();
	}
}