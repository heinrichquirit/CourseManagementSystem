package model;

import java.util.HashSet;

public class Course {

	private String courseId;
	private String courseTeacher;
	private int studentsEnrolled;
	private int enrolmentCapacity;
	private double studentCharges;
	private HashSet<Student> students;
	private double income;
	private double runningCosts;

	public Course() {
		courseId = "";
		courseTeacher = "";
		studentsEnrolled = 0;
		enrolmentCapacity = 0;
		studentCharges = 0.0;
		students = null;
		income = 0.0;
		runningCosts = 0.0;
	}

	public Course(
			String courseId, 
			String courseTeacher, 
			int studentsEnrolled, 
			int enrolmentCapacity,
			double studentCharges, 
			HashSet<Student> students,
			double income, 
			double runningCosts) {
		this.courseId = courseId;
		this.courseTeacher = courseTeacher;
		this.studentsEnrolled = studentsEnrolled;
		this.enrolmentCapacity = enrolmentCapacity;
		this.studentCharges = studentCharges;
		this.students = students;
		this.income = income;
		this.runningCosts = runningCosts;
	}

}
