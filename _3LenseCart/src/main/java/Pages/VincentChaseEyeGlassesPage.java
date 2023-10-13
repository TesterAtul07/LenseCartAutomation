package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VincentChaseEyeGlassesPage {

	@FindBy (xpath = "//span[text()='Half Rim']")
	private WebElement halfRimFrameType;
	  
	@FindBy (xpath = "(//span[text()='Aviator'])[1]")
	private WebElement aviatorFrameShape;
	
	@FindBy (xpath = "//span[text()='Black(1)']")
	private WebElement blackAsFrameColour;
	
	@FindBy (xpath = "//div[@class='ProductDetailsContainer--sc83rf ervdyj']")
	private WebElement targetProduct;
	
	private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;
	public VincentChaseEyeGlassesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickOnHalfRimFrameType() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(halfRimFrameType));
		actions.moveToElement(halfRimFrameType).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnAviatorFrameShape() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(aviatorFrameShape));
		actions.moveToElement(aviatorFrameShape).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnBlackAsFrameColour() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(blackAsFrameColour));
		actions.moveToElement(blackAsFrameColour).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnTargetProduct() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(targetProduct));
		actions.moveToElement(targetProduct).click().build().perform();
		Thread.sleep(500);
	}
}
