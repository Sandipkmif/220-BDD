package industrial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtons {

	/* @Test
	public void test01() {
		System.setProperty("webdriver.chrome.driver", "E://Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");

		List<WebElement> hobby = driver.findElements(By.xpath("//input[@type='radio']"));
		selectRadios(hobby, "Male");
		//selectRadios(hobby, "Cricket");
	}

	public void selectRadios(List<WebElement> hobby, String input) {
		for (WebElement hobbies : hobby) {
			if (hobbies.getAttribute("value").equals(input)) {
				hobbies.click();
				break;
			}
		}
	}

	@Test
	public void test02() {
		System.setProperty("webdriver.chrome.driver", "E://Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");

		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
		selectRadios1(radio, "HTML");
		selectRadios1(radio, "60");
	}

	public void selectRadios1(List<WebElement> radio, String input) {
		for (WebElement radios : radio) {
			if (radios.getAttribute("value").equals(input)) {
				radios.click();
				break;
			}
		}
	}*/

	@Test
	public void setRadios() {
		System.setProperty("webdriver.chrome.driver", "E://Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");

		List<WebElement> gender = driver.findElements(By.xpath("//input[@type='radio']"));
		selectRadios(gender, " Male ");
	}

	public  void selectRadios(List<WebElement> gender, String input) {
		for (WebElement radio : gender) {
			if (radio.getAttribute("value").equals(input)) {
				radio.click();
				break;
			}

		}
	}
}
