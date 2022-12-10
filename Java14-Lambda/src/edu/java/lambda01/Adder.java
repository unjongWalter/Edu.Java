package edu.java.lambda01;
// Functional Interface : 추상 메소드가 하나뿐인 메소드
// 람다(lambda) 표현식은 @functional interface만 사용 가능

@FunctionalInterface // annotation
public interface Adder { // 메서드 하나면 익명클래스 잦다

	public abstract double add(double x, double y);
	
}
