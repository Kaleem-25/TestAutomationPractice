package reading_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice_1 
{
	public void readFile() throws IOException 
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+("\\Test Scenario - Validating Gmail registration.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet3");
		int total_rows=sheet.getLastRowNum();
		int total_columns=sheet.getRow(0).getLastCellNum();
		//XSSFRow row=sheet.getRow(total_columns);
		//XSSFCell cell=row.getCell(total_columns);
		
		System.out.println("Total number of rows are: "+total_rows);
		System.out.println("Total number of columns are: "+total_columns);
		
		for (int r=0; r<=total_rows;r++) 
		{
			XSSFRow row=sheet.getRow(r);
	
			for (int c=1; c<total_columns;c++) 
			{
				XSSFCell cell=row.getCell(c);
				System.out.print
				(cell.toString()+"\t");
			}
		}
		workbook.close();
		file.close();
	
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException , NullPointerException
	{
		Practice_1 obj=new Practice_1();
		obj.readFile();
	}
}
