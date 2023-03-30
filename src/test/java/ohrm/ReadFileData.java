package ohrm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ReadFileData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ReadFileData rfd = new ReadFileData();
		rfd.ReadData(0);
	}
public static String[][] ReadData(int k) throws EncryptedDocumentException, IOException
	{
	File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Test.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheetName = wb.getSheetAt(k);
	
	int rows = sheetName.getLastRowNum();
	System.out.println(rows);
	Row rowcells = sheetName.getRow(0);
	int cells = rowcells.getLastCellNum();
	System.out.println(cells);
	
	DataFormatter format = new DataFormatter();
	String testData[][] = new String [rows][cells]; 
	for(int i = 0 ; i< rows ; i++)
	{
		for(int j=0 ; j < cells ; j++ )
		{
			testData[i][j]= format.formatCellValue(sheetName.getRow(i).getCell(j));
			System.out.println(testData [i][j]);	
		}
	}
	return testData;
	}

}

