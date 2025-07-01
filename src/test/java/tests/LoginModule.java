package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class LoginModule extends ProjectSpecificationMethod{
	
	@BeforeTest
	public void setup() {
		sheetname = "Login";
		
		testName = "Login Test";
		testDescription = "Testing the login functionality of the application with valid and invalid details";
		testAuthor ="Abdul Nazeer";
		testCategory = "Smoke Testing";
	}

	
	@Test
	(dataProvider = "readData", priority = 1)
	public  void Login(String email, String password, String testType, String expectedMessage) {
		// TODO Auto-generated method stub
		
		HomePage login = new HomePage(driver);
		
		login.LoginEmail(email);
		login.LoginPassWord(password);
		login.LoginSubmitBtn();
		login.validateLogin(testType, expectedMessage);			
	}

}
