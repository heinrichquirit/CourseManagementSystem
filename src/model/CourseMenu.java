package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import client.CourseManagementSystem;
import model.enums.CourseType;
import model.enums.MenuOption;
import util.Utils;

public class CourseMenu {
	
	private Scanner in = new Scanner(System.in);
	private ArrayList<MenuOption> options = new ArrayList<MenuOption>(Arrays.asList(MenuOption.values()));
	// Map value course references
	private Course cooking = CourseManagementSystem.getInstance().getCourses().get("cooking");
	private Course sewing = CourseManagementSystem.getInstance().getCourses().get("sewing");
	private Course writing = CourseManagementSystem.getInstance().getCourses().get("writing");
	
	public void displayOptions() {
		System.out.println("Course Management");
		System.out.println("===============");
		for(MenuOption o : options) {
			System.out.println(o.getDescription());
		}
		System.out.println("Enter an option:\n");
		
		int choice = in.nextInt();
		
		switch(choice) {
		case 1:
			addStudent();
			break;
		case 2:
			withdrawStudent();
			break;
		case 3:
			// Flush and advance to next line
			in.nextLine();
			
			System.out.println("Enter one of the following course type:"
					+ "\nCooking\nSewing\nWriting\n");
			String type = in.nextLine().toUpperCase();
			CourseType cType;
			
			// Validate type 
			try {
				cType = CourseType.valueOf(type);
				displayStudent(cType);
			} catch(IllegalArgumentException e) {
				System.out.println("Invalid type, please try again.");
				displayOptions();
			}
			
			break;
		case 4:
			displayCourseFigures();
			break;
		case 5:
			quit();
			break;
		default:
			invalidOption();
			displayOptions();
			break;
		}
	}
	
	private void addStudent() {
		// Flush line
		in.nextLine();
		
		System.out.println("Enter the one of the courses to add the student in:\nCooking\nSewing\nWriting");
		String course = in.nextLine();
		
		// Validate
		switch(course.toLowerCase()) {
			case "cooking": break;
			case "sewing": break;
			case "writing": break;
			default:
				System.out.println("Invalid course type! Must be: Cooking, Sewing or Writing");
				displayOptions();
				return;
		}
		
		// Check if course is full
		Course c = CourseManagementSystem.getInstance().getCourses().get(course.toLowerCase());
		if (c.getStudentsEnrolled() == c.getEnrolmentCapacity()) {
			System.out.printf("%s course is full! Please select another course.\n", course);
			displayOptions();
			return;
		}
		
		System.out.println("Enter the id of the student:\n");
		int id = in.nextInt();
		
		// Check if student is enrolled in any course
		// Expensive task check, should make it efficient
		for (Student students : cooking.getStudents()) {
			if (students.getId() == id) {
				System.out.printf("(%d)is already enrolled in the cooking course!\n", id);
				displayOptions();
				return;
			}
		}
		for (Student students : sewing.getStudents()) {
			if (students.getId() == id) {
				System.out.printf("(%d) %s is already enrolled in the sewing course!\n", id);
				displayOptions();
				return;
			}
		}
		for (Student students : writing.getStudents()) {
			if (students.getId() == id) {
				System.out.printf("(%d) %s is already enrolled in the writing course!\n", id);
				displayOptions();
				return;
			}
		}
		
		in.nextLine();
		System.out.println("Enter the name of the student:\n");
		String name = in.nextLine();
		System.out.println("Enter the age of the student:\n");
		int age = in.nextInt();
		System.out.printf("Enter the address of the %s:\n", name);
		in.nextLine();
		String address = in.nextLine();
		
		Student s = new Student();
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		s.hasBeenPreviouslyEnroled(false);
		
		Course enrolledCourse = CourseManagementSystem.getInstance().getCourses().get(course);
		// Need to append values not add
		double studentTotalFees = s.getCourseFees() + enrolledCourse.getStudentCharges();
		s.setCourseFees(studentTotalFees);
		enrolledCourse.getStudents().add(s);
		System.out.printf("Sucessfully added student: (%d) %s\n", id, name);
	}
	
	private void withdrawStudent() {
		// Flush
		in.nextLine();
		
		System.out.println("Enter the id of the student you want to withdraw.");
		int id = in.nextInt();
		if (!Utils.studentIsInCourse(id)) {
			System.out.printf("Student with an id of (%d) is not enrolled in any course!\n", id);
			displayOptions();
			return;
		}
		for (Student s : cooking.getStudents()) {
			if (s.getId() == id) {
				System.out.printf("Successfully withdrew student from cooking course: (%d) %s\n", id, s.getName());
				cooking.getStudents().remove(s);
			}
		}
		for (Student s : sewing.getStudents()) {
			if (s.getId() == id) {
				System.out.printf("Successfully withdrew student from sewing course: (%d) %s\n", id, s.getName());
				sewing.getStudents().remove(s);
			}
		}
		for (Student s : writing.getStudents()) {
			if (s.getId() == id) {
				System.out.printf("Successfully withdrew student from writing course: (%d) %s\n", id, s.getName());
				writing.getStudents().remove(s);
			}
		}
	}
	
	private void displayStudent(CourseType type) {
		// Display student details based on course type
		switch(type) {
			case COOKING:
				System.out.println("Displaying students for " + type.getName());
				for (Student s : cooking.getStudents()) {
					System.out.println(s);
				}
				break;
				
			case SEWING:
				System.out.println("Displaying students for " + type.getName());
				for (Student s : sewing.getStudents()) {
					System.out.println(s);
				}
				break;
			case WRITING:
				System.out.println("Displaying students for " + type.getName());
				for (Student s : writing.getStudents()) {
					System.out.println(s);
				}
				break;
			default:
				// Program won't go to default because we have validated the type
				System.out.println("Incorrect course type.");
		}
	}
	
	private void displayCourseFigures() {
		
	}
	
	private void quit() {
		System.out.println("You have exited the program.");
	}
	
	private void invalidOption() {
		System.out.println("Incorrect option, try again!");
		displayOptions();
	}
	
}
