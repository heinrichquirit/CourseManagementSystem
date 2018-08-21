package io.github.heinrichquirit.coursemanagement.objects;

import java.util.HashSet;

public class CourseBuilder {

	private String courseId;
	private String courseName;
	private String coordinator;
	private int enrolments;
	private int enrolmentCapacity;
	private double studentCharge;
	private HashSet<Student> students;
	private double income;
	private double runningCosts;
	
	public CourseBuilder() {}
	
	public CourseBuilder setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public CourseBuilder setCourseName(String courseName) {
		this.courseName = courseName;
		return this;
	}
	
	public CourseBuilder setCoordinator(String coordinator) {
		this.coordinator = coordinator;
		return this;
	}
	
	public CourseBuilder setEnrolments(int enrolments) {
		this.enrolments = enrolments;
		return this;
	}
	
	public CourseBuilder setEnrolmentCapacity(int enrolmentCapacity) {
		this.enrolmentCapacity = enrolmentCapacity;
		return this;
	}
	
	public CourseBuilder setStudentCharge(double studentCharge) {
		this.studentCharge = studentCharge;
		return this;
	}
	
	public CourseBuilder setStudents(HashSet<Student> students) {
		this.students = students;
		return this;
	}
	
	public CourseBuilder setIncome(double income) {
		this.income = income;
		return this;
	}
	
	public CourseBuilder setRunningCosts(double runningCosts) {
		this.runningCosts = runningCosts;
		return this;
	}
	
	public Course createCourse() {
		return new Course(
							courseId, courseName, coordinator, enrolments, 
							enrolmentCapacity, studentCharge, students,
							income, runningCosts);
	}
}
