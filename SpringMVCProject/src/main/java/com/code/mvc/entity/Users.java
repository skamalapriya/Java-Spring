package com.code.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Column(name = "fname", nullable = false, length = 30)
	private String firstname;
	@Column(name = "lname", nullable = false, length = 30)
	private String lastname;
	@Column(name = "country", nullable = false, length = 50)
	private String country;
	@Column(name = "gender", nullable = false, length = 30)
	private String gender;
	@Column(name = "language", length = 50)
	private String[] language;
	@Id
	@Column(name = "email_id", nullable = false, length = 50)
	private String emailid;
	@Column(name = "passwd", nullable = false, length = 50)
	private String passwd;
	
	public Users(){
	}

	public Users(String firstname, String lastname, String gender, String country, String[] language, String emailid,
			String passwd) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.country = country;
		this.language = language;
		this.emailid = emailid;
		this.passwd = passwd;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getLanguage() {
		return language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
	
	
