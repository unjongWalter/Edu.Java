package edu.java.contact06;

// 1. 현재 상황을 객관화 -> 2. 문제 해결 키워드 -> 키워드를 단어 나열 검색 ex) jtable addLow all clear.
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// UI적 요소.
public class ContactMain06 {// 메소드가 들어간 메인 붕어빵 틀, 컴파일러가 먼저 수행, 인스턴스 생성 ㄴㄴ
	// 어차피 컴파일러가 컨트롤하기에.
	// 메인메소드 없는 클래스 : 인스턴스 생성 후 사용, 붕어빵을 만들어서 쓴다는 개념, 필요할 때 특정 메소드에서 불러쓴다

	// 멤버변수 걍 다 써봐라 헷갈리면, 퍼블릭써봐라
	private JFrame frame;
	private JTextField txtName, txtPhone, txtEmail, txtIndex;
	private JTextArea txtAreaInfo, txtAreaLog;

	public static ContactDAO dao;// 스테틱 먼저만든다.../ 인터페이스 DAO역할 !

//	Connection conn = null; // 위치 모르겠
//	PreparedStatement pstmt = null; // ctrl space sql로 고고
//	ResultSet rs = null; // executeQuery관련, 여기 잘봐라

	/* 스윙 테이블을 사용하기 위한 멤버 변수 선언 */
	private JTable table;
	private String[] colNames = { "No", "이름", "전화번호", "이메일" }; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체, 한행 한행 넣을 데이터그릇
	// addLow...
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수

	public static void main(String[] args) {
		dao = ContactDAOImple.getInstance(); // DAO 인터페이스 역할~
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain06 window = new ContactMain06();
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
	public ContactMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Font lblFont = new Font("굴림", Font.PLAIN, 44);
		int lblWidth = 176;
		int lblHeight = 55;
		JLabel lblNewLabel = new JLabel("연락처 프로그램 Version 0.000006");
		lblNewLabel.setFont(lblFont);
		lblNewLabel.setBounds(12, 10, 746, 66);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblName = new JLabel("이름");
		lblName.setFont(lblFont);
		lblName.setBounds(12, 86, lblWidth, lblHeight);
		frame.getContentPane().add(lblName);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(lblFont);
		lblPhone.setBounds(12, 151, lblWidth, lblHeight);
		frame.getContentPane().add(lblPhone);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(lblFont);
		lblEmail.setBounds(12, 216, lblWidth, lblHeight);
		frame.getContentPane().add(lblEmail);

		Font txtFont = new Font("굴림", Font.PLAIN, 34);
		int txtWidth = 286;
		int txtHeight = 55;
		txtName = new JTextField();
		txtName.setFont(txtFont);
		txtName.setBounds(200, 86, txtWidth, txtHeight);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setFont(txtFont);
		txtPhone.setBounds(200, 151, txtWidth, txtHeight);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(txtFont);
		txtEmail.setBounds(200, 216, txtWidth, txtHeight);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		Font btnFont = new Font("굴림", Font.PLAIN, 24);

		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertContact(); // 단순히 불러옴...
			}
		});
		btnInsert.setFont(btnFont);
		btnInsert.setBounds(12, 281, 110, 46);
		frame.getContentPane().add(btnInsert);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectContact();
			}
		});

		btnSearch.setFont(btnFont);
		btnSearch.setBounds(256, 281, 110, 46);
		frame.getContentPane().add(btnSearch);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});

		btnUpdate.setFont(btnFont);
		btnUpdate.setBounds(12, 337, 110, 46);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteContact();
			}
		});

		btnDelete.setFont(btnFont);
		btnDelete.setBounds(134, 337, 110, 46);
		frame.getContentPane().add(btnDelete);

		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.addActionListener((e) -> { // lambda...를 써도된다~정도~
			selectAllContact();
			selectAllContactTable(); // 추가
		});
		btnAllSearch.setFont(btnFont);
		btnAllSearch.setBounds(256, 337, 190, 46);
		frame.getContentPane().add(btnAllSearch);

		txtIndex = new JTextField();
		txtIndex.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtIndex.setText(""); // 포커스 당하면 해당 인덱스를 비우자!.

			}

		});
		txtIndex.setText("인덱스 번호"); // 잡소리 비워두기... 오류발생... 포커싱했을떄 문자열 초기화...?
		txtIndex.setFont(new Font("굴림", Font.PLAIN, 17));
		txtIndex.setBounds(134, 281, 108, 46);
		frame.getContentPane().add(txtIndex);
		txtIndex.setColumns(5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 393, 480, 95);
		frame.getContentPane().add(scrollPane);

		txtAreaInfo = new JTextArea();
		txtAreaInfo.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane.setViewportView(txtAreaInfo);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 498, 480, 95);
		frame.getContentPane().add(scrollPane_1);

		txtAreaLog = new JTextArea();
		txtAreaLog.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane_1.setViewportView(txtAreaLog);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(504, 281, 254, 312);
		frame.getContentPane().add(scrollPane_2);

		// 테이블 기본형태 초기화
		tableModel = new DefaultTableModel(colNames, 0); // 모델 이름과 행 개수 설정
		table = new JTable(tableModel); // 테이블 모델을 테이블에 적용
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane_2.setViewportView(table);

	} // end initialize()

	// contactList 배열에 Contact 인스턴스를 저장
	private void insertContact() { // 등록시작
		String name = txtName.getText();
		String phone = txtPhone.getText();
		String email = txtEmail.getText();
		ArrayList<ContactVO> list = dao.select();
		// 한글로써라좀, 기능을 디테일하게 나열해봐라...
		// 세 개 중 하나라도 입력안되면, 경고창 띄우고 기능 실행 x, 문자열 제한 : 정규표현식사용
		if (name.equals("") || phone.equals("") || email.equals("")) {
			JOptionPane.showMessageDialog(frame, "연락처 정보 입력해라 좀");
			return; // 여기서 멈추도록 함
		}

		ContactVO vo = new ContactVO(0, name, phone, email);// 컨택아디 비워둠
		// contactId는 insert 쿼리 수행 시 필요 없어!!! 암거나 쳐넣어라
		txtAreaInfo.setText(vo.toString());

		int result = dao.insert(vo);
//		int size = ((ContactDAOImple) dao).getListSize(); // count 역할 다시봐라.
		if (result == 1) {
			txtAreaLog.setText("등록된 연락처 개수 : " + list.size() + "\n" + "연락처 등록 완료");
		} else {
			txtAreaLog.setText("연락처 등록 실패스");
		}

	} // end insertContact()

	private void selectAllContact() {
//		int size = ((ContactDAOImple) dao).getListSize(); // 불필요

		ArrayList<ContactVO> list = dao.select();
		int size = list.size(); // list에 size 쳐넣어라

		StringBuffer buffer = new StringBuffer();
		buffer.append("연락처 개수 : " + list.size() + "\n");// append는 계속 붙어서 buffer로...
		for (int i = 0; i < list.size(); i++) {
			buffer.append("--- 연락처 " + i + " --- \n" + list.get(i) + "\n");
		}
		txtAreaInfo.setText(buffer.toString());
	} // end selectAllContact()

	private void selectContact() { // static 없애라

		try {
			int contactId = Integer.parseInt(txtIndex.getText()); // 파싱 짓거리
			// int size = ((ContactDAOImple) dao).getListSize();

			ContactVO vo = dao.select(contactId);
			txtAreaInfo.setText(vo.toString());

		} catch (NullPointerException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(frame, "존재 ㄴㄴ");
		}

	} // end selectContact()

	private void updateContact() {

		int contactId = Integer.parseInt(txtIndex.getText()); // 문자 or 숫자 -> 파싱으로 명확화해야해
		String name = txtName.getText();
		String phone = txtPhone.getText();
		String email = txtEmail.getText();

		if (name.equals("") || phone.equals("") || email.equals("")) {
			JOptionPane.showMessageDialog(frame, "연락처 정보 입력해라 좀");
			return; // 여기서 멈추도록 함
		}

		ContactVO vo = new ContactVO(contactId, name, phone, email);
		int result = dao.update(vo); // vo에 있으니까!
		if (result == 1) {
			txtAreaInfo.setText("수정 완료");

		} else { // contactId에 비어있기에 큰 에러다...
			txtAreaInfo.setText(contactId + "번 인덱스에 연락처가 없습니다.");

		}

	} // end updateContact()

	private void deleteContact() {

		int contactId = Integer.parseInt(txtIndex.getText());
		int result = dao.delete(contactId);
//		int size = ((ContactDAOImple) dao).getListSize();

		if (result == 1) {
			txtAreaInfo.setText("삭제 완료");

		} else {
			txtAreaInfo.setText(contactId + "번 인덱스에 연락처가 없습니다.");
		}

	} // deleteContact()

	private void selectAllContactTable() {
		ArrayList<ContactVO> list = dao.select();
		tableModel.setRowCount(0); // table 그릇 전체 초기화하여 매번 데이터 쌓이지않도록 함
		for (int i = 0; i < list.size(); i++) { // records = object
			records[0] = list.get(i).getContactId(); // index 대신 변경
			records[1] = list.get(i).getName(); // name
			records[2] = list.get(i).getPhone();
			records[3] = list.get(i).getEmail();
			tableModel.addRow(records); // 리스트에서 꺼내서... addRow 행 추가.
		}
	}

} // end ContactMain06