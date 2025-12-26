package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendors {
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createVendorLookup;

	public Vendors(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateVendorLookup() {
		return createVendorLookup;
	}
	public void clickOnCreateVendors()
	{
		createVendorLookup.click();

	}
	
}
