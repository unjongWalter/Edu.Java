package edu.java.project01;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class JoinFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId,txtName, txtPhone, txtEmail;
	private JButton btnComplete, btnConfirm, btnCancel;	
	private JPasswordField pwF;
	private JLabel lblIdcheck;
	
	public static JoinDAO daoJ;	
	public JoinFrame(JFrame mainFrame) {

		daoJ = JoinDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblJoin = new JLabel("회원가입 페이지입니다.");
		lblJoin.setFont(new Font("굴림", Font.BOLD, 18));
		lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoin.setBounds(124, 25, 279, 75);
		contentPane.add(lblJoin);

		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(33, 120, 82, 58);
		contentPane.add(lblId);

		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setBounds(33, 209, 82, 58);
		contentPane.add(lblPw);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(33, 267, 82, 58);
		contentPane.add(lblName);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(33, 325, 82, 58);
		contentPane.add(lblPhone);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(33, 388, 77, 58);
		contentPane.add(lblEmail);

		txtId = new JTextField();
		txtId.setBounds(140, 130, 258, 39);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(140, 277, 258, 39);
		contentPane.add(txtName);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(140, 335, 258, 39);
		contentPane.add(txtPhone);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(140, 398, 258, 39);
		contentPane.add(txtEmail);

		// 완료, 빠져나가기로 현재창 비활성화
		btnComplete = new JButton("회원가입 완료");		
		btnComplete.setVisible(true);
		btnComplete.setEnabled(false);
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertMember();		
			//	mainFrame.setVisible(true);

			}
		});
		btnComplete.setBounds(103, 472, 128, 58);
		contentPane.add(btnComplete);

		btnCancel = new JButton("취소/돌아가기");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoinFrame.this.setVisible(false);
				mainFrame.setVisible(true);
			}
		});
		btnCancel.setBounds(287, 472, 116, 58);
		contentPane.add(btnCancel);

		pwF = new JPasswordField();
		pwF.setBounds(140, 219, 258, 39);
		contentPane.add(pwF);
		
		lblIdcheck = new JLabel("사용 가능 아이디네요.");
		lblIdcheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdcheck.setForeground(SystemColor.textHighlight);
		lblIdcheck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblIdcheck.setBounds(140, 179, 254, 19);
		lblIdcheck.setVisible(false);
		contentPane.add(lblIdcheck);
			
		// 아이디 중복확인
		btnConfirm = new JButton("중복확인");
		btnConfirm.setBorderPainted(false);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 아이디 중복확인용 메소드
				idCheck();				
			}
		});
		btnConfirm.setBounds(408, 130, 100, 39);
		contentPane.add(btnConfirm);			
	}
	
	// 아이디 중복확인용.
	private void idCheck() {
		int ch = 0;
		try {
			ArrayList<JoinVO> list = daoJ.select();
			for (int i = 0; i < list.size(); i++) {
				if (txtId.getText().equals(list.get(i).getJoinId())) {
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
					ch = 1;
					return;
				}	
			}	
			if (ch == 0) {
				int result = JOptionPane.showConfirmDialog(null, "사용가능한 아이디입니다. 사용하시겠습니까?", "확인창", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {					
					JOptionPane.showMessageDialog(null, "확인되었습니다.");
					btnComplete.setEnabled(true);
					lblIdcheck.setVisible(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end idCheck

	// 회원가입
	private void insertMember() {// int로 결과값 리턴
		try {
			String joinId = txtId.getText();
			String joinPassword = new String(pwF.getPassword());
			String joinName = txtName.getText();
			String joinPhone = txtPhone.getText();
			String joinEmail = txtEmail.getText();

			if (joinId.contains(" ") || joinPassword.contains(" ") || joinName.contains(" ") || joinPhone.contains(" ")
					|| joinEmail.contains(" ") )  {
				JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.", "error", JOptionPane.ERROR_MESSAGE);
				return; 				
			} else if (joinId.equals("") || joinPassword.equals("") || joinName.equals("") ||
			joinPhone.equals("") || joinEmail.equals("")) {
				JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요.");
				return;
			}
			JoinVO vo = new JoinVO(0, joinId, joinPassword, joinName, joinPhone, joinEmail);
			int result = daoJ.insert(vo);
			
			if (result == 1) {
								
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다. 로그인해주세요.");	
				dispose(); // 현재 실행 중 창 닫기
				// System.exit(0); // 열려있는 모든 창 닫기
			} else {
				JOptionPane.showMessageDialog(null, "회원가입이 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// end insertMember
}// end JoinFrame
