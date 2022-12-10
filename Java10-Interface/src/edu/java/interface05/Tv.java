package edu.java.interface05;

public class Tv implements RemoteController {

	@Override
	public void turunOn() {
		System.out.println("TV on");
	}

	@Override
	public void turunOff() {
		System.out.println("TV off");
	}
}
