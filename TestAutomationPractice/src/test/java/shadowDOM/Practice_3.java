package shadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Practice_3
{
	WebDriver driver;
	JavascriptExecutor jse;
	@Test
	public void launchAUT() 
	{
		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@Test
	public void scroll() throws InterruptedException 
	{
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.cssSelector("#userName"));
		jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", ele);
		Thread.sleep(40000);
	}
	@Test
	public void shadow() throws InterruptedException 
	{
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(60));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#userName")));
		
		WebElement host1=driver.findElement(By.cssSelector("div#userName"));
		jse=(JavascriptExecutor)driver;
		WebElement root1=(WebElement)jse.executeScript("return arguments[0].shadowRoot", host1);
		WebElement element=root1.findElement(By.id("kils"));
		Thread.sleep(2000);
		element.sendKeys("Hello world...");
		Thread.sleep(2000);
	}
	@Test
	public void teardown() 
	{
		driver.close();
	}
}
