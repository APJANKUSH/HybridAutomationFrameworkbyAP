package tests.ui;

import java.io.IOException;
import org.testng.annotations.Test;
import framework.base.BaseTest;
import framework.pages.HomePage;
import framework.utils.ConfigReader;

public class TC002_LoginPageTest  extends BaseTest {
	
	public static HomePage hp;
	ConfigReader cr= new ConfigReader();
	
	@Test
	public void userSigninTest() throws IOException, Exception 
	{
		String username=cr.getUsername();
		String password=cr.getPassword();
		
		hp = new HomePage(driver);
		hp.clickOnSignupAndLogin();
		hp.setLoginEmail(username);
		hp.setLoginPassword(password);
		hp.clickOnSignIn();	
		Thread.sleep(3000);
	}
	
	
//	@Test
	public void userSignoutTest() throws IOException 
	{
		hp = new HomePage(driver);
		hp.clickOnSignout();
		
	}

}
