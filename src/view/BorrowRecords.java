package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.ConnectDatabase;

/**
 * 用户借书记录界面
 * 
 * @author K.X
 * 
 */
public class BorrowRecords extends JFrame {
	/*
	 * 背景图片 表格
	 */
	// 面板
	private JPanel jPanel = new JPanel();
	// 分层窗格
	private JLayeredPane jLayeredPane = new JLayeredPane();
	// 标签
	private JLabel jLabel = new JLabel("借书记录");
	// 字体
	private Font font = new Font("宋体", Font.BOLD, 40);
	// 表格
	public DefaultTableModel model = new DefaultTableModel();

	public BorrowRecords(String user) {
		// 改变背景图片
		Icon i = new ImageIcon("img\\tabletop.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 800, 100);
		setLayout(null);
		setSize(800, 600);
		setLocationRelativeTo(null);

		jLabel.setFont(font);
		jLabel.setBounds(315, 80, 400, 100);

		jPanel.add(jLabel);
		// 表格
		model.addColumn("书号", new Vector<Integer>());
		model.addColumn("书名", new Vector<Integer>());
		model.addColumn("借书日期", new Vector<Integer>());
		model.addColumn("还书日期", new Vector<Integer>());
		model.addColumn("状态", new Vector<Integer>());
		JTable jTable = new JTable(model);
		JScrollPane pane = new JScrollPane(jTable);
		pane.setBounds(80, 160, 640, 350);
		jLayeredPane.add(pane);

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

		borrow(model, user);

		jPanel.setBounds(0, 0, 800, 200);
		jPanel.setOpaque(false);
		jPanel.setLayout(null);
		setTitle("借书记录");
		// 不可以改变窗体的大小
		setResizable(false);
		setContentPane(jLayeredPane);
		add(jPanel);
		add(Label);
		setVisible(true);
	}

	private void borrow(DefaultTableModel model, String user) {
		Connection con = ConnectDatabase.connectDB();
		PreparedStatement preSql;
		ResultSet rs;
		String sqlStr = "select * from borrowrecords where user = ?";
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, user);
			rs = preSql.executeQuery();
			boolean flag = false;
			while (rs.next()) {
				flag = true;
				int bookid = rs.getInt(3);
				String bookname = rs.getString(4);
				Date date = rs.getDate(5);
				Date date2 = rs.getDate(6);
				String state = rs.getString(7);
				model.addRow(new Vector<>(Arrays.asList(bookid, bookname, date, date2, state)));
			}
			if (!flag) {
				JOptionPane.showMessageDialog(null, "您还没有借书哦！");
			}
			con.close();
		} catch (SQLException e) {
		}
	}
}
