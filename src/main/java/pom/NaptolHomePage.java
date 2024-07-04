package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolHomePage {
	
	@FindBy (xpath ="//a[@id='login-panel-link']")private WebElement loginOrRegister;
	@FindBy (xpath ="//a[text()='Track Order']")private WebElement trackOrder;
	@FindBy (xpath ="//div[@class='cate_head']") private WebElement shoppingCategories;
	@FindBy (xpath ="//input[@id='header_search_text']")private WebElement searchField;
	@FindBy (xpath ="(//div[@class='search']//a)[2]") private WebElement search;
	@FindBy (xpath ="(//a[@id='cart-panel-link'])[2]") private WebElement cart;
	@FindBy (xpath ="//div[@id='mainMenuContent']//ul//li[1]//a//span") private WebElement listItem;
	@FindBy (xpath ="//div[@class='grid_Square ']") private List<WebElement> productList;
	@FindBy (xpath = "//a[@title='Close']") private WebElement close;
	@FindBy(xpath = "//section[@id='registerSignBox']")private WebElement popup;
	@FindBy (xpath = "//a[@class='link_Continue']") private WebElement continueShopping;
	
	public NaptolHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginOrRegister() {
		loginOrRegister.click();
	}
	
	public void clickOnTrackOrder() {
		trackOrder.click();
	}
	
	public void viewShoppingCategories(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(shoppingCategories);
		actions.perform();
	}
	
	public void enterProductToSearch(String product) {
		searchField.sendKeys(product);
	}
	
	public void clickOnSearch() {
		search.click();
	}
	
	public void clickOnCart() {
		cart.click();
	}
	
	public boolean isListItemDisplayed() {
		return listItem.isDisplayed();
	}
	
	public int getNumberOfProductDisplayed() {
		return productList.size();
	}
	public void clickOnClose() {
		close.click();
	}
	public void clickOnContinue() {
		continueShopping.click();
	}

	public boolean popupisDisplayed() {
		return popup.isDisplayed();
	}

	}

