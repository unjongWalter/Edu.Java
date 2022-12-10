package edu.java.lambda03;

@FunctionalInterface
interface Test1 {
	public abstract void printMax(int x, int y);
}// end Test1

@FunctionalInterface
interface Test2 {
	public abstract int findMax(int x, int y);	
}// end Test2

public class LambdaMain03 {
	public static void main(String[] args) {
		// 람다 표현식을 이용하여 구현
		Test1 test1 = (x, y) -> {
			int max;
			if(x > y) {
				max = x;
			} else {
				max = y;
			}
			System.out.println("max : " + max);					
		};
		test1.printMax(100, 1010);
		
		Test2 test2 = (x, y) -> (x > y) ? x : y;
		// x, y 중에 x가 크면(참이면) x를 리턴, 역이면 y를 리턴
		System.out.println("max : " + test2.findMax(10, 5));		

	} //end main()
} //end LambdaMain03
