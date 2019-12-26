package tests;

import org.junit.Test;

import core.BaseTest;
import pages.MenuHorizontalPage;

public class BuyTests extends BaseTest {

	MenuHorizontalPage menuPage = new MenuHorizontalPage();

	@Test
	public void buySuccessfully() {
		menuPage.moveMouseOpenMenu("Women"); //options text: Women, Dresses or T-shirts
		menuPage.menuWomenSelectOption("Summer Dresses"); //options text: T-shirts, Blouses, Casual Dresses, Evening Dresses or Summer Dresses
		
		//viewProductOptions("Printed Chiffon Dress") //inform the product
		//selectProductOption("More") //options text: Add to cart, More or Quick view		
	}
}