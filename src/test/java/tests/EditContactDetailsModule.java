package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.ContactDetailsPage;
import pages.ContactListPage;
import pages.EditContactDetailsPage;
import pages.HomePage;

public class EditContactDetailsModule extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() throws IOException {
		readAndWritePropFile();
		
		testName = "Edit Contact";
		testDescription = "Testing the edit contact  functionality of the application with valid and invalid details";
		testAuthor ="Abdul Nazeer";
		testCategory = "Smoke Testing";

	}

	@Test(priority = 1)
	public void testEditContact() throws InterruptedException {
		// Login
		HomePage login = new HomePage(driver);
		login.LoginEmail(prop.getProperty("useremail"))
		.LoginPassWord(prop.getProperty("password"))
		.LoginSubmitBtn();

		ContactListPage viewcontact = new ContactListPage(driver);
		viewcontact.ClickContactTable();

		ContactDetailsPage Clickedit = new ContactDetailsPage(driver);
		Clickedit.ClickEdit();

		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		Thread.sleep(5000);
		lastname.click();
		lastname.clear();


		WebElement save =  driver.findElement(By.id("submit"));
		save.click();

		Assert.assertEquals(EditContactDetailsPage.getValidationError(), "Validation failed: lastName: Path `lastName` is required.");
	}



	@Test(priority = 2)
	public  void EditingExsitingContact() throws InterruptedException{

		HomePage login = new HomePage(driver);
		login.LoginEmail(prop.getProperty("useremail"))
		.LoginPassWord(prop.getProperty("password"))
		.LoginSubmitBtn();

		ContactListPage viewcontact = new ContactListPage(driver);
		viewcontact.ClickContactTable();

		ContactDetailsPage Clickedit = new ContactDetailsPage(driver);
		Clickedit.ClickEdit();

		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		Thread.sleep(5000);
		email.click();
		email.clear();
		email.sendKeys("redy@gmail.com");

		WebElement phn = driver.findElement(By.xpath("//input[@id='phone']"));
		Thread.sleep(5000);
		phn.click();
		phn.clear();
		phn.sendKeys("9999999992");	

		WebElement save =  driver.findElement(By.id("submit"));
		save.click();

		ContactDetailsPage edit = new ContactDetailsPage(driver);
		edit.clickEdit();

		Assert.assertEquals(EditContactDetailsPage.getEmailFieldValue(),"redy@gmail.com");
		Assert.assertEquals(EditContactDetailsPage.getPhnNumFieldValue(), "9999999992");

	}




	@Test(priority = 3)
	public void VerifiyingCancelEdit() throws InterruptedException {

		HomePage login = new HomePage(driver);
		login.LoginEmail(prop.getProperty("useremail"))
		.LoginPassWord(prop.getProperty("password"))
		.LoginSubmitBtn();

		ContactListPage viewcontact = new ContactListPage(driver);
		viewcontact.ClickContactTable();

		ContactDetailsPage Clickedit = new ContactDetailsPage(driver);
		Clickedit.ClickEdit();

		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		Thread.sleep(2000);
		String originalEmail = email.getText();
		email.click();
		email.clear();
		email.sendKeys("testingvasee@gmail.com");

		WebElement cancel = driver.findElement(By.xpath("//button[@id='cancel']"));		
		cancel.click();

		ContactDetailsPage edit = new ContactDetailsPage(driver);
		edit.ClickEdit();

		Assert.assertEquals(EditContactDetailsPage.getEmailFieldValue(), originalEmail);
	}
}

