package url;

import java.io.*;
import java.net.*;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import data.DataFetcher;

public class UrlFetcher {
	
	private static String username;
	private static String  password;

	public static void main(String[] args) {
		
		//upload ExcellFile
		 String excelFilePath = "C:\\Users\\ASUS\\Downloads\\Urls.xlsx";
		// String excelFilePath = "C:\\Users\\ASUS\\Downloads\\Untitled_spreadsheet.xlsx.xlsx"; 	 
		 
		 
		try {
			String url= fetchUrl(excelFilePath,"Google");
			if(!url.equals("Not Found")) {
			String Data= DataFetcher.getData(url,username,password);
			
			System.out.println(Data);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}					
	}
	
	private static String fetchUrl(String file, String website) throws Exception {
					
					try {
					FileInputStream inputdata= new FileInputStream(new File(file)); 
					
					XSSFWorkbook  workbook = new XSSFWorkbook(inputdata);
					XSSFSheet sheets = workbook.getSheet("Sheet2"); 
					
					Iterator<Row> itr =sheets.iterator();
					
					while(itr.hasNext()) {
						Row row= itr.next();
						Iterator<Cell> cellIterator= row.cellIterator();
						Cell cell= row.getCell(0); 
				
						if(cell.toString().equals(website)) {
							System.out.println("cell value");
							cell= row.getCell(1);
							System.out.println(cell);
							return cell.toString();
						}
							
						
					}
				
							
					}
					catch(Exception e) {
						e.printStackTrace();
					}		
		
		return "Not Found";
			
		}
	
	
}
