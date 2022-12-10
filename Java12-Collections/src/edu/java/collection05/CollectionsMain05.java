package edu.java.collection05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Collection<E>
// |_ Set<E>
//		HashSet<E>, TreeSet<E>

// Set<E>
// 1. 데이터의 저장 순서가 중요하지 않음 -> 인덱스 ㄴㄴ
// 2. 중복된 데이터의 저장을 허용하지 않음
// 예> {1, 2, 2, 3, 3, 3} = {1, 2, 3}

// HashSet<E> : 검색을 빠르게 하기 위한 Hash 알고리즘이 적용된 Set
// TreeSet<E> : 정렬을 빠르게 하기 위한 Tree 알고리즘이 적용된 Set

public class CollectionsMain05 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		// Set에 대이터 저장 : add(element)
		set.add(300);
		set.add(100);
		set.add(200);
		set.add(300);
		System.out.println("size : " + set.size()); // 중복 개무시함
		
		// Set<E>은 인덱스로 데이터를 읽어올 수 있는 get() 메소드 제공 ㄴㄴ
		for(Integer x : set) {
			System.out.println(x);
		}
		
		System.out.println();
		// Iterator(반복자)를 사용한 데이터 검색
		// -Iterator 메소드
		//  iterator() : Iterator 객체를 리턴
		//  hasNext() : Iterator 객체가 가리키는 위치에
		//			원소가 있는지(true) 없는지(false)를 리턴하는 메소드
		//  next() : Iterator 객체가 가리키는 위치를 다음 위치로 이동하고,
		//			원래 가리키고 있던 값을 리턴하는 메소드
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());			
		}
		//Iterator 인터페이스 : 컬렉션 프레임워크의 표준 인터페이스
		List<Integer> list = new ArrayList<>();
		itr = list.iterator();
		
		// Set<E>의 원소를 삭제 : remove(element)
		// 인덱스가 없으므로 값 자체를 삭제한다. 변경이 없다! 위치가 없으니께!
		set.remove(300);
		System.out.println("삭제 후");
		for(Integer x : set) {
			System.out.println(x);			
		}
		// 데이터 변경을 위한 set(index, element) 메소드를 제공 ㄴㄴ
		// 데이터 변경 => 데이터 삭제(remove) + 데이터 추가(add)
		set.remove(200);
		set.add(500);
		System.out.println("변경 후 2"); // 위 300은 이미 삭제됨.
		for(Integer x : set) {
			System.out.println(x);			
		}
		
	} //end main()

} //end CollectionsMain05
