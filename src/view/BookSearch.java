package view;
/**
 * 图书查询界面
 * @author K.X
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.FindBook;

public class BookSearch {
	/*
	 * 一个大标签
	 * 
	 * 一个下拉框 一个文本框 一个按钮
	 * 
	 * 一个表格
	 */
	// 分层窗格
	public JLayeredPane jLayeredPane = new JLayeredPane();
	// 标签
	private JLabel jLabel = new JLabel("图书查询");
	private JLabel jLabel2 = new JLabel("请选择查询方式：");
	// 文本框
	private JTextField field = new JTextField(25);
	// 大小
	private Dimension dimension = new Dimension(220, 30);
	// 下拉框
	private JComboBox<String> box = new JComboBox<String>();
	// 按钮
	private JButton button = new JButton("搜索");
	// 表格
	public DefaultTableModel model = new DefaultTableModel();
	// 字体
	private Font font = new Font("宋体", Font.BOLD, 60);
	private Font font1 = new Font("宋体", Font.BOLD, 25);
	private Font font2 = new Font("宋体", Font.BOLD, 20);
	// 存储下拉选项
	private String s;
	private String book;
	private int id;

	public BookSearch() {
		// 改变背景图片
		Icon i = new ImageIcon("img\\booksearch.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 1200, 800);
		// 标签
		jLabel.setFont(font);
		jLabel.setBounds(485, 35, 800, 100);
		jLabel.setForeground(Color.cyan);

		jLabel2.setFont(font1);
		jLabel2.setBounds(180, 130, 250, 30);
		jLabel2.setForeground(Color.cyan);

		// 下拉框
		box.setSize(dimension);
		box.addItem("按照类别查找");
		box.addItem("按照书名查找");
		box.addItem("按照作者查找");
		box.addItem("按照书号查找");
		box.setFont(font2);
		box.setBounds(180, 170, 200, 40);
		// box.setBackground(Color.cyan);
		box.setOpaque(false);

		// 文本框
		field.setFont(font2);
		field.setSize(dimension);
		field.setBackground(Color.cyan);
		field.setBounds(480, 173, 250, 35);
		field.setForeground(Color.cyan);
		field.setOpaque(false);

		// 按钮
		button.setFont(font1);
		button.setBounds(850, 170, 100, 40);
		button.setForeground(Color.cyan);
		button.setBackground(Color.cyan);
		button.setOpaque(false);

		// 表格
		model.addColumn("书号", new Vector<Integer>());
		model.addColumn("类别", new Vector<Integer>());
		model.addColumn("书名", new Vector<Integer>());
		model.addColumn("作者", new Vector<Integer>());
		model.addColumn("出版社", new Vector<Integer>());
		model.addColumn("状态", new Vector<Integer>());
		JTable jTable = new JTable(model);

		JScrollPane pane = new JScrollPane(jTable);
		pane.setBounds(180, 250, 800, 400);

//		for(int k = 0; k < 30; k++) {
//			model.addRow(new Vector<Integer>());
//		}
		FindBook.allbook(model);

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
		
		//添加事件
		addEvent();
		
		// 加入分层窗口
		jLayeredPane.add(Label, new Integer(0), 0);
		jLayeredPane.add(jLabel, new Integer(100), 1);
		jLayeredPane.add(jLabel2, new Integer(100), 2);
		jLayeredPane.add(box, new Integer(100), 3);
		jLayeredPane.add(field, new Integer(100), 4);
		jLayeredPane.add(button, new Integer(100), 5);
		jLayeredPane.add(pane, new Integer(100), 6);
	}

	private void addEvent() {
		
		//获取下拉列表值
		s = "按照类别查找";
		box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					s=(String)e.getItem();
				}
			}
		});
		
		//添加搜索按钮事件
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.setRowCount(0);
				if(s.equals("按照类别查找")) {
					book=field.getText().trim();
					FindBook.findcategory(model, book);
				}else if(s.equals("按照书名查找")) {
					book=field.getText().trim();
					FindBook.findbookname(model, book);
				}else if(s.equals("按照作者查找")) {
					book=field.getText().trim();
					FindBook.findauthor(model, book);
				}else if(s.equals("按照书号查找")) {
					try {
						id= Integer.parseInt(field.getText().trim());
						FindBook.findbookid(model, id);
					}catch(Exception e1) {
					}
				}
				field.setText("");
			}
		});
	}
}
