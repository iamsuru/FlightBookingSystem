package com.booking.entry;

/**
 * @author Suru's PC
 *
 */
public class UserRegistration {
	private String name;
	private String email;
	private int id;
	private String type="user";
	public UserRegistration() {
		
	}

	public UserRegistration(String name, String email, String gender, String password, String type) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.password = password;
	}

	private String gender;
	private String password;	
	public UserRegistration(String name, String email, String gender, String password, String type,int id) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.type = "user";
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	
}
