package edu.java.access07;

public class AccessMain07 {

	public static void main(String[] args) { //num1, num2가 객체, 인스턴스
		MyNumber num1 = new MyNumber();
		System.out.println(num1);// num1의 인스턴스 참조값(주소값) 출력 // result의 주소값과 같다.
		num1.setNumber(5);
		System.out.println(num1.getNumber());		

		MyNumber num2 = new MyNumber(10);
		System.out.println(num2.getNumber());
		
		MyNumber result = num1.add(num2);
		// num1 객체의 number와 num2 객체의 number 값을 더해서
		// num1 객체의 number 변수에 저장하고, 그 객체를 반환한다.
		System.out.println(result); // num1의 주소값과 같다. 주소값(저장위치)
		
		System.out.println(result.getNumber()); // 값은 15.
		
		System.out.println("===============");
		
		MyNumber x = new MyNumber(1);
		MyNumber y = new MyNumber(2);
		MyNumber z = new MyNumber(3);
		MyNumber end = new MyNumber(4);
		
		x.add(y).add(z).add(end); 
		System.out.println(x.getNumber());
		
		x.setNumber(1); // 28열과 동일
		MyNumber r1 = x.add(y);
		MyNumber r2 = r1.add(z);
		MyNumber r3 = r2.add(end);
		System.out.println(r3.getNumber());
		
		
	} //end main()

} //end AccessMain07
