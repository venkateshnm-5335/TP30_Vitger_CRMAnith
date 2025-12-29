package createTroubleTickets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericLibraries.ExcelUtils;
import genericLibraries.FileUtils;
import genericLibraries.JavaUtils;
import genericLibraries.WebDriverUtils;

public class CreateTicketTest {
	@Test
	public void createTicketTest() throws Exception {
		//create Obj for Utility Classes
		FileUtils fu = new FileUtils();
		JavaUtils ju = new JavaUtils();
		ExcelUtils eu = new ExcelUtils();
		WebDriverUtils wdu = new WebDriverUtils();

		String BROWSER = fu.readDataFromProprtyFile("browser");
		String URL = fu.readDataFromProprtyFile("url");
		String USERNAME = fu.readDataFromProprtyFile("username");
		String PASSWORD = fu.readDataFromProprtyFile("password");

		//read data from excel file
		String ttitle = eu.ReadDataFromExcel("Trouble", 1, 1)+ju.getrandomNo();

//		Read DataFrom Property
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonDataProperty");
//		Properties pobj = new Properties();
//		pobj.load(fis);
//		String BROWSER = pobj.getProperty("browser");
//		String URL = pobj.getProperty("url");
//		String USERNAME = pobj.getProperty("username");
//		String PASSWORD = pobj.getProperty("password");
//		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\First XLSX Worksheet.xlsx");
//		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet("Trouble");
//		String ticketname = sh.getRow(1).getCell(1).getStringCellValue();
//		int random = new Random().nextInt(300);
//		String ttitle=ticketname+random;
//		Launch the browser
		WebDriver driver=null;

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		//maximize the window
		//driver.manage().window().maximize();
		wdu.maximizeWindow(driver);
		//enter URl
		driver.get(URL);
		//wait for page load
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wdu.waitForPageLoad(driver, 10);
		
		//step1.Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//step2.Click on 'Create Ticket' link
		driver.findElement(By.linkText("Trouble Tickets")).click();
		//step3.Click on create 'Create Ticket' lookup Image
		driver.findElement(By.xpath("//img[@title='Create Ticket...']")).click();
		//step4.Enter mandatory fields with valid data
		driver.findElement(By.xpath("//textarea[@rows=\"2\"]")).sendKeys(ttitle);
		//step5.click on 'Save' button
		driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();
		String text2 = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		System.out.println(text2);
		if(text2.contains(ttitle))
		{
			System.out.println("Trouble Tickets Created sucessfully");
		}
		else
		{
			System.out.println("Trouble Tickets not created ");
		}
		//click on administrator icon
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		//Click on 'sign out' 
		driver.findElement(By.linkText("Sign Out")).click();
		//close the browser
		driver.quit();


	}

}
