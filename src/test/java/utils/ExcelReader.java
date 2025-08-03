package utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.FileInputStream;

public class ExcelReader 
{
	public static String[] data = null;
	
	public static String[] readExcelFile(String fileName , String  sheetName )
	{
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			data = new String[row.getPhysicalNumberOfCells()];
			for(int i=0;i<row.getPhysicalNumberOfCells();i++)
			{
				switch(row.getCell(i).getCellType()) 
				{
					case STRING: data[i] = row.getCell(i).getStringCellValue();
								break;
					case NUMERIC: data[i] = row.getCell(i).getNumericCellValue()+"";
								break;
					case BLANK: data[i] = null;
								break;
				}
				
			}
			workbook.close();
			fis.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
}
