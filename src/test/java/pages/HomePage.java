package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod {

	@FindBy(id = "email")
	WebElement LoginEmail;
	
	@FindBy(id = "password")
	WebElement LoginPassword;
	
	@FindBy(id = "submit")
	WebElement LoginSubmitBtn;
	
	@FindBy(id= "signup")
	WebElement SignUpBtn;
	
	@FindBy(xpath = "//h1[normalize-space()='Contact List']")
	WebElement WelcomeMsg;
	
	@FindBy(xpath = "//span[text()='Incorrect username or password']")
	WebElement ErrorMsg;
	
	@SuppressWarnings("static-access")
	public HomePage(WebDriver driver) {
     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage LoginEmail(String email) {
		LoginEmail.sendKeys(email);
		return this;
	}
	
	public HomePage LoginPassWord(String psw) {
		LoginPassword.sendKeys(psw);
		
		return this;
	}
	
	public ContactListPage LoginSubmitBtn() {
		LoginSubmitBtn.click();
		return new ContactListPage(driver);
	}
//	
//	public static String getErrorMsg() {
//		return driver.findElement(By.id("ErrorMsg")).getText();
//	}

	public SignUpPage clickSignUp() {
		SignUpBtn.click();
		return new SignUpPage(driver);

	}
	
	public void validateLogin(String testType, String expectedMessage) {
		
		if(testType.equals("valid")) {
			
			String actualText = WelcomeMsg.getText();
			Assert.assertEquals(actualText, expectedMessage);
					
			}else if(testType.equals("invalid password")){
					
				String actualText = ErrorMsg.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}else if(testType.equals("No User")){
					
				String actualText = ErrorMsg.getText();
				Assert.assertEquals(actualText, expectedMessage);
				
				}else if(testType.equals("invalid email")){
					
				String actualText = ErrorMsg.getText();
				Assert.assertEquals(actualText, expectedMessage);
				}
	}
		
}