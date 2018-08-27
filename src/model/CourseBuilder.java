package model;

import java.util.HashSet;

public class CourseBuilder {

	private String courseId;
	private String courseTeacher;
	private int studentsEnrolled;
	private int enrolmentCapacity;
	private double studentCharges;
	private HashSet<Student> students;
	private double income;
	private double runningCosts;
	
	public CourseBuilder() {}
	
	public CourseBuilder setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public CourseBuilder setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
		return this;
	}
	
	public CourseBuilder setStudentsEnrolled(int studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
		return this;
	}
	
	public CourseBuilder setEnrolmentCapacity(int enrolmentCapacity) {
		this.enrolmentCapacity = enrolmentCapacity;
		return this;
	}
	
	public CourseBuilder setStudentCharges(double studentCharges) {
		this.studentCharges = studentCharges;
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
							courseId, 
							courseTeacher, 
							studentsEnrolled, 
							enrolmentCapacity,
							studentCharges,
							students,
							income,
							runningCosts
						 );
	}
	
}
