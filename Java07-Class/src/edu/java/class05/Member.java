package edu.java.class05;

public class Member {
	public boolean login(String id, String password) {
		if (id.equals("test") && password.equals("1234")) {
			// id == "test" : 주소값 비교
			// id.equals("test") : 실제 데이터 비교, 문자열 비교는 무조건 equals를 사용해.
			return true;
		} else {
			return false;
		}
	} //end
} //end
