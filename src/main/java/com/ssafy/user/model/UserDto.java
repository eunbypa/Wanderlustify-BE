package com.ssafy.user.model;

import lombok.Data;

@Data
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
	public UserDto(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public UserDto(String id, String password, String name, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
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
}
