package client;

import java.io.File;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

import model.Course;
import model.CourseMenu;
import model.Student;
import model.enums.CourseType;

public class CourseManagementSystem {
	
	public static void main(String[] args) {
		
		// If there is no initial data, load sample 
		loadSampleData();
		// Load directories for file storage
		loadDirectories();
		
		CourseMenu c = new CourseMenu();
		c.displayOptions();
	}
	
	private static void loadDirectories() {
		// Saved data from user input
		File studentDir = new File("students/");
		File courseDir = new File("courses/");
		
		studentDir.mkdir();
		courseDir.mkdir();
		System.out.println("Successfully loaded directories.\n");
	}
	
	private static void loadSampleData() {
		// Cooking course data
		HashSet<Student> cookingStudents = new HashSet<Student>();
		Course cooking = new Course("0001", "Gordon Ramsay", 75, 4500, cookingStudents, 1000, 3000, CourseType.COOKING);
		for (int i=0; i<=cooking.getEnrolmentCapacity(); i++) {
			cookingStudents.add(new Student(
											generateRandName(), 
											generateRandAge(), 
											generateRandAddress(),
											generateRandCourseFee(), 
											generateRandEnrolment())
										   );
		}
		// Sewing course data
		HashSet<Student> sewingStudents = new HashSet<Student>();
		Course sewing = new Course("0002", "Nanny Doubtfire", 60, 3000, sewingStudents, 750, 2500, CourseType.SEWING);
		for (int i=0; i<=sewing.getEnrolmentCapacity(); i++) {
			cookingStudents.add(new Student(
											generateRandName(), 
											generateRandAge(), 
											generateRandAddress(),
											generateRandCourseFee(), 
											generateRandEnrolment())
										   );
		}
		// Writing course data
		HashSet<Student> writingStudents = new HashSet<Student>();
		Course writing = new Course("0004", "Steven Spielberg", 90, 5000, writingStudents, 1250, 4000, CourseType.WRITING);
		for (int i=0; i<=writing.getEnrolmentCapacity(); i++) {
			cookingStudents.add(new Student(
											generateRandName(), 
											generateRandAge(), 
											generateRandAddress(),
											generateRandCourseFee(), 
											generateRandEnrolment())
										   );
		}
	}
	
	private static String generateRandName() {
		final String[] names = {"Fred", "George", "Sarah", "Samantha", "Henry", "Jeffrey", "Montanna", "Molly", "Taylah", "Gordon"};
		return names[ThreadLocalRandom.current().nextInt(0, names.length-1)];
	}
	
	private static int generateRandAge() {
		final int[] ages = {18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
		return ages[ThreadLocalRandom.current().nextInt(0, ages.length-1)];
	}
	
	private static String generateRandAddress() {
		final String[] address = {
				"123 Somethin St", "234 Nothin St", "345 Anythin St", 
				"456 Somethin St", "567 Nothin St", "678 Anythin St",
				"789 Somethin St", "891 Nothin St", "233 Anthin St", 
				"322 Somethin St"
			 };
		return address[ThreadLocalRandom.current().nextInt(0, address.length-1)];
	}
	
	private static double generateRandCourseFee() {
		return ThreadLocalRandom.current().nextDouble(3000, 5000);
	}
	
	private static boolean generateRandEnrolment() {
		return ThreadLocalRandom.current().nextInt(2) == 1 ? true : false;
	}
	
}
