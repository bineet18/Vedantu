package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import properties.initializeXpaths;

public class homePage extends initializeXpaths
{
	WebDriver driver;
	Properties propX;
	public homePage(WebDriver driver) throws IOException
	{
		this.driver = driver;
		this.propX = super.propX;
	}
	
	public void enterRoomName(String room)
	{
		
		driver.findElement(By.xpath(propX.getProperty("roomName"))).sendKeys(room);
	}
	
	public void startChat()
	{
		driver.findElement(By.xpath(propX.getProperty("submit"))).click();
	}
}
