package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
    public WebDriver driver;
	PropertyFileUtil putil = new PropertyFileUtil();
	WebdriverUtil wutil = new WebdriverUtil();

	@BeforeSuite
	public void BS()
	{
		System.out.println("Connect to Data Base");
		
	}
	
	@BeforeClass
	public void BC() throws IOException
	{
	//@Beforeclass is used to launch the application
		String URL = putil.getDataFromPropertyFile("Url");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	//To maximize the window
		wutil.maximize(driver);
		
	//To Apply wait for find element()
		wutil.implicitwait(driver);
		
		//To launch the application
				driver.get(URL);
		
	}
	
	@BeforeMethod
	public void BM() throws IOException
	{
		//@BeforeMethod is used to login the application
		
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void AM() throws InterruptedException
	{
		//@AfterMethod is used to sign out from application
		 Thread.sleep(2000);
		//Mouse hour on image
		   WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		   wutil.mousehover(driver, image);
		 
		//Click on signout
		    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	@AfterClass
	public void AC()
	{
		//@AfterClass is used to close the browser
		
		driver.quit();
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("Disconnect  to Data Base");
	}

}
