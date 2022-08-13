package TheKiranAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithPOI {

	@Test(dataProvider = "loginData")
	public void loginTest(String uname, String pass) {
		System.setProperty("webdriver.chrome.driver", "E://Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"file:///E:/Selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
	}

	@DataProvider
		public String[][]loginData() throws Exception{
		DataFormatter df=new DataFormatter();	
		FileInputStream fis = new FileInputStream("Username.xlsx");
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sh= wb.getSheet("Sheet1");
			int rows=sh.getLastRowNum();
			
			String[][]data=new String[rows][2];
			for(int i=1;i<=rows;i++){
				Cell c=sh.getRow(i).getCell(0);//username
				Cell c1=sh.getRow(i).getCell(1);//password
				
				String uname= df.formatCellValue(c);
				String pass=df.formatCellValue(c1);
				
				data[i-1][0]=uname;
				data[i-1][1]=pass;
			}
			
			
			return data;
			
		}

}
