package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/*
 1. 일반적인 try-catch-finally 구문
try {
 (실행문)
} catch (Exception e) {
 (예외 처리)
} finally {
 (항상 실행할 코드들) // 리소스 삭제
} 
  
 2. try-with-resource 구문 : Java 7버전부터 제공 
 - try() 안에서 생성된 리소스들의 해제 코드(close();)를 자동으로 호출해줌
 try(리소스 생성) {
  (실행문)
 } catch (Exception e) {
  (예외 처리)
 } 
*/

public class FileMain03 {

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("temp/big_text.txt");
			OutputStream out = new FileOutputStream("temp/big_text2.txt");
			// input && output 이름 주의
			int byteCopied = 0;
			int result = 0;
			System.out.println("test");
			long startTime = System.currentTimeMillis(); // 시간 재기용
			while(true) {
				// 1KB = 1,024 Bytes
				// 4KB = 4 * 1,024 Bytes
				// 1MB = 1,024 * 1,024 Bytes
				byte[] buffer = new byte[1024 * 1024]; // 1MB 공간
				// new byte[숫자] -> buffer 시간 주의				
				result = in.read(buffer); // if = -1 은 걍 외워라...
				// read(byte[] b) : 
				// 파일에서 읽은 데이터를 매개변수 배열 b에 저장
				// 실제로 읽은 바이트 수를 리턴, 파일 끝에서는 -1을 리턴
				
				if(result == -1) { // 걍 외워라
					break;
				}
				out.write(buffer, 0, result);
				// write(byte[] b) :
				// - 매개변수 배열 b의 내용을 한 번에 파일에 씀
				// write(byte[] b, int off, int len) :
				// - 배열 b의 인덱스 off번쨰부터 len 길이 만큼까지만 파일에 씀
								
				byteCopied += result;				
			}
			long endTime = System.currentTimeMillis();
			System.out.println("복사 경과 시간 : " + (endTime - startTime));
			System.out.println("복사된 바이트 : "+ byteCopied);
		} catch (Exception e) {
			
		}

	}//end main()

}//end FileMain03
