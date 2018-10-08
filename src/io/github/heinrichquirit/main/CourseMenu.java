package io.github.heinrichquirit.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import io.github.heinrichquirit.main.enums.CourseType;
import io.github.heinrichquirit.main.enums.MenuOption;
import io.github.heinrichquirit.main.objects.Course;
import io.github.heinrichquirit.main.objects.Student;
import io.github.heinrichquirit.main.util.ObjectFileWriter;
import io.github.heinrichquirit.main.util.Utils;

public class CourseMenu {
	
	private Scanner in = new Scanner(System.in);
	private ArrayList<MenuOption> options = new ArrayList<MenuOption>(Arrays.asList(MenuOption.values()));
	// Map value references
	private Course cooking = CourseManagementSystem.getInstance().getMap().get("cooking");
	private Course sewing = CourseManagementSystem.getInstance().getMap().get("sewing");
	private Course writing = CourseManagementSystem.getInstance().getMap().get("writing");
	// Use to stream/read data to/from file
	private ObjectFileWriter writer;
	// File used to store student data
	private File studentFile;
	// List to store enable notifications for students
	private HashSet<Integer> studIds = new HashSet<Integer>();
	// List to store catch up sessions for students
	private HashSet<Student> catchUpStudents = new HashSet<Student>();
	
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
			displayTeacherInfo();
			break;
		case 6:
			addPaymentOptions();
			break;
		case 7:
			enableStudentNotifications();
			break;
		case 8:
			catchUpSession();
			break;
		case 9:
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
		Course c = CourseManagementSystem.getInstance().getMap().get(course.toLowerCase());
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
		
		Course enrolledCourse = CourseManagementSystem.getInstance().getMap().get(course);
		// Need to append values not add
		double studentTotalFees = s.getCourseFees() + enrolledCourse.getStudentCharges();
		s.setCourseFees(studentTotalFees);
		enrolledCourse.getStudents().add(s);
		
		// Save student
		studentFile = new File("students/" + s.getId() + ".dat");
		writer = new ObjectFileWriter(studentFile, s);
		writer.save();
		
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
				File file = new File("students/" + id + ".dat");
				file.delete();
			}
		}
		for (Student s : sewing.getStudents()) {
			if (s.getId() == id) {
				System.out.printf("Successfully withdrew student from sewing course: (%d) %s\n", id, s.getName());
				File file = new File("students/" + id + ".dat");
				file.delete();
			}
		}
		for (Student s : writing.getStudents()) {
			if (s.getId() == id) {
				System.out.printf("Successfully withdrew student from writing course: (%d) %s\n", id, s.getName());
				File file = new File("students/" + id + ".dat");
				file.delete();
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
		System.out.println("Costs information");
		double j = cooking.getRunningCosts();
		double k = sewing.getRunningCosts();
		double l = writing.getRunningCosts();
		System.out.printf(
							"%s%s\n%s%s\n%s%s\n%s%s\n", 
							"Cooking cost: ", j,
							"Sewing cost: ", k,
							"Writing cost: ", l,
							"Total cost: ", (j+k+l));
	}
	
	private void displayTeacherInfo() {
		System.out.println("Displaying teacher info.");
		System.out.printf("%s%s%s\n", "Cooking Teacher ", "(" + cooking.getCourseTeacher() + "): ", cooking.getTeacherInfo());
		System.out.printf("%s%s%s\n", "Sewing Teacher ", "(" + sewing.getCourseTeacher() + "): ", sewing.getTeacherInfo());
		System.out.printf("%s%s%s\n", "Writing Teacher ", "(" + writing.getCourseTeacher() + "): ", writing.getTeacherInfo());
	}
	
	private void addPaymentOptions() {
		System.out.println("1. Credit Card");
		System.out.println("2. Paypal");
		int choice = in.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Adding card.");
				System.out.println("cardnumber:expdate:cvv");
				System.out.println("Use the following format 1234567891234567:0422:322");
				String cardDetails = in.nextLine();
				String cardNum = cardDetails.split(":")[0];
				String expDate = cardDetails.split(":")[1];
				String cvv = cardDetails.split(":")[2];
				System.out.println("Succussfully added card with the following details!");
				System.out.println("Card Number: " + cardNum);
				System.out.println("Card Exp Date: " + expDate);
				System.out.println("Card CVV: " + cvv);
			case 2:
				in.nextLine();
				System.out.println("Adding paypal.");
				System.out.println("Enter your email associated with the account.");
				String email = in.nextLine();
				System.out.println("Enter password associated with the account.");
				String pass1 = in.nextLine();
				System.out.println("Enter the password again to confirm.");
				String pass2 = in.nextLine();
				if (!pass1.equals(pass2)) {
					System.out.println("Password does not much, try again!");
					displayOptions();
					return;
				}
				System.out.println("Successfully added paypal under email " +  email);
		}
	}
	
	private void enableStudentNotifications() {
		in.nextLine();
		System.out.println("Enter the student id to enable notifications for");
		int id = in.nextInt();
		if (!Utils.studentExists(id)) {
			System.out.println("Student with id of (" + id + ") does not exist!");
			displayOptions();
			return;
		}
		if (studIds.contains(id)) {
			System.out.println("Student with id of (" + id + ") has notifications, would you like to disable? (y/n)");
			String ans = in.nextLine();
			if (ans.equalsIgnoreCase("y")) {
				studIds.remove(id);
			}
		}
		studIds.add(id);
		System.out.println("Successfully enabled notifications for student (" + id + ")");
	}
	
	private void catchUpSession() {
		in.nextLine();
		System.out.println("Enter your student id to register for a catch up session");
		int id = in.nextInt();
		for (Student a : catchUpStudents) {
			if (a.getId() == id) {
				System.out.println("You already have been registered for a catch up session.");
				System.out.println("Would you like to view the list? (y/n)");
				String ans = in.nextLine();
				if (ans.equalsIgnoreCase("y")) {
					for (Student b : catchUpStudents) {
						System.out.println(b.getId() + " " + b.getName());
					}
				} else {
					displayOptions();
					return;
				}
				return;
			} else {
				System.out.println("Here are the registered students.");
				for (Student c : catchUpStudents) {
					System.out.println(c.getId() + " " + c.getName());
				}
			}
		}
	}
	
	private void quit() {
		System.out.println("You have exited the program.");
	}
	
	private void invalidOption() {
		System.out.println("Incorrect option, try again!");
		displayOptions();
	}
	
}
