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
import utility.Reports;

@Listeners(test.Listeners.class)
public class ProductSearchTest extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyIfUserIsAbleRoSerachProduct() {
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("grinder");
		naptolHomePage.clickOnSearch();
		Assert.assertTrue(driver.getTitle().contains("grinder"));
		Assert.assertTrue(naptolHomePage.getNumberOfProductDisplayed() > 0);

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
