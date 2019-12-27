package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private static WebDriver browser;

	private DriverFactory() {

	}

	public static WebDriver getDriver() {
		if (browser == null) {
			browser = new ChromeDriver();
		}
		return browser;
	}

	public static void killDriver() {
		if (browser != null) {
			browser.quit();
			browser = null;
		}
	}
}