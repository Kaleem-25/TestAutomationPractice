package reading_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice_3 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file =new FileInputStream(System.getProperty("user.dir")+("\\Test Scenario - Validating Gmail registration.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet st=wb.getSheet("Sheet2");
		int total_rows=st.getLastRowNum();
		int total_columns=st.getRow(0).getLastCellNum();
		
		System.out.println("total no. of rows are: "+total_rows);
		System.out.println("total no. of columns are: "+total_columns);
		System.out.println("=================================");
		
		for(int r=0; r<=total_rows; r++) 
		{
			XSSFRow row=st.getRow(r);
			System.out.println(row.getCell(0)+"\t"+row.getCell(1));
		}

	}

}
