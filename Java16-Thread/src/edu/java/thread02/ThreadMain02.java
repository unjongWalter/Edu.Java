package edu.java.thread02;

// 자바는 다중 상속을 허용하지 않기에
// 다른 클래스를 이미 상속받고 있는 경우에는 Thread 클래스를 상속받지 못함
// Runnable 인터페이스를 구현하여 Thread를 생성할 수 있는 방법 제공

// 자바에서 쓰레드를 생성하고 사용하는 방법 2
// 1. Runnable 인터페이스를 구현하는 클래스 정의(implements Runnable)
// 2. 정의한 클래스에서 run()메소드를 override
// -> 쓰레드가 해야 할 기능 구현
// 3. 정의한 클래스(Runnable 구현 클래스)의 인스턴스 생성
// 4. Runnable 인스턴스를 매개변수로 해서 Thread 인스턴스 생성
// 5. Thread 인스턴스에서 start() 메소드를 호출 -> run() 자동 호출

// 1. Runnable 인터페이스를 구현하는 클래스 정의
class MyRunnable implements Runnable{
	private String msg;
	public MyRunnable(String msg) {
		this.msg = msg;
	}
	
	// 2. run() 메소드 override
	@Override // 오른쪽, 빨갱이 run method 생성
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i + " : " + msg);
			try {
				Thread.sleep(100); // 빨갱이짓 ㄱㄱ, 상속받은 게 없어... Thread에서 해...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadMain02 {

	public static void main(String[] args) {
		// 3. Runnable을 구현하는 클래스(MyRunnable)의 인스턴스 생성
		MyRunnable r1 = new MyRunnable("r1");
		Runnable r2 = new MyRunnable("r2");
		
		// 4. Runnable 인스턴스를 인자값으로 보내 Thread 인스턴스 생성
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		
		// 5. 쓰레드 인스턴스에서 start() 호출
		th1.start();
		th2.start();

		System.out.println("main Thread ends");
		
	}//end main()

}//end ThreadMain02