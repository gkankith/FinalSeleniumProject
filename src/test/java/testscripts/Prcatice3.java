package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Prcatice3 {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("src/test/resources/excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Wish");
		int count=s.getLastRowNum();
		for(int i=0;i<=count;i++)
		{
			Row r = s.getRow(i);
			int count1=r.getLastCellNum();
			for(int j=0;j<count1;j++) 
			{
				Cell c = r.getCell(j);
				DataFormatter format=new DataFormatter();
				String data = format.formatCellValue(c);
				System.out.println(data);
			}
		}
	}
}
