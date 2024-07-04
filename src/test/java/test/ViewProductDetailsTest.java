package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class ViewProductDetailsTest extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyIfUserIsViewProductDetailsFromQuickView() {
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("cooker");
		naptolHomePage.clickOnSearch();
		ProductResultPage productResultPage = new ProductResultPage(driver);
		String productName = productResultPage.getProductTitle(1);
		String productPrice = productResultPage.getProductPrice(1);
		productResultPage.moveToDesiredProduct(driver, 1);
		productResultPage.clickOnQuickView(1);
		Assert.assertEquals(productResultPage.getProductNameOnQuickView(), productName);
		Assert.assertEquals(productResultPage.getProductPriceOnQuickView(), productPrice);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@AfterTest
	public void publishReport() {
		reports.flush();

	}
}
