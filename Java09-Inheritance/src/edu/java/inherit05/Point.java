package edu.java.inherit05;

public class Point {

	private double x;
	private double y;
	
	public Point() {}
	
	public Point(double x, double y) {
		
		this.x = x;
		this.y = y;
		
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
