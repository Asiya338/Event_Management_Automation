package stepdefinitions;

import utils.WaitUtils;
import utils.ExcelReader;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.ContactUsPage;
import setup.DriverSetup;
import setup.ConfigReader;
import org.testng.Assert;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContactUsSteps {

	public static WebDriver driver;
	public static ContactUsPage contactObj;
	public static final Logger logger = LogManager.getLogger(ContactUsSteps.class);
	
	public ContactUsSteps() {}
	
	@Given("start chrome browser")
	public void start_chrome_browser()
	{
		driver = DriverSetup.getDriver();
		contactObj = new ContactUsPage(driver);
		logger.info("Current Working Directory: " + new File("").getAbsolutePath());
		logger.info("Starting chrome browser....");
	}
	
	@And("navigate to ContactUs page")
	public void navigate_to_ContactUs_page()
	{
		ConfigReader reader = new ConfigReader();
		driver.get(reader.getContactUsUrl());
		driver.manage().window().maximize();
		logger.info("Navigate to ContactUs page....");
	}
	
	@When("enter all valid details and invalid email")
	public void enter_all_valid_details_and_invalid_email() 
	{
		String[] datatable = ExcelReader.readExcelFile("src/test/resources/testdata/contactData.xlsx", "Sheet1");
		
		contactObj.setcontactName(datatable[0]);
		contactObj.setcontactEmail(datatable[1]);
		contactObj.setcontactSubject(datatable[2]);
		contactObj.setcontactMsg(datatable[3]);
		
		logger.info("Enter all valid details and invalid email by reading Excel file....");
	}
	
	@And("click on send message button")
	public void click_on_send_message_button() {//logger.info("");
		contactObj.clickMessageBtn();
		logger.info("Clicked on send message button....");
	}
	
	@Then("it should display success message")
	public void it_should_display_success_message() 
	{
		WaitUtils.waitForThreeSeconds(driver, "mesgtab");
		contactObj.getsuccessMsg();
		logger.info("Success Message is displayed after 3 seconds....");
	}
	
	@Then("it should display invalid email error message")
	public void it_should_display_invalid_email_error_message()
	{
		logger.error("No error message displayed for invalid email....");
		Assert.assertFalse( contactObj.successMsgDisplayed(), "Expected error message for invalid email in contactUs, but none was displayed.");
	}
	
	@When("enter all valid details")
	public void enter_all_valid_details()
	{
		String[] datatable = ExcelReader.readExcelFile("src/test/resources/testdata/contactData.xlsx", "Sheet2");
		
		/*contactObj.setcontactName(datatable[0]);
		contactObj.setcontactEmail(datatable[1]);
		contactObj.setcontactSubject(datatable[2]);
		contactObj.setcontactMsg(datatable[3]);*/
		
		contactObj.setcontactName("Asiya");
		contactObj.setcontactEmail("asiyaShaik@gmail.com");
		contactObj.setcontactSubject("Birthday Event");
		contactObj.setcontactMsg("Organize Birthday Event");
		
		logger.info("Entered all valid details....");
		
	}
	
}
