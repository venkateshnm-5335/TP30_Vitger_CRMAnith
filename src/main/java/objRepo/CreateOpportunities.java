package objRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtils;

public class CreateOpportunities extends WebDriverUtils {
	@FindBy(name = "potentialname")
	private WebElement OpportunitiName;
	
	@FindBy(xpath = "//input[@id=\"related_to_display\"]/following-sibling::img")
	private WebElement exestingOrg;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;

	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement searchtextField;
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchBtn;
	
	public CreateOpportunities(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getExestingOrg() {
		return exestingOrg;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOpportunitiName() {
		return OpportunitiName;
	}
	
	public WebElement getSearchtextField() {
		return searchtextField;
	}
	
	public void creteOpportunitiesWithExestingOrg(WebDriver driver, String opName,String exOrg) {
		
		OpportunitiName.sendKeys(opName);
	
		String pTitle = driver.getWindowHandle();
		exestingOrg.click();
		switchToChildWindow(driver,"Accounts&action");
		searchtextField.sendKeys(exOrg);
		searchBtn.click();
		waitUntilEleToBeVisible(driver, 15, driver.findElement(By.xpath("//a[.='"+exOrg+"']")));
		driver.findElement(By.xpath("//a[.='"+exOrg+"']")).click();
		switchToParentWindow(driver, pTitle);
		save.click();
		
		
//		exestingOrg.click();
//		switchToChildWindow(driver, Ctitle);
//		searchtextField.sendKeys(exOrg);
//		searchBtn.click();
//		waitUntilEleToBeVisible(driver, 15, driver.findElement(By.xpath("//a[.='"+exOrg+"']")));
//		driver.findElement(By.xpath("//a[.='"+exOrg+"']")).click();
//		switchToParentWindow(driver, pTitle);
//		save.click();
		

		
		
		
		
		
		
		
		
		
		
		
	}
	
}

