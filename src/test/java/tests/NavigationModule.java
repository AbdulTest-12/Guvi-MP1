package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.ContactListPage;
import pages.HomePage;

public class NavigationModule  extends ProjectSpecificationMethod{

	@BeforeTest
	public void setup() throws IOException {
    
		readAndWritePropFile();
		
		testName = "Navigation Test";
		testDescription = "Testing the Navigation functionality of the application";
		testAuthor ="Abdul Nazeer";
		testCategory = "Smoke Testing";
	}
	@Test(priority = 1)
	public void NavigationTest() throws InterruptedException {

		HomePage login = new HomePage(driver);
		login.LoginEmail(prop.getProperty("useremail"))
		.LoginPassWord(prop.getProperty("password"))
		.LoginSubmitBtn();


		Thread.sleep(2500);	
		Assert.assertTrue(driver.getTitle().contains("My Contacts"));
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-contact']")).isDisplayed());

	}

	@Test(priority = 2)
	public void ActionButtonsVisibility() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='password']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='submit']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='signup']")).isDisplayed());
	}

	@Test(priority = 3)
	public void AddContactNavTest() throws InterruptedException {

		HomePage login = new HomePage(driver);
		login.LoginEmail(prop.getProperty("useremail"))
		.LoginPassWord(prop.getProperty("password"))
		.LoginSubmitBtn();


		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@id='add-contact']")).click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.id("logout")).isDisplayed());
		Assert.assertTrue(driver.getPageSource().contains("Add Contact"));


	}
	
	@Test(priority = 4)
	public void EditContactNavTest() throws InterruptedException {

		HomePage login = new HomePage(driver);
		login.LoginEmail(prop.getProperty("useremail"))
		.LoginPassWord(prop.getProperty("password"))
		.LoginSubmitBtn();		

		ContactListPage viewcontact = new ContactListPage(driver);
		viewcontact.ClickContactTable();
		
		Assert.assertTrue(driver.findElement(By.id("edit-contact")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("delete")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("return")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("logout")).isDisplayed());
		Assert.assertTrue(driver.getPageSource().contains("Contact Details"));
		
		

	}

	@Test(priority = 5)
	public void FontConsistency() throws InterruptedException {

		HomePage login = new HomePage(driver);
		login.LoginEmail(prop.getProperty("useremail"))
		.LoginPassWord(prop.getProperty("password"))
		.LoginSubmitBtn();

		WebElement header = driver.findElement(By.xpath("//img[@src='/img/thinkingTesterLogo.png']"));
		header.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement freshHeader = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//img[@src='/img/thinkingTesterLogo.png']")));

		String fontFamily = freshHeader.getCssValue("fontFamily");

		Assert.assertTrue(fontFamily.toLowerCase().contains("arial"));

	}

	
	@Test(priority = 6)
	public void getPasswordFieldType() {
		@SuppressWarnings("deprecation")
		String fieldType = driver.findElement(By.id("password")).getAttribute("type");
		Assert.assertEquals(fieldType, "password", "Password field is not masked.");

	}
}


