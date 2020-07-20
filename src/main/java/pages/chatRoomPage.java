package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import properties.initializeXpaths;

public class chatRoomPage extends initializeXpaths
{
	WebDriver driver;
	Properties propX;
	public chatRoomPage(WebDriver driver) throws IOException
	{
		this.driver = driver;
		this.propX = super.propX;
	}
	
	public void clickOnChat() throws InterruptedException
	{
		//Thread.sleep(6000);
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(propX.getProperty("chatBox")))));
		e.click();		
	}
	
	public void sendMessage(String Message) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(propX.getProperty("messageTextBox")))));
		e.sendKeys(Message);
		Thread.sleep(1000);
		e.sendKeys(Keys.ENTER);
	}
	
	public String getMessage()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(propX.getProperty("userMessage")))));
		String message = e.getText();
		
		return message;
	}

}
