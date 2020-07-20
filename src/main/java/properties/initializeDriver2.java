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

public class initializeDriver2 extends initializeConfigurations
{
	Properties propC;
	WebDriver driver2;
	String browser;
	public initializeDriver2() throws IOException
	{
		this.propC = super.propC;
	}
	
	public WebDriver returnDriver() throws MalformedURLException
	{
		browser = propC.getProperty("browser2");
		String path = System.getProperty("user.dir");
		
		if(browser.equals("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("use-fake-ui-for-media-stream");
			System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
			driver2 = new ChromeDriver(option);
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", path+"\\Drivers\\geckodriver.exe");
			driver2 = new FirefoxDriver();
		}
		else if (browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", path+"\\Drivers\\edgedriver.exe");
			driver2 = new EdgeDriver();
		}
		
		driver2.manage().timeouts().implicitlyWait(Integer.parseInt(propC.getProperty("driverTimeout")), TimeUnit.SECONDS);
		
		return driver2;
	}
}
