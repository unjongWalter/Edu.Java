package edu.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 프로그램 <== FileInputStream <== 파일
// FileInputStream 클래스의 read()메소드를 사용하여 파일을 읽음

// 프로그램 ==> FileOutputStream ==> 파일
// FileOutputStream 클래스의 write()메소드를 사용하여 파일에 쓴다

public class FileMain02 {

	public static void main(String[] args) {
		// temp/original.txt 파일에서 데이터를 읽어서
		// temp/copy.txt 파일에 데이터를 쓴다
		InputStream in = null;
		OutputStream out = null;
		
		try { // 빨갱이짓 ㄱ, try catch
			// 파일에서 데이터를 읽어올 통로인 FileInputStream 객체 생성
			in = new FileInputStream("temp/original.txt");
			
			// 파일에서 데이터를 쓸 통로인 FileOutputStream 객체 생성
			out = new FileOutputStream("temp/copy.txt");
			
			int data = 0; // 퍼다 나를 그릇, read() 메소드 리턴하는 값 저장변수
			int byteCopied = 0; // write() 메소드를 호출할 떄 마다 1씩 증가
			while (true) {
				// read() : 파일에서 1바이트씩 데이터를 읽어옴
				// 파일 끝에 도달했을 때 -1을 리턴
				data = in.read(); // 빨갱이짓 두번쨰
				System.out.println(data);
				if(data == -1) { // 걍 외워라
					break;
				}				
				// write() : 1바이트씩 파일에 쓴다
				out.write(data); // read 했으니 write 하자...			
				byteCopied++;			
			}		
			// 1byte씩 퍼다 나른다... 어쩌라고... 슈밥...
			System.out.println(byteCopied + "바이트 복사됬나벼");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}//end main()
}//end FileMain02
