package ExcellPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataToEExcell{
	public static void main(String[] args) throws Throwable {
		//Oen the Exsting Excell File
		FileInputStream fis= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//Create New Sheet
		Sheet sh = wb.createSheet("Details");
		
		//Create first Row 
		Row r1 = sh.createRow(0);
		//create cell and set the value
		r1.createCell(0).setCellValue("Name");
		r1.createCell(1).setCellValue("Country");
		r1.createCell(2).setCellValue("Result");
		
		//Create second  Row 
		Row r2 = sh.createRow(1);
		//Creat cell and set the value
		r2.createCell(0).setCellValue("Rajesh");
		r2.createCell(1).setCellValue("India");
		r2.createCell(2).setCellValue("Pass");
		
		//Oen the workbook in write mode
		FileOutputStream fos= new FileOutputStream("./src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		//close the workbook and Stream
		wb.close();
		fis.close();
		fos.close();
		
	}
	

}
