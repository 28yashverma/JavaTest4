package finalPack;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class PoiCode 
{
	static String fileName = "Final.xlsx";
	static Workbook workbook = new XSSFWorkbook();
	static Sheet sheet = workbook.createSheet("Sheet1");
	static Row row = null;
	static Cell cell = null;
	static FileOutputStream filout = null;

	
	
	
	public static void method(String productName, int flipkartPrice, int snapdealPrice, String status, String category, String subCategory, int incoming, int initial)
	{
		for(int i = 0; i < 1; i++)
		{
			row = sheet.createRow(i);
			for(int j = 0; j < 1; j++)
			{
				cell = row.createCell(j);
				cell.setCellValue("Products");
				
			}
			
			for(int j = 1; j < 2; j++)
			{
				cell = row.createCell(j);
				cell.setCellValue("Flipkart");
			}
			
			for(int j = 2; j < 3; j++)
			{
				cell = row.createCell(j);
				cell.setCellValue("Snapdeal");
			}
			
			for(int j = 3; j < 4; j++)
			{
				cell = row.createCell(j);
				cell.setCellValue("Category");
			}
			
			for(int j = 4; j < 5; j++)
			{
				cell = row.createCell(j);
				cell.setCellValue("Sub Category");
			}
			
			for(int j = 5; j < 6; j++)
			{
				cell = row.createCell(j);
				cell.setCellValue("Status");
			}
		}
		
					
			for(int i = initial; i < incoming; i++)
			{
				row = sheet.createRow(i);
				for(int j = 0; j < 1; j++)
				{
					cell = row.createCell(j);
					cell.setCellValue(productName);
				}
				
				for(int j = 1; j < 2; j++)
				{
					cell = row.createCell(j);
					cell.setCellValue(flipkartPrice);
				}
				
				for(int j = 2; j < 3; j++)
				{
					cell = row.createCell(j);
					cell.setCellValue(snapdealPrice);
				}
				
				for(int j = 3; j < 4; j++)
				{
					cell = row.createCell(j);
					cell.setCellValue(category);
				}
				
				for(int j = 4; j < 5; j++)
				{
					cell = row.createCell(j);
					cell.setCellValue(subCategory);
				}
				
				for(int j = 5; j < 6; j++)
				{
					cell = row.createCell(j);
					cell.setCellValue(status);
				}
					
			}

		
		
		
		try
		{
			FileOutputStream filout = new FileOutputStream(fileName);
			workbook.write(filout);
			filout.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
