package edu.java.inherit08;

public class Manager extends Employee {
	private String type;

	public Manager(String name, String type) {
		super(name);
		this.type = type;
	}

	public Manager() {
		super();
		
	}

	public String getType() {
		return type;
	}

//	public void setType(String type) {
//		this.type = type;
//	}	
	
	@Override // test ctrl space
	public void test() {
		System.out.println("매니져");
		super.test();
	}
	
}
