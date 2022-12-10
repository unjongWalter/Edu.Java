package edu.java.contact03;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
// 객체지향, 부품화..., ver4에 ContactDAOImple만 건들자....
//
public class ContactDAOImple implements ContactDAO { // delete 구현이안되어서

	// 싱글 패턴을 사용하여 인스턴스를 생성, ContactDAO.java의 추상 메소드들을 오버라이딩해서
	// 실제 기능 메소드들을 구현
	// 1. private static 자기자신 타입 멤버변수 선언

	private static ContactDAOImple instance = null;

	// 2. private 기본 생성자

	private ContactDAOImple() {}

	// 3. public static method ~ instance를 return하는 method

	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();		
			}
		return instance;

	} // end ContactDAOImple get

	// 배열 저장 카운트 같은것 ㄱㄱ
//    private final int MAX = 100; // 최대 갯수 제한 불필요 -> 단점보완필요
	private ArrayList<ContactVO> list = new ArrayList<ContactVO>(); // 연락처 저장할 배열

	public int getListSize() { // public ... 필요한것 작성추가
		return list.size();
	}

	
	
  //  private int count; // 배열에 저장할 데이터 갯수, private로 막아뒀어...

	// public int getCount() { // count를 MemberMain에서 사용하기위해 뚫자

	// return count;

	// }

	@Override
	public int insert(ContactVO vo) { // 등록이니까 카운트 추가해
//	      list.add(vo); // Array list에 데이터 저장
	      OutputStream out = null;
	      BufferedOutputStream bout = null;
	      ObjectOutputStream oout = null;
	      
	      try {
	         out = new FileOutputStream("temp/contact.txt");
	         bout = new BufferedOutputStream(out);
	         oout = new ObjectOutputStream(bout);
	         list.add(vo);
	         
	         
	      } catch (Exception e) {
	         // TODO: handle exception
	      } finally {
	         
	      }
	      return 1;
	   }
	

	@Override
	public ArrayList<ContactVO> select() { // 전체검색
		return list; // 파일에서 데이터(?) 가져와서 list에 준대..;;
	}

	@Override
	public ContactVO select(int index) { // 파일에서 갖고와서 보여줄게 완죠니달리진놔~
		return list.get(index); // list에서 index를 리턴해보자
	}

	@Override
	public int update(int index, ContactVO vo) {
		list.set(index, vo); // 퀴즈와 관련...+ 파일에 데이터 어떤형태를 저장....
		
//		list.get(index).setName(vo.getName());
//		list.get(index).setPhone(vo.getPhone());
//		list.get(index).setEmail(vo.getEmail());
		return 1;
	}

	@Override
	public int delete(int index) { // 변경, 삭제니까 줄어들어야지....
		list.remove(index); // 파일에... 데이터 어떤형태를 저장...
	//	count--;
		return 1;

	}

} // end ContactDAOImple