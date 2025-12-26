package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

@Listeners(com.ui.listeners.TestListener.class)

public class AddNewFirstAddressTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private AddressPOJO address;
	
	@BeforeMethod(description = "Valid First time user logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("kopit20941@kudimi.com", "password");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addNewAddress() {
		String newAddress = myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
		
	}

}
