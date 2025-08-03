package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BookingPage {

	public WebDriver driver;
	
	
	public BookingPage(){}
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver , this);
	}
	
	@FindBy(id="firstName")
	public WebElement firstNameElmt;
	
	@FindBy(id="lastName")
	public WebElement lastNameElmt;
	
	@FindBy(id="phoneNo")
	public WebElement phoneNoElmt;
	
	@FindBy(id="emaiId")
	public WebElement emaiIdElmt;
	
	@FindBy(id="eventType")
	public WebElement eventTypeElmt;
	
	@FindBy(id="eventDate")
	public WebElement eventDateElmt;
	
	@FindBy(id="eventTime")
	public WebElement eventTimeElmt;
	
	@FindBy(id="guestCount")
	public WebElement guestCountElmt;
	
	@FindBy(id="vegFood")
	public WebElement vegFoodElmt;
	
	@FindBy(id="nonVegFood")
	public WebElement nonVegFoodElmt;
	
	@FindBy(id="address")
	public WebElement addressElmt;
	
	@FindBy(id="city")
	public WebElement cityElmt;
	
	@FindBy(id="pincode")
	public WebElement pincodeElmt;
	
	@FindBy(id="book-now")
	public WebElement bookNowElmt;
	//err elements
	@FindBy(id="fnameErr")
	public WebElement fnameErrElmt;
	
	@FindBy(id="lnameErr")
	public WebElement lnameErrElmt;
	
	@FindBy(id="phoneErr")
	public WebElement phoneErrElmt;
	
	@FindBy(id="emailErr")
	public WebElement emailErrElmt;
	
	@FindBy(id="eventTypeErr")
	public WebElement eventTypeErrElmt;
	
	@FindBy(id="eventDateErr")
	public WebElement eventDateErrElmt;
	
	@FindBy(id="eventTimeErr")
	public WebElement eventTimeErrElmt;
	
	@FindBy(id="guestCountErr")
	public WebElement guestCountErrElmt;
	
	@FindBy(id="radioBtnErr")
	public WebElement radioBtnErrElmt;
	
	@FindBy(id="addressErr")
	public WebElement addressErrElmt;
	
	@FindBy(id="cityErr")
	public WebElement cityErrElmt;
	
	@FindBy(id="pincodeErr")
	public WebElement pincodeErrElmt;
	
	@FindBy(id="bookingconfirm")
	public WebElement bookingconfirmElmt;
	
	public void setFirstName(String firstName)
	{	firstNameElmt.clear();
		firstNameElmt.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		lastNameElmt.clear();
		lastNameElmt.sendKeys(lastName);
	}
	
	public void setphoneNo(String phoneNo)
	{
		phoneNoElmt.clear();
		phoneNoElmt.sendKeys(phoneNo);
	}
	
	public void setemaiId(String emaiId)
	{
		emaiIdElmt.clear();
		emaiIdElmt.sendKeys(emaiId);
	}
	
	public void seteventType(String eventType)
	{
		Select s = new Select(eventTypeElmt);
		if (eventType != null && !eventType.trim().isEmpty()) {
	        s.selectByVisibleText(eventType);
	    }
	}
	
	public void seteventDate(String eventDate)
	{
		eventDateElmt.clear();
		eventDateElmt.sendKeys(eventDate);
	}
	
	public void seteventTime(String eventTime)
	{
		eventTimeElmt.clear();
		eventTimeElmt.sendKeys(eventTime);
	}
	
	public void setguestCount(String guestCount)
	{
		guestCountElmt.clear();
		guestCountElmt.sendKeys(guestCount);
	}
	
	public void setradiobutton(String radiobutton)
	{
		if(radiobutton.equalsIgnoreCase("Vegetarian"))
			vegFoodElmt.click();
		else if(radiobutton.equalsIgnoreCase("NonVegetarian"))
			nonVegFoodElmt.click();
	}
	
	public void setAddress(String address)
	{
		addressElmt.clear();
		addressElmt.sendKeys(address);
	}
	
	public void setCity(String city)
	{
		Select s = new Select(cityElmt);
		if (city != null && !city.trim().isEmpty()) {
	        s.selectByVisibleText(city);
	    }
	}
	
	public void setpincode(String pincode)
	{
		pincodeElmt.clear();
		pincodeElmt.sendKeys(pincode);
	}
	
	public void clickbookNowBtn()
	{
		bookNowElmt.click();
	}
	
	public String bookingconfirmMsg()
	{
		return bookingconfirmElmt.getText();
	}
	
	public boolean successMsgDisplayed()
	{
		return bookingconfirmElmt.isDisplayed();
	}
	
	public String getfnameErr()
	{
		 return fnameErrElmt.getText();
	}
	
	public String getlnameErr()
	{
		 return lnameErrElmt.getText();
	}
	
	public String getphoneErr()
	{
		 return phoneErrElmt.getText();
	}
	
	public String getemailErr()
	{
		 return emailErrElmt.getText();
	}
	
	public String geteventTypeErr()
	{
		 return eventTypeErrElmt.getText();
	}
	
	public String geteventDateErr()
	{
		 return eventDateErrElmt.getText();
	}
	
	public String geteventTimeErr()
	{
		 return eventTimeErrElmt.getText();
	}
	
	public String getguestCountErr()
	{
		 return guestCountErrElmt.getText();
	}
	
	public String getradioBtnErr()
	{
		 return radioBtnErrElmt.getText();
	}
	
	public String getaddressErr()
	{
		 return addressErrElmt.getText();
	}
	
	public String getCityErr()
	{
		 return cityErrElmt.getText();
	}
	
	public String getpincodeErr()
	{
		 return pincodeErrElmt.getText();
	}

	
}
