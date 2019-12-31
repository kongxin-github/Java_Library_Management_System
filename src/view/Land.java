package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.Landing;

/**
 * 登陆界面
 * 
 * @author K.X
 * 
 */

public class Land {

	/*
	 * 定义窗体 一个大标签 两个小标签 两个文本框 两个按钮 五个面板
	 */
	// 标签
	private JLabel jLabel = new JLabel("图书管理系统");
	private JLabel jLabel2 = new JLabel("用户名： ");
	private JLabel jLabel3 = new JLabel("密  码： ");

	// 字体
	private Font font = new Font("宋体", Font.BOLD, 40);
	private Font font2 = new Font("宋体", Font.BOLD, 25);
	private Font font3 = new Font("宋体", Font.BOLD, 20);

	// 文本框
	private JTextField field = new JTextField(22);
	private JPasswordField field2 = new JPasswordField(22);

	// 按钮
	private JButton button = new JButton("登陆");
	private JButton button2 = new JButton("注册");

	// 面板
	private JPanel jPanel = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JPanel jPanel3 = new JPanel();
	private JPanel jPanel4 = new JPanel();
	private JPanel jPanel5 = new JPanel();
	// 窗体
	private JFrame frame = new JFrame("登陆");
	// 大小
	private Dimension dimension = new Dimension(30, 30);
	private Dimension dimension2 = new Dimension(100, 50);
	
	public String user;
	private String password;

	public Land() {
		
		frame.setTitle("登陆");
		// 设置大小
		frame.setSize(550, 500);
		// 居中
		frame.setLocationRelativeTo(null);
		// 布局为空
		frame.setLayout(null);

		// 改变窗口图标
		Toolkit t = Toolkit.getDefaultToolkit();
		Image image = t.getImage("img\\top.jpg");
		frame.setIconImage(image);

		// 添加组件
		addassembly();

		// 设置透明
		transparent();

		// 添加事件
		addEvent();

		// 改变背景图片
		Icon i = new ImageIcon("img\\land1.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 550, 500);
		frame.add(Label);

		// 不可以改变窗体的大小
		frame.setResizable(false);
		// 窗口关闭
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 窗口可见
		frame.setVisible(true);
	}

	private void addassembly() {
		// 添加字体
		jLabel.setFont(font);
		jLabel2.setFont(font2);
		jLabel3.setFont(font2);
		button.setFont(font3);
		button2.setFont(font3);
		field.setFont(font3);
		field2.setFont(font3);
		field.setPreferredSize(dimension);
		field2.setPreferredSize(dimension);
		button.setPreferredSize(dimension2);
		button2.setPreferredSize(dimension2);
//		button.setBackground(Color.pink);
//		button2.setBackground(Color.GRAY);

		jPanel.add(jLabel);
		jPanel2.add(jLabel2);
		jPanel2.add(field);
		jPanel3.add(jLabel3);
		jPanel3.add(field2);
		jPanel4.add(button);
		jPanel5.add(button2);

		jPanel.setBounds(0, 60, 550, 80);
		jPanel2.setBounds(0, 160, 550, 80);
		jPanel3.setBounds(0, 250, 550, 60);
		jPanel4.setBounds(100, 325, 150, 80);
		jPanel5.setBounds(275, 325, 150, 80);

		frame.add(jPanel);
		frame.add(jPanel2);
		frame.add(jPanel3);
		frame.add(jPanel4);
		frame.add(jPanel5);

	}

	private void transparent() {
		// 设置透明
		jLabel.setOpaque(false);
		jLabel2.setOpaque(false);
		jLabel3.setOpaque(false);
		field.setOpaque(false);
		field2.setOpaque(false);
		// button.setOpaque(false);
		// button2.setOpaque(false);
		jPanel.setOpaque(false);
		jPanel2.setOpaque(false);
		jPanel3.setOpaque(false);
		jPanel4.setOpaque(false);
		jPanel5.setOpaque(false);

	}

	private void addEvent() {

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user = field.getText().trim();
				password = field2.getText().trim();
				if(Landing.test(user, password)) {
//					JOptionPane.showMessageDialog(null, "登陆成功");
					frame.dispose();
					new MainInterface(user);
				}else {
					empty();
				}
					
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//frame.setVisible(false);
				frame.dispose();
				new Register();
			}
		});
	}
	private void empty() {
		field.setText("");
		field2.setText("");
	}
}
