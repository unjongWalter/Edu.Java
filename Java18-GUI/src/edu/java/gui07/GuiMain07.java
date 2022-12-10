package edu.java.gui07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain07 {

	private JFrame frame;
	// 버튼 클릭에 따라 배열 인덱스에 저장한 값을 나타낸다.
	private static final String[] STRINGS = { // 이름 선언
			"1. 공봉석", "2. 김병훈", "3. 김성현", "4. 김승현", "5. 김시원", "6. 백운종", "7. 심청미", "8. 유훈재", "9. 이소연", "10. 이충호",
			"11. 이호", "12. 임희지", "13. 조성환", "14. 최진홍", "15. 한병훈"

	};

	private int index; // 멤버변수, 전역변수 선언

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain07 window = new GuiMain07();
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
	public GuiMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { // 뭘만들지, 뭘참고할지, 디자인적 vs 기능적 요소 확인
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblOutput = new JLabel("New label");
		lblOutput.setText(STRINGS[index]); // 첫 시작 시, index[0] 값부터 출력되도록

		lblOutput.setFont(new Font("굴림", Font.BOLD, 42));
		lblOutput.setBounds(12, 10, 410, 100);
		frame.getContentPane().add(lblOutput);

		JButton btlPrev = new JButton("이전"); // 이전 버튼을 누르면 인덱스가 감소한다.
		btlPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // index[1]은 감소가능, [0]은 감소 ㄴㄴ, 경계선 찾아봐라
				if(index > 0 ) {
					index--; // index -= 2; 하면 짝수 사라짐
				} else {
					index = STRINGS.length - 1 ; // 순환구조... 증가부터 이해...
				}
				System.out.println(index);
				lblOutput.setText(STRINGS[index]);
			}
		});
		btlPrev.setFont(new Font("굴림", Font.BOLD, 42)); // 인덱스 번호가 2번인 경우, 누르면 우찌댐?
		btlPrev.setBounds(12, 139, 161, 112);
		frame.getContentPane().add(btlPrev);

		JButton btlNext = new JButton("다음");
		btlNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < STRINGS.length - 1 ) { // STRINGS 길이 - 1까지만 실행. == 14
					index++; // 전역변수 위에 선언 후, 인덱스 증가부터 // index +=; 하면 짝수는 못먹음
				} else { // index는 문자열길이 - 1일 때, 다시 0번 인덱스로 돌아간다...
					index = 0;
				}
				System.out.println(index);
				lblOutput.setText(STRINGS[index]);

			}
		});
		btlNext.setFont(new Font("굴림", Font.BOLD, 42));
		btlNext.setBounds(261, 139, 161, 112);
		frame.getContentPane().add(btlNext);
		
		JButton btnRandomGame = new JButton("Random Game"); // 랜덤게임 만들기. 15개의 인덱스 중에 난수발생
		btnRandomGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int random = (int) ((STRINGS.length) * Math.random());
				lblOutput.setText(STRINGS[random]);
			}
		});
		btnRandomGame.setBounds(143, 97, 140, 35);
		frame.getContentPane().add(btnRandomGame);
	}
}
