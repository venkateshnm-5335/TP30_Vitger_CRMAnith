package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendor {
	@FindBy(name = "vendorname")
	private WebElement vendorname;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;
	
	public CreateVendor(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorname() {
		return vendorname;
	}

	public WebElement getSave() {
		return save;
	
	}
	
	public void enterVenderNameAndSave(String vName) {
		vendorname.sendKeys(vName);
		save.click();
	}
	
}
