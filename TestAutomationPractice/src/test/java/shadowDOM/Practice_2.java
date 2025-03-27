package shadowDOM;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice_2 
{
	WebDriver driver;
	JavascriptExecutor jse;
	@Test
	
	public void launchAUT() throws InterruptedException 
	{
		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
	@Test
	public void scrolldown() throws InterruptedException 
	{
		WebElement target_element =driver.findElement(By.cssSelector("div#userName"));
		jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", target_element);
		Thread.sleep(30000);
		System.out.println(driver.getPageSource());
	}
	@Test
	public void handle_SDOM() throws InterruptedException 
	{
		
		//This Element is inside single shadow DOM.
		/*
		 * String cssSelectorForHost1 = "#shadow_host"; Thread.sleep(1000);
		 */
		SearchContext shadow = driver.findElement(By.id("userName")).getShadowRoot();
		Thread.sleep(5000);
		/*
		 * SearchContext
		 * shadow0=shadow.findElement(By.cssSelector("#nested_shadow_host")).
		 * getShadowRoot(); Thread.sleep(2000);
		 */
		shadow.findElement(By.id("kils")).sendKeys("Hello world...");
		Thread.sleep(5000);
	}
	@Test
	public void get_title() throws InterruptedException 
	{
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	
	}

}
