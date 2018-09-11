package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import util.CourseType;
import util.MenuOption;

public class CourseMenu {
	
	private Scanner in = new Scanner(System.in);
	private ArrayList<MenuOption> options = new ArrayList<MenuOption>(Arrays.asList(MenuOption.values()));
	
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
					+ "\nCooking\nSewing\nWriting:\n");
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
		
		// Check if is enrolled in course
		// Or course is full
		
	}
	
	private void withdrawStudent() {
	
	}
	
	private void displayStudent(CourseType type) {
		
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
