package edu.java.collection03;

import java.util.LinkedList;
import java.util.List;

// Collection<E> : 자료(데이터)를 저장하기 위한 Generic 클래스
// |_ List<E>, Set<E>
// |_ Map<K, V>

// List<E>
// 1. 자료들이 저장되는 순서가 중요 -> 인덱스 사용
// 2. 중복된 값들의 저장을 허용

// List<E>
// |_ ArrayList<E>, LinkedList<E>

// ArrayList<E> 삭제 노굳, 검색 굳
// 1. 내부적으로 배열 자료구조를 사용
// 2. 저장 용량을 늘리는 과정에 많은 시간 소요 = 단점
// 3. 저장된 데이터를 삭제하는데 많은 시간 소요 = 단점
// 4. 데이터참조(검색)할 떄 매우 빠름 = 장점

// LinkedList<E> 삭제 굳, 검색 노굳
// 1. 내부적으로 LinkedList 자료구조를 사용
// 2. 저장 용량을 늘리는 과정이 매우 간단 = 장점
// 3. 저장된 데이터를 삭제하는 과정 매우 간단 = 장점
// 4. 데이터 참조(검색)하는 시간이 매우 느림 = 단점

// ArrayList<E>, LinkedList<E> 에서 사용되는 메소드들 (형변환 등 가능)
// add(element), get(index), set(index, element), remove(index)

public class CollectionsMain03 {

	public static void main(String[] args) {
		// String을 저장할 수 있는 LinkedList 객체 생성
		List<String> list = new LinkedList<String>(); // 다형성
		
		list.add("월요일");
		list.add("입니다.");
		list.add("내일은");
		list.add("아직 화요일밖에...");
	
		for(String x : list) {
			System.out.println(x);			
		}
		
		list.set(3, "금요일에 만나요~"); // index 3에 들어감!
		for(String x : list) {
			System.out.println(x);
		}
		
		list.remove(3);
		for(String x : list) {
			System.out.println(x);
		}
		
	}//end main()

}//end CollectionsMain03
