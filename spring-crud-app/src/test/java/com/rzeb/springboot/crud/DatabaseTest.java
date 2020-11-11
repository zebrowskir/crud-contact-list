package com.rzeb.springboot.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
	
    static Connection con = null;
    private static Statement st;
    public static String DB_URL = "jdbc:mysql://localhost:3306/contact_list?useSSL=false&serverTimezone=UTC";   
    public static String DB_USER = "springstudent";
    public static String DB_PASSWORD = "springstudent";

    @Before
    public void setUp() throws Exception {
    		
    		try{
        	   
                  String dbClass = "com.mysql.cj.jdbc.Driver";
                  Class.forName(dbClass).newInstance();
                  
                  Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                  
                  st = con.createStatement();
           	}
           	catch (Exception e){
	                e.printStackTrace();
           	}
    }

    @Test
    public void test() {
           try{
	           String query = "select * from contact";
	           
	           ResultSet res = st.executeQuery(query);
           // Print the result until all the records are printed
           // res.next() returns true if there is any next record else returns false
	           while (res.next()){
	        	   System.out.print(res.getString(1));
		           System.out.print("\t" + res.getString(2));
		           System.out.print("\t" + res.getString(3));
		           System.out.println("\t" + res.getString(4));
	           }           
           }
           catch(Exception e){
                  e.printStackTrace();
           }     
    }

    @After
    public void tearDown() throws Exception {
           if (con != null) {
           con.close();
           }
    }
}