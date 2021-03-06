package tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.CartSummaryPage;
import pages.DeliveryAddressesPage;
import pages.ListProductPage;
import pages.MenuHorizontalPage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.RegisterCustomerPage;
import pages.ShippingPage;

public class BuyTests extends BaseTest {

	MenuHorizontalPage menuPage = new MenuHorizontalPage();
	ListProductPage listProductPage = new ListProductPage();
	ProductPage productPage = new ProductPage();
	CartSummaryPage summaryPage = new CartSummaryPage();
	RegisterCustomerPage registerCustomerPage = new RegisterCustomerPage();
	DeliveryAddressesPage addressPage = new DeliveryAddressesPage();
	ShippingPage shippingPage = new ShippingPage();
	PaymentPage paymentPage = new PaymentPage();

	@Test
	public void buySuccessfully() {
		// Choice and add products to cart
		menuPage.moveMouseOpenMenu("Women"); // Options: Women, Dresses or T-shirts
		menuPage.menuWomenSelectOption("Summer Dresses"); // Options: T-shirts, Blouses, Casual Dresses, Evening, Dresses, Summer Dresses
		listProductPage.waitProductListProcessing();
		listProductPage.selectProductAndOptions("Printed Chiffon Dress", "More"); // Options: Add to cart, More, Quick view
		productPage.waitProductProcessing();
		productPage.setQuantity("2");
		productPage.selectSize("M");
		productPage.clickButtonAddToCart();
		productPage.waitCartProcessing();
		productPage.clickButtonProccedCheckout();
		Assert.assertEquals("Printed Chiffon Dress", summaryPage.verifykProductCart());
		summaryPage.screenshot("verifykProductCart");
		// Register Customer
		summaryPage.clickProceedCheckout();
		registerCustomerPage.setEmailRandomForCreateAccount();
		registerCustomerPage.clickCreateAccount();
		registerCustomerPage.waitFormPersonalInformation();
		registerCustomerPage.clickRegister();
		List<String> errors = registerCustomerPage.verifyRequiredFields();
		Assert.assertTrue(errors.containsAll(Arrays.asList("You must register at least one phone number.",
				"lastname is required.", "firstname is required.", "passwd is required.", "address1 is required.",
				"city is required.", "The Zip/Postal code you've entered is invalid. It must follow this format: 00000",
				"This country requires you to choose a State.")));
		Assert.assertEquals(8, errors.size());
		registerCustomerPage.clickTitleMr();
		registerCustomerPage.setFirstName("Wylliam");
		registerCustomerPage.setLastName("Flores");
		registerCustomerPage.setPassword("12345");
		registerCustomerPage.setDateOfBirth("12  ", "January ", "1960  ");
		registerCustomerPage.checkNewsletter();
		registerCustomerPage.checkReceiveSpecialOffers();
		registerCustomerPage.yourAdressSetFirstName("Wylliam");
		registerCustomerPage.yourAdressSetLastName("Flores");
		registerCustomerPage.yourAdressSetCompany("Ltda");
		registerCustomerPage.yourAdressSetAddress("37 E. Victoria St");
		registerCustomerPage.yourAdressSetCity("Santa Barbara");
		registerCustomerPage.yourAdressSelectState("California");
		registerCustomerPage.yourAdressSetPostalCode("93101");
		registerCustomerPage.yourAdressSelectCountry("United States");
		registerCustomerPage.yourAdressSetAdditionalInformation("green house");
		registerCustomerPage.yourAdressSetHomePhone("3333-3333");
		registerCustomerPage.yourAdressSetMobilePhone("9999-9999");
		registerCustomerPage.setAlternateAddress("Canada");
		registerCustomerPage.clickRegister();
		// Delivery Address
		List<String> text = addressPage.verifyDeliveryAddress();
		Assert.assertTrue(
				text.containsAll(Arrays.asList("YOUR DELIVERY ADDRESS", "Wylliam Flores", "Ltda", "37 E. Victoria St",
						"Santa Barbara, California 93101", "United States", "3333-3333", "9999-9999", "Update")));
		addressPage.screenshot("verifyDeliveryAddress");
		addressPage.addCommentAboutOrder("deliver from 13h to 18h");
		addressPage.clickProceedCheckout();
		shippingPage.checkTermsOfService();
		shippingPage.clickProceedCheckout();
		// Payment
		Assert.assertEquals("$34.80", paymentPage.verifyTotalBuyValue());
		paymentPage.screenshot("verifyTotalBuyValue");
		paymentPage.selectPaymentMethod("Pay by check."); // Options: Pay by bank wire, Pay by check.
		paymentPage.clickConfirmMyOrder();
		Assert.assertEquals("Your order on My Store is complete.", paymentPage.verifyBuyWasSuccessful());
	}
}