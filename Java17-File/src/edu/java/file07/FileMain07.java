package edu.java.file07;

import java.io.File;

// File 클래스 :
// 		파일(txt, doc, mp4, jpg, png, ..) 객체와
// 		디렉토리(폴더) 객체를 다루기 위한 클래스
// File 클래스의 인스턴스 생성 : new File();
// 		메모리(힙)에 File 클래ㅡ의 인스턴스를 생성한다는 의미
//		실제 하드디스크에 있는 물리적인 파일/풀더(디렉토리)를 생성하는 것은 아님
//		실제 파일/폴더를 만들기 위해서는 File 클래스의 메소드를 호출해야 함

// 파일(디렉토리)의 경로 : 절대 경로, 상대 경로
// 절대 경로 : 루트(C:\, D:\)부터 파일(폴더)의 위치까지 전체 이름
// 	예) C:\Study\JabaClass\temp
// 상대 경로 : 현재 작업 디렉토리를 기준으로 파일(폴더)가 어디에 있는지 표시
//	예) temp\test.txt
// .: 현재 디렉토리(폴더)
// .. : 상위 디렉토리(폴더)

// 파일 구분자(file separator) - 운영체제(OS)마다 다르게 사용
// 		MS Windows - \ 사용
// 		Unix, Linux, Android, ... - / 사용
// 자바에는 File.separator라는 변수를 제공

public class FileMain07 {
	public static final String TEST_DIR1 = "C:\\test1";
	public static final String TEST_DIR2 = "test2";
	public static final String TEST_DIR3 = 
			"C:" + File.separator + "Study" + File.separator + "test3";

	public static void main(String[] args) {
		
		System.out.println(TEST_DIR1);
		System.out.println(TEST_DIR2);
		System.out.println(TEST_DIR3);
		
		File f = new File(TEST_DIR3); // 파일, 폴더(디렉토리)를 다루기 위한 객체
		// exists() : 파일, 폴더가 존재하는지(true), 아닌지 (false)를 리턴
		
		if(!f.exists()) { // 존재하지 않는 경우!
			System.out.println("폴더가 없넹? 우짤래?");
			// mkdirs() : 상위디렉토리를 포함하여 생성하는 메소드
			// mkdir() : 디렉토리를 생성하는 메소드, 성공 true, 실패 false 리턴
			if(f.mkdirs()) { // 미친!!! 개쩔어!!!
				System.out.println("생성 성공 ㅜㅜㅜ"); // 한번 생성하면 끝!
			} else {
				System.out.println("생성 실패스 ㅋㅋㅋ");
			}			
		} else  { // 존재하는 경우~
			System.out.println("폴더가 있넹~ 좋겠네~"); // 또 실행하면 있다고 나오겠지...
		}
				
	}//end main()

}//end FileMain07
