package com.ssafy.user.model;

public class UserDto {
	private String id;
	private String password;
	private String name;
	private String email;
	private boolean isAdmin;
	private int flag;
	private String joinDate;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public UserDto(String id, String password, String name, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public UserDto(String id, String password, String name, String email, boolean isAdmin, int flag) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isAdmin = isAdmin;
		this.flag = flag;
	}

	public UserDto(String id, String password, String name, String email, boolean isAdmin) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isAdmin = isAdmin;
	}
	
	public UserDto(String id, String password, String name, String email, boolean isAdmin, int flag, String joinDate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isAdmin = isAdmin;
		this.flag = flag;
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", isAdmin="
				+ isAdmin + ", flag=" + flag + ", joinDate=" + joinDate + "]";
	}

	
	
}
