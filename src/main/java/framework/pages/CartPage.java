package framework.pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartPage {
	WebDriver ldriver;

	public CartPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(new AjaxElementLocatorFactory(rdriver, 15), this);
	}
	
	@FindBy(xpath="//a[@href='/view_cart']")
	@CacheLookup
	WebElement viewCart;
	
	@FindBy(xpath="//div[@id='cart_info']")
	@CacheLookup
	WebElement cart_info;
	

	@FindBy(xpath="(//tbody)[1]/tr")
	@CacheLookup
	List<WebElement> cartRows;
	
	@FindBy(xpath="(//tbody)[1]/tr/td[2]")
	@CacheLookup
	WebElement desc;

	
	@FindBy(xpath="(//tbody)[1]/tr/td[3]")
	@CacheLookup
	WebElement uPrice;
	
	@FindBy(xpath="(//tbody)[1]/tr/td[4]")
	@CacheLookup
	WebElement quantity;
	
	@FindBy(xpath="(//tbody)[1]/tr/td[5]")
	@CacheLookup
	WebElement tPrice;
	
	
	
	
	
	public void checkCart() 
	{
		viewCart.click();
	}
	
	public void cartInfo() throws Exception {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File src = cart_info.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "/Screenshots/"+ timestamp + ".png");
        FileUtils.copyFile(src, dest);
        System.out.println("Screenshot taken" + dest.getAbsolutePath());
        
	}
	
	public void checkTottalPrice() {
		
		List<WebElement> cr = cartRows;

        int grandTotal = 0;
		int itemCount = cr.size();
		
		for (int i = 1; i <= itemCount; i++) {
            // === Description Check ===
            String description = desc.getText();
            if (!description.trim().isEmpty()) {
                System.out.println("Description available: " + description);
            } else {
                System.out.println("Description is missing at row " + i);
            }
            
            
		
		String priceText = uPrice.getText();
		int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
		System.out.println(price);
		
		String qtyText = quantity.getText();
		int quantity = Integer.parseInt(qtyText);
		System.out.println(quantity);
		
		 String totalText = tPrice.getText();
		 int total = Integer.parseInt(totalText.replaceAll("[^0-9]", ""));
		 System.out.println(total);
		 
		 int expectedTotal = price * quantity;
		 if (expectedTotal == total) {
             System.out.println("Price calculation correct for item " + i);
         } else {
             System.out.println("Price mismatch at row " + i + ": expected " + expectedTotal + ", found " + total);
         }
		 grandTotal += total;
		 
		 if (price * quantity == total) {
	            System.out.println("Price Calculation Verified Successfully.");
	        } else {
	            System.out.println("Price Mismatch! Expected: " + (price * quantity) + ", Found: " + total);
	        }
		 if (itemCount >= 2) {
	            System.out.println("Total number of items: " + itemCount);
	            System.out.println("Grand Total for all items: Rs. " + grandTotal);
	        }
	}
	
	}	
	
}
