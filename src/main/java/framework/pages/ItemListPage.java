package framework.pages;


import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.Files;

public class ItemListPage {
	WebDriver ldriver;

	public ItemListPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(new AjaxElementLocatorFactory(rdriver, 15), this);
	}
	
	@FindBy(xpath="(//a[@class='add-to-cart'][normalize-space()='Add to cart'])[1]")
	@CacheLookup
	WebElement clickToItem;
	

	@FindBy(xpath="//div[@class='productinfo text-center']//p")
	@CacheLookup
	List<WebElement> items;
	
	@FindBy(xpath="//button[normalize-space()='Continue Shopping'])")
	@CacheLookup
	WebElement continueShopping;

	//button[normalize-space()='Continue Shopping']
	
	public void getItemList(String iname) 
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		Actions actions = new Actions(ldriver);
		String targetItem = iname;
		
		
		List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath("//div[@class='productinfo text-center']"))));
                
		for(WebElement product : products) 
		{
            String name = product.findElement(By.tagName("p")).getText();

            if (name.equalsIgnoreCase(targetItem)) 
            {
                // Move to product to trigger hover effect
                WebElement productWrapper = product.findElement(By.xpath("./ancestor::div[@class='product-image-wrapper']"));
                actions.moveToElement(productWrapper).perform();

                // Wait for and click the 'Add to cart' button in the overlay
                WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        productWrapper.findElement(By.xpath("//div[@class='product-overlay']/div/a"))
                ));
              
                addToCartBtn.click();
                
                continueShopping.click();

                System.out.println(targetItem + "' added to cart.");
                break;
            }
        }
        try 
        {
            Thread.sleep(3000);
        } catch (InterruptedException e) 
        {
            throw new RuntimeException(e);
        }
  		 
	}
	
}
