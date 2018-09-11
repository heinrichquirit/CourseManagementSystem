package model;

import java.io.Serializable;
import java.util.HashSet;

import util.CourseType;

public class Course implements Serializable {

	private static final long serialVersionUID = 5420132462390929675L;
	private String courseId;
	private String courseTeacher;
	private int studentsEnrolled;
	private int enrolmentCapacity;
	private double studentCharges;
	private HashSet<Student> students;
	private double income;
	private double runningCosts;
	private CourseType courseType;

	public Course() {
		courseId = "";
		courseTeacher = "";
		studentsEnrolled = 0;
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
			int studentsEnrolled, 
			int enrolmentCapacity,
			double studentCharges, 
			HashSet<Student> students,
			double income, 
			double runningCosts,
			CourseType courseType) {
		this.courseId = courseId;
		this.courseTeacher = courseTeacher;
		this.studentsEnrolled = studentsEnrolled;
		this.enrolmentCapacity = enrolmentCapacity;
		this.studentCharges = studentCharges;
		this.students = students;
		this.income = income;
		this.runningCosts = runningCosts;
		this.courseType = courseType;
	}

}
