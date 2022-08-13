package TheKiranAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestWithExcel {
	@Test
	public void test01() throws Exception{
		System.setProperty("webdriver.chrome.driver","E://Chromedriver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///E:/Selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		
		String uname=ExcelRead_POI.getCellData(1, 0);
		
		String pass=ExcelRead_POI.getCellData(1, 1);
		
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
	}

}
