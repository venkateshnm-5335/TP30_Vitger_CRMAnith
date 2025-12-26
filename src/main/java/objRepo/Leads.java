package objRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leads {
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createLeadLookup;
	@FindBy(xpath = "//table[@class=\"lvt small\"]//tr[@class=\"lvtColData\"]/td/span[@vtfieldname=\"lastname\"]/preceding-sibling::a")
	private List<WebElement> listOfleads;
	public Leads(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateLead() {
		return createLeadLookup;
	}
	public List<WebElement> getListOfleads() {
		return listOfleads;
	}
	public void clickOnCreateLead()
	{
		createLeadLookup.click();
	}
	public void getListOfLeadNames() {
		for(WebElement leadNames : listOfleads)
		{
			System.out.println(leadNames.getText());
		}
	}

}
