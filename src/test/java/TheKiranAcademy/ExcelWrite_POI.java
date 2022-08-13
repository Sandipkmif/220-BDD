package TheKiranAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelWrite_POI {
	Sheet sh=null;
	Row row=null;
	Cell c=null;
	
	@Test
	public void test01() throws Exception{
		FileInputStream fis=new FileInputStream("Username.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		if(wb.getSheet("TheKiranAcademy")==null){
			sh=wb.createSheet("THeKiranAcademy");
			row=sh.createRow(5);
			c=row.createCell(3);
			c.setCellValue("TheKiranAcademyTest");
		}
		else{
			sh=wb.getSheet("TheKiranAcademy");
			if(sh.getRow(5)==null){
				row=sh.createRow(5);
				c=row.createCell(3);
			}
			else{
				row=sh.getRow(5);
				if(row.getCell(3)==null)
					c=row.createCell(3);
				else
					c=row.getCell(3);
				
				c.setCellValue("Selenium--Test");
			}
		}
		FileOutputStream fos=new FileOutputStream("Username.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
				
	}
	

}
