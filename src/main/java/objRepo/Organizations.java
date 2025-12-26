package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")
	private WebElement createOrgLookup;

	
	public Organizations(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateOrgLookup() {
		return createOrgLookup;
	}
	public void clickOnCreateOrganizations()
	{
		createOrgLookup.click();
	}

}
