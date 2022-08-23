package Task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Amazon {
	@Test
	public void login() throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.gecko.driver","./SeleniumKit/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Actions a=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//span[.='Hello, Sign in']"));
		Thread.sleep(2000);
		a.moveToElement(ele).perform();
		WebElement ele1=driver.findElement(By.xpath("(//span[.='Sign in'])[1]"));
		/*Robot r=new Robot();
		a.contextClick(ele1).perform();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		String par_id = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		allid.remove(par_id);
		for (String s : allid) {
			driver.switchTo().window(s);
		}*/
		driver.findElement(By.xpath("(//span[.='Sign in'])[1]")).click();
		driver.findElement(By.name("email")).sendKeys("prakashsj158@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.name("password")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		WebElement ele2 = driver.findElement(By.xpath("//a[@data-nav-role='signin']"));
		Thread.sleep(2000);
		a.moveToElement(ele2).perform();
		driver.findElement(By.xpath("//span[.='Sign Out']")).click();
	}

}
