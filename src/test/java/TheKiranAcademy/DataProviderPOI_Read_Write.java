package TheKiranAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPOI_Read_Write {
	Cell c = null;
	int count = 1;
	WebDriver driver = null;

	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E://Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///E:/Selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String uname, String pass) throws Exception {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(3000);
		if (driver.getTitle().equals("JavaByKiran | Dashboard")) {
			driver.findElement(By.linkText("Logout")).click();
			writeData("Sheet1", count, 2, "PASS");
		} else
			writeData("Sheet1", count, 2, "FAIL");
		count++;
	}

	private void writeData(String sheetName, int row, int col, String data) throws Exception {
		FileInputStream fis = new FileInputStream("Username.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		if (sh.getRow(row) == null) {
			Row r = sh.createRow(row);
			c = r.createCell(col);
			c.setCellValue(data);
		} else {
			if (sh.getRow(row).getCell(col) == null) {
				c = sh.getRow(row).createCell(col);
				c.setCellValue(data);
			}
			c = sh.getRow(row).getCell(col);
			c.setCellValue(data);
		}
		FileOutputStream fos = new FileOutputStream("Username.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
	}

	@DataProvider
	public String[][] loginData() throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("Username.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rows = sh.getLastRowNum();

		String[][] data = new String[rows][2];
		for (int i = 1; i <= rows; i++) {
			Cell c = sh.getRow(i).getCell(0);// Column For Username
			Cell c1 = sh.getRow(i).getCell(1);// Column For Password

			String uname = df.formatCellValue(c);
			String pass = df.formatCellValue(c1);

			data[i - 1][0] = uname;
			data[i - 1][1] = pass;

		}
		return data;
	}
}
