package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeads {
	
	@FindBy(name = "lastname")
	private WebElement lName;
	
	@FindBy(name = "company")
	private WebElement cmpnyName;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;
	
	public CreateLeads(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getlName() {
		return lName;
	}

	public WebElement getCmpnyName() {
		return cmpnyName;
	}

	public WebElement getSave() {
		return save;
	}
	public void enterLastName(String lastnme)
	{
		lName.sendKeys(lastnme);
		save.click();
	}
	public void enterCompanyName(String compname)
	{
		cmpnyName.sendKeys(compname);
		save.click();

	}
	public void entermandatoryFields(String lastnme,String compname)
	{
		lName.sendKeys(lastnme);
		cmpnyName.sendKeys(compname);
		save.click();


	}

}
