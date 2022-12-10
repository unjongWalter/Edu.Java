package edu.java.collection01;

import java.util.ArrayList;

// * List<> 클래스
// 배열과 같은 역할을 Generic 클래스로 생성한 형태
// 배열은 저장되는 한계를 지정해줘야하지만, List는 저장의 한계가 없음
// 추가하는 만큼 저장 공간을 늘려줌, 감소하는 만큼 줄여주기도 해야해...
// 주요 메소드 :
// add() : 원소 추가
// get() : 원소 읽기
// set() : 원소 변경
// remove() : 원소 삭제

public class ListMain01 {// 자료구조, 중요챕터

	public static void main(String[] args) {
		int[] list1 = new int[3];
		list1[0] = 1;
		System.out.println(list1.length);
		// 배열의 길이는 데이터가 저장된 개수와 상관없이 고정
		// 배열에 저장된 데이터의 개수를 확인하기 어려움
		
		ArrayList<Integer> list = new ArrayList<>(); // default : 0
		System.out.println("리스트 크기 : " + list.size()); // length 대신
		
		// ArrayList에 원소(element) 추가 : add() 메소드 사용
		list.add(100); // index = 0
		list.add(200); // index = 1
		list.add(300); // index = 2
		list.add(400); // index = 3
		System.out.println("리스트 크기 : " + list.size());
		
		// ArrayList에 있는 원소 참조(읽기) : get(index) 메소드 사용
		System.out.println(list.get(0));
		System.out.println(list.get(2));
//		System.out.println(list.get(4)); // 불가, error code
		System.out.println("====");
		// for-each()
		// for(원소타입 변수이름 : 배열 또는 컬렉션) {...}
		for(Integer n : list) { // for(int n : list){}도 가능
			System.out.println(n);
		}
		System.out.println();
		// ArrayList에서 특정 언덱스의 원소를 변경 : set(index, value)
		list.set(0, 1111);
		list.set(2, 2222);
		for(Integer n : list) {
			System.out.println(n);
		}
		System.out.println("=====");
		// ArrayList에서 특정 인덱스의 원소를 삭제 : remove(index)
		list.remove(1);
		System.out.println("리스트의 크기 : "+ list.size());
		for(int i = 0; i <list.size(); i++) { // 해당 공간 자체를 삭제, 유용해
			System.out.println("index : " + i+", value : " + list.get(i));
		}
				
	} //end main()

}//end ListMain01
