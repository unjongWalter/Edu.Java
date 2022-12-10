package edu.java.gui10;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
// JMenubar 
public class GuiMain10 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain10 window = new GuiMain10();
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
	public GuiMain10() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("FIle");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JFileChooser : 파일을 선택할 수 있는 팝업창
				JFileChooser chooser = new JFileChooser();
				int result = chooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) { // 확인 버튼 클릭 시
					System.out.println("파일 선택");
					File selected = chooser.getSelectedFile();
					System.out.println(selected.getAbsolutePath());				
				} else { // 취소 버튼 클릭 시
					System.out.println("취소");
				}						
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ConfirmDialog : 
				// Yes(확인) - No(아니오) - Cancel(취소) 버튼을 갖는 다이얼로그
				int result = // frame.get~을 안하면 창이 중앙이 아닌, 윈도우 중앙으로 나온다.
						JOptionPane.showConfirmDialog(frame.getContentPane(), "종료하시게...");
						// parentComponent : 부모컴퍼넌트를 설정, 현재 컴퍼넌트의 보여줄 위치를 설정한다.
				System.out.println("네 선택이란다 : " + result);
				if(result == JOptionPane.YES_OPTION) {
					// 프로그램 종료 :
					// System.exit(0); 정상 종료
					// System.exit(0 이외 숫자); 비정상 종료
					System.exit(0);		
					
				} else {
					System.out.println("취소");
				}			
				
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메시지와 Ok 버튼만 있는 다이얼로그 : MessageDialog
				JOptionPane.showMessageDialog(frame, "버전 0.000000000001");	
			
			}
		});
		mnHelp.add(mntmAbout);
	}

}
