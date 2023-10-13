package _3LenseCart;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Browser;
import LensUtility.Utilities;
import Pages.CartPage;
import Pages.EyeGlasses;
import Pages.HeaderPage;
import Pages.ProductPage;
import Pages.VincentChaseEyeGlassesPage;


public class Test_1 extends Browser{
	
	private WebDriver driver;
	private HeaderPage headerPage;
	private EyeGlasses eyeGlasses;
	private VincentChaseEyeGlassesPage vincentChaseEyeGlassesPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private String TestID;
	static ExtentHtmlReporter reporter;
		
		@BeforeTest
		@Parameters("browser")
		public void launchBrowser(String browsername) throws Exception {
			
			reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
			ExtentReports extend = new ExtentReports();
			extend.attachReporter(reporter);	
		if(browsername.equals("chrome"))
		{
		  driver = launchChrome();
		}
		
		if(browsername.equals("firefox"))
		{
			driver = launchFireFox();	
		}
		
		if(browsername.equals("microsoftEdge"))
		{
			driver = launchEdge();
		}
		
						
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@BeforeClass
	public void creatingPOMObject()
	{
		headerPage = new HeaderPage(driver);	
		eyeGlasses = new EyeGlasses(driver);
		vincentChaseEyeGlassesPage = new VincentChaseEyeGlassesPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
	}
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver.get("https://www.lenskart.com/");
		
		Thread.sleep(1000);
	}
	
	@Test
	public void selectTargetProduct() throws InterruptedException, IOException
	{
		TestID = "Lense01";
		
		Thread.sleep(500);
		headerPage.clickOnClassicEyeGlassesTab();
		Thread.sleep(500);
		eyeGlasses.clickOnViewRangeButton();
		vincentChaseEyeGlassesPage.clickOnHalfRimFrameType();
		vincentChaseEyeGlassesPage.clickOnAviatorFrameShape();
		vincentChaseEyeGlassesPage.clickOnBlackAsFrameColour();
		vincentChaseEyeGlassesPage.clickOnTargetProduct();
		
		 ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		  
		  driver.switchTo().window(addr.get(1));
		productPage.clickOnCheckDeliveryDropDownTab();
		productPage.clickOnEnterPinCodeFeild();
		String pincode = Utilities.getDataFromExcelSheet("src//test//resources//ProjectTestData//TestData.xlsx", "LesnkartData", 1, 0);
		Thread.sleep(500);
		productPage.sendPinCode(pincode);
		productPage.clickOnCheckPinCodeButton();
		productPage.clickOnSelectLensesButton();
		productPage.clickOnFrameOnlyButton();
		cartPage.clickOnProceedToCheckOutButton();
		
		
	}
	
	@AfterMethod
	public void testTestment(ITestResult result) throws IOException
	{

		if(ITestResult.FAILURE == result.getStatus())
		{
		  Utilities.captureScreenshot(driver, "test-output//FailedTestScreenshot", TestID);
	     }
	
	}
	
	@AfterClass
	public void clearingObject()
	{
		headerPage = null;
		eyeGlasses = null;
		vincentChaseEyeGlassesPage = null;
		productPage = null;
		cartPage = null;

	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}

	


}
