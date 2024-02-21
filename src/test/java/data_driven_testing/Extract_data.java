package data_driven_testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Extract_data {
	
	public Object[][]readfile() throws EncryptedDocumentException, IOException{
		
		FileInputStream file=new FileInputStream("C:\\QCCA22\\Arrays\\PART 3\\selenium_project\\src\\main\\resources\\data.xlsx");
		
		Workbook excel=WorkbookFactory.create(file);
		org.apache.poi.ss.usermodel.Sheet sheet=excel.getSheet("Sheet1");
		
		//Now get Row and column
		int rows=sheet.getLastRowNum();
		//System.out.println(rows);
		int columns=sheet.getRow(9).getLastCellNum();
		
		Object obj[][]=new Object[rows][columns];
		
		for(int i=0;i<rows; i++) {
			
			for(int j=0;j<columns;j++) {
				
				obj[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
				
			}
		}
		
			
			
		return obj;
	}

}