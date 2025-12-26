package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtils;

public class HomePage extends WebDriverUtils{

	//Deceleration

	@FindBy(linkText ="Leads")
	private WebElement leadModule;

	@FindBy(linkText ="Organizations")
	private WebElement orgModule;

	@FindBy(linkText ="Contacts")
	private WebElement contactsModule;

	@FindBy(linkText ="Opportunities")
	private WebElement opportunitiesModule;

	@FindBy(linkText ="Products")
	private WebElement productsModule;

	@FindBy(linkText ="Trouble Tickets")
	private WebElement ticketsModule;

	@FindBy(linkText = "More")
	private WebElement more;

	@FindBy(xpath = "//a[@href=\"index.php?module=Vendors&action=index\"]")
	private WebElement vendorsModule;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admstn;

	@FindBy(xpath = "//a[@href=\"index.php?module=Users&action=Logout\"]")
	private WebElement signout;
	//initialization
	public HomePage(WebDriver drver){
		PageFactory.initElements(drver, this);
	}
	//utilization

	public WebElement getLeadModule() {
		return leadModule;
	}

	public WebElement getOrgModule() {
		return orgModule;
	}

	public WebElement getContactsModule() {
		return contactsModule;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}

	public WebElement getProductsModule() {
		return productsModule;
	}

	public WebElement getTicketsModule() {
		return ticketsModule;
	}

	public WebElement getVendorsModule() {
		return vendorsModule;
	}

	public WebElement getMore() {
		return more;
	}
	//business logic

	public void clickOnLeadModule() {
		leadModule.click();
	}
	public void clickOnorgModule() {
		orgModule.click();
	}
	public void clickOnproductsModule() {
		productsModule.click();
	}
	public void clickOncontactsModule() {
		contactsModule.click();
	}
	public void clickOnopportunitiesModule() {
		opportunitiesModule.click();
	}
	
	public void ClickOnCreateTroupleTicketsModule(){
		ticketsModule.click();
	}
	public void ClickOnCreatevendorsModule(){
		more.click();
		vendorsModule.click();
	}
	public void signOut(WebDriver driver) {

		admstn.click();
		signout.click();
	}

}


