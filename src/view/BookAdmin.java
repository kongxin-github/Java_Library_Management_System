package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * 图书管理界面
 * 
 * @author K.X
 * 
 */
public class BookAdmin {
	/*
	 * 标签
	 *
	 * 五个按钮 添加图书信息 修改图书信息 删除图书信息 添加图书类别 修改图书类别
	 * 
	 */
	// 面板
	public JPanel jPanel2 = new JPanel();
	// 标签
	private JLabel jLabel = new JLabel("图书管理");
	// 按钮
	private JButton button = new JButton("添加图书信息");
	private JButton button2 = new JButton("修改图书信息");
	private JButton button3 = new JButton("删除图书信息");
	private JButton button4 = new JButton("添加图书类别");
	private JButton button5 = new JButton("修改图书类别");
	// 字体
	private Font font = new Font("宋体", Font.BOLD, 60);
	private Font font1 = new Font("宋体", Font.BOLD, 25);
	// 表格 用于更新图书搜索界面的表格
	public DefaultTableModel model = new DefaultTableModel();

	public BookAdmin() {
		// 改变背景图片
		Icon i = new ImageIcon("img\\bookadmin.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 1200, 800);
		// 面板布局为空
		jPanel2.setLayout(null);
		// 标签
		jLabel.setFont(font);
		jLabel.setBounds(460, 50, 800, 70);
		// 按钮
		button.setFont(font1);
		button2.setFont(font1);
		button3.setFont(font1);
		button4.setFont(font1);
		button5.setFont(font1);
		button.setBounds(150, 190, 250, 50);
		button2.setBounds(150, 250, 250, 50);
		button3.setBounds(150, 310, 250, 50);
		button4.setBounds(150, 370, 250, 50);
		button5.setBounds(150, 430, 250, 50);

		button.setBackground(Color.cyan);
		button2.setBackground(Color.cyan);
		button3.setBackground(Color.cyan);
		button4.setBackground(Color.cyan);
		button5.setBackground(Color.cyan);

		button.setOpaque(false);
		button2.setOpaque(false);
		button3.setOpaque(false);
		button4.setOpaque(false);
		button5.setOpaque(false);
		
		//添加事件
		add();
		
		jPanel2.add(button);
		jPanel2.add(button2);
		jPanel2.add(button3);
		jPanel2.add(button4);
		jPanel2.add(button5);
		jPanel2.add(jLabel);
		jPanel2.add(Label);
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	// 添加事件
	private void add() {
		// 添加图书信息
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddBook addBook = new AddBook();
				addBook.setModel(model);
			}
		});

		// 修改图书信息
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ModifyBook modifyBook = new ModifyBook();
				modifyBook.setModel(model);
			}
		});

		// 删除图书信息
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteBook deleteBook = new DeleteBook();
				deleteBook.setModel(model);
			}
		});

		// 添加图书类别
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddCategory();
			}
		});

		// 修改图书类别
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ModifyCategory();
			}
		});

	}
}
