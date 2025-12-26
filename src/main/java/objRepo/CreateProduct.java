package objRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtils;

public class CreateProduct extends WebDriverUtils{
	@FindBy(name = "productname")
	private WebElement ProdName;
	
	@FindBy(xpath ="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement vendorName;
	
	@FindBy(xpath = "//select[@name=\"productcategory\"]")
	private WebElement prdctgry;
	
	@FindBy(name="search_text")
	private WebElement seacrhText;
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;
	
	public CreateProduct(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getProdName() {
		return ProdName;
	}

	public WebElement getPrdctgry() {
		return prdctgry;
	}

	public WebElement getVendorName() {
		return vendorName;
	}
	

	public WebElement getSeacrhText() {
		return seacrhText;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSave() {
		return save;
	}
	public void enterProductdetails(WebDriver driver,String PrdName,String Prdcategory,String cTitle,String pTitle,String extvendor)
	{
		ProdName.sendKeys(PrdName);
		dropdownUsingVisibletext(prdctgry, Prdcategory);
		vendorName.click();
		switchToChildWindow(driver, cTitle);
		seacrhText.sendKeys(extvendor);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+extvendor+"']"));
		switchToParentWindow(driver, pTitle);
		save.click();
	}
}
