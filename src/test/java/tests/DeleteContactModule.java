package tests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.ContactDetailsPage;
import pages.ContactListPage;
import pages.HomePage;


public class DeleteContactModule extends ProjectSpecificationMethod{
	@BeforeTest
	public void setup() throws IOException{
		
		readAndWritePropFile();
		testName = "Delete Contact Test";
		testDescription = "Testing the Delete Contact functionality of the application with valid and invalid details";
		testAuthor ="Abdul Nazeer";
		testCategory = "Smoke Testing";
		
	}
	@Test(priority = 1)
	public  void DeleteContactAlert() throws InterruptedException {

		HomePage login = new HomePage(driver);
		login.LoginEmail(prop.getProperty("useremail"))
		.LoginPassWord(prop.getProperty("password"))
		.LoginSubmitBtn();

		ContactListPage viewcontact = new ContactListPage(driver);
		viewcontact.ClickContactTable();

		ContactDetailsPage delete = new ContactDetailsPage(driver);
		delete.ClickDelete();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();

		Assert.assertTrue(alertText.contains("Are you sure you want to delete this contact?"));
	}

	@Test(priority = 2)
	public  void DeleteContact() throws InterruptedException {

		HomePage login = new HomePage(driver);
		login.LoginEmail(prop.getProperty("useremail"))
		.LoginPassWord(prop.getProperty("password"))
		.LoginSubmitBtn();

		Dimension contacttable = driver.findElement(By.id("myTable")).getSize();

		ContactListPage viewcontact = new ContactListPage(driver);
		viewcontact.ClickContactTable();


		driver.findElement(By.xpath("//button[@id='delete']")).click();


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());        
		Alert alert = driver.switchTo().alert();
		alert.accept();


		Dimension table = driver.findElement(By.id("myTable")).getSize();
		Assert.assertNotEquals(contacttable, table);

	}

}
