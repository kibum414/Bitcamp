package com.example.demo.uss.domain;

import javax.persistence.*;

import lombok.Builder;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_no")
	private int userNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "regdate")
	private String regdate;

	@Builder
	public User(String name, String userName, String password, 
			String email, String birthday, String gender, String regdate) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.regdate = regdate;
	}
	
	public User() {
		return;
	}
}
