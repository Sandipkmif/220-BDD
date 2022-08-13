package industrial;

import java.awt.im.InputContext;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class selectDropDown {
	
	WebDriver driver=null;
	@Test
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E://Chromedriver/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
         
		//Select obj=new Select(driver.findElement(By.id("Skills")));
		// obj.selectByVisibleText("C");
         
		
		//WebElement element = driver.findElement(By.id("Skills"));
		//Select select = new Select(element);
		//select.selectByIndex(5);
		//select.selectByVisibleText("C");
		
		
		/*List<WebElement> selectedOptions = select.getAllSelectedOptions();
		for (WebElement selectedOption : selectedOptions) {
			System.out.println(selectedOption.getText());
		}*/
		
		
      /* WebElement element1 = driver.findElement(By.id("Skills"));
		Select select1 = new Select(element1);
		List<WebElement> selectedOptions1 = select1.getAllSelectedOptions();
		for(WebElement selectedOption : selectedOptions1) {
		    System.out.println(selectedOption.getText());
		}*/
		
		/*Select OPtionAvailable = new Select(driver.findElement(By.id("Skills")));

		List <WebElement> TotalOption = OPtionAvailable.getOptions();
		for(WebElement Options:TotalOption){
			System.out.println(Options.getText());
		}*/

		//System.out.println(TotalOption.size()); 
		
		//List<WebElement>gender=driver.findElements(By.xpath("//input[@type='radio']"));
		//for(gender:)
		
	}

	
}
