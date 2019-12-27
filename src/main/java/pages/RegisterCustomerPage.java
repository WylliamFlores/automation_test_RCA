package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;
import core.DriverFactory;

public class RegisterCustomerPage extends BasePage {

	public void waitFormPersonalInformation() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("uniform-id_gender1")));
	}

	public void setEmailForCreateAccount(String text) {
		write_id("email_create", text);
	}

	public void clickCreateAccount() {
		click_id("SubmitCreate");
	}

	public void clickTitleMr() {
		clickRadio_id("uniform-id_gender1");
	}

	public void setFirstName(String text) {
		write_id("customer_firstname", text);
	}

	public void setLastName(String text) {
		write_id("customer_lastname", text);
	}

	public void setEmail(String text) {
		write_id("email", text);
	}

	public void setPassword(String value) {
		write_id("passwd", value);
	}

	public void setDateOfBirth(String day, String month, String year) {
		selectCombo_id("days", day);
		selectCombo_id("months", month);
		selectCombo_id("years", year);
	}

	public void checkNewsletter() {
		clickCheck_id("newsletter");
	}

	public void checkReceiveSpecialOffers() {
		clickCheck_id("optin");
	}

	public void yourAdressSetFirstName(String text) {
		write_id("firstname", text);
	}

	public void yourAdressSetLastName(String text) {
		write_id("lastname", text);
	}

	public void yourAdressSetCompany(String text) {
		write_id("company", text);
	}

	public void yourAdressSetAddress(String text) {
		write_id("address1", text);
	}

	public void yourAdressSetAddress2(String text) {
		write_id("address2", text);
	}

	public void yourAdressSetCity(String text) {
		write_id("city", text);
	}

	public void yourAdressSelectState(String text) {
		selectCombo_id("id_state", text);
	}

	public void yourAdressSetPostalCode(String text) {
		write_id("postcode", text);
	}

	public void yourAdressSelectCountry(String text) {
		selectCombo_id("id_country", text);
	}

	public void yourAdressSetAdditionalInformation(String text) {
		write_id("other", text);
	}

	public void yourAdressSetHomePhone(String value) {
		write_id("phone", value);
	}

	public void yourAdressSetMobilePhone(String value) {
		write_id("phone_mobile", value);
	}

	public void setAlternateAddress(String text) {
		write_id("alias", text);
	}

	public void clickRegister() {
		click_xpath("//button[@name='submitAccount']");
	}
}