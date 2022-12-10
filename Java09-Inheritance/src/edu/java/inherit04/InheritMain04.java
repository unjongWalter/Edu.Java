package edu.java.inherit04;

public class InheritMain04 {

	public static void main(String[] args) {
		Animal animal = new Animal("동물");
		animal.speak();		

		System.out.println();
		Dog dog = new Dog("TOTO", "시고르자브종");
		dog.speak();
		
		System.out.println();
		Cat cat = new Cat();
		cat.speak();
		
		System.out.println("=======");
		Animal[] a = new Animal[2];
		a[0] = dog; // 부모형태에 자식을 넣기
		a[1] = cat; // 다양성, 자식이니까 넣기가능
		for(int i = 0; i < a.length; i++) {
			a[i].speak();
			
		}
		
	} //end main()

} //end InheritMain04
