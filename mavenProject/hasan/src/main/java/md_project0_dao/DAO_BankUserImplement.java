package md_project0_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import md_project0_util.ConnectionUtil;

public class DAO_BankUserImplement implements DAO_BankUserInterface{
   // Connection connect=ConnectionUtil.getConnection();
	//private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	Scanner scanner=new Scanner(System.in);
	

	public Connection connect() throws Exception {
		try {
		ConnectionUtil conn= new ConnectionUtil();
	    return conn.makeConnection();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public int login(String userName, String passWord) throws Exception {
		String query="SELECT ID, user_name, password FROM useraccount WHERE user_name=? and password=?";
		try {
			preparedStatement=connect().prepareStatement(query);
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,passWord);
			preparedStatement.executeQuery();
			
			resultSet=preparedStatement.getResultSet();
			
			while(resultSet.next()) {
				int Id = resultSet.getInt("id");
				return Id;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public boolean createAccount() throws Exception {
		// TODO Auto-generated method stub
		int bankUserId;
		String userName;
		String password;
		String firstName;
		String lastName;
		int isAdmin;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Your First Name: ");
		firstName = sc.nextLine().toLowerCase();
		System.out.println("Enter Your Last Name: ");
		lastName = sc.nextLine().toLowerCase();
		System.out.println("Enter Username: ");
		userName = sc.nextLine().toLowerCase();
		while(isRegistered(userName)) {
			System.out.println("Username has been taken!");
			System.out.println("Please enter a different username.");
			System.out.println("Enter Username: ");
			userName = sc.nextLine().toLowerCase();
		}
		System.out.println("Enter Password: ");
		password = sc.nextLine().toLowerCase();
		
		System.out.println("Enter 1/0 for admin/user: ");
		isAdmin = sc.nextInt();
		
		System.out.println("Enter your bankuser Id: ");
		bankUserId = sc.nextInt();
		
		String query= "insert into useraccount"+"(d, user_name, password, frist_name, last_name, is_admin)"+" values(?,?,?,?,?,?)";
		try {
			preparedStatement=connect().prepareStatement(query);
			preparedStatement.setInt(1, bankUserId);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, lastName);
			preparedStatement.setInt(6, isAdmin);
			
		if(	preparedStatement.executeUpdate()==1) return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void viewAll() throws Exception {
		// TODO Auto-generated method stub
		String query="select id, user_name, password, first_name, last_name,is_admin from useraccount";
		try {
			preparedStatement=connect().prepareStatement(query);
			preparedStatement.executeQuery();
			resultSet=preparedStatement.getResultSet();
			while(resultSet.next()) {
				int userId=resultSet.getInt("id");
				String userName=resultSet.getString("user_name");
				String passW=resultSet.getString("password");
				String firstName=resultSet.getString("first_name");
				String lastName=resultSet.getString("last_name");
				int isAd=resultSet.getInt("is_Admin");
				
				System.out.println(String.format("%d  %5s  %5s    %5s    %5s    %d", userId,userName, passW, firstName, lastName,isAd));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public boolean update(int userId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Eneter first name: ");
		String firstName=scanner.nextLine();
		System.out.println("Eneter last name: ");
		String lastName=scanner.nextLine();
      String query="update bank_user set frist_name=?, last_name=? where bankuser_id=?";
      try {
		preparedStatement=connect().prepareStatement(query);
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setInt(3, userId);
		
		if(preparedStatement.executeUpdate()==1) return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean delete(int userId) throws Exception {
		// TODO Auto-generated method stub
		String query= "DELETE from bank_user WHERE bankuser_id=?";
		try {
			preparedStatement=connect().prepareStatement(query);
			preparedStatement.setInt(1, userId);
			if(preparedStatement.executeUpdate()==1) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean isRegistered(String userName)throws Exception {
		// TODO Auto-generated method stub
		String query= "select user_name from useraccount where user_name=?";
		try {
			preparedStatement=connect().prepareStatement(query);
			preparedStatement.setString(1,userName);
			preparedStatement.executeQuery();
			resultSet= preparedStatement.getResultSet();
			while(resultSet.next()) {
				String uName=resultSet.getString("user_name");
				if(uName.equals(userName)) return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

