package edu.java.homework;

public class HomeWork4 {

	public static void main(String[] args) {
		Point pt1 = new Point(6,3);
		pt1.getX();
		Point pt2 = new Point(3,6);
		
		double d = pt1.distance(pt2);
		System.out.println("두 점 사이의 거리 : " + d);
		
	}

}
