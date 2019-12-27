package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void write_id(String id, String text) {
		getDriver().findElement(By.id(id)).clear();
		getDriver().findElement(By.id(id)).sendKeys(text);
	}

	public void write_xpath(String xpath, String text) {
		getDriver().findElement(By.xpath(xpath)).clear();
		getDriver().findElement(By.xpath(xpath)).sendKeys(text);
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

	public void clickRadio_id(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clickCheck_id(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void wait_visibilityOfAllElementsLocatedBy(String xpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}
}