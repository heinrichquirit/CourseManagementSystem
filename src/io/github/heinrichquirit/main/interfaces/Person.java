package io.github.heinrichquirit.main.interfaces;

public interface Person {

	/**
	 * 
	 * @return human readable name
	 */
	public abstract String getName();
	
	/**
	 * 
	 * @param name human readable name
	 */
	public abstract void setName(String name);
	
	/**
	 * 
	 * @return person's age
	 */
	public abstract int getAge();
	
	/**
	 * 
	 * @param age set person's age
	 */
	public abstract void setAge(int age);
	
}
