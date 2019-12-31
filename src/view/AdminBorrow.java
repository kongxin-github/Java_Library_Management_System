package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.ConnectDatabase;
import database.FindBook;
import database.FindBorrow;

/**
 * 管理员借书记录页面
 * 
 * @author K.X
 */
public class AdminBorrow extends JFrame {
	/*
	 * 背景图片 表格
	 * 
	 * 下拉框 文本框 按钮
	 */
	// 面板
	private JPanel jPanel = new JPanel();
	// 分层窗格
	private JLayeredPane jLayeredPane = new JLayeredPane();
	// 标签
	private JLabel jLabel = new JLabel("借书记录");
	private JLabel jLabel2 = new JLabel("请选择查询方式：");
	// 文本框
	private JTextField field = new JTextField(20);
	// 下拉框
	private JComboBox<String> box = new JComboBox<String>();
	// 按钮
	private JButton button = new JButton("搜索");
	// 字体
	private Font font = new Font("宋体", Font.BOLD, 40);
	private Font font2 = new Font("宋体", Font.BOLD, 20);
	private Font font3 = new Font("宋体", Font.BOLD, 18);
	private Font font4 = new Font("宋体", Font.BOLD, 17);
	// 表格
	public DefaultTableModel model = new DefaultTableModel();
	// 存储下拉选项
	private String s;
	private int num;

	public AdminBorrow() {
		// 改变背景图片
		Icon i = new ImageIcon("img\\admintop.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 850, 100);
		setLayout(null);
		setSize(850, 650);
		setLocationRelativeTo(null);

		jLabel.setFont(font);
		jLabel.setBounds(345, 80, 400, 100);

		jLabel2.setFont(font4);
		jLabel2.setBounds(95, 140, 250, 30);

		// 下拉框
		box.addItem("按照用户名查找");
		box.addItem("按照书号查找");
		box.setFont(font3);
		box.setBounds(95, 175, 160, 30);
		// box.setBackground(Color.cyan);
		box.setOpaque(false);

		// 文本框
		field.setFont(font2);
		field.setBackground(Color.cyan);
		field.setBounds(325, 175, 200, 30);
		field.setOpaque(false);

		// 按钮
		button.setFont(font2);
		button.setBounds(590, 173, 80, 35);
		button.setBackground(Color.cyan);
		button.setOpaque(false);

		jPanel.add(jLabel);
		jPanel.add(jLabel2);
		jPanel.add(box);
		jPanel.add(field);
		jPanel.add(button);
		// 表格
		model.addColumn("用户名", new Vector<Integer>());
		model.addColumn("书号", new Vector<Integer>());
		model.addColumn("书名", new Vector<Integer>());
		model.addColumn("借书日期", new Vector<Integer>());
		model.addColumn("还书日期", new Vector<Integer>());
		model.addColumn("状态", new Vector<Integer>());
		JTable jTable = new JTable(model);
		JScrollPane pane = new JScrollPane(jTable);
		pane.setBounds(80, 220, 690, 340);
		jLayeredPane.add(pane);

		// 所有借书记录
		FindBorrow.allborrow(model);
		
		setTitle("借书记录");
		// 不可以改变窗体的大小
		setResizable(false);
		// 添加事件
		addEvent();
		JTableHeader head = jTable.getTableHeader();
		// 设置表头的大小
		head.setPreferredSize(new Dimension(head.getWidth(), 30));
		// 设置表头字体大小
		head.setFont(new Font("宋体", Font.BOLD, 20));
		// head.setForeground(Color.cyan);
		head.setBackground(Color.cyan);
		// 设置表格的行宽
		jTable.setRowHeight(30);
		// 设置表格行中字体大小
		jTable.setFont(new Font("宋体", Font.ROMAN_BASELINE, 17));
		/* 设置表格中的内容居中 */
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		jTable.setDefaultRenderer(Object.class, renderer);

		// jPanel.setBackground(Color.blue);
		jPanel.setBounds(0, 0, 850, 250);
		jPanel.setOpaque(false);
		jPanel.setLayout(null);
		setContentPane(jLayeredPane);
		add(jPanel);
		add(Label);
		setVisible(true);
	}

	private void addEvent() {

		// 获取下拉列表值
		s = "按照用户名查找";
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					s = (String) e.getItem();
				}
			}
		});

		// 添加搜索按钮事件
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.setRowCount(0);
				if (s.equals("按照用户名查找")) {
					try {
						String user = field.getText().trim();
						FindBorrow.userborrow(model, user);
					} catch (Exception e1) {
					}
				} else if (s.equals("按照书号查找")) {
					try {
						num = Integer.parseInt(field.getText().trim());
						FindBorrow.bookidborrow(model, num);
					} catch (Exception e1) {
					}
				}
				field.setText("");
			}
		});
	}
}
