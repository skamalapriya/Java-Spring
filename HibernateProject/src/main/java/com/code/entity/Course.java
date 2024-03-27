package com.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courseinfo")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseinfo_id")
	private int course_id;
	@Column(name = "title", nullable = false, length = 50)
	private String title;
	@Column(name = "fees")
	private double fees;
	@ManyToOne
	@JoinColumn(name = "inst_id")
	private Instructor instructor;
	
	public Course() {
		this.course_id = 0;
		this.title = null;
		this.fees = 0;
		this.instructor = null;
	}

	public Course(String title, double fees, Instructor instructor) {
		//super();
		//this.course_id = course_id;
		this.title = title;
		this.fees = fees;
		this.instructor = instructor;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", title=" + title + ", fees=" + fees + ", instructor=" + instructor
				+ "]";
	}
	
	
	
	
}
