package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunities {
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createOpportinutiesLookup;


	public Opportunities(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOpportinutiesLookup() {
		return createOpportinutiesLookup;
	}

	public void clickOnCreateOpportinuties()
	{
		createOpportinutiesLookup.click();

	}
		
}
