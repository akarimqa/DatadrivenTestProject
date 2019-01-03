package com.testdata;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]>myData=new ArrayList<Object[]>();
		try {
			reader=new Xls_Reader("/Users/ahmadkarim/Documents/eclipse/TestngProject/src/com/testdata/Workbook2.xlsx");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("Sheet1");rowNum++) {
			String username=reader.getCellData("Sheet1", "username", rowNum);
			String password=reader.getCellData("Sheet1", "password", rowNum);
			
			Object ob[]= {username,password};
			myData.add(ob);
			
		}
		
		return myData;
	}

}
