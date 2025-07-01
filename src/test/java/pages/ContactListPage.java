package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class ContactListPage extends ProjectSpecificationMethod {
	
	@FindBy(id= "add-contact")
	WebElement ClickAddContactList;
	
	@FindBy(xpath = "//tr[@class='contactTableBodyRow']")
	WebElement ClickContactTable;
	
	@FindBy(id = "logout")
	WebElement ClickLogOutBtn;

	@SuppressWarnings("static-access")
	public ContactListPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public AddContactPage ClickAddContactList() {
		ClickAddContactList.click();
        return new AddContactPage(driver);
    }
	
	public ContactDetailsPage ClickContactTable() {
		ClickContactTable.click();
		return new ContactDetailsPage(driver);
	}
		
	public HomePage ClickLogOut() {
		ClickLogOutBtn.click();
		return new HomePage(driver);
	}


}