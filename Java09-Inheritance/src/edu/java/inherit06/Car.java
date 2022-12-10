package edu.java.inherit06;

public class Car {
	// 멤버 변수
	private int fuel;

	public Car() {}
	
	public Car(int fuel) {
		super();
		this.fuel = fuel;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	@Override
	public String toString() {
		return "Car [fuel=" + fuel + "]";
	}
	
	public void display() {
		System.out.println("Car's energy : " + fuel);
	}
	
}
