package properties;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class initializeDriver1 extends initializeConfigurations
{
	Properties propC;
	WebDriver driver1;
	String browser;
	public initializeDriver1() throws IOException
	{
		this.propC = super.propC;
	}
	
	public WebDriver returnDriver() throws MalformedURLException
	{
		browser = propC.getProperty("browser1");
		String path = System.getProperty("user.dir");
		
		if(browser.equals("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("use-fake-ui-for-media-stream");
			System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
			driver1 = new ChromeDriver(option);
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", path+"\\Drivers\\geckodriver.exe");
			driver1 = new FirefoxDriver();
		}
		else if (browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", path+"\\Drivers\\edgedriver.exe");
			driver1 = new EdgeDriver();
		}
		
		driver1.manage().timeouts().implicitlyWait(Integer.parseInt(propC.getProperty("driverTimeout")), TimeUnit.SECONDS);
		
		return driver1;
	}
}
