package util;

import java.util.HashSet;
import java.util.Map;

import client.CourseManagementSystem;
import model.Course;
import model.Student;

public class Utils {

	public static boolean studentIsInCourse(int studentId) {
		HashSet<Integer> studentIds = new HashSet<Integer>();
		Map<String, Course> courses = CourseManagementSystem.getInstance().getCourses();
		for (Student s : courses.get("cooking").getStudents()) {
			studentIds.add(s.getId());
		}
		for (Student s : courses.get("sewing").getStudents()) {
			studentIds.add(s.getId());
		}
		for (Student s : courses.get("writing").getStudents()) {
			studentIds.add(s.getId());
		}
		return studentIds.contains(studentId);
	}
	
	public static String findStudentCourses(int studentId) {
		StringBuilder sb = new StringBuilder();
		Map<String, Course> courses = CourseManagementSystem.getInstance().getCourses();
		for (Student s : courses.get("cooking").getStudents()) {
			if (s.getId() == studentId) {
				sb.append("Cooking");
				continue;
			}
		}
		for (Student s  : courses.get("sewing").getStudents()) {
			if (s.getId() == studentId) {
				sb.append("Sewing");
				continue;
			}
		}
		for (Student s  : courses.get("writing").getStudents()) {
			if (s.getId() == studentId) {
				sb.append("Writing");
			}
		}
		return sb.toString();
	}
	
}
