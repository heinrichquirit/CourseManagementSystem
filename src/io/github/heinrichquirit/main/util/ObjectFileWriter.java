package io.github.heinrichquirit.main.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectFileWriter {
	
	private File file;
	private Object object;
	
	public ObjectFileWriter(File file, Object obj) {
		this.file = file;
		this.object = obj;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(file.getName() + " file cannot be created.");
			}
		}
	}
	
	public void save() {
		// Allows us to stream data to specified file
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
			os.writeObject(object);
			// Don't need to invoke close() as the new try-with-resources syntax handles it
		} catch (FileNotFoundException e) {
			System.out.println(file.getName() + " file cannot be found.");
		} catch (IOException e) {
			System.out.println("Cannot save to file " + file.getName());
		}
	}
	
}