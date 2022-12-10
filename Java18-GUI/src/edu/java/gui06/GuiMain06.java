package edu.java.gui06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
// 양자택일 남여
public class GuiMain06 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup(); // 라디오버튼 그룹화
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain06 window = new GuiMain06();
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
	public GuiMain06() {
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
		textArea.setBounds(21, 109, 389, 127);
		frame.getContentPane().add(textArea);
		
		
		JRadioButton rdbtnMale = new JRadioButton("남"); // 라디오버튼 이벤트 삭제
				
		
		buttonGroup.add(rdbtnMale); // set button group, standard
		rdbtnMale.setSelected(true); // 시작 시 체크버튼활성화
		rdbtnMale.setBounds(21, 24, 121, 23); 
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("여"); // 라디오 이벤트 삭제
				
		
		buttonGroup.add(rdbtnFemale); // set button group, standard
		rdbtnFemale.setBounds(191, 24, 121, 23);
		frame.getContentPane().add(rdbtnFemale);		
		
		JButton btnConfirmed = new JButton("Confirmed"); // 버튼갖고 장난 ㄱㄱ
		btnConfirmed.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// '남' 버튼 선택 시, textArea에 "성별 : 남자" 출력
				// '여' 버튼 선택 시, textArea에 ''
				if (rdbtnMale.isSelected() == true) { // isSelected 기능 확인, is는 인지아닌지!
					textArea.setText("성별 : 남자");
				} else {
					textArea.setText("성별 : 여자");
				} 
				
			}
		});
		btnConfirmed.setBounds(21, 62, 97, 23);		
		frame.getContentPane().add(btnConfirmed);		
		
	}
}
