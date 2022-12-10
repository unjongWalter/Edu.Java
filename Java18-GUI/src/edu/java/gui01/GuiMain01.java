package edu.java.gui01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class GuiMain01 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // Runnable 쓰레드 구현용, main & ui
			public void run() {
				try {
					GuiMain01 window = new GuiMain01();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMain01() { // 생성자
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { // 인스턴스 생성코드
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);// x, y, width, height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 구현
//		frame.getContentPane().setLayout(new BorderLayout(0,0)); 확인용
		
		JLabel northlbl = new JLabel("North"); // alt shift r 사용 변경
		frame.getContentPane().add(northlbl, BorderLayout.NORTH); // component가 label의 부모
		
		JLabel westlbl = new JLabel("West");
		frame.getContentPane().add(westlbl, BorderLayout.WEST);
		
		JLabel eastlbl = new JLabel("East");
		frame.getContentPane().add(eastlbl, BorderLayout.EAST);
		
		JLabel centerlbl = new JLabel("Center");
		frame.getContentPane().add(centerlbl, BorderLayout.SOUTH);
		
		JLabel southlbl = new JLabel("South");
		frame.getContentPane().add(southlbl, BorderLayout.CENTER);
	}

}
