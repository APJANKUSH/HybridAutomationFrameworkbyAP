package framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage {

	WebDriver ldriver;

	public RegistrationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(new AjaxElementLocatorFactory(rdriver, 15), this);
	}
	
	   @FindBy(xpath = "//label[normalize-space()='Mr.']")
	    WebElement titleMr;

	    // Title - Mrs.
	    @FindBy(xpath = "//label[normalize-space()='Mrs.']")
	    WebElement titleMrs;

	    // Name input
//	    @FindBy(xpath = "//input[@id='name']")
//	    WebElement nameField;
//
//	    // Email input
//	    @FindBy(xpath = "//input[@id='email']")
//	    WebElement emailField;

	    // Password input
	    @FindBy(xpath = "//input[@id='password']")
	    WebElement passwordField;

	    // Date of Birth dropdowns
	    @FindBy(xpath = "//select[@id='days']")
	    WebElement dayDropdown;

	    @FindBy(xpath = "//select[@id='months']")
	    WebElement monthDropdown;

	    @FindBy(xpath = "//select[@id='years']")
	    WebElement yearDropdown;

	    // Newsletter checkbox
	    @FindBy(xpath = "//input[@id='newsletter']")
	    WebElement newsletterCheckbox;

	    // Offers checkbox
	    @FindBy(xpath = "//input[@id='optin']")
	    WebElement offersCheckbox;
	    
	    
	    
	    @FindBy(xpath = "//input[@id='first_name']")
	    WebElement firstname;
	    
	    @FindBy(xpath = "//input[@id='last_name']")
	    WebElement lastname;
	    
	    @FindBy(xpath = "//input[@id='company']")
	    WebElement company;
	    
	    @FindBy(xpath = "//input[@id='address1']")
	    WebElement address1;
	    
	    @FindBy(xpath = "//input[@id='address2']")
	    WebElement address2;
	    
	    @FindBy(xpath = "//select[@id='country']")
	    WebElement country;
	    
	    @FindBy(xpath = "//input[@id='state']")
	    WebElement state;
	    
	    @FindBy(xpath = "//input[@id='city']")
	    WebElement city;
	    
	    @FindBy(xpath = "//input[@id='zipcode']")
	    WebElement zipcode;
	    
	    @FindBy(xpath = "//input[@id='mobile_number']")
	    WebElement mobilenumber;
	    
	    
	    @FindBy(xpath = " //button[normalize-space()='Create Account']")
	    WebElement clickToCreateAcc;
	 
	    @FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
	    WebElement welcomeMsg;
	    
	    @FindBy(xpath = "//a[normalize-space()='Continue']")
	    WebElement continuebutton; 
//	    
	    
	    
	    public void selectTitleMr() {
	        titleMr.click();
	    }

//	    public void enterName(String name) {
//	        nameField.clear();
//	        nameField.sendKeys(name);
//	    }
//
//	    public void enterEmail(String email) {
//	        emailField.clear();
//	        emailField.sendKeys(email);
//	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void selectDOB(String day, String month, String year) {
	        new Select(dayDropdown).selectByVisibleText(day);
	        new Select(monthDropdown).selectByVisibleText(month);
	        new Select(yearDropdown).selectByVisibleText(year);
	    }

	    public void checkNewsletter() {
	        if (!newsletterCheckbox.isSelected()) {
	            newsletterCheckbox.click();
	        }
	    }

	    public void checkOffers() {
	        if (!offersCheckbox.isSelected()) {
	            offersCheckbox.click();
	        }
	    }
	    
	    
	    public void scrollByPixels(int pixels) {
	        JavascriptExecutor js = (JavascriptExecutor) ldriver;
	        js.executeScript("window.scrollBy(0," + pixels + ")");
	    }
	    
	    
	    
	    
		public void enterFirstName(String fname) {

			firstname.sendKeys(fname);
		}

		public void enterLastName(String lname) {

			lastname.sendKeys(lname);
		}
       
		public void enterCompaName(String cmp) {
			company.sendKeys(cmp);
		}
		
		public void enterAddress1(String add1) {
			address1.sendKeys(add1);
		}
		
		public void enterAddress2(String add2) {
			address2.sendKeys(add2);
		}
		
		public void selectCountry(String ctry) {
			new Select(country).selectByVisibleText(ctry);
		}
	    
		public void enterState(String st) {
			state.sendKeys(st);
		}
		
		public void enterCity(String ct) {
			city.sendKeys(ct);
		}
		
		public void enterZipCode(String zp) {
			zipcode.sendKeys(zp);
		}
		
		public void enterMobilenumber(String mbn) {
			mobilenumber.sendKeys(mbn);
		}
		
		public void clickOnCreateAccount() {
			clickToCreateAcc.click();
		}
		
		public String getWelcomeMessage() {
		    return welcomeMsg.getText().trim();  
		}
		
		public void clickOnContinuebutton() {
			continuebutton.click();
		}
		
}
