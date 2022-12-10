package edu.java.thread03;
// main callback?
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadMain03 {

	public static void main(String[] args) {
		// 1. 클래스 인스턴스를 생성하여 쓰레드 start()
		Thread th1 = new Thread(new MyRunnable("클래스"));
		th1.start();
		
		// 2. 익명 클래스를 사용하여 쓰레드 start() // 1회용
		Thread th2 = new Thread(new Runnable() {
			
			@Override // new Thread(new Runnable ctrl space
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(i + " : 익명");
					try {
						Thread.sleep(100); // 빨갱이짓 ㄱㄱ, 상속받은 게 없어... Thread에서 해...
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		});
		th2.start();
		
		// 3. 람다 표현식 사용하여 쓰레드 start()
		new Thread(()->{
			for(int i = 0; i < 100; i++) {
				System.out.println(i + " : 람다");
				try {
					Thread.sleep(100); // 빨갱이짓 ㄱㄱ, 상속받은 게 없어... Thread에서 해...
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}				
		}).start(); // ...?			

	}//end main()

}//end ThreadMain03
