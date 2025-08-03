package stepdefinitions;

import java.io.File;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.BookingPage;
import setup.ConfigReader;
import setup.DriverSetup;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.ExcelReader;

public class BookingSteps 
{
	public static WebDriver driver;
	public static BookingPage bookObj;
	public static final Logger logger = LogManager.getLogger(BookingSteps.class);
			
	public BookingSteps() {}
	
	@Given("start the chrome browser")
	public void start_the_chrome_browser() {
		driver = DriverSetup.getDriver();
		bookObj = new BookingPage(driver);
		logger.info("Current Working Directory: " + new File("").getAbsolutePath());
		logger.info("Starting Chrome Browser....");
	}
	
	@And("navigate to Booking page")
	public void navigate_to_booking_page() {
		ConfigReader reader = new ConfigReader();
		driver.get(reader.getBookingUrl());		
		driver.manage().window().maximize();
		//driver.get("https://webapps.tekstac.com/SeleniumApp1/EventManagement/index.html");
		logger.info("Navigating to Booking Page....");
	}
	
	@When("enter all fields blank")
	public void enter_all_fields_blank()
	{
		bookObj.setFirstName("");
		bookObj.setLastName("");
		bookObj.setphoneNo("");
		bookObj.setemaiId("");
		bookObj.seteventType("Select Event"); // logger.info();
		bookObj.seteventDate("");
		bookObj.seteventTime("");
		bookObj.setguestCount("");
		bookObj.setradiobutton("");
		bookObj.setAddress("");
		bookObj.setCity("");
		bookObj.setpincode("");
		logger.info("Entered all fields blank....");
		
	}
	
	@And("click on book now button")
	public void click_on_book_now_button()
	{
		bookObj.clickbookNowBtn();
		logger.info("Click book now button");
	}
	
	@Then("it should display error message below all fields")
	public void it_should_display_error_message_below_all_fields()
	{
		String fnameErr = bookObj.getfnameErr();
		String lnameErr = bookObj.getlnameErr();
		String phoneErr = bookObj.getphoneErr();
		String emailErr = bookObj.getemailErr();
		String eventTypeErr = bookObj.geteventTypeErr();
		String eventDateErr = bookObj.geteventDateErr();
		String eventTimeErr = bookObj.geteventTimeErr();
		String guestCountErr = bookObj.getguestCountErr();
		String radiobuttonErr = bookObj.getradioBtnErr();
		String addressErr = bookObj.getaddressErr();
		String cityErr = bookObj.getCityErr();
		String pincodeErr = bookObj.getpincodeErr();
		
		Assert.assertEquals(fnameErr , "Your first name is required");
		Assert.assertEquals(lnameErr , "Your last name is required");
		Assert.assertEquals(phoneErr , "Your phone number is required");
		Assert.assertEquals(emailErr , "Your email id is required");
		Assert.assertEquals(eventTypeErr , "Your event type is required");
		Assert.assertEquals(eventDateErr , "Your event date is required");
		Assert.assertEquals(eventTimeErr , "Your event time is required");
		Assert.assertEquals(guestCountErr , "Your guest count is required");
		Assert.assertEquals(radiobuttonErr , "Your catering option is required");
		Assert.assertEquals(addressErr , "Your address is required");
		Assert.assertEquals(cityErr , "Your city is required");
		Assert.assertEquals(pincodeErr , "Your pincode is required"); 
		
		logger.info("Error message displayed below all fields....");
		
	}
	
	@When("enter valid details in all fields and invalid email")
	public void enter_valid_details_in_all_fields_and_invalid_email() 
	{
		String[] data = ExcelReader.readExcelFile("src/test/resources/testData/bookingData.xlsx", "Sheet1");
		bookObj.setFirstName(data[0]);
		bookObj.setLastName(data[1]);
		bookObj.setphoneNo(data[2]);
		bookObj.setemaiId(data[3]);
		bookObj.seteventType(data[4]);
		bookObj.seteventDate("05/04/2025");
		bookObj.seteventTime("5:50");
		bookObj.setguestCount(data[7]);
		bookObj.setradiobutton(data[8]);
		bookObj.setAddress(data[9]);
		bookObj.setCity(data[10]);
		bookObj.setpincode(data[11]);
		
		logger.info("Entered valid details in all fields with invalid email....");
	}
	
	@Then("should display invalid email error message")
	public void should_display_invalid_email_error_message()
	{
		logger.error("No error message displayed for invalid email....");
		Assert.assertFalse(bookObj.successMsgDisplayed() ,"Expected error message for invalid email in bookingPage, but none was displayed.");
	}
	
	@Then("should display success message")
	public void should_display_success_message() 
	{
		Assert.assertEquals(bookObj.bookingconfirmMsg(), "Your Booking has been Confirmed !");	
		logger.info("Success message shown when valid details are entered....");
	}
	
	@When("enter valid details in all fields and non numeric phone number")
	public void enter_valid_details_in_all_fields_and_non_numeric_phone_number() 
	{
		String[] data = ExcelReader.readExcelFile("src/test/resources/testData/bookingData.xlsx", "Sheet2");
		bookObj.setFirstName(data[0]);
		bookObj.setLastName(data[1]);
		bookObj.setphoneNo(data[2]);
		bookObj.setemaiId(data[3]);
		bookObj.seteventType(data[4]);
		bookObj.seteventDate("05/04/2025");
		bookObj.seteventTime("5:50");
		bookObj.setguestCount(data[7]);
		bookObj.setradiobutton(data[8]);
		bookObj.setAddress(data[9]);
		bookObj.setCity(data[10]);
		bookObj.setpincode(data[11]);
		
		logger.info("Entered valid details in all fields with non-numeric phoneno....");
	}
	
	@Then("should display invalid phoneno error message")
	public void should_display_invalid_phoneno_error_message()
	{
		logger.error("No error message displayed for non-numeric phoneno....");
		Assert.assertFalse(bookObj.successMsgDisplayed() ,"Expected error message for non-numeric phone no, but none was displayed.");
		
	}
	
	@When("enter all valid details to book")
	public void enter_all_valid_details_to_book() 
	{
		String[] data = ExcelReader.readExcelFile("src/test/resources/testData/bookingData.xlsx", "Sheet3");
		bookObj.setFirstName(data[0]);
		bookObj.setLastName(data[1]);
		bookObj.setphoneNo(data[2]);
		bookObj.setemaiId(data[3]);
		bookObj.seteventType(data[4]);
		bookObj.seteventDate(data[5]);
		bookObj.seteventTime(data[6]);
		bookObj.setguestCount(data[7]);
		bookObj.setradiobutton(data[8]);
		bookObj.setAddress(data[9]);
		bookObj.setCity(data[10]);
		bookObj.setpincode(data[11]);
		
		logger.info("Entered valid details in all fields....");
	}
}
