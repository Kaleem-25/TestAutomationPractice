package reading_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice_4 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fi=new FileInputStream("C:\\Users\\pkale\\OneDrive\\Documents\\Test Scenario - Validating Gmail registration.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet st=wb.getSheet("Sheet2");
		if(st==null) 
		{
			System.out.println("There is no sheet 2!!!");
		}
		int total_rows=st.getLastRowNum();
		int total_columns=st.getRow(0).getLastCellNum();
		
		System.out.println("Total number of rows are: "+ total_rows);
		System.out.println("Total number of columns are: "+total_columns);
		System.out.println("=================================");
		
		for (int r=0; r<=total_rows; r++) 
		{
			 XSSFRow row=st.getRow(r);
			 for (int c=0; c<=total_columns; c++) 
			 { 
				 XSSFCell cell=row.getCell(c); 
				 if(cell==null) 
				 {
					 continue;
				 }
				
				 System.out.print(cell+"\t");
			 }
			 System.out.println();
		}
		
	}

}
