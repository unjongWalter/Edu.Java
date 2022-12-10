package edu.java.inherit06;

public class HybridCar extends Car {
	// 멤버 변수
	private int battery;

	public HybridCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HybridCar(int battery) {	
		this.battery = battery;
		// TODO Auto-generated constructor stub
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "HybridCar [battery=" + battery + "]";
	}
		
	@Override
	public void display() {
		System.out.println("하이브리드 자동차 연료 : " + getFuel());
		System.out.println("하이브리드 자동차 배터리 : " + battery);
	//	super.display();
	}
		
}
