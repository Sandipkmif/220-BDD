package TheKiranAcademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
	@Test
	public void testDemo(){
		System.setProperty("webdriver.chrome.driver","E://Chromedriver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//driver.get(null);//data:,
		
		//driver.get("http:www.google.com");//data:,//
		//org.openqa.selenium.InvalidArgumentException: invalid argument
		driver.get("file:///E:/Selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		//file:///E:/Selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html

		String title=driver.getTitle();
		System.out.println(title);
		//JavaByKiran | Log in
		
		String pagesource=driver.getPageSource();
		System.out.println(pagesource);
		
		WebElement element=driver.findElement(By.id("email"));
		
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Guitar");
	}

}
