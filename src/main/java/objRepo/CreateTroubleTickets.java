package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTroubleTickets {
	//decleration
	@FindBy(name = "ticket_title")
	private WebElement titleName;
	
	@FindBy(xpath ="//input[@name=\"parent_name\"]/following-sibling::img")
	private WebElement Exstngcontacts;
	
	@FindBy(xpath ="//input[@name=\"search_text\"]")
	private WebElement searchTextfield;
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;
	
	public CreateTroubleTickets(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getTitleName() {
		return titleName;
	}

	public WebElement getExstngcontacts() {
		return Exstngcontacts;
	}

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSave() {
		return save;
	}
	public void enterMandatoryField(String title) {
		
		titleName.sendKeys(title);
		save.click();
		
		
	}
	
	
	
}
