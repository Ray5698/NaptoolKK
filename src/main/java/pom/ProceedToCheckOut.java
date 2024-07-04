package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedToCheckOut {

	@FindBy (xpath="//a[@class='red_button2']")private WebElement proceed;
	@FindBy (xpath="//input[@id='gc-registration-basic-panel-mobile']")private WebElement mobilenumber;
	@FindBy (xpath ="//input[@id='gc-registration-basic-panel-submit']")private WebElement submit;
	@FindBy (xpath = "//input[@placeholder='Enter One Time Password ( OTP )']")private String otp;
	@FindBy (xpath = "//input[@id='gc-registration-otp-panel-submit']")private WebElement submitbutton;
	public ProceedToCheckOut(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void ClickOnProceedToCheckOut() {
		proceed.click();
	}
	
	public void ClickOnContinue() {
		submit.click();
	}
    public void ClickOnSubmit() {
    	submitbutton.click();
    }
	public String EnterMobileNumber(String number) {
		mobilenumber.sendKeys(number);
		return number;
	}
		
	}

