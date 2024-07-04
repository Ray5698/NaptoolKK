package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;

import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProceedToCheckOut;
import pom.ProductDetailPage;
import pom.ProductResultPage;

public class BaseTest {

	public static WebDriver driver;
	public NaptolHomePage naptolHomePage;
	public ProductResultPage productResultPage;
	public ProductDetailPage productDetailPage;
	public CartPage cartPage;
	public ExtentReports reports;
	public ProceedToCheckOut proceedToCheckOut;
	
	public void switchToChildBrowser() {
		Set<String> handles =driver.getWindowHandles();
		Iterator<String> i=handles.iterator();
		
		while(i.hasNext()) {
			driver.switchTo().window(i.next());
		}
	}
}