package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.CartSummaryPage;
import pages.ListProductPage;
import pages.MenuHorizontalPage;
import pages.ProductPage;
import pages.RegisterCustomerPage;

public class BuyTests extends BaseTest {

	MenuHorizontalPage menuPage = new MenuHorizontalPage();
	ListProductPage listProductPage = new ListProductPage();
	ProductPage productPage = new ProductPage();
	CartSummaryPage summaryPage = new CartSummaryPage();
	RegisterCustomerPage registerCustomerPage = new RegisterCustomerPage();

	@Test
	public void buySuccessfully() {
		//Choice and add products to cart
		menuPage.moveMouseOpenMenu("Women"); //Options: Women, Dresses or T-shirts
		menuPage.menuWomenSelectOption("Summer Dresses"); //Options: T-shirts, Blouses, Casual Dresses, Evening Dresses, Summer Dresses
		listProductPage.selectProductAndOptions("Printed Chiffon Dress", "More"); //Options: Add to cart, More, Quick view	
		productPage.setQuantity("2");
		productPage.selectSize("M");
		productPage.clickButtonAddToCart();
		productPage.waitCartProcessing();
		productPage.clickButtonProccedCheckout();		
		Assert.assertEquals("Printed Chiffon Dress", summaryPage.verifykProductCart());
		//Register Custumer
		summaryPage.clickProceedCheckout();
		registerCustomerPage.setEmailForCreateAccount("email@teste.com");
		registerCustomerPage.clickCreateAccount();
		registerCustomerPage.waitFormPersonalInformation();
		registerCustomerPage.clickTitleMr();
		registerCustomerPage.setFirstName("Wylliam");
		registerCustomerPage.setLastName("Flores");
		registerCustomerPage.setPassword("12345");
		registerCustomerPage.setDateOfBirth("12  ", "January ", "1960  ");
		registerCustomerPage.checkNewsletter();
		registerCustomerPage.checkReceiveSpecialOffers();
		registerCustomerPage.yourAdressSetFirstName("Wyll");
		registerCustomerPage.yourAdressSetLastName("Flowers");
		registerCustomerPage.yourAdressSetCompany("Ltda");
		registerCustomerPage.yourAdressSetAddress("Av. Padre Cacique, 320");
		registerCustomerPage.yourAdressSetAddress2("Av Independência, 500");
		registerCustomerPage.yourAdressSetCity("Porto Alegre");
		registerCustomerPage.yourAdressSelectState("California");
		registerCustomerPage.yourAdressSetPostalCode("90810");
		registerCustomerPage.yourAdressSelectCountry("United States");
		registerCustomerPage.yourAdressSetAdditionalInformation("green house");
		registerCustomerPage.yourAdressSetHomePhone("3333-3333");
		registerCustomerPage.yourAdressSetMobilePhone("9999-9999");
		registerCustomerPage.setAlternateAddress("Canada");
		registerCustomerPage.clickRegister();				
	}
}