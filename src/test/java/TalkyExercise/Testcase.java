package TalkyExercise;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.callSettingPage;
import pages.chatRoomPage;
import pages.homePage;
import properties.initializeConfigurations;
import properties.initializeDriver1;
import properties.initializeDriver2;

public class Testcase 
{
	WebDriver driver1;
	WebDriver driver2;
	Properties propC;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		initializeConfigurations c = new initializeConfigurations(); // Initialize the Configuration File
		propC = c.returnConfiguration();
		
		initializeDriver1 i1 = new initializeDriver1();
		initializeDriver2 i2 = new initializeDriver2();
		
		driver1 = i1.returnDriver();
		driver2 = i2.returnDriver();
		
		driver1.manage().window().maximize(); // Maximize the Window
		driver2.manage().window().maximize(); // Maximize the Window
	}
	
	@Test
	public void Test1() throws IOException, InterruptedException
	{
driver1.get(propC.getProperty("url"));
		
		homePage h = new homePage(driver1);
		h.enterRoomName(propC.getProperty("chatRoomName"));
		h.startChat();
		
		
		callSettingPage c1 = new callSettingPage(driver1);
		c1.joinCall();
		
		chatRoomPage r = new chatRoomPage(driver1);
		r.clickOnChat();
		r.sendMessage(propC.getProperty("messageText"));
		
		
		
		
		driver2.get(propC.getProperty("url"));
		
		h = new homePage(driver2);
		h.enterRoomName(propC.getProperty("chatRoomName"));
		h.startChat();
		
		c1 = new callSettingPage(driver2);
		c1.joinCall();
		
		r = new chatRoomPage(driver2);
		r.clickOnChat();
		
		Assert.assertTrue(propC.getProperty("messageText").equals(r.getMessage()));

		
		
	}
	
	@AfterMethod
	public void closeAll()
	{
		driver1.close();
		driver2.close();
	}

}
