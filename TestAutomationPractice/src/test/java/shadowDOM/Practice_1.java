package shadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice_1 
{
	//Get the title of the webpage when we click on the webelement which is in shadowDOM
	
	WebDriver driver;
	JavascriptExecutor jse;
	@Test
	
	public void launchAUT() throws InterruptedException 
	{
		driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test
	public void scrolldown() throws InterruptedException 
	{
		WebElement target_element =driver.findElement(By.xpath("//h2[text()='ShadowDOM']"));
		jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", target_element);
		Thread.sleep(2000);
	}
	@Test
	public void handle_SDOM() 
	{
		WebElement shadowHost=driver.findElement(By.cssSelector("div#shadow_host"));
		jse=(JavascriptExecutor)driver;
		WebElement shadowRoot=(WebElement)jse.executeScript("return arguments[0].shadow_root", shadowHost);
		WebElement shadowElement=shadowRoot.findElement(By.cssSelector("a[href='https://www.pavantestingtools.com/']"));
		shadowElement.click();
	}
	@Test
	public void get_title() throws InterruptedException 
	{
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}
}
