package com.example.demo;

public class RegexpPattern {
	public static final String INTEGER = "^[0-9]+$";
	public static final String AUTHORITY = "^$";
	public static final String EMPTY = "^$";
	public static final String DATE = "^([1-2][0-9]{3})/(0?[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01])$";
	public static final String TIME = "^$";
	
	private RegexpPattern() {}
}
