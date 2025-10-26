package tests.ui;

import java.io.IOException;
import org.testng.annotations.Test;

import framework.base.BaseTest;
import framework.pages.ItemListPage;
import framework.pages.RegistrationPage;



public class TC004_ItemListPageTest  extends BaseTest 

{

	public static RegistrationPage rp;
	public static ItemListPage ip;
	
	
	@Test
	public void checkItemListTest() throws Exception {
		rp= new RegistrationPage(driver);
		ip= new ItemListPage(driver);
		rp.scrollByPixels(500);
		ip.getItemList("Tshirt");
		Thread.sleep(5000);
//		ip.addToCart();
		Thread.sleep(5000);
				
		
	}
	
}
