package io.github.heinrichquirit.coursemanagement.objects;

import java.util.HashSet;

public class Course {
	
	private String courseId;
	private String courseName;
	private String coordinator;
	private int enrolments;
	private int enrolmentCapacity;
	private double studentCharge;
	private HashSet<Student> students;
	private double income;
	private double runningCosts;
	
	public Course() {
		courseId = "";
		courseName = "";
		coordinator = "";
		enrolments = 0;
		enrolmentCapacity = 0;
		studentCharge = 0.0;
		students = null;
		income = 0.0;
		runningCosts = 0.0;
	}
	
	public Course(
					courseId, courseName, coordinator,
					enrolments, enrolmentCapacity, studentCharge, 
					students, income, runningCosts) {
	}
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseId() {
		return courseId;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	
	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}
	
	public String getCoordinator() {
		return coordinator;
	}
	
	public void setEnrolment(int enrolments) {
		this.enrolments = enrolments;
	}
	
	public int getEnrolments() {
		return enrolments;
	}
	
	public void setEnrolmentCapacity(int enrolmentCapacity) {
		this.enrolmentCapacity = enrolmentCapacity;
	}
	
	public int getEnrolmentCapacity() {
		return enrolmentCapacity;
	}
	
	public void setStudentCharge(double studentCharge) {
		this.studentCharge = studentCharge;
	}
	
	public double getStudentCharge() {
		return studentCharge;
	}
	
	public void setStudent(HashSet<Student> students) {
		this.students = students;
	}
	
	public HashSet<Student> getStudents() {
		return students;
	}
	
	public void setIncome(double income) {
		this.income = income;
	}
	
	public double getIncome() {
		return income;
	}
	
	public void setRunningCosts(double runningCosts) {
		this.runningCosts = runningCosts;
	}
	
	public double getRunningCosts() {
		return runningCosts;
	}
	
	public String toString() {
		return 
	}
	
}	
