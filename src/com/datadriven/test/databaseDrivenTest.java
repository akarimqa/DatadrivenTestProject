package com.datadriven.test;

import java.util.List;

import org.testng.annotations.Test;

import com.testdata.ConnectDB;


public class databaseDrivenTest {
	@Test
	public void databaseTest() throws Exception {
	//DriverManager.getConnection("localhost", "root", "");
	ConnectDB db=new ConnectDB();
	List<String> st = db.readDataBase("test", "username" );
	List<String> ps = db.readDataBase("test", "password");
   for(String data:st) {
	   System.out.println(data);
   }
   
   for(String data1:ps) {
	   System.out.println(data1);
   }

    }
}



