package io.github.heinrichquirit.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import io.github.heinrichquirit.main.objects.Course;
import io.github.heinrichquirit.main.objects.Student;

public class ObjectFileReader {

	public List<Student> loadAllStudents() {
		ArrayList<Student> temp = new ArrayList<Student>();
		File dir = new File("student/");
		if (dir.isDirectory()) {
			for (File f : dir.listFiles()) {
				try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(f))) {
					temp.add((Student)os.readObject());
					if (temp.size() == dir.list().length) {
						// Now we know that all saved students have been transferred to the list
						return temp;
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public List<Course> loadAllCourses() {
		ArrayList<Course> temp = new ArrayList<Course>();
		File dir = new File("courses/");
		if (dir.isDirectory()) {
			for (File f : dir.listFiles()) {
				try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(f))) {
					temp.add((Course)os.readObject());
					if (temp.size() == dir.list().length) {
						// Now we know that all saved courses have been transferred to the list
						return temp;
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
}