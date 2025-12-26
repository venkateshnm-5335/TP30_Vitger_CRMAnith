package objRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtils;

public class CreateContact extends WebDriverUtils{
	@FindBy(name = "lastname")
	private WebElement lName;
	
	@FindBy(name="industry")
	private WebElement indDdown;
	
	@FindBy(xpath = "//input[@name=\"account_id\"]/following-sibling::img")
	private WebElement exestingOrg;
	
	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement searchtextField;
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;
	
	public CreateContact(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getlName() {
		return lName;
	}

	public WebElement getIndDdown() {
		return indDdown;
	}

	public WebElement getExestingOrg() {
		return exestingOrg;
	}

	public WebElement getSearchtextField() {
		return searchtextField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSave() {
		return save;
	}
	public void createContact(String lastname)
	{
		
		lName.sendKeys(lastname);
		save.click();
	}
	
	public void createContact(WebDriver driver, String lastname,String exOrg,String Ctitle,String pTitle) {
		lName.sendKeys(lastname);
		exestingOrg.click();
		switchToChildWindow(driver, Ctitle);
		searchtextField.sendKeys(exOrg);
		searchBtn.click();
		waitUntilEleToBeVisible(driver, 15, driver.findElement(By.xpath("//a[.='"+exOrg+"']")));
		driver.findElement(By.xpath("//a[.='"+exOrg+"']")).click();
		switchToParentWindow(driver, pTitle);
		save.click();
	}
}






