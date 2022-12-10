package edu.java.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import edu.java.file04.MemberVO;

// 프로그램 ===> ObjectOutputStream ===> BufferedOutputStream ===> FileOutputStream ===> 파일(HDD)
// Buffered : 중간에 가교역할하는 고마운놈

public class FileMain06 {

	public static void main(String[] args) {
		
		System.out.println("ArrayList<Member> 객체를 파일에 저장하고 읽어오는 코드");
		
		/*ArrayList<Member> 저장하는 코드 */
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		try {
			out = new FileOutputStream("temp/list.txt"); // 객체생성
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			ArrayList<MemberVO> list = new ArrayList<>(); // 넣기 4번에서 끌고오네
			for (int i = 0; i < 100; i++) {
				String id = "member" + i;
				String pw = "pw" + i;
				MemberVO m = new MemberVO(i, id, pw);
				list.add(m);
			}			
			oout.writeObject(list);
			System.out.println("데이터 저장 완료");
		} catch (Exception e) {
			System.out.println(e.toString());			
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		/* 데이터 파일을 읽어서 ArrayList의 내용 출력 */
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			
			in = new FileInputStream("temp/list.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			// 강제 형변환 누를차례... 슈밥...
			ArrayList<MemberVO> list = (ArrayList<MemberVO>) oin.readObject();
			
			for (MemberVO m : list) { // for each로 다 꺼내자
				System.out.println(m);			
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}			
		}
				
	}//end main()

}//end FileMain06
