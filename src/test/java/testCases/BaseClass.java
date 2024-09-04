package testCases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseClass extends ConfigReader {

	public static WebDriver driver;
	//FirefoxOptions firefoxoptions= new FirefoxOptions();
	//ChromeOptions chromeoptions= new ChromeOptions();
	public Logger logger;
	//String browser;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	@Parameters({"browser", "os"})
	public void setUp(@Optional("chrome") String browser, @Optional("windows") String os)
		logger=LogManager.getLogger(this.getClass());
		loadProperties();
		//browser=getproperty("browser");
		try {
		
		if(getproperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities= new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				throw new IllegalArgumentException("No Matching OS");
			}
			
			switch(browser.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox"); 
				break;
				default:
					throw new IllegalArgumentException("No Matching Browser");
			}
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Failed to initialize RemoteWebDriver.");
	        }

		}		
		
		else if (getproperty("execution_env").equalsIgnoreCase("local")) {
			
			switch(browser.toLowerCase()) {
			case "firefox":
				driver= new FirefoxDriver();
				break;
			case "chrome": 
				driver= new ChromeDriver();
				break;
				default :
					throw new IllegalArgumentException("Invalid browser name");	
			}
							
		}
		
		else {
            throw new IllegalArgumentException("Invalid execution environment");
        }
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(getproperty("url"));
		driver.manage().window().maximize();
	}
	catch (Exception e) {
        logger.error("Error during WebDriver initialization: ", e);
        throw new RuntimeException("WebDriver setup failed", e);
	}
		if (driver == null) {
	        logger.error("WebDriver is null after setup");
	        throw new RuntimeException("WebDriver is null after setup");
	    }
	}
	
		
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}



	public String captureScreen(String tname) throws IOException {
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
		File sourceFile= takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+ tname+"_"+ timeStamp+ "png";
		File targetFile= new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
	
//	@BeforeClass
//	public void setUp() {
//		loadProperties();
//		driver= new ChromeDriver();
//		driver.get(getproperty("url"));
//		driver.manage().window().maximize();
//	}
	

}
