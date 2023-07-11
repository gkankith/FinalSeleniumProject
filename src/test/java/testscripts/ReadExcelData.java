package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("src/test/resources/testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		/*Sheet sh = wb.getSheet("Krishna");
		Row r = sh.getRow(1);
		Cell c = r.getCell(1);
		String data = c.getStringCellValue();
		System.out.println(data);*/
		
		String data = wb.getSheet("Krishna").getRow(1).getCell(1).getStringCellValue();
		System.out.println(data);
	}

}
