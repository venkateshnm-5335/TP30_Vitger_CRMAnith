package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtils;

public class CreateOrganization extends WebDriverUtils{
	
	@FindBy(name = "accountname")
	private WebElement OrgName;
	
	@FindBy(name="industry")
	private WebElement indDdown;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;
	
	public CreateOrganization(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterOnlyMandatoryFields(String org) {
		OrgName.sendKeys(org);
		save.click();
	}
	
	public void enterMandatoryFieldswithIndustry(String org, String ind)
	{
		OrgName.sendKeys(org);
		
		dropdownUsingVisibletext(indDdown, ind);
		
		save.click();
	}
	
}
