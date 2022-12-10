package edu.java.gui11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MyFrame extends JFrame { // 부모 자동 상속받음

	private JPanel contentPane; // 변수로 컨텐트판 갖네

	/**
	 * Launch the application.
	 */
	// main 지워버림...

	/**
	 * Create the frame.
	 */
	public MyFrame() { // ~.이 아니라 단독사용한다!
		// this가 숨겨져있어...  기본생성자 같대~
		// JFrame.EXIT_ON_CLOSE : 프로그램 전체 종료
		// JFrame.DISPOSE_ON_CLOSE : 현재 창만 종료
		// 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();// 셀프로 갖는대~
//		frame.getContentPane()과 동일
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 61, 410, 80);
		contentPane.add(btnNewButton);
	}

}
