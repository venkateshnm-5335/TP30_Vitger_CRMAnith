package genericLibraries;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

import objRepo.HomePage;
import objRepo.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	public DataBaseUtils dlib=new DataBaseUtils();
	public DataBaseUtils dLib=new DataBaseUtils();
	public FileUtils fLib=new FileUtils();
	public ExcelUtils eLib=new ExcelUtils();
	public JavaUtils jLib= new JavaUtils();
	public WebDriverUtils wLib=new WebDriverUtils();

	//@BeforeSuite (groups = {"smoke","regression"})
	@BeforeSuite (alwaysRun = true)
	public void connectToDB() throws SQLException
	{
//		dlib.connectToDb();
		System.out.println("---Connected to DB---");
	}
	
	
	@Parameters("BROWSER")
	@BeforeClass (alwaysRun = true)
	public void launchBrowser(@Optional("chrome")String BROWSER) throws Exception
	{
	//	String BROWSER = fLib.readDataFromProprtyFile("browser");
		String URL = fLib.readDataFromProprtyFile("url");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")){
			
			System.setProperty("webdriver.edge.driver","C:\\Users\\Lenovo\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			
			
			driver = new EdgeDriver();
		}
		sdriver=driver;
		
		//Maximize window
		wLib.maximizeWindow(driver);

		//navigate to Application
		driver.get(URL);

		//wait for page load
		wLib.waitForPageLoad(driver, 12);

		System.out.println("---Browser launched sucessfully---");
	}
	@BeforeMethod (alwaysRun = true)
	public void loginToApplication() throws Exception
	{
		String USERNAME=fLib.readDataFromProprtyFile("username");
		String PASSWORD=fLib.readDataFromProprtyFile("password");

		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("-----Login to the Application-----");
	}
	@AfterMethod (alwaysRun = true)
	public void logOutFromApplication()
	{
		HomePage hp=new HomePage(driver);
		hp.signOut(driver);
		
		System.out.println("---logged Out from Application---");
	}
	@AfterClass (alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("---Browser Closed---");
	}
	//@AfterSuite (groups = {"smoke","regression"})
	@AfterSuite (alwaysRun = true)
	public void disConnectFromDB() throws SQLException
	{
	//	dlib.disconnectDB();
		System.out.println("---Disconnected From DB---");

	}
}
