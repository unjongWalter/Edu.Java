package edu.java.file09;

import java.io.File;

public class FIleMain09 {

	public static final String TEST1 = "test1";
	public static final String TEST2 = "test2";
	public static final String DUMMY = "dummy.txt";
	
	public static void main(String[] args) {
		// 파일, 디렉토리 이름 변경/삭제
		// test1 -> test2 디렉토리 이름 변경
		File org = new File(TEST1);
		File dest = new File(TEST2);
		
		if(org.renameTo(dest)) {
			System.out.println("디렉토리 이름 변경 성공");			
		} else {
			System.out.println("디렉토리 이름 변경 실패");
		}
		
		// test2\dummy.txt 파일 삭제
		String filePath = TEST2 + File.separator + DUMMY;
		File file = new File(filePath);
		if(file.delete()) {
			System.out.println("파일 삭제 성공");
		} else {
			System.out.println("파일 삭제 실패");
		}
		
	} // end main()

} //end FileMain09
