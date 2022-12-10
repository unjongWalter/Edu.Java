package edu.java.gui11;
// 복잡한 구조에서 콜하게 맹근대... 우짜니...
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain11 {

	private JFrame frame;
	// 메인지웠어
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain11 window = new GuiMain11();
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
	public GuiMain11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); // 스스로 프레임 내부에서 인스턴스 생성
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn1 = new JButton("New Frame"); // frame 다 쳐넣을 수 있대...
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JFrame myFrame = new JFrame(); // frame이 다같구나 ...
//				myFrame.setBounds(10, 10, 400, 400);
//				myFrame.setVisible(true); // 디자인에서 볼 수 없어
				// 일반적으로 새로운 프레임이나, 다이얼로그를 생설할 때는
				// 각 클래스들을 상속받는 자식 클래스를 만들어서 사용하는 것이
				// 편의성면에서 더 좋음
				// ---> JFrame을 새로 생성하여 상속받을거야
				
				MyFrame myFrame = new MyFrame(); // call
				myFrame.setVisible(true); // 빌려왔대... 자식프레임
				frame.setVisible(false); // 선택 후 메인/어미 프레임 안보이게 맹글기				
				
			}
		});
		btn1.setFont(new Font("굴림", Font.BOLD, 30));
		btn1.setBounds(12, 22, 410, 59);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("New Dialog");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				// 다이얼로그 호출
				MyDialog myDialog = new MyDialog(); // VO로 묶어주고~
				// myDialog.setVisible(true);// 이 위치에서 마이다이얼로그로 이동...
						
			}
		});
		btn2.setFont(new Font("굴림", Font.BOLD, 30));
		btn2.setBounds(12, 91, 410, 61);
		frame.getContentPane().add(btn2);
	}

}
