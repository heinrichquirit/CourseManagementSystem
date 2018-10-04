package model;

import java.io.Serializable;
import java.util.HashSet;

import model.enums.CourseType;

public class Course implements Serializable {

	private static final long serialVersionUID = 5420132462390929675L;
	private String courseId;
	private String courseTeacher;
	private int enrolmentCapacity;
	private double studentCharges;
	private HashSet<Student> students;
	private double income;
	private double runningCosts;
	private CourseType courseType;

	public Course() {
		courseId = "";
		courseTeacher = "";
		enrolmentCapacity = 0;
		studentCharges = 0.0;
		students = null;
		income = 0.0;
		runningCosts = 0.0;
		courseType = null;
	}

	public Course(
			String courseId, 
			String courseTeacher, 
			int enrolmentCapacity,
			double studentCharges, 
			HashSet<Student> students,
			double income, 
			double runningCosts,
			CourseType courseType) {
		this.courseId = courseId;
		this.courseTeacher = courseTeacher;
		this.enrolmentCapacity = enrolmentCapacity;
		this.studentCharges = studentCharges;
		this.students = students;
		this.income = income;
		this.runningCosts = runningCosts;
		this.courseType = courseType;
	}
	
	public String getCourseId() {
		return courseId;
	}
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseTeacher() {
		return courseTeacher;
	}
	
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	
	public int getStudentsEnrolled() {
		return students.size();
	}
	
	public int getEnrolmentCapacity() {
		return enrolmentCapacity;
	}
	
	public void setEnrolmentCapacity(int enrolmentCapacity) {
		this.enrolmentCapacity = enrolmentCapacity;
	}
	
	public double getStudentCharges() {
		return studentCharges;
	}
	
	public void setStudentCharges(double studentCharges) {
		this.studentCharges = studentCharges;
	}
	
	public HashSet<Student> getStudents() {
		return students;
	}
	
	public void setStudents(HashSet<Student> students) {
		this.students = students;
	}
	
	public double getIncome() {
		return income;
	}
	
	public void setIncome(double income) {
		this.income = income;
	}
	
	public double getRunningCosts() {
		return runningCosts;
	}
	
	public void setRunningCosts(double runningCosts) {
		this.runningCosts = runningCosts;
	}
	
	public CourseType getCourseType() {
		return courseType;
	}
	
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	
}
