package md_project0_util;

import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil { 
	
	/*  public static void main (String[] args) { 
	    try
	    {
	     
	      
	      Connection conn = getConnection();
	      Statement st=conn.createStatement();
	      String sql="select * from useraccount";
	      ResultSet rs=st.executeQuery(sql);
	      while(rs.next()) {
	    	  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6));
	    	  
	      }
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	  }
	*/
		
	/*public static Connection getConnection() throws SQLException, IOException {
		  String url="jdbc:oracle:thin:@oracledb.cfe2qnsz3yfb.us-east-1.rds.amazonaws.com:1521:orcl";
	      String username="mdhasan";
	      String password="AwsHasan2019";
		// read in contents of a properties file - NEVER want to hardcode credentials
		Properties prop = new Properties();
		//InputStream in = new FileInputStream("connection.properties");
		prop.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties"));
		// need to provide: url to the database, username, password
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}*/
	public Connection makeConnection() throws SQLException {
		try
	    {
	      // Step 1: "Load" the JDBC driver
	      Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    }

	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	    // Step 2: Establish the connection to the database 
	      String url="jdbc:oracle:thin:@oracledb.cfe2qnsz3yfb.us-east-1.rds.amazonaws.com:1521:orcl";
	      String username="mdhasan";
	      String password="AwsHasan2019";
	      
		return DriverManager.getConnection(url,username,password);
	}
	
	} 