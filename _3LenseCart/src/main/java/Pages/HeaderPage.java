package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	
	
	@FindBy (xpath = "(//a[text()='Eyeglasses'])[1]")
	private WebElement eyeGlassesTab;
	
	@FindBy (xpath = "(//img[@alt='Men'])[1]")
	private WebElement menTab;
	
	@FindBy (xpath = "//span[text()='CLASSIC EYEGLASSES']")
	private WebElement classicEyeGlassesTab;
	
	private WebDriver driver;

	
	public HeaderPage(WebDriver driver)
	{
	 
		PageFactory.initElements(driver, this);
		this.driver = driver;
	    
	}
	
	
	public void clickOnClassicEyeGlassesTab() throws InterruptedException
	{
		Actions action = new Actions(driver); 
	   	action.moveToElement(eyeGlassesTab).perform();
	   	action.moveToElement(menTab).perform();
	   	action.moveToElement(classicEyeGlassesTab).perform();
	   	action.click().build().perform();
	   	Thread.sleep(500);
	}
}
