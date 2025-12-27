package testScripts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import objRepo.CreateTroubleTickets;
import objRepo.HomePage;
import objRepo.TroubleTickets;

public class CreateTroubleTickets6 extends BaseClass{
	@Test(dependsOnGroups = "smoke")
	public void createTicketTest() throws Exception {
		//read data from excel file
		String ttitle = eLib.ReadDataFromExcel("Trouble", 1, 1)+jLib.getrandomNo();
		HomePage hP = new HomePage(driver);
		hP.ClickOnCreateTroupleTicketsModule();
		TroubleTickets tickets2 = new TroubleTickets(driver);
		tickets2.clickOnCreateTroubleTickets();
		CreateTroubleTickets tickets = new CreateTroubleTickets(driver);
		tickets.enterMandatoryField(ttitle);
		String text2 = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		assertTrue(text2.contains(ttitle));
	}
}
