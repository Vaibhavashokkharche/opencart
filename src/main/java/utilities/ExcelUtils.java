package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	String path;
	
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public static FileOutputStream fo;
	public ExcelUtils(String filepath){
		this.path=filepath;
	}
	public static int getRowCount (String xlfile, String xlsheet) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		int rowcount= ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		int cellCount= row.getLastCellNum();
		wb.close();
		fi.close();
		
	return cellCount;	
	}
	public static String getCellData(String xlfile, String xlsheet, int rownum, int cellnum ) throws IOException {
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cell =row.getCell(cellnum);
		String data;
		try {
		//data=cell.toString();
			DataFormatter formattor= new DataFormatter();
			data= formattor.formatCellValue(cell);
			
		}catch(Exception e)
		{
		data="";
		
		}
		wb.close();
		fi.close();
		return data;
	}
	   public static void SetCellData(String xlfile, String xlsheet, int rownum, int columnum, String data ) throws IOException {
		   fi= new FileInputStream(xlfile);
		   wb= new XSSFWorkbook(fi);
		   ws= wb.getSheet(xlsheet);
		   row= ws.getRow(rownum);
		   cell= row.createCell(columnum) ;
		   cell.setCellValue(data);
		   fo= new FileOutputStream(xlfile);
		   wb.write(fo);
		   wb.close();
		   fi.close();
		   fo.close();
	   }
	public static void fillGreencolor(String xlfile, String xlsheet, int rownum, int colnum ) throws IOException {
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		cell= row.getCell(colnum);
		  style= wb.createCellStyle();
		  style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	fo= new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	
	}
	
	public static void fillRedcolor(String xlfile, String xlsheet, int rownum, int colnum ) throws IOException {
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		cell= row.getCell(colnum);
		  style= wb.createCellStyle();
		  style.setFillForegroundColor(IndexedColors.RED.getIndex());
		  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	fo= new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	
	}
	

}



