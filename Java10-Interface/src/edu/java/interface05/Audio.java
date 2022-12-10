package edu.java.interface05;

public class Audio implements RemoteController{

	@Override
	public void turunOn() {
		System.out.println("Audio On");		
	}

	@Override
	public void turunOff() {
		System.out.println("Audio Off");		
	}

}
