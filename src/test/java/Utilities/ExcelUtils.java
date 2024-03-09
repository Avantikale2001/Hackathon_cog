package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static void write(String sheetName, int rownum, int colnum, String data)throws IOException {
		 
		//Opening the excel file
 
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\ExcelFile.xlsx");
 
		XSSFWorkbook workbook=new XSSFWorkbook(file);
        
 
		//Creating the sheet if it does not exist
 
		if(workbook.getSheetIndex(sheetName)==-1) {
 
			workbook.createSheet(sheetName);              
 
		}
 
		XSSFSheet sheet=workbook.getSheet(sheetName);
//		System.out.println(sheet);
 
		if(sheet.getRow(rownum)==null)
 
		{
 
			sheet.createRow(rownum);
 
		}
 
		XSSFRow row =sheet.getRow(rownum);   
 
		// Creating cell
 
		XSSFCell cell=row.createCell(colnum);
 
		//Setting the data in the column
 
		cell.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\ExcelFile.xlsx");
 
		workbook.write(fos);
 
		workbook.close();
 
		file.close();
 
		fos.flush();
 
		fos.close();
 
	}
}
