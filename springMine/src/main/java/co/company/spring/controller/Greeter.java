package co.company.spring.controller;

public class Greeter {
	private String format;
	public String greet(String guest) {
		return String.format(format,  guest);
	}
	public void setFormat(String format) {
		this.format = format;
	}
}
