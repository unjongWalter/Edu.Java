package edu.java.inherit10;

import edu.java.inherit09.Test2;

public class Test3 extends Test2 {
	@Override
	public void display() {
//		System.out.println("a = " + a); // private
//		System.out.println("b = " + b); // package
		System.out.println("c = " + c); // protected
		System.out.println("d = " + d); // public
	}

}
