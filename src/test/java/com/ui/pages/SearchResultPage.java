package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility{
	
	private static final By PRODUCT_LISTING_TITILE_LOCATOR = By.xpath("//span[@class='lighter']");
	
	private static final By ALL_PRODUCT_LISTS_NAMES = By.xpath("//h5[@itemprop ='name']/a");
	

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSearchresultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITILE_LOCATOR); 
	}
	
	public boolean isSearchTermPresentInProductList(String searchTerm) {
		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList = getAllVisibleText(ALL_PRODUCT_LISTS_NAMES);
		boolean result = productNamesList.stream()
		.anyMatch(name ->(keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}
	
	public ProductDetailPage ClickOnTheProductIndexAt(int index) {
		clickOn(getAllElements(ALL_PRODUCT_LISTS_NAMES).get(index));
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
	}

}
