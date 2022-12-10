package edu.java.gui05;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// 라디오 버튼!!!
public class GuiMain05 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup(); // 그룹묶어야 그룹 내 양자택일 가능.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain05 window = new GuiMain05();
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
	public GuiMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { // 앱솔로 바꿈, 컴포넌트 라디오버튼
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextArea textArea = new JTextArea(); // 텍스트영역 추가 시점 위로 올리기가능스... 동시 존재하니까
		textArea.setBounds(21, 53, 389, 183);
		frame.getContentPane().add(textArea);
		
		
		JRadioButton rdbtnAgree = new JRadioButton("동의"); // 디자인에서, Agree로 바꿈, selected
		rdbtnAgree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 액션퍼폼드 오른쪽 ㄱㄱ
				textArea.setText(rdbtnAgree.getText()+"할거요???"); // radio버튼 텍스트를 가져온대 미친...
					
			}
		});
		buttonGroup.add(rdbtnAgree); // set button group, standard, 영역 동시 선택 후 오른쪽 클릭.
		rdbtnAgree.setSelected(true); // 시작 시 체크버튼활성화
		rdbtnAgree.setBounds(21, 24, 121, 23); 
		frame.getContentPane().add(rdbtnAgree);
		
		JRadioButton rdbtnReject = new JRadioButton("거절"); 
		rdbtnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(rdbtnReject.getText()+"합니까???");
				
			}
		});
		buttonGroup.add(rdbtnReject); // set button group, standard
		rdbtnReject.setBounds(191, 24, 121, 23);
		frame.getContentPane().add(rdbtnReject);		
		
	}
}
