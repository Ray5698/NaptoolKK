package pom;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

	@FindBy (xpath = "//ul[@id='cartData']") private List<WebElement> products;
	@FindBy (xpath = "//div[@class='cart_info']//h2") private List<WebElement> productName;
	@FindBy (xpath = "//li[@class='head_UPrice']") private List<WebElement> productPrice;
	@FindBy (xpath = "//li[@class='head_ship']") private List<WebElement> shippingPrice;
	@FindBy (xpath = "//li[@class='head_Amount']") private List<WebElement> orderAmount;
	@FindBy (xpath = "//a[text()='Remove']") private WebElement remove;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getNumberOfProductsInCart() {
		return products.size();
	}
	
	public String getProductName(int index) {
		return productName.get(index).getText();
	}
	
	public double getProductPrice(int index) {
		//Start index from 1 as 0 is table heading
		return Double.parseDouble(removeCommaFromString(productPrice.get(index).getText().substring(3)));
	}
	
	public double getShippingPrice(int index) {
		//Start index from 1 as 0 is table heading
		return Double.parseDouble(removeCommaFromString(shippingPrice.get(index).getText().substring(3)));
	}
	
	public double getOrderAmount(int index) {
		//Start index from 1 as 0 is table heading
		return Double.parseDouble(removeCommaFromString(orderAmount.get(index).getText()));
	}
	public void removeProductFromCart() {
		remove.click();
			
	}

}