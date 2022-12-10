package edu.java.homework;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Homework5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OutputStream out = null;
		ObjectOutputStream oout = null; // 저장용

		try {
			// 쓸 때는 OutputStream... 헷갈린다...
			out = new FileOutputStream("temp/student.txt");
			oout = new ObjectOutputStream(out);// oout ~ oout 하면 무한동력 개그

			for (int i = 0; i < 3; i++) {
				System.out.println("이름, 수학점수, 영어점수 입력해봐라");
				System.out.println("name?");
				String name = sc.next();
				System.out.println("math?");
				int math = sc.nextInt();
				System.out.println("eng?");
				int eng = sc.nextInt();
				Student s1 = new Student(name, math, eng);
				oout.writeObject(s1);
			}
			System.out.println("저장대땅...");

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			// 리소스(oout)를 해제할 때는 최종적으로 생성된 리소스만 해제하면,
			// 그 리소스(oout)가 사용하고 있는 다른 리소스(out)들도 순차적으로 해제됨
			try {
				oout.close(); // 빨갱이 트라이캐치 또 씀...
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		

//		 읽어오자이제...		
		InputStream in = null;
		ObjectInputStream oin = null;		
		try {
			in = new FileInputStream("temp/student.txt");
			oin = new ObjectInputStream(in);						
			while (true) {
				try {
					Student s = (Student) oin.readObject();
					s.displayInfo();
				} catch (EOFException e) {
					break;
				}								
			}			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {			
			
		}		
	}// end main()
}// end Homework5
