package com.code.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Column(name = "fname", nullable = false, length = 50)
	private String fname;
	@Column(name = "lname", nullable = false, length = 50)
	private String lname;
	@Id
	@Column(name = "email_id")
	private String email;
	@Column(name = "mobile_no")
	private String mobile_no;
	@ManyToMany
	@JoinTable(name = "students_course", joinColumns = @JoinColumn(name = "email_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;
	
	public Student() {
		this.fname = null;
		this.lname = null;
		this.email = null;
		this.mobile_no = null;
		this.courses = null;
	}

	public Student(String fname, String lname, String email_id, String mobile_no) {
		//super();
		this.fname = fname;
		this.lname = lname;
		this.email = email_id;
		this.mobile_no = mobile_no;
	}

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

	public String getEmail_id() {
		return email;
	}

	public void setEmail_id(String email_id) {
		this.email = email_id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		if(courses == null) {
			courses = new ArrayList<Course>();
		}
		courses.add((Course) course);
	}

	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", email_id=" + email + ", mobile_no=" + mobile_no
				+ "]";
	}
	
	
}
