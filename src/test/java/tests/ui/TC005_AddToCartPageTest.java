package tests.ui;

import org.testng.annotations.Test;



import framework.base.BaseTest;
import framework.pages.CartPage;
import framework.pages.HomePage;
import framework.utils.ConfigReader;

public class TC005_AddToCartPageTest extends BaseTest  {
	ConfigReader cr= new ConfigReader();
	public static CartPage cp;
	public static HomePage hp;
	
	@Test
	public void checkCartPageTest() throws Exception {
		String username=cr.getUsername();
		String password=cr.getPassword();
		
		hp= new HomePage(driver);
		cp= new CartPage(driver);
		hp.clickOnSignupAndLogin();
		hp.setLoginEmail(username);
		hp.setLoginPassword(password);
		hp.clickOnSignIn();	
		cp.checkCart();
		cp.cartInfo(); // Element Screenshot
		cp.checkTottalPrice();
		
		 
	}
}      
