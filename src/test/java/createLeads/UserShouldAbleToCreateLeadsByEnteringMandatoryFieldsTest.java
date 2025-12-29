package createLeads;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import objRepo.CreateLeads;
import objRepo.HomePage;
import objRepo.Leads;

public class UserShouldAbleToCreateLeadsByEnteringMandatoryFieldsTest extends BaseClass{
	@Test
	public void userShouldAbleToCreateLeadsByEnteringMandatoryFieldsTest() throws Exception {

		//read data from excel file
		String ls = eLib.ReadDataFromExcel("Leads", 4, 0)+jLib.getrandomNo();
		String company = eLib.ReadDataFromExcel("Leads",4, 1);

		HomePage hPage = new HomePage(driver);
		hPage.clickOnLeadModule();
		
		Leads leads = new Leads(driver);
		leads.getListOfLeadNames();
		wLib.waitForPageLoad(driver, 15);
		
		leads.clickOnCreateLead();
		
		CreateLeads creatLead = new CreateLeads(driver);
		creatLead.entermandatoryFields(ls,company);
		
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(text);
		
		assertTrue(text.contains(ls));
		
//		InfoPage validation = new InfoPage(driver);
//		validation.getValidation(driver, ls);
//Leads.venkatesh
		
	}

}
