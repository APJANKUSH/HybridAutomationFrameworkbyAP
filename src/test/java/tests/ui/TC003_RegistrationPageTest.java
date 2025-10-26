package tests.ui;


import java.io.IOException;

import org.testng.*;
import org.testng.Assert;
import org.testng.annotations.Test;



import framework.base.BaseTest;
import framework.pages.RegistrationPage;

public class TC003_RegistrationPageTest extends BaseTest {
	
	public static RegistrationPage rp;
	public static TC001_HomePageTest thp;
	
//	@Test
	public void registrationPageTest() throws IOException 
	{
	  	
		
		  thp = new TC001_HomePageTest();
		  thp.userSignupTest();
		
		  rp= new RegistrationPage(driver);
		  rp.selectTitleMr();
		  rp.enterPassword("hp1529");
		  rp.selectDOB("31", "December", "1998");
//		  rp.checkNewsletter();
//		  rp.checkOffers();  
		  rp.scrollByPixels(700);
		  rp.enterFirstName("HP");
		  rp.enterLastName("Creations");
		  rp.enterCompaName("HPCreations");
		  rp.enterAddress1("Pune");
		  rp.enterAddress2("MH");
		  rp.selectCountry("India");
		  rp.enterState("Maharashtra");
		  rp.enterCity("Pune");
		  rp.enterZipCode("411033");
		  rp.enterMobilenumber("1234567890");
		  rp.clickOnCreateAccount();

		  String expectedMessage = "Congratulations! Your new account has been successfully created!";
		  String actualMessage = rp.getWelcomeMessage();
		  Assert.assertEquals(actualMessage, expectedMessage, "Welcome message does not match!");
		  
		 rp.clickOnContinuebutton();
		
		
	}

}
