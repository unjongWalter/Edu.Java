package edu.java.thread01;

// Thread : 하나의 작업을 순차적으로 진행하는 실행코드
// 멀티 쓰레드 프로그램 :
// - 하나의 프로그램(프로세스)에서 여러 개의 쓰레드를 동작하는 프로그램
// - 예) 채팅 프로그램 = 채팅 + 파일 전송

// 자바에서 쓰레드를 생성하고 사용하는 방법 1
// 1. Thread 클래스를 상속받는 새로운 클래스 정의(extends Thread)
// 2. 정의한 새로운 클래스 안에서 run() 메소드를 override
// -> run() : 쓰레드가 해야 할 기능 구현
// 3. 정의한 클래스의 인스턴스를 생성
// 4. 생성된 인스턴스에서 start()메소드를 호출
// -> 쓰레드가 가져야 할 메모리 공간을 확보, 스케쥴링을 위해 쓰레드 등록, 초기화
// -> 쓰레드의 run() 메소드가 자동으로 실행됨

// 1. Thread 클래스 상속받는 새로운 클래스 정의
class MyThread extends Thread {
	// 멤버변수
	private String msg;

	// 생성자
	public MyThread(String msg) {
		this.msg = msg;
	}
	// 2. run () - 쓰레드가 해야 할 기능들을 구현
	// ctrl space로 run method override

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " : " + msg);
			try { // milli seconds 동안 멈춤(delay)
				sleep(1000); // sleep 후 빨갱이짓 ㄱ, 부모님 것 막 갖다써...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
} //end MyThread

public class ThreadMain01 { //활용 : 시계 타이머

	public static void main(String[] args) { // main도 하나의 쓰레드.
		// 3. Thread를 상속받는 클래스(MyThread)의 인스턴스 생성
		MyThread th1 = new MyThread("heyyyy");
		
		// 4. 생성된 인스턴스에서 start() 메소드를 호출 -> 쓰레드 실행
		th1.start();
		
		MyThread th2 = new MyThread("bye");
		th2.start(); // 서로 우선순위가 읎어	
		
		// join() : 해당 쓰레드가 종료될 때까지 기다림. 우선순위 매기기
		try {
			th1.join(); // main이 최소한 먼저 하게...마지막 양심
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("Main Thread ends"); // 제일 위에 실행되네...?
				
	}// end main()

}// end ThreadMain01
