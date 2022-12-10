package edu.java.gui04;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiMain04 {
// 레이블 2개, 텍스트필드 2개, 버튼 4개, 스크롤판, 텍스트에어리어
	private JFrame frame;
	private JTextField txtNumber1, txtNumber2; // type, 변수선언, 밑에서 쓸때 new 필수
	private JButton btnAdd, btnMinus, btnMul, btnDiv; 	
	private JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain04 window = new GuiMain04();
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
	public GuiMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		int lblWidth = 240; // label 넓이
//		int lblHeight = 76; // label 높이
//		Font lblFont = new Font("굴림", Font.BOLD, 48);
				
		JLabel lblNumber1 = new JLabel("Number 1"); // 지역변수 선언
		lblNumber1.setOpaque(true); // 배경색 설정용 세팅 : true, 필수
		lblNumber1.setBackground(SystemColor.control);
		lblNumber1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber1.setFont(new Font("맑은 고딕", Font.ITALIC, 48));
		lblNumber1.setBounds(12, 10, 280, 70);
		frame.getContentPane().add(lblNumber1);
		
		JLabel lblNumber2 = new JLabel("Number 2");
		lblNumber2.setOpaque(true);
		lblNumber2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber2.setFont(new Font("맑은 고딕", Font.ITALIC, 48));
		lblNumber2.setBackground(SystemColor.control);
		lblNumber2.setBounds(12, 96, 280, 70);
		frame.getContentPane().add(lblNumber2);
		
//		int txtWidth = 633;
//		int txtHeight = 76;
		Font txtFont = new Font("굴림", Font.PLAIN, 40);
		
		txtNumber1 = new JTextField(); // 선언!!필수, 멤버변수로 선언
		txtNumber1.setFont(txtFont);
		txtNumber1.setBounds(304, 10, 368, 70);
		txtNumber1.setColumns(10);
		frame.getContentPane().add(txtNumber1);
		
		txtNumber2 = new JTextField(); // 선언!!필수, 멤버변수로 선언
		txtNumber2.setFont(txtFont);
		txtNumber2.setBounds(304, 96, 368, 70);
		txtNumber2.setColumns(10);
		frame.getContentPane().add(txtNumber2);
		
		// button 시작, 플러스, 액션퍼폼드가 기본 클릭형태
		JButton btnAdd = new JButton("+");				
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 문자열로 받을 수 밖에 없대
				String num1 = txtNumber1.getText();
				String num2 = txtNumber2.getText();
				
				// 문자열 숫자로 변환
				double x = Double.parseDouble(num1);
				double y = Double.parseDouble(num2);
				
				// 결과값 나타내기
				String result = x + " + " + y + " = " + (x + y) + "\n";
				textArea.append(result); // append 기존 데이터에 연결한다.
				
//				double no1 = Double.parseDouble(txtNumber1.getText());				
//				double no2 = Double.parseDouble(txtNumber2.getText());
//				double add = no1 + no2;
//				String result = no1 + " + " + no2 + " = " + add;
//				txtOutput.setText(result);		
//				textArea.append(result+"\n");
			}
		});		
		btnAdd.setBounds(12, 170, 100, 100); // 버튼 구현하기
		btnAdd.setFont(txtFont);
		frame.getContentPane().add(btnAdd); // 버튼 쳐넣기
				
		// 마이너스
		JButton	btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double no1 = Double.parseDouble(txtNumber1.getText());				
				double no2 = Double.parseDouble(txtNumber2.getText());
				double minus = no1 - no2;
				String result = no1 + " - " + no2 + " = " + minus;
				textArea.append(result + "\n");						
			}
		});
		btnMinus.setBounds(192,170,100,100);
		btnMinus.setFont(txtFont);		
		frame.getContentPane().add(btnMinus);
		
		// 곱하기, enter 누르면~
		JButton btnMul = new JButton("*");		
//		btnMul.addActionListener(new ActionListener() {
		btnMul.addKeyListener(new KeyAdapter() {
					
			@Override
			public void keyPressed(KeyEvent e) {
			//	getKeycode() : 사용자가 누른 정보 갖고
				System.out.println("btnMul : keyPressed()");
				System.out.println(e.getKeyCode());		
				if(e.getKeyCode() == 10 ) { // enter 10번 누르면 나오게
					System.out.println("엔터키 누름");
					double no1 = Double.parseDouble(txtNumber1.getText());				
					double no2 = Double.parseDouble(txtNumber2.getText());
					double mul = no1 * no2;
					String result2 = no1 + " * " + no2 + " = " + mul;
					textArea.append(result2 + "\n");
				}
			}
			
		});			
			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				double no111 = Double.parseDouble(txtNumber1.getText());				
//				double no222 = Double.parseDouble(txtNumber2.getText());
//				double mul = no111*no222;
//				String result2 = no111 + " * " + no222 + " = " + mul;
//				textArea.append(result2+"\n");
//				
//			}
//		});
		btnMul.setBounds(386,170,100,100);
		btnMul.setFont(txtFont);
		frame.getContentPane().add(btnMul);				
		
		// 나누기 두개 구현...?
		JButton btnDiv = new JButton("/");	
		btnDiv.addMouseListener(new MouseAdapter() {
			@Override // callback 특정 이벤트 발생 시 뭔가나온다. 강의 + 물떠왕
			public void mouseClicked (MouseEvent e) {
				System.out.println("btnDiv : mouseClicked");
				double no1 = Double.parseDouble(txtNumber1.getText());				
				double no2 = Double.parseDouble(txtNumber2.getText());
				double div = no1 / no2;
				String result = no1 + " / " + no2 + " = " + div;
				textArea.append(result + "\n");	
			}
		});
		
		btnDiv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed (KeyEvent e) {	
				System.out.println("btnDiv : keyPressed");
				double no1 = Double.parseDouble(txtNumber1.getText());				
				double no2 = Double.parseDouble(txtNumber2.getText());
				double div = no1 / no2;
				String result = no1 + " / " + no2 + " = " + div;
				textArea.append(result + "\n");					
			}				
		});		
		
//		btnDiv.addActionListener(new ActionListener() {			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				double no1111 = Double.parseDouble(txtNumber1.getText());				
//				double no2222 = Double.parseDouble(txtNumber2.getText());
//				double div = no1111/no2222;
//				String result3 = no1111 + " / " + no2222 + " = " + div;
//				textArea.append(result3+"\n");				
//			}
//		});
		
		btnDiv.setBounds(572,170,100,100); // 듀얼기능 구현 후 한방에 닫기
		btnDiv.setFont(txtFont);		
		frame.getContentPane().add(btnDiv);
				
//		txtOutput = new JTextField(); // 버튼에 입힐 텍스트필드 영역만 맹글기
//		txtOutput.setBounds(12, 378, 890, 100); // 쓰기용 필드
//		txtOutput.setFont(txtFont);
//		txtOutput.setColumns(10);
//		frame.getContentPane().add(txtOutput);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 280, 660, 222);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
//		textArea.setTabSize(40);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 40));
		scrollPane.setViewportView(textArea);
		
	}

}
