package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel2 {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis1= new FileInputStream("src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Products");
		Row r = sh.getRow(4);
		String Productname = r.getCell(3).getStringCellValue();
		System.out.println(Productname);
	}

}
