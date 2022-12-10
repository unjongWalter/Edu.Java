package edu.java.contact05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

// 객체지향, 부품화..., ver4에 ContactDAOImple만 건들자...
// 데이터를 집어넣기위한 연결고리!
public class ContactDAOImple implements ContactDAO { // delete 구현이안되어서

	// 싱글 패턴을 사용하여 인스턴스를 생성, ContactDAO.java의 추상 메소드들을 오버라이딩해서
	// 실제 기능 메소드들을 구현
	// 1. private static 자기자신 타입 멤버변수 선언
	private static ContactDAOImple instance = null;
	
	// 2. private 기본 생성자
	private ContactDAOImple() { // 파일 쓰기용
		initDataDir(); // 여따다가 쳐넣냐... 시불... 10불...
		initDataFile();
	}

	// 3. public static method ~ instance를 return하는 method
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;

	} // end ContactDAOImple get

	// 데이터를 저장할 폴더와 파일 이름 정의
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";

	// data 폴더의 contact.data 파일을 관리할 File 객체 선언
	private File dataDir;
	private File dataFile;

	// private final int MAX = 100; // 최대 갯수 제한 불필요 -> 단점보완필요
	private ArrayList<ContactVO> list = new ArrayList<>(); // 연락처 저장할 배열

	// data 폴더가 있는지 검사하고, 없으면 새로 생성해보자
	private void initDataDir() { // 신규추가
		System.out.println("initDataDir() 함수");
		dataDir = new File(DATA_DIR);
		System.out.println("폴더 경로 : " + dataDir.getPath());
		System.out.println("절대 경로 : " + dataDir.getAbsolutePath());

		if (!dataDir.exists()) { // 폴더가 없으면
			if (dataDir.mkdirs()) {
				System.out.println("<폴더 생성 성공>");
			} else {
				System.out.println("<폴더 생성 실패>");
			}
		} else { // 폴더가 있으면
			System.out.println("<폴더가 이미 존재>");
		}

	}// end initDataDir

	// 데이터 파일이 있는지 검사하고,
	// 없는 경우 - 새로운 데이터 파일 생성
	// 있는 경우 - 파일에서 데이터를 읽어서 ArrayList로 채움
	private void initDataFile() {
		System.out.println("initDataFile() 호출");
		String filePath = DATA_DIR + File.separator + DATA_FILE;
		dataFile = new File(filePath);
		
		System.out.println("파일 경로 : " + dataFile.getPath());
		System.out.println("절대 경로 : " + dataFile.getAbsolutePath());

		if (!dataFile.exists()) { // 데이터 파일이 없으면
			try {
				if (dataFile.createNewFile()) { // 없으니께 만든다
					System.out.println("<새로운 데이터 파일 생성>");
				//	writeDataToFile(); // list가 비어도 file에 저장하나봐...
				} else {
					System.out.println("<파일 생성 실패>");
				}
			} catch (IOException e) { // IOE로 교체
				System.out.println(e.toString());
				e.printStackTrace(); // 추가 교체
			}

		} else { // 데이터 파일이 있으면
			System.out.println("<기존 데이터 있음>");
			if(dataFile.length() != 0) {// 아닐때 불러와봐???
			readDataFromFile(); // 신규추가	
			}
			// TODO : 파일에서 데이터를 읽어서 list 변수에 저장
		}

	}// end initDataFile()

	// TODO : 멤버 변수 list 객체를 data\contact.data 파일에 저장(쓰기)
	private void writeDataToFile() {
		System.out.println("writeDataToFile() 호출");
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream(dataFile); // 기존 내용과 헷갈릴 수 있어
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);

			oout.writeObject(list); // 어디다 쓸래?
			// list 데이터가 있는 상황을 파일에 저장!
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// end writeDataToFile()

	// TODO : data\contact.data 파일에서 ArrayList 객체를 읽어와서
	// 멤버 변수 list에 저장
	private void readDataFromFile() {
		System.out.println("readDataFromFile() 호출");
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream(dataFile); // dataFile이 관건
			bin = new BufferedInputStream(in); // in 조심
			oin = new ObjectInputStream(bin);		
//			System.out.println(bin);// 로그 찍기
//			list = (ArrayList<ContactVO>) oin.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}// end readDataFromFile()

	// writeDataToFile()을 호출해야하는 곳에 대해 고민해봐라...
	// 파일은 읽기/쓰기 밖에 없는데, update와 delete는 우짜꼬?
	// update, delete는 list의 데이터를 변경시킨다.
	// 변경한 데이터를 저장하는 것으로 해결이 될 거 같다.

	public int getListSize() { // public ... 필요한것 작성추가
		return list.size(); // 이놈 역할이...??? 
	}
	// private int count; // 배열에 저장할 데이터 갯수, private로 막아뒀어...
	// public int getCount() { // count를 MemberMain에서 사용하기위해 뚫자
	// return count;
	// }

	@Override
	public int insert(ContactVO vo) { // 등록이니까 카운트 추가해
		list.add(vo); // Array List에 데이터 저장 필요, 글쓰자
		writeDataToFile(); // 변경된 상황 이후에 넣자
		// count++; // 파일에 데이터 어떤 형태로 저장...?
		return 1;
	}

	@Override
	public ArrayList<ContactVO> select() { // 전체검색
		return list; // 파일에서 데이터(?) 가져와서 list에 준대..;;
	}

	@Override
	public ContactVO select(int index) { // 파일에서 갖고와서 보여줄게 완죠니달라진놔~
		return list.get(index); // list에서 index를 리턴해보자
	}

	@Override
	public int update(int index, ContactVO vo) {
		list.set(index, vo); // 퀴즈와 관련...+ 파일에 데이터 어떤형태를 저장....??? set > add로 바꿈??/
//		list.get(index).setName(vo.getName());
//		list.get(index).setPhone(vo.getPhone());
//		list.get(index).setEmail(vo.getEmail());
		writeDataToFile(); // 변경된 상황 이후에 넣자
		return 1;
	}

	@Override
	public int delete(int index) { // 변경, 삭제니까 줄어들어야지...
		list.remove(index); // 파일에... 데이터 어떤형태를 저장...
		writeDataToFile(); // 변경된 상황 이후에 넣자
		// count--;
		return 1;
	}

} // end ContactDAOImple