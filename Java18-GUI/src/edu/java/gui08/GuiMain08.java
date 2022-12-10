package edu.java.gui08;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiMain08 {

	// 그림(ImageIcon) 구현하기 "java swing JLabel image"
	private JFrame frame;

	private static final ImageIcon[] IMAGE_ICONS = {
			new ImageIcon("res/dog1.jpg"),
			new ImageIcon("res/dog2.jpg"),
			new ImageIcon("res/dog3.jpg"),
			new ImageIcon("res/dog4.jpg"),
			new ImageIcon("res/dog5.jpg"),	
			
	};
	private int index; // 복사하고 에러잡자.
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain08 window = new GuiMain08();
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
	public GuiMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { // 뭘만들지, 뭘참고할지, 디자인적 vs 기능적 요소 확인
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblOutput = new JLabel();
//		lblOutput.setText(STRINGS[0]); // 이미지니까 불필요. 지우자
		lblOutput.setIcon(IMAGE_ICONS[0]); // 경로 기억해, 시작 시 보이도록 하자.
//		lblOutput.setFont(new Font("굴림", Font.BOLD, 42)); // 이미지니까 불필요
		lblOutput.setBounds(12, 10, 410, 295);
		frame.getContentPane().add(lblOutput);

		JButton btlPrev = new JButton("이전"); // 이전 버튼을 누르면 인덱스가 감소한다.
		btlPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // index[1]은 감소가능, [0]은 감소 ㄴㄴ, 경계선 찾아봐라
				if(index > 0 ) {
					index--; // index -= 2; 하면 짝수 사라짐
				} else {
					index = IMAGE_ICONS.length - 1; // 이미지도 문자열과 동일패턴
				}
				System.out.println(index);
				lblOutput.setIcon(IMAGE_ICONS[index]);

			}
		});
		btlPrev.setFont(new Font("굴림", Font.BOLD, 42)); // 인덱스 번호가 2번인 경우, 누르면 우찌댐?
		btlPrev.setBounds(12, 385, 161, 112);
		frame.getContentPane().add(btlPrev);

		JButton btlNext = new JButton("다음");
		btlNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < IMAGE_ICONS.length - 1 ) { // STRINGS 길이 - 1까지만 실행. == 14
					index++; // 전역변수 위에 선언 후, 인덱스 증가부터 // index +=; 하면 짝수는 못먹음
				} else { // index는 문자열길이 - 1일 때, 다시 0번 인덱스로 돌아간다...
					index = 0;
				}
				System.out.println(index);
				lblOutput.setIcon(IMAGE_ICONS[index]);

			}
		});
		btlNext.setFont(new Font("굴림", Font.BOLD, 42));
		btlNext.setBounds(261, 385, 161, 112);
		frame.getContentPane().add(btlNext);
	}

}
