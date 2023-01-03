package com.booking.main;

import java.sql.*;

import com.booking.entry.UserRegistration;

public class User {
	private Connection con;
	public User(Connection con) {
		this.con = con;
	}
	
	//user registration
	//this function is receiving data from entry package's class
	public boolean registerUser(UserRegistration user) {
		boolean status = false;
		try {
			PreparedStatement pstmt = this.con.prepareStatement("insert into users(fname,email,gender,password,type) values(?,?,?,?,?)");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getGender());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getType());
			pstmt.executeUpdate();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public UserRegistration getUser(String email,String password) {
		UserRegistration user = null;
		try {
			PreparedStatement pstmt = con.prepareStatement("Select * from users where email=? and password=? and type=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, "user");
			ResultSet set = pstmt.executeQuery();
			if(set.next()) {
				user = new UserRegistration();
				user.setId(set.getInt("id"));
				user.setName(set.getString("fname"));
				user.setEmail(set.getString("email"));
				user.setGender(set.getString("gender"));
				//user.setPassword(set.getString("password"));
				user.setType(set.getString("type"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public UserRegistration getAdmin(String email,String password,String type) {
		UserRegistration user = null;
		try {
			PreparedStatement pstmt = con.prepareStatement("Select * from users where email=? and password=? and type=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, type);
			ResultSet set = pstmt.executeQuery();
			if(set.next()) {
				user = new UserRegistration();
				user.setName(set.getString("fname"));
				user.setEmail(set.getString("email"));
				user.setGender(set.getString("gender"));
				//user.setPassword(set.getString("password"));
				user.setType(set.getString("type"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
