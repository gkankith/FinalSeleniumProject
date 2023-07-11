package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelData {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("src/test/resources/testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("Krishna").getRow(0).getCell(0).setCellValue("Shri");
		FileOutputStream fos=new FileOutputStream("src/test/resources/testscript1.xlsx");
		wb.write(fos);
		wb.close();
	}

}
