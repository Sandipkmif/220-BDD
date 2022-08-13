package industrial;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
	
	@Test
	public void setup() throws Exception{
	System.setProperty("webdriver.chrome.driver","E://Chromedriver/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!RSA!108599293!6504095653!602838584772!e!goibibo!c!&gclid=Cj0KCQjw2MWVBhCQARIsAIjbwoPOG2X60zATt83wTQ8h_1Pv4ApIBtV96QEKjK3q5vdSDjV193iUfzIaAlzuEALw_wcB");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	WebElement aboutUs=driver.findElement(By.xpath("//li[text()='our products']"));
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", aboutUs);
	
		WebElement ourProducts=driver.findElement(By.xpath("//li[text()='our products']"));
		List<WebElement> links=ourProducts.findElements(By.tagName("a"));
		System.out.println(links.size());
	
	}
	
}
