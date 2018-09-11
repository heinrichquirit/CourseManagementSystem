package client;

import java.io.File;

import model.CourseMenu;

public class CourseManagementSystem {

	public static void main(String[] args) {
		
		// Load directories for file storage
		loadDirectories();
		
		CourseMenu c = new CourseMenu();
		c.displayOptions();
	}
	
	private static void loadDirectories() {
		File studentDir = new File("students/");
		File courseDir = new File("courses/");
		
		studentDir.mkdir();
		courseDir.mkdir();
		System.out.println("Successfully loaded directories.\n");
	}
	
	
}
