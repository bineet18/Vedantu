package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import properties.initializeXpaths;

public class callSettingPage extends initializeXpaths
{
	WebDriver driver;
	Properties propX;
	public callSettingPage(WebDriver driver) throws IOException
	{
		this.driver = driver;
		this.propX = super.propX;
	}
	
	public void acceptThePermission() throws InterruptedException
	{
		driver.findElement(By.xpath(propX.getProperty("allowCameraAccess"))).click();		
		driver.findElement(By.xpath(propX.getProperty("allowMicrophoneAccess"))).click();

	}
	
	public void joinCall()
	{
		driver.findElement(By.xpath(propX.getProperty("joinCall"))).click();
	}

}
