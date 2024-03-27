package com.code.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_profile")
public class InstructorProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_profile_id")
	private int id;
	@Column(name = "qualification")
	private String qualification;
	@Column(name = "hobby")
	private String hobby;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inst_id")
	private Instructor instructor;
	
	public InstructorProfile() {
		this.id = 0;
		this.qualification = null;
		this.hobby = null;
		this.instructor = null;
	}
	
	public InstructorProfile(String qualification, String hobby, Instructor instructor) {
		//super();
	//	this.id = id;
		this.qualification = qualification;
		this.hobby = hobby;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorProfile [id=" + id + ", qualification=" + qualification + ", hobby=" + hobby + ", instructor="
				+ instructor + "]";
	}

	
	
	
	

}
