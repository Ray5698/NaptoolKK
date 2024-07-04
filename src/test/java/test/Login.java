package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.AddressToShipProductPage;
import pom.NaptolHomePage;
import pom.ProceedToCheckOut;
import pom.ProductDetailPage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class Login extends BaseTest {
	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test

	public void verifyProceedToCheckOut() throws InterruptedException, EncryptedDocumentException, IOException {
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("cooker");
		naptolHomePage.clickOnSearch();
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickOnBuyButton();
		proceedToCheckOut = new ProceedToCheckOut(driver);
		proceedToCheckOut.ClickOnProceedToCheckOut();
		proceedToCheckOut.EnterMobileNumber("7559441512");
		proceedToCheckOut.ClickOnContinue();
		Thread.sleep(25000);
		proceedToCheckOut.ClickOnSubmit();
		AddressToShipProductPage shippingaddress = new AddressToShipProductPage(driver);
		shippingaddress.selectTitle();
		shippingaddress.enterFirstName();
		shippingaddress.enterLastName();
		shippingaddress.enterAddress();
		shippingaddress.enterLandMark();
		shippingaddress.enterPincode();
		shippingaddress.selectState();

		shippingaddress.enterMobileNoinShippingAddrees();
		shippingaddress.enterLandLine();
		shippingaddress.clickOnShipptothisAddress();

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
