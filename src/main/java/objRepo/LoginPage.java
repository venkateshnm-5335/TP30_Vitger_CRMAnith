package objRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Decleration
	@FindBy(name ="user_name")
	private WebElement username;
	
	@FindBy(name = "user_password")
	private WebElement pwd;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	//initialization
	public LoginPage(WebDriver drver){
		PageFactory.initElements(drver, this);
	}
	//utilization
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getSubmitButton() {
		return loginButton;
	}
	//business logic
	
	public void login(String USERNAME,String PASSWORD) {
		username.clear();
		username.sendKeys(USERNAME);
		pwd.clear();
		pwd.sendKeys(PASSWORD);
		loginButton.click();
	}

}
