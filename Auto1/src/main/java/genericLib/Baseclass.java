package genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class Baseclass {
	public WebDriver driver;
	public DataUtility du=new DataUtility();
	@BeforeClass
	public void launchBrowser()
	{
	//WebDriverManager.chromedriver().setup();
	System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	@BeforeMethod
	public void login() throws IOException
	{
		driver.get(du.getDataFromProperty("url"));
		driver.findElement(By.id("username")).sendKeys(du.getDataFromProperty("username"));
		driver.findElement(By.name("pwd")).sendKeys(du.getDataFromProperty("password"));
		driver.findElement(By.id("loginButton")).click();
	}
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}

}
