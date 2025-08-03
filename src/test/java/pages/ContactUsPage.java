package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage {

	public WebDriver driver;
	
	public ContactUsPage() {};
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(id="contact_name")
	public WebElement contactNameElmt;
	
	@FindBy(id="contact_email")
	public WebElement contactEmailElmt;
	
	@FindBy(id="contact_subject")
	public WebElement contactSubjectElmt;
	
	@FindBy(id="contact_message")
	public WebElement contactMsgElmt;
	
	@FindBy(id="message")
	public WebElement messageBtn;
	
	@FindBy(id="mesgtab")
	public WebElement successMsgElmt;
	
	@FindBy(id="contactEmailErr")
	public WebElement contactEmailErrElmt;
	
	public void setcontactName(String contactName) {
		contactNameElmt.clear();
		contactNameElmt.sendKeys(contactName);
	}
	
	public void setcontactEmail(String contactEmail) {
		contactEmailElmt.clear();
		contactEmailElmt.sendKeys(contactEmail);
	}
	
	public void setcontactSubject(String contactSubject) {
		contactSubjectElmt.clear();
		contactSubjectElmt.sendKeys(contactSubject);
	}
	
	public void setcontactMsg(String contactMsg) {
		contactMsgElmt.clear();
		contactMsgElmt.sendKeys(contactMsg);
	}
	
	public void clickMessageBtn(){
		messageBtn.click();
	}
	
	public String getsuccessMsg(){
		return successMsgElmt.getText();
	}
	
	public boolean successMsgDisplayed(){
		return successMsgElmt.isDisplayed();
	}
	
	public String getcontactEmailErr()
	{
		return contactEmailErrElmt.getText();
	}
}
