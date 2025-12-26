package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{

	private static final By PAY_BY_BANK_WIRE_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
	
	private static final By I_CONFIRM_MY_ORDER_BUTTON_LOCATOR = By.xpath("//button[contains(@class, 'button btn btn-default')]");
	
	private static final By ORDER_COMPLETE_SUCCESS_MESSAGE_LOCATOR = By.xpath("//p[@class = 'alert alert-success']");
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public PaymentPage clickOnPaymentMethod() {
		clickOn(PAY_BY_BANK_WIRE_LOCATOR);
		return new PaymentPage(getDriver());
	}
	
	public PaymentPage clickOnIConfirmMyOrderButton() {
		clickOn(I_CONFIRM_MY_ORDER_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}
	
	public String getOrderSuccessMessage() {
		return getVisibleText(ORDER_COMPLETE_SUCCESS_MESSAGE_LOCATOR);
	}
}
