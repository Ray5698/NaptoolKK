package pom;


	
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;

	import utility.Parametrization;

	public class AddressToShipProductPage {
		
		@FindBy  (xpath="//select[@name='fktitle_id']")private WebElement titLe;
		@FindBy  (xpath="//input[@id='firstName']")private WebElement firstName;
		@FindBy  (xpath="//input[@id='lastName']")private WebElement lastName;
		@FindBy  (xpath="//textarea[@id='address']")private WebElement address;
		@FindBy  (xpath="//input[@name='landmark']")private WebElement landMark;
		@FindBy  (xpath="//input[@id='pincode']")private WebElement pincode;
		@FindBy  (xpath="//select[@id='state']")private WebElement state;
		@FindBy  (xpath="//select[@id='city']")private WebElement city;
		@FindBy  (xpath="//input[@id='mobile']")private WebElement mobileNumberAddress;
		@FindBy  (xpath="//input[@id='landline']")private WebElement landLine;
		@FindBy  (xpath="//a[@class='button_2']")private WebElement shipToThisAddress;

		
		public  AddressToShipProductPage (WebDriver driver) {
			PageFactory.initElements(driver, this);
	}
		public void selectTitle() {
			Select select = new Select(titLe);
			select.selectByIndex(1);
		}

		public void enterFirstName() throws EncryptedDocumentException, IOException {
			String Name = Parametrization.getTestData( 1, 0, "Sheet1");
			firstName.sendKeys(Name);
		}

		public void enterLastName() throws EncryptedDocumentException, IOException {
			String Lastname = Parametrization.getTestData(2, 0, "Sheet1");
			lastName.sendKeys(Lastname);
		}

		public void enterAddress() throws EncryptedDocumentException, IOException {
			String add = Parametrization.getTestData(3, 0, "Sheet1");
			address.sendKeys(add);
		}

		public void enterLandMark() throws EncryptedDocumentException, IOException {
			String mark = Parametrization.getTestData(4, 0, "Sheet1");
			landMark.sendKeys(mark);
		}

		public void enterPincode() throws EncryptedDocumentException, IOException {
			String pin = Parametrization.getTestData(5, 0, "Sheet1");
			pincode.sendKeys(pin);
		}

		public void selectState() {
			state.click();
			Select select = new Select(state);
			select.selectByVisibleText("MAHARASHTRA");
		}

	
		public void enterMobileNoinShippingAddrees() throws EncryptedDocumentException, IOException
		{
			String mobileNumber = Parametrization.getTestData(6, 0, "Sheet1");
			mobileNumberAddress.sendKeys(mobileNumber);
		}

		public void enterLandLine() throws EncryptedDocumentException, IOException {
			String landline = Parametrization.getTestData(7, 0, "Sheet1");
			landLine.sendKeys(landline);
		}

		public void clickOnShipptothisAddress() {
			shipToThisAddress.click();

		}

	}


