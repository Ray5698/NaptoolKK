package test;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductDetailPage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class CartTestAddTwoProducts extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyAddToCartFromOrderDeatils() {
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("Cooker");
		naptolHomePage.clickOnSearch();
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickOnBuyButton();

		naptolHomePage.clickOnContinue();
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("Copper Water Dispenser");
		naptolHomePage.clickOnSearch();
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		productDetailPage.clickOnBuyButton();
		cartPage = new CartPage(driver);
		String expectedName = cartPage.getProductName(0);
		double expectedPrice = cartPage.getProductPrice(1);
		double expectedShippingPrice = cartPage.getShippingPrice(1);

		Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 2);
		Assert.assertEquals(cartPage.getProductName(0), expectedName);
		Assert.assertEquals(cartPage.getProductPrice(1), expectedPrice);
		Assert.assertEquals(cartPage.getShippingPrice(1), expectedShippingPrice);

	}

	@Test

	public void verifyRemoveFunctionalityFromAddToCart() throws InterruptedException {
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("Cooker");
		naptolHomePage.clickOnSearch();
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickOnBuyButton();
		cartPage = new CartPage(driver);
		cartPage.removeProductFromCart();

		Thread.sleep(2000);
		Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 0);

	}

}