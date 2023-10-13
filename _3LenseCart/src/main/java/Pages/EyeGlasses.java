package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EyeGlasses {
	
	@FindBy (xpath = "(//div[text()='VIEW RANGE'])[2]")
	private WebElement viewRangeButton;
	
	
	private WebDriver driver;
	
	public EyeGlasses(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	
	
	public void clickOnViewRangeButton() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(viewRangeButton).click().build().perform();
		Thread.sleep(500);
	}
}
