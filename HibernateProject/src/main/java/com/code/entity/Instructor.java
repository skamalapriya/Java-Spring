package com.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private int id;
	@Column(name = "fname", nullable = false, length = 30)
	private String fname;
	@Column(name = "lname", nullable = false, length = 30)
	private String lname;
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	public Instructor() {
		this.id = 0;
		this.fname = null;
		this.lname = null;
		this.email = null;
	}
	public Instructor(String fname, String lname, String email) {
		
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	/*public void setId(int id) {
		this.id = id;
	}*/
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}
	
	
}
