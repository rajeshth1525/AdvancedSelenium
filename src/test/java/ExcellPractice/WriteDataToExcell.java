package ExcellPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcell {
	public static void main(String[] args) throws Throwable {
		// Step 1: Open existing Excel file
		FileInputStream fis= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		// Step 2: Get sheet (Data)
		Sheet sh = wb.getSheet("Data");
		// Step 2: Creat New Row
		Row r = sh.createRow(0);
		// Step 2: Creat New Cell
		Cell c = r.createCell(0);
		// Step 5: Set value
		c.setCellValue("Rajesh");
		//Open the Excel file in write mode 
		FileOutputStream fos= new FileOutputStream("./src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		// Step 7: Close workbook and streams
		wb.close();
		fis.close();
		fos.close();
		System.out.println("Data Writern successufully");
	}
	
	

}
