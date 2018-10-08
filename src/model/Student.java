package model;

import java.io.Serializable;

import model.interfaces.Person;
import util.Utils;

public class Student implements Person, Serializable {

	private static final long serialVersionUID = -3796095927356107079L;
	private static int count;
	private int id;
	private String name;
	private int age;
	private String address;
	private double courseFees;
	private boolean hasPreviousEnrolment;
	
	public Student() {
		id = count++;
		name = "";
		age = 0;
		address = "";
		courseFees = 0.0;
		hasPreviousEnrolment = false;
	}
	
	public Student(String name, 
					int age, String address, 
					double courseFees, boolean hasPreviousEnrolment) {
		this.id = count++;
		this.name = name;
		this.age = age;
		this.address = address;
		this.courseFees = courseFees;
		this.hasPreviousEnrolment = hasPreviousEnrolment;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getCourseFees() {
		return courseFees;
	}
	
	public void setCourseFees(double courseFees) {
		this.courseFees = courseFees;
	}
	
	public boolean hasPreviousEnrolment() {
		return hasPreviousEnrolment;
	}
	
	public void hasBeenPreviouslyEnroled(boolean hasPreviousEnrolment) {
		this.hasPreviousEnrolment = hasPreviousEnrolment;
	}
	
	@Override
	public String toString() {
		return String.format(
								"%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%b\n%s%s\n====================", 
								"Id: ", id,
								"Name: ", name,
								"Age: ", age,
								"Address: ", address,
								"CourseFees: ", courseFees,
								"PreviouslyEnrolled: ", hasPreviousEnrolment,
								"CoursesEnrolled: ", Utils.findStudentCourses(id)
							);
	}

}
