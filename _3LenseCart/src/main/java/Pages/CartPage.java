package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy (xpath = "//div[text()='Proceed To Checkout']")
	private WebElement proceedToCheckOutButton;
	
	private WebDriver driver;
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOnProceedToCheckOutButton()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(proceedToCheckOutButton).click().build().perform();
		
	}
	
}
