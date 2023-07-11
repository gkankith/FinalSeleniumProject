package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataByDataFormatter {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("src\\test\\resources\\testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet("Krishna").getRow(0).getCell(0);
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(c);
		System.out.println(data);






	}

}
