package edu.java.file04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
// 사번은 쓰기, 오번은 읽기/
// 프로그램 ===> ObjectOutputStream ===> FileOutputStream ===> 파일(HDD)

public class FileMain04 {

	public static void main(String[] args) {
		OutputStream out = null;
		ObjectOutputStream oout = null;
		
		try {
			// 쓸 때는 OutputStream... 헷갈린다...
			out = new FileOutputStream("temp/member.txt");
			oout = new ObjectOutputStream(out);// oout ~ oout 하면 무한동력 개그
			
			MemberVO m1 = new MemberVO(1, "root1", "root123");
			oout.writeObject(m1);
			
			MemberVO m2 = new MemberVO(2, "root2", "root123");
			oout.writeObject(m2);
			
			MemberVO m3 = new MemberVO(3, "root3", "root123");
			oout.writeObject(m3);
			
			System.out.println("파일 저장대땅...");
				
		} catch (Exception e) {
			System.out.println("예외래... : " + e.toString());
			
		} finally {
			// 리소스(oout)를 해제할 때는 최종적으로 생성된 리소스만 해제하면,
			// 그 리소스(oout)가 사용하고 있는 다른 리소스(out)들도 순차적으로 해제됨
			try {
				oout.close(); // 빨갱이 트라이캐치 또 씀...
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}//end main()

}//end FileMain04
