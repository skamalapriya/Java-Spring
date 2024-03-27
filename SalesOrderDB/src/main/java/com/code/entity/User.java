package com.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "email_id")
	private String email_id;
	@Column(name = "password")
	private String passwd;

	public User() {
		this.user_id = 0;
		this.user_name = null;
		this.email_id = null;
		this.passwd = null;
	}

	public User(String user_name, String email_id, String passwd) {
		//super();
		//this.user_id = user_id;
		this.user_name = user_name;
		this.email_id = email_id;
		this.passwd = passwd;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", email_id=" + email_id + ", passwd=" + passwd
				+ "]";
	}
		
}
