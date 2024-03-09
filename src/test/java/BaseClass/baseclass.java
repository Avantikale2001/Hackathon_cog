package BaseClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseclass {
      
    public static WebDriver driver;
  	public static Logger logger;
  	public static  Properties p;
  	@BeforeTest(groups = {"sanity","regression","master"})
  	@Parameters("browser")
	 public void Setup(String br) throws InterruptedException, IOException {
  		
  		if(br.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver(); 
		}
		else if(br.equalsIgnoreCase("Edge")) 
		{
			driver=new EdgeDriver(); 
		}
		//Loading property file
			FileReader file=new FileReader(".//src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
		logger= LogManager.getLogger(this.getClass());
		logger.info("----- Driver Launch -----");
		driver.get(p.getProperty("AppUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	}
  	
  	 public  String captureScreen(String name) 
		{
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			sourceFile.renameTo(targetFile);
			return targetFilePath;
		}
	 @AfterTest(groups = {"sanity","regression","master"})
	 public void tearDown() 
		{
		 logger.info("---Execution Stop---");
			driver.quit();
			
		}
	 
	 
	
}
