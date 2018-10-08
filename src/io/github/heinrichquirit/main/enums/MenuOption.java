package io.github.heinrichquirit.main.enums;

public enum MenuOption {
	
	OPTION_ONE(1,"1. Add a student to a course"),
	OPTION_TWO(2, "2. Withdraw a student from a course"),
	OPTION_THREE(3, "3. Display a student list for a course"),
	OPTION_FOUR(4, "4. Display the course figures"),
	OPTION_FIVE(5, "5. Display course teacher information."),
	OPTION_SIX(6, "6. Add payment options."),
	OPTION_SEVEN(7, "7. Enable Student Nofications."),
	OPTION_EIGHT(8, "8. Register or View for Catch up session"),
	OPTION_NINE(9, "9. Quit");
	
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
