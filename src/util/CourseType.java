package util;

public enum CourseType {

	COOKING(1, "Cooking"),
	SEWING(2, "Sewing"),
	WRITING(3, "Writing");
	
	private final int id;
	private final String name;
	
	CourseType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
}
