package genericLibraries;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**This method is used to wait for page load
	 * @author Lenovo
	 * @param driver
	 * @param seconds
	 */
	public void waitForPageLoad(WebDriver driver,int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	/**This method is used to wait for a specific condition 
	 * @author Lenovo
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntilEleToBeVisible(WebDriver driver,int seconds,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to wait Until Element To Be Clickable
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntilEleToBeClickable(WebDriver driver,int seconds,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to handle dropdown
	 * @param element
	 * @return
	 */
	public  Select dropdown(WebElement element) {
		Select sel = new Select(element);
		return sel;
	}
	/**
	 * select the dropDown element by using value
	 * @param element
	 * @param value
	 */
	//select the dropDown element by using value
	public void dropdownUsingValue(WebElement element,String value) {
		dropdown(element).selectByValue(value);
	}
	/**
	 * select the dropDown element by using selectByContainsVisibleText
	 * @param element
	 * @param text
	 */
	//select the dropDown element by using selectByContainsVisibleText
	public void selectByContainsVisibleText(WebElement element,String text)
	{
		dropdown(element).selectByContainsVisibleText(text);
	}
	/**
	 * select the dropDown element by using index
	 * @param element
	 * @param index
	 */
	//select the dropDown element by using index
	public void dropdownUsingIndex(WebElement element,int index) {
		dropdown(element).selectByIndex(index);
		
		
	}
	/**
	 * select the drop down element by using text
	 * @param element
	 * @param text
	 * 
	 */
	//select the drop down element by using visible text
	public void dropdownUsingVisibletext(WebElement element,String text) {
		dropdown(element).selectByVisibleText(text);
	}
	/**
	 * This method is used to perform mouseHover actions
	 * @param driver
	 * @return
	 */

	public Actions actions(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}
	// to moveHover the specific element
	public void mouseHover(WebDriver driver,WebElement element) {
		actions(driver).moveToElement(element).perform();
	}
	/**
	 * to moveHover the specific element and click on element
	 * @param driver
	 * @param element
	 */
	//to moveHover the specific element and click on element
	public void mousehoverandclickonEle(WebDriver driver,WebElement element) {
		actions(driver).moveToElement(element).click(element).perform();
	}
	/**
	 * to drag and drop the elements
	 * @param driver
	 * @param src
	 * @param dst
	 */
	//to drag and drop the elements
	public void DragandDrop(WebDriver driver,WebElement src,WebElement dst) {
		actions(driver).dragAndDrop(src, dst).perform();
	}
	/**
	 * To scroll till the element
	 * @param driver
	 * @param Element
	 */
	//To scroll till the element
	public void ScrollToElement(WebDriver driver,WebElement Element) {
		actions(driver).scrollToElement(Element).perform();
	}
	/**
	 * To scroll by co-ordinates
	 * @param driver
	 * @param x
	 * @param y
	 */
	//To scroll by co-ordinates
	public void co_ordinates(WebDriver driver, int x,int y) {
		actions(driver).scrollByAmount(x,y).perform();
	}
	/**
	 * To perform double click on webPage
	 * @param driver
	 */
	//To perform double click on webPage
	public void DoubleClick(WebDriver driver) {
		actions(driver).doubleClick().perform();
	}
	/**
	 * To perform double click on element
	 * @param driver
	 * @param Element
	 */
	//To perform double click on element
	public void DoubleClickOnElement(WebDriver driver,WebElement Element) {
		actions(driver).doubleClick(Element).perform();
	}
	/**
	 * To perform rightClick on webPage
	 * @param driver
	 */
	//To perform rightClick on webPage
	public void rightClickOnWebpage(WebDriver driver) {
		actions(driver).contextClick().perform();
	}
	/**
	 * To perform rightClick on element
	 * @param driver
	 * @param element
	 */
	//To perform rightClick on element
	public void rightClickonElement(WebDriver driver,WebElement element) {
		actions(driver).contextClick(element).perform();
	}
	/**
	 * To perform Click and hold on element
	 * @param driver
	 * @param Element
	 */
	//To perform Click and hold on element
	public void ClickandHold(WebDriver driver,WebElement Element) {
		actions(driver).clickAndHold(Element).perform();
	}
	/**
	 * To perform Click and Hold,release on element
	 * @param driver
	 * @param Element
	 */
	//To perform Click and Hold,release on element
	public void ClickHoldandRelease(WebDriver driver,WebElement Element) {
		actions(driver).clickAndHold(Element).release().perform();
	}

	/**
	 * This is used to handle windows/Switch between windows
	 * @author Lenovo
	 * @param driver
	 * @param expTitle
	 */

	public void switchToChildWindow(WebDriver driver,String expTitle) {
		String parent=driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext()) 
		{
			String currentWin=it.next();
			String actualTitle=driver.switchTo().window(currentWin).getTitle();
			if(actualTitle.contains(expTitle))
			{
				break;
			}
		}
	}
	/**
	 * To switch parent window
	 * @param driver
	 * 
	 * @param parentID
	 */
	//To switch parent window
	public void switchToParentWindow(WebDriver driver,String parentID) {
		driver.switchTo().window(parentID);
	}


	//frames
	/**
	 * This method is used to switch frames
	 * @author Lenovo
	 * @param driver
	 * @param index
	 */
	//To switch to child frame using index
	public void SwitchTochildFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * To switch to child frame using name
	 * @param driver
	 * @param name
	 */
	//To switch to child frame using name
	public void SwitchTochildFrame(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}
	/**
	 * To switch to child frame using element address
	 * @param driver
	 * @param Element
	 */
	//To switch to child frame using element address
	public void SwitchToChildFrame(WebDriver driver,WebElement Element) {
		driver.switchTo().frame(Element);
	}
	/**
	 * To Switch to parent
	 * @param driver
	 */
	//To Switch to parent
	public void SwitchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * To switch to mainFrame
	 * @param driver
	 */
	//To switch to mainFrame
	public void SwitchTomainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used handle popUps
	 * @param driver
	 */
	//alert popUps

	/**
	 * To accept popUp
	 * @param driver
	 */
	//To accept popUp
	public void acceptAlertpopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * To cancel the popUp
	 * @param driver
	 */
	//To cancel the popUp
	public void cancelAlertpopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * To get text from popUp
	 * @param driver
	 */
	//To get text from popUp
	public void getTextFromAlertpopup(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	/**
	 * To send the values to PopUps
	 * @param driver
	 * @param value
	 */
	//To send the values to PopUps
	public void enterValueIntoAlertpopup(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	//javaScript executor methods
	/**
	 * to create object for JavascriptExecutor
	 * @param driver
	 * @return
	 */
	public JavascriptExecutor javascriptExecuter(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}
	/**
	 * scroll till bottom of page
	 * @param driver
	 */
	//scroll till bottom of page
	public void scrollHeight(WebDriver driver) {
		javascriptExecuter(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * scroll till element
	 * @param driver
	 * @param element
	 */
	//scroll till element
	public void scrollUntillEleIsVisibleUsingJSE(WebDriver driver,WebElement element) {
		javascriptExecuter(driver).executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * click on element
	 * @param driver
	 * @param element
	 */
	//click on element
	public void clickOnElementUsingJSE(WebDriver driver,WebElement element) {
		javascriptExecuter(driver).executeScript("arguments[0].click()",element);
	}
	/**
	 * To pass Sendkeys
	 * @param driver
	 * @param element
	 * @param value
	 */
	//To pass Sendkeys
	public void enterValueIntoTextFieldUsingJSE(WebDriver driver,WebElement element,String value) {
		javascriptExecuter(driver).executeScript("arguments[0].value=arguments[1]",element,value);
	}
	/**
	 * To scroll to element by using co-ordinates
	 * @param driver
	 * @param element
	 * @param value
	 */
	//To scroll to element by using co-ordinates
	public void scrollToEleUsingXYCoOrdinate(WebDriver driver,WebElement element,String value) {
		Point loc=element.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		javascriptExecuter(driver).executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	
}
