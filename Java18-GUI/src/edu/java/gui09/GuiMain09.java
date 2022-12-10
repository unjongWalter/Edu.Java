package edu.java.gui09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// 회원가입 시, 이름~취미~ 체크박스 선택스, 앱솔루트 레이아웃 바꾸기
public class GuiMain09 {

	private JFrame frame;

	private JButton btnOutput; // 다른 곳에서 접근해야하면 위로 선언해버려라.
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain09 window = new GuiMain09();
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
	public GuiMain09() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxMusic = new JCheckBox("음악스~"); // 양자택일 아님, 그룹화 ㄴㄴ
		chckbxMusic.setBounds(21, 23, 85, 23);
		frame.getContentPane().add(chckbxMusic);
		
		JCheckBox chckbxMovie = new JCheckBox("영화스~");
		chckbxMovie.setBounds(120, 23, 85, 23);
		frame.getContentPane().add(chckbxMovie);
		
		JCheckBox chckbxReading = new JCheckBox("독서스~");
		chckbxReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 독서 선택 시, 버튼 막아둔다.
				if(chckbxReading.isSelected()) { // 독서 체크박스 선택 시, is 인지아닌지!!!
					btnOutput.setEnabled(false); // 기능불가능하도록 조치. setEnabled!!!
				} else {
					btnOutput.setEnabled(true);
				}				
			}
		});
		chckbxReading.setBounds(221, 23, 85, 23);
		frame.getContentPane().add(chckbxReading);
		
		
		JTextArea textArea = new JTextArea(); // 이사보내기! 밑에서 짜고칠수있게
		textArea.setBounds(48, 74, 346, 124); 
		frame.getContentPane().add(textArea);
		
		btnOutput = new JButton("출력"); // 선택여부 확인 // 위에 private로 선언했으니 JButton 뗴버린대
		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "음악 : " +chckbxMusic.isSelected() + "\n"
						+ "영화 : " + chckbxMovie.isSelected() + "\n"
						+ "독서 : " + chckbxReading.isSelected() + "\n";	
				textArea.setText(result); // 결과값 나타내주기
									
			}
		});
		btnOutput.setBounds(314, 23, 97, 23);
		frame.getContentPane().add(btnOutput);		
		
	}
}
