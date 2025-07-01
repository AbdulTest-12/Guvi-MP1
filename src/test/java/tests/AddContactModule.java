package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.AddContactPage;
import pages.ContactListPage;
import pages.HomePage;

public class AddContactModule extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		
		sheetname = "AddContact";
		testName = "Add Contact Test";
		testDescription = "Testing the Add Contact functionality of the application with valid and invalid details";
		testAuthor = "Abdul Nazeer";
		testCategory = "Smoke Testing";
	}
	
	@Test(dataProvider = "readData", priority = 1)
	public  void AddModule(String email, String password, String firstname, String lastname, 
			String dob, String addemail, String phn, String add1, String add2, 
			String city, String state, String postal, String country, String testType, String expectedMessage) {
		HomePage login = new HomePage(driver);
		login.LoginEmail(email);
		login.LoginPassWord(password);
		login.LoginSubmitBtn();
		
		ContactListPage addnewcontact = new ContactListPage(driver);
		addnewcontact.ClickAddContactList();
		
		AddContactPage addInfo = new AddContactPage(driver);
		addInfo.AddFirstName(firstname)
		.AddLastName(lastname)
		.AddDOB(dob)
		.AddEmail(addemail)
		.AddPhnNumber(phn)
		.AddStreet1(add1)
		.AddStreet2(add2)
		.AddCity(city)
		.AddState(state)
		.AddPostalCode(postal)
		.AddCountry(country)
		.ClickSubmitBtn();
		
		addInfo.validateAddConatct(testType, expectedMessage);

	}

}
