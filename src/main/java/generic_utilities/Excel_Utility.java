package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Excel_Utility {
	public String getExcelData(String sheet,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream("src/test/resources/testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public String getExcelDataByDataFormatter(String sheet,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream("src/test/resources/testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(c);
		return data;
		
	}
	
	
		
	public Object[][] readMultipleData(String sheet) throws Throwable
	{
		FileInputStream fis=new FileInputStream("src/test/resources/testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int lastrow=sh.getLastRowNum();
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=wb.getSheet(sheet).getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
	
	
		
	
	

}
