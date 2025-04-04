package testBase;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters; 

public class BaseTest {
	public WebDriver driver;
	public Logger logger;;
	public Properties p;
	
	
	@BeforeClass(groups={"Master", "Sanity","Regreesion, DataDriven"})
	@Parameters({"os","browser"})
		public void Setup(String os, String br) throws IOException {
		
		//Loading Config.properties File
		FileReader file =new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());   
		
		
		if(p.getProperty("execution_envi").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else {
			System.out.println("No matching Operating system found");
			return;
			}
		
	// browser
			switch(br.toLowerCase()) {  
		
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			 default: System.out.println("Not matching with any browser"); return;
							}	
			driver=new RemoteWebDriver(new URL ("http://localhost:4444/wd/hub"), capabilities);
			
		}
		
		
		if(p.getProperty("execution_envi").equalsIgnoreCase("local")) {
			switch(br.toLowerCase())
			{
			case "chrome": driver= new ChromeDriver(); break;
			case "edge" : driver= new EdgeDriver();  break;
			case "firefox": driver=new FirefoxDriver(); break;
			
			}
		}
				
		
	
		
		
		
		
		
			//driver.get("http://localhost/opencart/upload/");
			
			driver.get(p.getProperty("appURL2")); 
			
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

   
	public String RandomString() {
		String GeneratedString=RandomStringUtils.randomAlphanumeric(5);
		return GeneratedString;
	}
	public String Randomint() {
		String  Generatedint=RandomStringUtils.randomNumeric(10);
		return Generatedint;
	}
	
	public String randomAlphaNumeric() {
		String  Generatedint=RandomStringUtils.randomNumeric(3);
		String Generatedstring=RandomStringUtils.randomAlphabetic(3);
		return (Generatedint+Generatedstring);
	}
	
	public String captureScreen (String tname) throws IOException, WebDriverException { 
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); 
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver; 
		File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE); 
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "__"+ timeStamp +".png";
				
		File targetFile=new File(targetFilePath); 
		sourceFile.renameTo(targetFile); 
		return targetFilePath; 
	}
	
	
	
	
	
	
	
	 @AfterMethod
	@AfterClass(groups={"Master", "Sanity","Regreesion, DataDriven"})
		public void tearDown(){
	  	  
	  	
			driver.quit();
			
		}
	
	
	
	
}
