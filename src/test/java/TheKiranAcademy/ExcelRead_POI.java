package TheKiranAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelRead_POI {

	@Test
	public void test01() throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("Username.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");

		int rows = sh.getLastRowNum();// 3
		int col = sh.getRow(0).getLastCellNum();// 1
		// System.out.println(rows);
		// System.out.println(col);
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= col; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String value = df.formatCellValue(c);
				System.out.println(value + "   ");
			}
			System.out.println();
		}
	}

	public static FileInputStream fis = null;
	public static Workbook wb = null;

	public static String getCellData(int row, int col) throws Exception {
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream("Username.xlsx");
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet("Sheet1");

		Cell c = sh.getRow(row).getCell(col);
		return df.formatCellValue(c);

	}

}
