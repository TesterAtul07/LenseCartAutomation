package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	@FindBy (xpath = "//span[text()='Check Delivery Options']")
	private WebElement checkDeliveryDropDownTab;
	
	@FindBy (xpath = "//label[text()='Enter Pin Code']")
	private WebElement enterPinCodeFeild;
	
	@FindBy (xpath = "//button[text()='CHECK']")
	private WebElement checkPinCodeButton;
	
	@FindBy (xpath = "//p[text()='SELECT LENSES']")
	private WebElement selectLensesButton;
	
	@FindBy (xpath = "//div[text()='Frame Only']")
	private WebElement frameOnlyButtton;
	
	private WebDriver driver;
	private Actions actions;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void clickOnCheckDeliveryDropDownTab() throws InterruptedException
	{
		actions.moveToElement(checkDeliveryDropDownTab).click().build().perform();
		Thread.sleep(1000);
	}
	

	public void clickOnEnterPinCodeFeild() throws InterruptedException
	{
		actions.moveToElement(enterPinCodeFeild).click().build().perform();
		Thread.sleep(500);
		
	
	}
	
	public void sendPinCode(String pincode) throws InterruptedException
	{
		enterPinCodeFeild.sendKeys(pincode);
		Thread.sleep(500);
	}
	
	public void clickOnCheckPinCodeButton() throws InterruptedException
	{
		actions.moveToElement(checkPinCodeButton).click().build().perform();
		Thread.sleep(500);
		
	}
	
	public void clickOnSelectLensesButton() throws InterruptedException
	{
		actions.moveToElement(selectLensesButton).click().build().perform();
		Thread.sleep(500);
	}
	
	public void clickOnFrameOnlyButton() throws InterruptedException
	{
		actions.moveToElement(frameOnlyButtton).click().build().perform();
		Thread.sleep(500);
	}
}
