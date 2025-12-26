package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;
import static com.ui.pages.Size.*;


@Listeners(com.ui.listeners.TestListener.class)
public class ProductCheckoutTest extends TestBase{


	private static final String SEARCH_TERM ="Printed summer Dress";
	private static final String ORDER_SUCCESSFUL_MESSAGE = "Your order on My Shop is complete.";
	
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description = "Valid user logs into the application and searches for the product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("kopit20941@kudimi.com", "password").searchForTheProduct(SEARCH_TERM);
	}
	
	@Test(description = "Verify if the logged in User is able to buy a dress", groups = {"e2e", "smoke", "sanity" })
	public void checkoutTest() {	
		assertEquals(searchResultPage.ClickOnTheProductIndexAt(2).changeSize(L).addProductToCart()
		.proceedtoCheckout().goToConfirmAddressPage().goToShipmentPage().goToPaymentPage()
		.clickOnPaymentMethod().clickOnIConfirmMyOrderButton().getOrderSuccessMessage(), ORDER_SUCCESSFUL_MESSAGE);
	}
}
