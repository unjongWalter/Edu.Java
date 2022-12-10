package edu.java.project01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ItemFrame extends JFrame {

	private JPanel contentPane;

	// 스윙테이블 이용하자
	private JTable table;
	private String[] colNames = { "번호", "이름", "매입가", "판매가", "매입수량", "판매수량", "거래처", "거래일" };
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	
	private JTextField txtItemId;
	private JTextField txtPurchase_P;
	private JTextField txtSales_P;
	private JTextField txtPurchase_C;
	private JTextField txtSales_C;
	private JTextField txtVendor_Name;
	private JTextField txtItemName;
	
	public static ItemDAO daoI;
	
	public ItemFrame(JFrame mainFrame) { // main으로!

		daoI = ItemDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 789, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 7, 7, 7));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btninsert = new JButton("등록");
		btninsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertItem();
				selectallItem();
			}
		});
		btninsert.setForeground(Color.WHITE);

		btninsert.setBackground(SystemColor.textHighlight);
		btninsert.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btninsert.setBounds(521, 17, 113, 29);
		contentPane.add(btninsert);

		JButton btnselect = new JButton("전체조회");
		btnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectallItem();
			}
		});
		btnselect.setForeground(Color.WHITE);
		btnselect.setBackground(SystemColor.textHighlight);
		btnselect.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btnselect.setBounds(646, 17, 113, 29);
		contentPane.add(btnselect);

		JButton btnupdate = new JButton("수정");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateItem();
				selectallItem();
			}
		});
		btnupdate.setForeground(Color.WHITE);
		btnupdate.setBackground(SystemColor.textHighlight);
		btnupdate.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btnupdate.setBounds(521, 56, 113, 29);
		contentPane.add(btnupdate);

		JButton btndelete = new JButton("삭제");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItem();
				selectallItem();
			}
		});
		btndelete.setForeground(Color.WHITE);
		btndelete.setBackground(SystemColor.textHighlight);
		btndelete.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btndelete.setBounds(646, 56, 113, 29);
		contentPane.add(btndelete);

		JButton btntoMain = new JButton("초기화면 이동");
		btntoMain.setForeground(Color.WHITE);
		btntoMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "초기화면으로 돌아가시겠습니까?", null, JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					ItemFrame.this.setVisible(false);
					mainFrame.setVisible(true);
				}
			}
		});
		btntoMain.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btntoMain.setBackground(SystemColor.textHighlight);
		btntoMain.setBounds(332, 27, 163, 33);
		contentPane.add(btntoMain);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 102, 506, 554);
		contentPane.add(scrollPane);

		// 테이블모델 건들지말자
		tableModel = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int index = table.getSelectedRow();
				TableModel data = table.getModel();

				int itemId = (int) data.getValueAt(index, 0);
				String itemN = (String) data.getValueAt(index, 1);
				String itemPurchaseP = (String) data.getValueAt(index, 2);
				String itemSalesP = (String) data.getValueAt(index, 3);
				String itemPurchaseC = (String) data.getValueAt(index, 4);
				String itemSalesC = (String) data.getValueAt(index, 5);
				String itemVendorName = (String) data.getValueAt(index, 6);
				Date itemD = (Date) data.getValueAt(index, 7);

				txtItemId.setText(Integer.toString(itemId));
				txtItemName.setText(itemN);
				txtPurchase_P.setText(itemPurchaseP);
				txtSales_P.setText(itemSalesP);
				txtPurchase_C.setText(itemPurchaseC);
				txtSales_C.setText(itemSalesC);
				txtVendor_Name.setText(itemVendorName);
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		JTextArea txtItemInfo = new JTextArea();
		txtItemInfo.setFont(new Font("고딕", Font.BOLD, 20));
		txtItemInfo.setBackground(SystemColor.gray);
		txtItemInfo.setBounds(500, 300, 400, 300);
		contentPane.add(scrollPane);

		JLabel lblItemTitle = new JLabel("아이템 관리 메뉴");
		lblItemTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemTitle.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		lblItemTitle.setBackground(SystemColor.activeCaption);
		lblItemTitle.setBounds(33, 5, 220, 51);
		contentPane.add(lblItemTitle);

		// 인덱스 보여준다
		txtItemId = new JTextField("table 선택 or 인덱스 입력");
		txtItemId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtItemId.setText("");
			}
		});
		txtItemId.setForeground(Color.GRAY);
		txtItemId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtItemId.setHorizontalAlignment(SwingConstants.CENTER);
		txtItemId.setBackground(Color.WHITE);
		txtItemId.setColumns(10);
		txtItemId.setBounds(608, 102, 153, 51);
		contentPane.add(txtItemId);

		txtPurchase_P = new JTextField();
		txtPurchase_P.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtPurchase_P.setHorizontalAlignment(SwingConstants.CENTER);
		txtPurchase_P.setBackground(Color.WHITE);
		txtPurchase_P.setColumns(10);
		txtPurchase_P.setBounds(608, 261, 153, 51);
		contentPane.add(txtPurchase_P);

		txtSales_P = new JTextField();
		txtSales_P.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtSales_P.setHorizontalAlignment(SwingConstants.CENTER);
		txtSales_P.setBackground(Color.WHITE);
		txtSales_P.setColumns(10);
		txtSales_P.setBounds(608, 345, 153, 51);
		contentPane.add(txtSales_P);

		txtPurchase_C = new JTextField();
		txtPurchase_C.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtPurchase_C.setHorizontalAlignment(SwingConstants.CENTER);
		txtPurchase_C.setBackground(Color.WHITE);
		txtPurchase_C.setColumns(10);
		txtPurchase_C.setBounds(608, 429, 153, 51);
		contentPane.add(txtPurchase_C);

		txtSales_C = new JTextField();
		txtSales_C.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtSales_C.setHorizontalAlignment(SwingConstants.CENTER);
		txtSales_C.setBackground(Color.WHITE);
		txtSales_C.setColumns(10);
		txtSales_C.setBounds(608, 508, 153, 51);
		contentPane.add(txtSales_C);

		txtVendor_Name = new JTextField();
		txtVendor_Name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtVendor_Name.setHorizontalAlignment(SwingConstants.CENTER);
		txtVendor_Name.setBackground(Color.WHITE);
		txtVendor_Name.setColumns(10);
		txtVendor_Name.setBounds(608, 590, 153, 51);
		contentPane.add(txtVendor_Name);

		txtItemName = new JTextField();
		txtItemName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtItemName.setHorizontalAlignment(SwingConstants.CENTER);
		txtItemName.setBounds(608, 182, 153, 51);
		contentPane.add(txtItemName);
		txtItemName.setColumns(10);

		JLabel lblName = new JLabel("이름 :");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblName.setBounds(535, 183, 78, 51);
		contentPane.add(lblName);

		JLabel lblPurchase_P = new JLabel("매입가 :");
		lblPurchase_P.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchase_P.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPurchase_P.setBounds(530, 262, 83, 51);
		contentPane.add(lblPurchase_P);

		JLabel lblSalse_P = new JLabel("판매가 :");
		lblSalse_P.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalse_P.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblSalse_P.setBounds(535, 346, 78, 51);
		contentPane.add(lblSalse_P);

		JLabel lblPurchase_C = new JLabel("매입수량 :");
		lblPurchase_C.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchase_C.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPurchase_C.setBounds(521, 430, 92, 51);
		contentPane.add(lblPurchase_C);

		JLabel lblSalse_C = new JLabel("판매수량 :");
		lblSalse_C.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalse_C.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblSalse_C.setBounds(523, 509, 90, 51);
		contentPane.add(lblSalse_C);

		JLabel lblVendor_Name = new JLabel("거래처 :");
		lblVendor_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendor_Name.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblVendor_Name.setBounds(530, 591, 83, 51);
		contentPane.add(lblVendor_Name);

		JLabel lblItemId = new JLabel("아이템번호 :");
		lblItemId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblItemId.setBounds(521, 102, 92, 51);
		contentPane.add(lblItemId);

		JLabel lblInfor = new JLabel("* 아이템번호, 등록일은 자동생성됩니다.");
		lblInfor.setBounds(12, 60, 255, 29);
		contentPane.add(lblInfor);
	}

	private void updateItem() {
		try {
			int itemId = Integer.parseInt(txtItemId.getText());
			String itemN = txtItemName.getText();
			String itemPurchaseP = txtPurchase_P.getText();
			String itemSalesP = txtSales_P.getText();
			String itemPurchaseC = txtPurchase_C.getText();
			String itemSalesC = txtSales_C.getText();
			String vendorName = txtVendor_Name.getText();

			// 공백처리
			if (itemN.contains(" ") || itemPurchaseP.contains(" ") || itemSalesP.contains(" ")
					|| itemPurchaseC.contains(" ") || itemSalesC.contains(" ") || vendorName.contains(" ")) {
				JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
				return;

			// 빈칸처리
			} else if (itemN.equals("") || itemPurchaseP.equals("") || itemSalesP.equals("") || itemPurchaseC.equals("")
					|| itemSalesC.equals("") || vendorName.equals("")) {
				JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요.");
				return;
			}

			ItemVO vo = new ItemVO(itemId, itemN, itemPurchaseP, itemSalesP, itemPurchaseC, itemSalesC, vendorName,
					null);
			int result = daoI.update(vo);

			if (result == 1) {
				JOptionPane.showMessageDialog(null, "수정완료 되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "수정실패 하였습니다.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "숫자만 입력해주세요.");
			return;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "다시 확인해주세요.");
			e.printStackTrace();
		}
	}// end updateItem

	private void deleteItem() {
		try {
			int itemId = Integer.parseInt(txtItemId.getText());
			int result = daoI.delete(itemId);

			if (result == 1) {
				JOptionPane.showMessageDialog(null, "삭제완료 되었습니다.");
				// txt에 delete 기능 후 초기화(null 입력 셋)
				txtItemId.setText(null);
				txtItemName.setText(null);
				txtPurchase_P.setText(null);
				txtSales_P.setText(null);
				txtPurchase_C.setText(null);
				txtSales_C.setText(null);
				txtVendor_Name.setText(null);

			} else {
				JOptionPane.showMessageDialog(null, "없는 인덱스숫자입니다.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "등록된 정보가 없습니다.");
			return;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "삭제 실패하였습니다.");
			e.printStackTrace();
		}
	}// end deleteItem

	private void insertItem() {
		try {
			String itemName = txtItemName.getText();
			String itemPurchaseP = txtPurchase_P.getText();
			String itemSalesP = txtSales_P.getText();
			String itemPurchaseC = txtPurchase_C.getText();
			String itemSalesC = txtSales_C.getText();
			String vendorName = txtVendor_Name.getText();

			if (itemName.contains(" ") || itemPurchaseP.contains(" ") || itemSalesP.contains(" ")
					|| itemPurchaseC.contains(" ") || itemSalesC.contains(" ") || vendorName.contains(" ")) {
				JOptionPane.showMessageDialog(null, "공백없이 입력해주세요.");
				return;
			} else if (itemName.equals("") || itemPurchaseP.equals("") || itemSalesP.equals("")
					|| itemPurchaseC.equals("") || itemSalesC.equals("") || vendorName.equals("")) {
				JOptionPane.showMessageDialog(null, "내용을 모두 입력해주세요.");
				return;
			}

			ItemVO vo = new ItemVO(0, itemName, itemPurchaseP, itemSalesP, itemPurchaseC, itemSalesC, vendorName, null);

			int result = daoI.insert(vo);
			if (result == 1) {
				JOptionPane.showInternalMessageDialog(null, "아이템등록 완료되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요.");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}// end inserItem

	private void selectallItem() {
		try {
			ArrayList<ItemVO> list = daoI.select();
			tableModel.setRowCount(0);
			for (int i = 0; i < list.size(); i++) {
				records[0] = list.get(i).getItemId();
				records[1] = list.get(i).getItemN();
				records[2] = list.get(i).getItemPurchaseP();
				records[3] = list.get(i).getItemSalesP();
				records[4] = list.get(i).getItemPurchaseC();
				records[5] = list.get(i).getItemSalesC();
				records[6] = list.get(i).getVendorName();
				records[7] = list.get(i).getItemD();
				tableModel.addRow(records);
			}	if (records[0] == null) {
				JOptionPane.showMessageDialog(null, "조회할 정보가 없답니다.");
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "등록된 데이터가 없답니다. 먼저 등록하랍니다요.");
			return;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "데이터를 먼저 등록하랍니다요.");
			e.printStackTrace();
		}
	}// end selectallItem
} // end ItemFrame
