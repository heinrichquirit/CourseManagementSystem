package io.github.heinrichquirit.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import io.github.heinrichquirit.main.enums.CourseType;
import io.github.heinrichquirit.main.objects.Course;
import io.github.heinrichquirit.main.objects.Student;
import io.github.heinrichquirit.main.util.ObjectFileReader;
import io.github.heinrichquirit.main.util.ObjectFileWriter;

public class CourseManagementSystem {
	
	private static CourseManagementSystem instance;
	private static HashMap<String, Course> courseMap = new HashMap<String, Course>();
	private static ObjectFileWriter writer;
	private static ObjectFileReader reader = new ObjectFileReader();
	private static File cookingFile;
	private static File sewingFile;
	private static File writingFile;
	private static File sampleStudentFile;
	private static List<Student> students;
	private static List<Course> coursesList;
	
	private CourseManagementSystem() {
		instance = this;
	}
	
	public static void main(String[] args) {
		new CourseManagementSystem();
		// Load directories for file storage
		loadDirectories();
		loadSavedData();
		// If there is no initial data, load sample 
		loadSampleData();
		loadMap();
		
		// print sample course data
		// print sample student data
		
		System.out.println("Listing sample cooking students.");
		
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
	
	public static void loadSavedData() {
		students = reader.loadAllStudents();
		coursesList = reader.loadAllCourses();
	}
	
	private static void loadSampleData() {
		// Cooking course data
		HashSet<Student> cookingStudents = new HashSet<Student>();
		String cookInfo = "\nContact: gordon@uni.com\nWorld renowned chef, has 3 Michellin starts to his name.";
		Course cooking = new Course("0001", "Gordon Ramsay", cookInfo, 75, 4500, cookingStudents, 1000, 3000, CourseType.COOKING);
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
		String sewInfo = "\nContact: nanny@uni.com\nOld lady, likes to baby sit children while knitting clothes.";
		Course sewing = new Course("0002", "Nanny Doubtfire", sewInfo, 60, 3000, sewingStudents, 750, 2500, CourseType.SEWING);
		for (int i=0; i<=sewing.getEnrolmentCapacity(); i++) {
			sewingStudents.add(new Student(
											generateRandName(), 
											generateRandAge(), 
											generateRandAddress(),
											generateRandCourseFee(), 
											generateRandEnrolment())
										   );
		}
		// Writing course data
		HashSet<Student> writingStudents = new HashSet<Student>();
		String writeInfo = "\nContact: steven@uni.com\nDirector of the highest calibre, has created many movies.";
		Course writing = new Course("0004", "Steven Spielberg", writeInfo, 90, 5000, writingStudents, 1250, 4000, CourseType.WRITING);
		for (int i=0; i<=writing.getEnrolmentCapacity(); i++) {
			writingStudents.add(new Student(
											generateRandName(), 
											generateRandAge(), 
											generateRandAddress(),
											generateRandCourseFee(), 
											generateRandEnrolment())
										   );
		}
		
		cookingFile = new File("courses/" + cooking.getCourseId() + ".dat");
		writer = new ObjectFileWriter(cookingFile, cooking);
		writer.save();
		sewingFile = new File("courses/" + sewing.getCourseId() + ".dat");
		writer = new ObjectFileWriter(sewingFile, sewing);
		writer.save();
		writingFile = new File("courses/" + writing.getCourseId() + ".dat");
		writer = new ObjectFileWriter(writingFile, writing);
		writer.save();
		
		List<Student> studentTemp = new ArrayList<Student>();
		for (Student s : cooking.getStudents()) {
			studentTemp.add(s);
		}
		for (Student s : sewing.getStudents()) {
			studentTemp.add(s);	
		}
		for (Student s : writing.getStudents()) {
			studentTemp.add(s);
		}
		
		// Make a check to prevent more than 100 files being created
		int dirSize = new File("students/").listFiles().length;
		if (dirSize < 100) {
			for (Student s : studentTemp) {
				sampleStudentFile = new File("students/" + s.getId() + ".dat");
				writer = new ObjectFileWriter(sampleStudentFile, s);
				writer.save();
			}
		} else {
			System.out.println("Cannot create anymore sample student files! Limit exceeded ("+ dirSize +")!");
		}
	}
	
	private static void loadMap() {
		courseMap.put("cooking", coursesList.get(0));
		courseMap.put("sewing", coursesList.get(1));
		courseMap.put("writing", coursesList.get(2));
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
	
	// #getInstance used to access getters for courses
	
	public synchronized static CourseManagementSystem getInstance() {
		if (instance == null) {
			instance = new CourseManagementSystem();
		}
		return instance;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public List<Course> getCourses() {
		return coursesList;
	}
	
	public Map<String, Course> getMap() {
		return courseMap;
	}
	
}
