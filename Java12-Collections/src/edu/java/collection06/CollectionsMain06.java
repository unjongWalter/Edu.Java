package edu.java.collection06;

import java.util.Set;
import java.util.TreeMap;

// List<E>, Set<E> : 한 가지 타입의 데이터를 저장할 수 있는 Collection
// Map<K, V> : Key-value 쌍으로 데이터를 저장하는 구조, k 중복가능, v 중복불가
//				1. Key는 중복되지 않는 값만 저장 가능
//				2. value는 중복된 값도 저장 가능
//				3. 검색, 수정, 삭제할 때 key값 사용

// HashMap<K,V> : 검색을 빠르게 하기 위한 Hash 알고리즘 적용 Map
// TreeMap<K,V> : 정렬을 빠르게 하기 위한 Hash 알고리즘 적용 Map

public class CollectionsMain06 {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		// Map<K, V>에 데이터 저장 : put(key, value)
		map.put(16 , " 황의조");
		map.put(7 , " 손흥민");
		map.put(18 , " 이승우");
		System.out.println(map);
		
		// Map<K, V>의 데이터 하나 검색 : get(key)
		// - 해당 key 값의 value를 리턴
		System.out.println(map.get(7));
		System.out.println(map.get(16));
		System.out.println(map.get(18));
		
		System.out.println();
		// Map<K, V>에서 데이터를 수정 : put(key, value)
		map.put(7, "김병지"); // 있던 데이터에 덧씌워져 결국 수정됨
		System.out.println("추가 된 사람 : " + map.get(7));
		System.out.println(map);
		
		System.out.println();
		// Map<K, V>에서 데이터를 삭제 : remove(key)
		map.remove(7);
		System.out.println(map);
		
		System.out.println();
		// Map<K, V>에서 key들로만 이루어진 Set을 생성 : KetSet()
		Set<Integer> keyset = map.keySet();		
		
	}//end main()

} //end CollectionsMain06
