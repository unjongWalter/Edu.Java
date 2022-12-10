package edu.java.gui03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiMain03 {

	private JFrame frame; // type, 잘모르면 전부 지역변수로...해도...되긴...해...
	private JTextField txtName, txtPhone, txtEmail, txtOutput; // type, 변수선언, 밑에서 쓸때 new 필수
	private JButton btnInsert; 	
	private JTextArea textArea; // 뚫어주기
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain03 window = new GuiMain03();
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
	public GuiMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 930, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // Absolute layout으로 설정 code type
		
		int lblWidth = 245; // label 넓이
		int lblHeight = 76; // label 높이
		Font lblFont = new Font("굴림", Font.BOLD, 48);
		
		JLabel lblName = new JLabel("이름"); // 지역변수 선언
		lblName.setOpaque(true); // 배경색 설정용 세팅 : true, 필수
		lblName.setBackground(Color.PINK);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(lblFont);
		lblName.setBounds(12, 10, lblWidth, lblHeight);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setOpaque(true);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(lblFont);
		lblPhone.setBackground(Color.ORANGE);
		lblPhone.setBounds(12, 96, lblWidth, lblHeight);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(lblFont);
		lblEmail.setBackground(Color.BLUE);
		lblEmail.setBounds(12, 182, lblWidth, lblHeight);
		frame.getContentPane().add(lblEmail);
		
		int txtWidth = 633;
		int txtHeight = 76;
		Font txtFont = new Font("굴림", Font.PLAIN, 30); // txt상자 맹글기 시작
		
		txtName = new JTextField(); // 선언!!필수, 멤버변수로 선언
		txtName.setFont(txtFont);
		txtName.setBounds(269, 10, txtWidth, txtHeight);
		txtName.setColumns(10);
		frame.getContentPane().add(txtName);
		
		txtPhone = new JTextField(); // 선언!!필수
		txtPhone.setFont(txtFont);
		txtPhone.setBounds(269, 96, txtWidth, txtHeight);
		txtPhone.setColumns(10);
		frame.getContentPane().add(txtPhone);
		
		txtEmail = new JTextField(); // 선언!!필수
		txtEmail.setFont(txtFont);
		txtEmail.setBounds(269, 182, txtWidth, txtHeight);
		txtEmail.setColumns(10);
		frame.getContentPane().add(txtEmail);
		
		
		btnInsert = new JButton("정보 츨력"); // button 맹글기
		btnInsert.setBounds(12, 268, 890, 100);
		btnInsert.setFont(txtFont);
		btnInsert.addActionListener(new ActionListener() { // 익명 맹글기, null 에서 new Act~ 했더니 ~ 이벤트성 기능 추가
			
			@Override
			public void actionPerformed(ActionEvent e) { // JTextField에 show할 기능 구현ㄱㄱ
				// 기능구현, 눌렀을 때, 가져와서 보여준다.
				String name = txtName.getText();
				String phone = txtPhone.getText();
				String email = txtEmail.getText();
				String msg = "이름 : " + name + "\n"
						+ "전화번호 : " + phone + "\n"
						+ "이메일 : " + email + "\n";
				txtOutput.setText(msg);				
				textArea.setText(msg);
			}
		});
		frame.getContentPane().add(btnInsert);
		
		txtOutput = new JTextField(); // 버튼에 입힐 텍스트필드 영역만 맹글기
		txtOutput.setBounds(12, 378, 890, 100);
		txtOutput.setFont(txtFont);
		txtOutput.setColumns(10);
		frame.getContentPane().add(txtOutput);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 488, 890, 69);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
				
	}
}
