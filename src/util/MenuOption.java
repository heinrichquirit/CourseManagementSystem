package util;

public enum MenuOption {
	
	OPTION_ONE(1,"1. Add a student"),
	OPTION_TWO(2, "2. Withdraw a student"),
	OPTION_THREE(3, "3. Display a student list for a course"),
	OPTION_FOUR(4, "4. Display the course figures"),
	OPTION_FIVE(5, "5. Quit");
	
	private final int id;
	private final String description;
	
	MenuOption(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
}
