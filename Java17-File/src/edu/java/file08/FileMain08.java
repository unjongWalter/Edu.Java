package edu.java.file08;

import java.io.File;
import java.io.IOException;
// 상대경로쓴다
public class FileMain08 {
	
	public static final String DIR_NAME = "test1";
	public static final String FILE_NAME = "dummy.txt";
 	public static final String FILE_PATH = 
 		DIR_NAME + File.separator + FILE_NAME;
	// C:\Users\goott07\eclipse-workspace\Java17-File\src\edu\java\file08\FileMain08.java
 	// => (현재 프로젝트 위치)\test1\dummy.txt
 	
	public static void main(String[] args) {
		System.out.println(FILE_PATH);
		
		File f = new File(FILE_PATH);
		
		if(!f.exists()) {
			System.out.println("without any file");
			
			// createNewFile() : 새로운 빈 파일을 생성
			try { // 당연하게도 폴더부터 경로에 맞게 생성하고... 
				if(f.createNewFile()) { // 파일만 생성, 폴더는 안만들어주는디?
					System.out.println("success");
				} else {
					System.out.println("fail");
				}				
			} catch (IOException e) {
				System.out.println(e.toString()); // 까먹지마래이... 
			} 
			
		} else {
			System.out.println("exsist file");
		}	

	}//end main()

}//end FileMain08
