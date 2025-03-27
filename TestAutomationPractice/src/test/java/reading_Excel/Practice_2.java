package reading_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice_2 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+("\\Test Scenario - Validating Gmail registration.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet2");
	   
	    int total_rows=sheet.getLastRowNum();
	    int total_cells=sheet.getRow(1).getLastCellNum();
	    
	    System.out.println("Total rows are: "+total_rows);
	    System.out.println("Total columns are: "+total_cells);
	    System.out.println("==================================");
	    
	    for(int r=0;r<=total_rows;r++) 
	    {
	    	//This command will fetch the 1st row data
	    	XSSFRow row=sheet.getRow(r);
	    	//System.out.println("The data of row "+r+" is: "+row.getCell(0));
	    	for (int c=0;c<=total_cells;c++) 
	    	{
	    		XSSFCell cell=row.getCell(c);
	    		System.out.println("The data of row "+r+" is: "+row.getCell(c)+ "\t");
	    	}
	    }
	    
	    workbook.close();
	    file.close();
	}

}
