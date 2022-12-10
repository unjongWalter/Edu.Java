package edu.java.project01;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

// 키워드 검색가능 기능???, 숫자만 입력할 수 있도록
public class VendorFrame extends JFrame {

	private JPanel contentPane;

	// 테이블 띄우기
	private JTable table;
	private String[] colNamesV = { "거래처번호", "거래처명", "전화번호", "이메일" };
	private Object[] recordsV = new Object[colNamesV.length];
	private DefaultTableModel tableModel;

	public static VendorDAO daoV;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtId;

	public VendorFrame(JFrame mainFrame) { // 메인과 연동되도록

		daoV = VendorDAOImple.getInstance(); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 608);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 7, 7, 7));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 등록 버튼
		JButton btninsert = new JButton("등록");
		btninsert.addActionListener((e) -> {
			insertVendor();
			selectAllVendor();// 등록시 전체 내용 다 보여주는

		});
		btninsert.setBackground(SystemColor.info);
		btninsert.setFont(new Font("고딕", Font.BOLD, 18));
		btninsert.setBounds(467, 27, 114, 29);
		contentPane.add(btninsert);

		// 조회 버튼
		JButton btnselect = new JButton("전체조회");
		btnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAllVendor();
			}
		});
		btnselect.setBackground(SystemColor.info);
		btnselect.setFont(new Font("고딕", Font.BOLD, 18));
		btnselect.setBounds(602, 27, 114, 29);
		contentPane.add(btnselect);

		// 수정 버튼, txt get해서 DB 수정 query도 바꿈.
		JButton btnupdate = new JButton("수정");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVendor();
				selectAllVendor();
			}
		});
		btnupdate.setBackground(SystemColor.info);
		btnupdate.setFont(new Font("고딕", Font.BOLD, 18));
		btnupdate.setBounds(467, 66, 114, 29);
		contentPane.add(btnupdate);

		// 삭제 버튼
		JButton btndelete = new JButton("삭제");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteVendor();
				selectAllVendor();
			}
		});
		btndelete.setBackground(SystemColor.info);
		btndelete.setFont(new Font("고딕", Font.BOLD, 18));
		btndelete.setBounds(602, 66, 114, 29);
		contentPane.add(btndelete);

		// 초기화면 이동 버튼
		JButton btntoMain = new JButton("초기화면 이동");
		btntoMain.setForeground(Color.WHITE);
		btntoMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "초기화면으로 돌아가시겠습니까?", null, JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					VendorFrame.this.setVisible(false);
					mainFrame.setVisible(true);
				}
			}
		});

		btntoMain.setFont(new Font("Dialog", Font.BOLD, 18));
		btntoMain.setBackground(SystemColor.textHighlight);
		btntoMain.setBounds(266, 32, 158, 29);
		contentPane.add(btntoMain);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 120, 421, 431);
		scrollPane.setColumnHeaderView(table);
		contentPane.add(scrollPane);

		JTextArea txtItemInfo = new JTextArea();
		txtItemInfo.setFont(new Font("고딕", Font.BOLD, 20));
		txtItemInfo.setBackground(SystemColor.gray);
		txtItemInfo.setBounds(500, 300, 400, 300);
		contentPane.add(scrollPane);

		JLabel lblVendorTitle = new JLabel("거래처 관리 메뉴");
		lblVendorTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendorTitle.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		lblVendorTitle.setBackground(SystemColor.activeCaption);
		lblVendorTitle.setBounds(39, 10, 194, 51);
		contentPane.add(lblVendorTitle);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(557, 179, 154, 39);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhone.setColumns(10);
		txtPhone.setBounds(557, 228, 154, 39);
		contentPane.add(txtPhone);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setColumns(10);
		txtEmail.setBounds(557, 277, 154, 39);
		contentPane.add(txtEmail);

		// table 클릭 막아두자.
		tableModel = new DefaultTableModel(colNamesV, 0){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {

			// 각 txt에서 읽어와서 다시 쓰기,
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel data = table.getModel();

				int vendorNo = (int) data.getValueAt(index, 0);
				String vendorName = (String) data.getValueAt(index, 1);
				String vendorPhone = (String) data.getValueAt(index, 2);
				String vendorEmail = (String) data.getValueAt(index, 3);

				txtId.setText(Integer.toString(vendorNo));
				txtName.setText(vendorName);
				txtPhone.setText(vendorPhone);
				txtEmail.setText(vendorEmail);
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		JLabel lblName = new JLabel("거래처명 :");
		lblName.setBackground(new Color(230, 230, 250));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblName.setBounds(445, 181, 100, 34);
		contentPane.add(lblName);

		JLabel lblPhone = new JLabel("전화번호 :");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPhone.setBackground(new Color(230, 230, 250));
		lblPhone.setBounds(445, 230, 100, 34);
		contentPane.add(lblPhone);

		JLabel lblEmail = new JLabel("이메일 :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblEmail.setBackground(new Color(230, 230, 250));
		lblEmail.setBounds(455, 277, 90, 34);
		contentPane.add(lblEmail);

		JLabel lblVendor = new JLabel("거래처번호 :");
		lblVendor.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblVendor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendor.setBounds(445, 133, 100, 39);
		contentPane.add(lblVendor);
		
		JLabel lblNewLabel = new JLabel("* 거래처번호는 자동저장됩니다.");
		lblNewLabel.setBounds(12, 87, 226, 23);
		contentPane.add(lblNewLabel);

		// 인덱스 보여준다
		txtId = new JTextField("table 선택 or 인덱스 입력");
		txtId.setForeground(Color.GRAY);
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtId.setText("");
			}
		});		
		txtId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtId.setBackground(Color.WHITE);		
		txtId.setBounds(557, 133, 154, 36);		
		txtId.setColumns(10);
		contentPane.add(txtId);
		
			}
	// 삭제기능
	private void deleteVendor() {
		try {
			int vendorId = Integer.parseInt(txtId.getText());
			int result = daoV.delete(vendorId);

			if (result == 1) {
				JOptionPane.showMessageDialog(null, "거래처정보 삭제완료되었습니다.");
				txtId.setText(null);
				txtName.setText(null);
				txtPhone.setText(null);
				txtEmail.setText(null);
			} else {
				JOptionPane.showMessageDialog(null, "없는 인덱스숫자입니다.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "해당등록된 정보가 없습니다.");
			return;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "삭제 실패하였습니다.");
			e.printStackTrace();
		}
	}// end deleteVendor

	// 등록기능
	private void insertVendor() {
		try {
			String vendorName = txtName.getText();
			String vendorPhone = txtPhone.getText();
			String vendorEmail = txtEmail.getText();

			if (vendorName.contains(" ") || vendorPhone.contains(" ") || vendorEmail.contains(" ")) {
				JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
				return;

			} else if (vendorName.equals("") || vendorPhone.equals("") || vendorEmail.equals("")) {
				JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
				return;
			}

			VendorVO vo = new VendorVO(0, vendorName, vendorPhone, vendorEmail);
			int result = daoV.insert(vo);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "등록완료되었습니다.");
//				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "등록실패되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end insertVendor

	// 수정
	private void updateVendor() {
		try {
			int vendorId = Integer.parseInt(txtId.getText()); // 문자 or 숫자 -> 파싱으로 명확화해야해
			String name = txtName.getText();
			String phone = txtPhone.getText();
			String email = txtEmail.getText();

			if (name.contains(" ") || phone.contains(" ") || email.contains(" ")) {
				JOptionPane.showMessageDialog(null, "공백없이 입력해달랍니요.");
				return; 
			} else if (name.equals("") || phone.equals("") || email.equals("")){
				JOptionPane.showMessageDialog(null, "수정할 정보를 모두 입력해달랍니다요");
				return;
			}

			VendorVO vo = new VendorVO(vendorId, name, phone, email);
			int result = daoV.update(vo); // vo에 있으니까!
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "수정되었답니다요.");
			} else { // contactId에 비어있기에 큰 에러다...
				JOptionPane.showMessageDialog(null, "수정할 내용이 없답니다요.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "입력한 값을 확인해달랍니다요.");
			return;
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "다시 확인해달랍니다요.");
			e.printStackTrace();
		}
	}// end updateVendor

	// 전체 테이블 보여주기, 예외처리 : 빈칸, 노데이터 외
	private void selectAllVendor() {
		try {
			ArrayList<VendorVO> list = daoV.select();
			tableModel.setRowCount(0);
			for (int i = 0; i < list.size(); i++) {
				recordsV[0] = list.get(i).getVendorId();
				recordsV[1] = list.get(i).getVendorName();
				recordsV[2] = list.get(i).getVendorPhone();
				recordsV[3] = list.get(i).getVendorEmail();
				tableModel.addRow(recordsV);
			} if (recordsV[0] == null) {
				JOptionPane.showMessageDialog(null, "조회할 정보가 없답니다요.");
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "등록된 데이터가 없답니다. 먼저 등록하랍니다요.");
			e.printStackTrace();
			return;
		} catch (IllegalArgumentException e) {
			JOptionPane.showConfirmDialog(null, "확인하여 다시 시도해달랍니요.");
			e.printStackTrace();
			return;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "데이터를 먼저 등록하랍니다요.");
			e.printStackTrace();
		}
	}// end selectAllVendorTable()

} // end VendorFrame
