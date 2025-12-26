package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import genericLibraries.WebDriverUtils;

public class InfoPage extends WebDriverUtils{
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement Updatedinfo;
	
	public InfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdatedinfo() {
		return Updatedinfo;
	}
	public void getValidation(WebDriver driver,String orgn)
	{
		waitUntilEleToBeVisible(driver, 10, Updatedinfo);
		String text = Updatedinfo.getText();
		
		Assert.assertTrue(text.contains(text));
		
		
		
//		if(text.contains(orgn))
//		{
//			System.out.println("Created sucessfully");
//		}
//		else
//		{
//			System.out.println("NOT created");
//
//		}
		
		
		
	}

}
