 package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility {
	public String readDataFromExcell(String SheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet(SheetName);
		return sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		
	}

}
