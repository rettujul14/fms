package fms;

import java.sql.*; 
class Connection1{  
	
	public static String url = "jdbc:sqlserver://localhost:1433;"+"databaseName=fms;integratedSecurity=true;";
	public static void main(String[] args){
		try{  
//			Class.forName("com.mysql.jdbc.Driver");  
			System.out.println("test1");
			 Connection con=DriverManager.getConnection(url);  

			System.out.println("test2");
			Statement stmt=con.createStatement();
			ResultSet rs_admin=stmt.executeQuery("select * from admin");  
			while(rs_admin.next())  
			System.out.println(rs_admin.getString(2));  
			

			  
			}catch(Exception e){ System.out.println(e);}  
			}


}  