package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts{
	@FindBy(xpath = "//img[@title=\"Create Contact...\"]")
	private WebElement ClickOncreateContactLookup;
	
	public Contacts(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLead() {
		return ClickOncreateContactLookup;
	}
	public void clickOnContactsLookup()
	{
		ClickOncreateContactLookup.click();

	}

}
