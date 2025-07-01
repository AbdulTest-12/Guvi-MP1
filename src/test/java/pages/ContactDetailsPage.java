package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class ContactDetailsPage extends ProjectSpecificationMethod{
	
	@FindBy(id= "edit-contact")
	WebElement ClickEditContactBtn;
	
	@FindBy(id = "delete")
	WebElement ClickDeleteContactBtn;
	
	@FindBy(id = "return")
	WebElement ClickReturnBtn;
	
	@FindBy(xpath = "//label[normalize-space()='Email:']")
	WebElement EmailInCD;
	
	@FindBy(xpath = "//label[normalize-space()='Phone:']")
	WebElement PhnInCD;
	
	@SuppressWarnings("static-access")
	public ContactDetailsPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	public EditContactDetailsPage ClickEdit() {
		ClickEditContactBtn.click();
		return new EditContactDetailsPage(driver);
	}
	public ContactListPage ClickDelete() {
		ClickDeleteContactBtn.click();
		return new ContactListPage(driver);
		
	}
	public ContactListPage ClickReturn() {
		ClickReturnBtn.click();
		return new ContactListPage(driver);
	}
	public EditContactDetailsPage clickEdit() {
		ClickEditContactBtn.click();
		return new EditContactDetailsPage(driver);
		
	}
	
	public  boolean isContactdeleted(String Products) {
        return driver.getPageSource().contains(Products);
    }

}
