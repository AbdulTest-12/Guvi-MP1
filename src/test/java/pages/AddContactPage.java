package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class AddContactPage extends ProjectSpecificationMethod {

	@FindBy(id = "firstName")
	WebElement AddFirstName;
	
	@FindBy(id = "lastName")
	WebElement AddLastName;
	
	@FindBy(id = "birthdate")
	WebElement AddDOB;
	
	@FindBy(id = "email")
	WebElement AddEmail;
	
	@FindBy(id = "phone")
	WebElement AddPhnNum;
	
	@FindBy(id = "street1")
	WebElement  AddStreet1;
	
	@FindBy(id = "street2")
	WebElement AddStreet2;
	
	@FindBy(id = "city")
	WebElement AddCity;
	
	@FindBy(id = "stateProvince")
	WebElement AddState;
	
	@FindBy(id = "postalCode")
	WebElement AddPostalCode;
	
	@FindBy(id = "country")
	WebElement AddCountry;
	
	@FindBy(xpath = "//span[contains(text(),'firstName: Path `firstName` is required., lastName: Path `lastName` is required.')]")
	WebElement ErrorMsg;
	
	@FindBy(xpath = "//span[contains(text(),'Phone number is invalid')]")
	WebElement InvalidPhnNum;
	
	@FindBy(id = "submit")
	WebElement SubmitAddContactBtn;
	
	@SuppressWarnings("static-access")
	public AddContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public AddContactPage AddFirstName(String FName) {
		AddFirstName.sendKeys(FName);
		return this;
	}

	public AddContactPage AddLastName(String LName) {
		AddLastName.sendKeys(LName);
		return this;
	}

	public AddContactPage AddDOB(String DOB) {
		AddDOB.sendKeys(DOB);
		System.out.println(AddDOB);
		return this;
	}

	public AddContactPage AddEmail(String Email) {

		AddEmail.sendKeys(Email);
		return this;
	}
	public AddContactPage AddPhnNumber(String PhnNum) {
		AddPhnNum.sendKeys(PhnNum);
		return this;
	}
	public AddContactPage AddStreet1(String Street1) {
		AddStreet1.sendKeys(Street1);
		return this;
	}
	public AddContactPage AddStreet2(String Street2) {
		AddStreet2.sendKeys(Street2);
		return this;
	}

	public AddContactPage AddCity(String city) {
		AddCity.sendKeys(city);
		return this;
	}

	public AddContactPage  AddState(String state) {
		AddState.sendKeys(state);
		return this;
	}
	
	public AddContactPage AddPostalCode(String postalcode) {
		AddPostalCode.sendKeys(postalcode);
		return this;
	}
	
	public AddContactPage AddCountry(String country) {
		AddCountry.sendKeys(country);
		return this;
	}
	
	public ContactListPage ClickSubmitBtn() {
			
		SubmitAddContactBtn.click();
		return new ContactListPage(driver);
	}
	
public void validateAddConatct(String testType, String expectedMessage) {
		
		if(testType.equals("Valid")) {
			
			String actualText = driver.findElement(By.xpath("//p[normalize-space()='Click on any contact to view the Contact Details']")).getText();
			Assert.assertEquals(actualText, expectedMessage);
					
			}else if(testType.equals("No User")){
					
				String actualText = ErrorMsg.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}else if(testType.equals("Duplicate")){
					
				String actualText = driver.findElement(By.xpath("//p[normalize-space()='Click on any contact to view the Contact Details']")).getText();
				Assert.assertEquals(actualText, expectedMessage);
				
				}else if(testType.equals("Without Name")){
					
				String actualText = ErrorMsg.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}else if(testType.equals("Invalid Phn")){
					
				String actualText = InvalidPhnNum.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}
}

}