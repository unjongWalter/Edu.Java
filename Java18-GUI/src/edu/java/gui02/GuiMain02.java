package edu.java.gui02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain02 {

	private JFrame frame;
	private JTextField txtInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain02 window = new GuiMain02();
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
	public GuiMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOutput = new JLabel("오늘이 아직 월요일...?!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setForeground(Color.BLUE);
		lblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblOutput.setBounds(12, 10, 410, 30);
		frame.getContentPane().add(lblOutput);
		
		txtInput = new JTextField(); // 1. name change, 입력칸
		txtInput.setFont(new Font("맑은 고딕", Font.PLAIN, 24)); // 2. setFont 직접 입력 
		txtInput.setBounds(12, 84, 410, 47);
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		
		JButton btnInput = new JButton("입력");
//		btnInput.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnInput.addMouseListener(new MouseAdapter() { // 익명클래스 적용
			@Override
			public void mouseClicked(MouseEvent e) { // 버튼 오른쪽 클릭, 애드이벤트 -> 마우스~
				// 버튼 클릭시 해야할 기능 구현
				// JTextField에 입력된 내용을 읽어서 JLable에 쓴다.
				String msg = txtInput.getText();
			//	System.out.println(msg); // 입력만 한 상태 확인용
				
				lblOutput.setText(msg); // lbloutput에 쓰기 
				lblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 38)); // 바뀌는 효과 추가
				lblOutput.setForeground(Color.RED);
			}
		});
		btnInput.setFont(new Font("굴림", Font.PLAIN, 18));
		btnInput.setBounds(12, 151, 410, 30);
		frame.getContentPane().add(btnInput);
		frame.setBounds(100, 100, 450, 300);
		
		System.out.println("버스 떠났다?"); // call back 의 개념... 동시에 두 개가 실행 중
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}//end GuiMain02
