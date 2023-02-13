package qhung.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	@Id
	private String courseNo; 
	private String courseName; 
	@ManyToOne
	private Professor professor;
	
	public Course(String courseNo, String courseName, Professor professor) {
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.professor = professor;
	}
	public Course() {
		
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
