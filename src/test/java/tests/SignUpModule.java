package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.SignUpPage;

public class SignUpModule extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup() {
		

		sheetname = "Signup";
		
		testName = "SignUp Test";
		testDescription = "Testing the SignUp functionality of the application with valid and invalid details";
		testAuthor ="Abdul Nazeer";
		testCategory = "Smoke Testing";
		
	}
	@Test(dataProvider = "readData")
	public void SignUpTest(String firstName , String lastName, String email , String password, String testType, String expectedMessage) {
			
	    HomePage home = new HomePage(driver);
		SignUpPage signup = home.clickSignUp();
		signup.enterFirstName(firstName);
	    signup.enterLastName(lastName);
		signup.enterEmail(email);
		signup.enterPassword(password);
		signup.clickSignUpSubmitBtn();
		signup.validateSignup(testType, expectedMessage);
	}
	
	}
	
	
	

