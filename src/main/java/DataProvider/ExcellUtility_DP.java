package DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility_DP {
	
	// Read specific cell data
	public String readDatafromExcell(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		return sh.getRow(rowNum).getCell(cellNum).toString();
	}
	
	
	//get the number of row
	
	public int rowcount(String sheetName) throws Throwable
	{
		FileInputStream fis1= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet(sheetName);
		return sh.getLastRowNum();
			
	}
	
	
	

}
