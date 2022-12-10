package edu.java.project01;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPasswordField;

public class ProgramMain {

	public JFrame frame;

	private JButton btnItem, btnVendor;
	private JButton btnLogin, btnLogout, btnJoin;
	private JLabel lblLogo, lblmain;
	private Component currentComponent;
	private JTextField txtId;
	private JLabel lblId, lblPw;
	private JPasswordField pwF;

	private static VendorDAOImple daoV;
	private static ItemDAOImple daoI;
	private static JoinDAOImple daoJ;
	public static JoinVO vo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		daoV = VendorDAOImple.getInstance();
		daoI = ItemDAOImple.getInstance();
		daoJ = JoinDAOImple.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramMain window = new ProgramMain();
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
	public ProgramMain() {
		initialize();
	} 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblId = new JLabel("아이디");
		lblId.setBounds(23, 97, 52, 15);
		frame.getContentPane().add(lblId);

		lblPw = new JLabel("비밀번호");
		lblPw.setBounds(23, 128, 52, 15);
		frame.getContentPane().add(lblPw);

		// 회원가입 프레임으로 넘어가게
		btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoinFrame joinFrame = new JoinFrame(frame);
				joinFrame.setVisible(true);
			}
		});
		btnJoin.setBounds(245, 114, 95, 29);
		frame.getContentPane().add(btnJoin);

		lblLogo = new JLabel("");
		lblLogo.setVisible(false);
		lblLogo.setBounds(25, 10, 255, 28);
		frame.getContentPane().add(lblLogo);

		btnLogout = new JButton("로그아웃");
		btnLogout.setVisible(false);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(currentComponent, "로그아웃됩니다.");
				btnLogin.setVisible(true);
				btnJoin.setVisible(true);
				lblId.setVisible(true);
				lblPw.setVisible(true);
				txtId.setVisible(true);
				pwF.setVisible(true);
				
				btnLogout.setVisible(false);
				lblLogo.setVisible(false);
				btnItem.setEnabled(false);
				btnVendor.setEnabled(false);
			}
		});
		btnLogout.setBounds(355, 76, 95, 28);
		frame.getContentPane().add(btnLogout);

		// 거래처프레임으로 넘어가게
		btnVendor = new JButton("거래처 관리");
		btnVendor.setEnabled(false);
		btnVendor.setBounds(245, 186, 141, 36);
		btnVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendorFrame v = new VendorFrame(frame);
				v.setVisible(true);
			}
		});
		frame.getContentPane().add(btnVendor);

		// 아이템 프레임으로 넘어가게
		btnItem = new JButton("아이템 관리");
		btnItem.setEnabled(false);
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemFrame i = new ItemFrame(frame);
				i.setVisible(true);
			}
		});
		btnItem.setBounds(70, 186, 141, 36);
		frame.getContentPane().add(btnItem);

		lblmain = new JLabel("거래처, 아이템 등록 프로그램");
		lblmain.setFont(new Font("굴림", Font.PLAIN, 20));
		lblmain.setBounds(107, 28, 288, 46);
		frame.getContentPane().add(lblmain);

		txtId = new JTextField();
		txtId.setBounds(85, 94, 117, 21);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

		pwF = new JPasswordField();
		pwF.setBounds(85, 125, 117, 21);
		frame.getContentPane().add(pwF);

		// 로그인 기능
		btnLogin = new JButton("로그인");
		btnLogin.setBounds(355, 114, 95, 29);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String pw = new String(pwF.getPassword());

				if (id.contains(" ") || pw.contains(" ")) {
					JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.", "errors", JOptionPane.INFORMATION_MESSAGE);
					return;

				} else if (id.equals("") || pw.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요.");
					return;
				}
				int index = -1; 
				try {
					ArrayList<JoinVO> list = daoJ.select();
					for (int i = 0; i < list.size(); i++) { 
						if (id.equals(list.get(i).getJoinId())) {
							index = i;
							break;
						}
					}
					if (index == -1) {
						JOptionPane.showMessageDialog(null, "가입된 내역이 아닙니다.");
						return;
					}
					if (list.get(index).getJoinPassword().equals(pw)) {

						JOptionPane.showMessageDialog(null, "로그인되었습니다. 프로그램 사용이 가능합니다.");
						btnLogout.setVisible(true);
						lblId.setVisible(false);
						lblPw.setVisible(false);
						txtId.setVisible(false);
						pwF.setVisible(false);
						btnLogin.setVisible(false);
						btnJoin.setVisible(false);

						lblLogo.setVisible(true);
						lblLogo.setText(id + "님 환영합니다.");
						btnItem.setEnabled(true);
						btnVendor.setEnabled(true);
						txtId.setText(null);
						pwF.setText(null);
					} else {
						// 비번 틀릴때... 보안을 위해...
						JOptionPane.showMessageDialog(null, "정보를 다시 확인해주세요.");
					}					
				} catch (Exception e1) {					
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "읭?");
				}
			}
		});
		frame.getContentPane().add(btnLogin);
	}
}// end programMain
