package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class EditContactDetailsPage extends ProjectSpecificationMethod{
	
	@FindBy(id = "firstName")
	WebElement EditFirstName;
	
	@FindBy(id = "lastName")
	WebElement EditLastName;
	
	@FindBy(id = "birthdate")
	WebElement EditDOB;
	
	@FindBy(id = "email")
	static
	//static
	WebElement EditEmail;
	
	@FindBy(id = "phone")
	static
	//static
    WebElement EditPhnNum;
	
	@FindBy(id = "street1")
	WebElement EditStreet1;
	
	@FindBy(id = "street2")
	WebElement EditStreet2;
	
	@FindBy(id = "city")
	WebElement EditCity;
	
	@FindBy(id = "stateProvince")
	WebElement EditState;
	
	@FindBy(id = "postalCode")
	WebElement EditPostalCode;
	
	@FindBy(id = "country")
	WebElement EditCountry;
	
	@FindBy(id = "submit")
	WebElement EditSaveBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement CancelEdit;
	
	@FindBy(xpath = "//span[text()='Validation failed: lastName: Path `lastName` is required.']")
	static
	WebElement LNError;
	
	@SuppressWarnings("static-access")
	public EditContactDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public EditContactDetailsPage EditFirstName(String FName) {
		EditFirstName.sendKeys(FName);
		return this;
	}

	public EditContactDetailsPage EditLastName() throws InterruptedException {
		EditLastName.clear();
		//Thread.sleep(3000);
	    //EditLastName.sendKeys(LName);
		return this;
	}

	public EditContactDetailsPage EditDOB(String DOB) {
		EditDOB.sendKeys(DOB);
		return this;
	}

	public EditContactDetailsPage EditEmail(String email) {
		EditEmail.clear();
		EditEmail.sendKeys(email);
		return this;
	}
	public EditContactDetailsPage EditPhnNumber(String PhnNum) {
		EditPhnNum.clear();
		EditPhnNum.sendKeys(PhnNum);
		return this;
	}
	public EditContactDetailsPage EditStreet1(String Street1) {
		EditStreet1.sendKeys(Street1);
		return this;
	}
	public EditContactDetailsPage EditStreet2(String Street2) {
		EditStreet2.sendKeys(Street2);
		return this;
	}

	public EditContactDetailsPage EditCity(String city) {
		EditCity.sendKeys(city);
		return this;
	}

	public EditContactDetailsPage  EditState(String state) {
		EditState.sendKeys(state);
		return this;
	}
	
	public EditContactDetailsPage EditPostalCode(String postalcode) {
		EditPostalCode.sendKeys(postalcode);
		return this;
	}
	
	public EditContactDetailsPage EditCountry(String country) {
		EditCountry.sendKeys(country);
		return this;
	}
	
	public ContactDetailsPage ClickSaveBtn() {
	
	EditSaveBtn.click();
	return new ContactDetailsPage(driver);
	
	}
	
	public ContactDetailsPage ClickCancel() {
		
	CancelEdit.click();
	return new ContactDetailsPage(driver);
	
	}
	
	 public static  String getValidationError() {
	        return LNError.getText();
	    }

	@SuppressWarnings("deprecation")
	public static String  getEmailFieldValue() {
  
	        return EditEmail.getAttribute("value");
	}
	

	@SuppressWarnings("deprecation")
	public static String getPhnNumFieldValue() {

		return EditPhnNum.getAttribute("value");
	}
	


}
