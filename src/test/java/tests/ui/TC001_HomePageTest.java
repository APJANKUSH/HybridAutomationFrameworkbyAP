package tests.ui;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;



import framework.base.BaseTest;
import framework.pages.HomePage;

public class TC001_HomePageTest extends BaseTest  {
	
	public static HomePage hp;
	
	@Test
	public void userSignupTest() throws IOException 
	{
		hp = new HomePage(driver);
		hp.clickOnSignupAndLogin();
		hp.setUserName("hp");
		hp.setUserEmail("hp@t.com");
		hp.clickOnSignup();
		
		String expectedMessage = "ENTER ACCOUNT INFORMATION" ;
		String actualMessage = hp.getWelcomeMessage();
		
		Assert.assertEquals(actualMessage, expectedMessage, "Welcome message does not match!");
		
	}	



	
	
}
