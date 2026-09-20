package ExcellPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToEExcellInSafeVersion {
	public static void main(String[] args) throws Throwable {
		//Step 1: Open existing Excel file
		FileInputStream fis= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//Get Sheet(New Data)
		Sheet sh = wb.getSheet("New Data");
		if(sh==null)
		{
			sh = wb.createSheet("New Data");// if sheet not theire then creating new sheet as New Data
		}
		//Get row
		Row r = sh.getRow(0);
		if(r==null)
		{
			r=sh.createRow(0);  // if row not theire then creating new row  in New Data sheet
		}
		
		//Get Cell
		Cell c = r.getCell(0);
		if(c==null)
		{
			c=r.createCell(0);// if cell not theire then creating new row  in New Data sheet
		}
		
		//Set the value
		c.setCellValue("Yuvansh");
		//Open the Workbook in write mode
		FileOutputStream fos= new FileOutputStream("./src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		//close workbook and stream
		wb.close();
		fis.close();
		fos.close();
		
				
		
	}

}
