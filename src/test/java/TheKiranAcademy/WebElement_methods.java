package TheKiranAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElement_methods {

	@Test
	public void test01() throws Exception {
		System.out.println("1. isDisplayed() method run successfully");
		System.setProperty("webdriver.chrome.driver", "E://Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"file:///D:/Software/Selenium/Selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		boolean value = driver.findElement(By.xpath("/html/body/div/center/img")).isDisplayed();
		System.out.println(value);

		System.out.println("2. isEnable() method run successfully");
		boolean enable = driver.findElement(By.id("email")).isEnabled();
		System.out.println(enable);

		System.out.println("3. getLocation method run successfully");
		Point p = driver.findElement(By.id("email")).getLocation();
		System.out.println(p.x);
		System.out.println(p.y);
		System.out.println(p);
		
		/*
		 * driver.get(
		 * "file:///D:/Software/Selenium/Selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/add_user.html"
		 * ); System.out.println("4. isSelected() method run successfully");
		 * driver.findElement(By.id("Male")).click(); boolean selected =
		 * driver.findElement(By.id("Male")).isSelected(); System.out.println(selected);
		 */
		
		
		System.out.println("5. getSize() method run successfully");
		Dimension dim =driver.findElement(By.id("email")).getSize();
		System.out.println(dim);
		
		
		System.out.println("6. getTagName() method run successfully");
		String name = driver.findElement(By.id("email")).getTagName();
	    System.out.println(name);
	
		System.out.println("7. getText() method run successfully");
		String name2 = driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
		System.out.println(name2);

		System.out.println("8. clear() method run successfully");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("654321");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();

		System.out.println("9. click() method run successfully");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("654321");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();

		System.out.println("10. submit() method run successfully");
		driver.findElement(By.id("email")).sendKeys("kira@gmail.com");
		driver.findElement(By.id("password")).sendKeys("654321");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).submit();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();

		System.out.println("11. findElement() method run successfully");
		driver.findElement(By.id("email")).sendKeys("pawan@gmail.com");
		driver.findElement(By.id("email")).clear();

		System.out.println("12. findElements() method run successfully");
		int a = driver.findElements(By.xpath("//input")).size();
		System.out.println(a);

		System.out.println("13. getAttribute() method run successfully");
		String img = driver.findElement(By.xpath("/html/body/div/center/img")).getAttribute("src");
		System.out.println(img);

		System.out.println("14. getCssValue() method run successfully");
		String color = driver.findElement(By.xpath("/html/body/div/center/img")).getCssValue("color");
		System.out.println(color);

		System.out.println("15. SendKeys() meyhod run successfully");
		driver.findElement(By.id("password")).sendKeys("65432");
		driver.findElement(By.id("password")).clear();

		// driver.close();
	}

	@Test
	public void test02() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"file:///D:/Software/Selenium/Selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/add_user.html");
		System.out.println("4. isSelected() method run successfully");
		driver.findElement(By.id("Male")).click();
		boolean selected = driver.findElement(By.id("Male")).isSelected();
		System.out.println(selected);

	}

}
