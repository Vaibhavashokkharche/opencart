package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
@DataProvider(name="logindata")

	public String[][] GetData() throws IOException {
	
		
		String path=System.getProperty("user.dir")+("\\testdata\\logintestdata.xlsx");
		
		ExcelUtils xlutil=new ExcelUtils(path);
		int totalrows=xlutil.getRowCount(path,"Sheet1");
		int totalcolums=xlutil.getCellCount(path, "Sheet1", totalrows);
	
		String  logindata[][]= new String[totalrows][totalcolums];
		
		for (int i=1;i<=totalrows;i++){
			for(int j=0;j<totalcolums;j++) {
				  logindata[i-1][j]=xlutil.getCellData(path, "Sheet1", i, j);
				
				
				
			}
		
		}
		return logindata;
	}

@DataProvider (name="product")
    public String [][] Getproductdata () throws IOException{
    	
    
    		String path1=System.getProperty("user.dir")+("\\testdata\\product data.xlsx");
    		
    		ExcelUtils xlutil=new ExcelUtils(path1);
    		int totalrows=xlutil.getRowCount(path1,"Sheet1");
    		int totalcolums=xlutil.getCellCount(path1, "Sheet1", totalrows);
    	
    		String  Productdata[][]= new String[totalrows][totalcolums];
    		
    		for (int i=1;i<=totalrows;i++){
    			for(int j=0;j<totalcolums;j++) {
    				Productdata[i-1][j]=xlutil.getCellData(path1, "Sheet1", i, j);
    				
    				
    				
    			}
    		
    		}
    		return Productdata;
    	}


    	
    	
    



		public static void main(String[] args) throws IOException {
			Dataprovider dp=new Dataprovider();
			dp.GetData();
			dp.Getproductdata();
		}
	
	}
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	


