package framework.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.base.BaseTest;




public class HomePage extends BaseTest {
	WebDriver ldriver;

	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
//		PageFactory.initElements(new AjaxElementLocatorFactory(rdriver, 15), this);
		PageFactory.initElements(driver, this);
	}
	
	
	// Sign Up Page :
	
	@FindBy(xpath="//a[@href='/login']")
	@CacheLookup
	WebElement clickOnLink;
	
	
    
	@FindBy(xpath="//input[@placeholder='Name']")
	@CacheLookup
	WebElement enterUserName;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	@CacheLookup
	WebElement enterUserEmail;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	@CacheLookup
	WebElement signUp;
	
	@FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
	@CacheLookup
	WebElement welcomeMsg;
	
	//--------------------------------------------------------------------------
	
	
	
	// Sign In Page :
	@FindBy(xpath = "//input[@data-qa='login-email']")
	@CacheLookup
	WebElement loginEmail;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	@CacheLookup
	WebElement loginPassword;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	@CacheLookup
	WebElement clickLogin;
	//--------------------------------------------------------------------------
	
	// Sign Out Page :
	
	@FindBy(xpath = "//a[@href='/logout' and contains(text(),'Logout')]")
	@CacheLookup
	WebElement clickLogout;
	
	
	//--------------------------------------------------------------------------

	
	
	

	
	// Sign Up Page Script :
	
	public void clickOnSignupAndLogin()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clickOnLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));

		clickOnLink.click();
	}
	
	public void setUserName(String name)
	{
		enterUserName.sendKeys(name);
	}
	public void setUserEmail(String email)
	{
		enterUserEmail.sendKeys(email);
	}
	public void clickOnSignup()
	{
		signUp.click();
	}
	
	public String getWelcomeMessage() {
	    return welcomeMsg.getText().trim();  
	}
	//--------------------------------------------------------------------------

	
	
	// Sign in Page Script :
	
	public void setLoginEmail(String email)
	{
		loginEmail.sendKeys(email);
	}
	
	public void setLoginPassword(String password)
	{
		loginPassword.sendKeys(password);
	}
	
	public void clickOnSignIn()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clickLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='login-button']")));
		clickLogin.click();
	}
	
	//--------------------------------------------------------------------------
	
	
  
	// Sign out Page Script :
	public void clickOnSignout()
	{
		clickLogout.click();
	}
	   
	//--------------------------------------------------------------------------

	
	
}
