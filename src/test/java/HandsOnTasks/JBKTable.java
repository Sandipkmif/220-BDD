package HandsOnTasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JBKTable {
	public static void main(String[] args) {
		// /html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]
		System.setProperty("webdriver.chrome.driver", "E://Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"file:///E:/Selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/users.html");

		WebElement table = driver.findElement(By.xpath("//table"));

		List<WebElement> totalrows = driver.findElements(By.xpath("//tr"));
		System.out.println("total nu of rows=" + totalrows.size());
		int rowscount = totalrows.size();

		for (int i = 1; i <= rowscount; i++) {
			List<WebElement> totalCells = totalrows.get(i).findElements(By.xpath("//td"));

			for (int j = 0; j <= totalCells.size(); j++) {
				String cell = totalCells.get(j).getText();
				System.out.print(cell + " ");
			}
			System.out.println();

		}
		
	}

}
