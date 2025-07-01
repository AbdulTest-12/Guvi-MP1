package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class SignUpPage extends ProjectSpecificationMethod {

	@FindBy(id = "firstName")
	WebElement FirstName;

	@FindBy(id = "lastName")
	WebElement LastName;

	@FindBy(id = "email")
	WebElement Email;

	@FindBy(id = "password")
	WebElement PassWord;

	@FindBy(id = "submit")
	WebElement SignUpSubmitBtn;
	
	@FindBy(xpath  = "//h1[normalize-space()='Contact List']")
	WebElement WelcomeContactList;
	
	@FindBy(xpath = "//span[text()='Email address is already in use']")
	WebElement EmailAlreadyInUse;
	
	@FindBy(xpath = "//span[text()='User validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required., email: Email is invalid, password: Path `password` is required.']")
	WebElement NoUser;
	
	@FindBy(xpath = "//span[text()='User validation failed: email: Email is invalid']")
	WebElement InvalidEmail;
	
	@SuppressWarnings("static-access")
	public SignUpPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public SignUpPage enterFirstName(String Fname) {

		FirstName.sendKeys(Fname);
		return this;
	}

	public SignUpPage enterLastName(String Lname) {
		LastName.sendKeys(Lname);
		return this;
	}

	public SignUpPage enterEmail(String email) {

		Email.sendKeys(email);
		return this;
	}

	public SignUpPage enterPassword(String psw) {
		PassWord.sendKeys(psw);
		return this;
	}

	public ContactListPage clickSignUpSubmitBtn() {
		SignUpSubmitBtn.click();

		return new ContactListPage(driver);
	}
	public void validateSignup(String testType, String expectedMessage) {
		
		if(testType.equals("Valid")) {
			
			String actualText = WelcomeContactList.getText();
			Assert.assertEquals(actualText, expectedMessage);
					
			}else if(testType.equals("Duplicate")){
					
				String actualText = EmailAlreadyInUse.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}else if(testType.equals("No User")){
					
				String actualText = NoUser.getText();
				Assert.assertEquals(actualText, expectedMessage);
				
				}else if(testType.equals("Wrong Format")){
					
				String actualText = InvalidEmail.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}
	}
	
}