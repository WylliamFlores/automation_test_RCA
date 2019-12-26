package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.CartSummaryPage;
import pages.ListProductPage;
import pages.MenuHorizontalPage;
import pages.ProductPage;

public class BuyTests extends BaseTest {

	MenuHorizontalPage menuPage = new MenuHorizontalPage();
	ListProductPage listProductPage = new ListProductPage();
	ProductPage productPage = new ProductPage();
	CartSummaryPage summaryPage = new CartSummaryPage();

	@Test
	public void buySuccessfully() {
		menuPage.moveMouseOpenMenu("Women"); //Options: Women, Dresses or T-shirts
		menuPage.menuWomenSelectOption("Summer Dresses"); //Options: T-shirts, Blouses, Casual Dresses, Evening Dresses or Summer Dresses
		listProductPage.selectProductAndOptions("Printed Chiffon Dress", "More"); //Options: Add to cart, More or Quick view	
		productPage.setQuantity("2");
		productPage.selectSize("M");
		productPage.clickButtonAddToCart();
		productPage.waitCartProcessing();
		productPage.clickButtonProccedCheckout();
		Assert.assertEquals("Printed Chiffon Dress", summaryPage.checkProductCart());
		summaryPage.clickProceedCheckout();		
	}
}