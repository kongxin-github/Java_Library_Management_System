package view;

import java.awt.Color;
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

import database.Adduser;

/**
 * 注册界面
 * 
 * @author K.X
 * 
 */
public class Register {

	/*
	 * 七个标签 五个个文本框 一个按钮 七个面板
	 */
	// 标签
	private JLabel jLabel = new JLabel("注 册");
	private JLabel jLabel2 = new JLabel("用 户 名：");
	private JLabel jLabel3 = new JLabel(" 学  号：");
	private JLabel jLabel4 = new JLabel(" 姓  名：");
	private JLabel jLabel5 = new JLabel(" 密  码：");
	private JLabel jLabel6 = new JLabel("确认密码:");
	private JLabel jLabel7 = new JLabel("                                       密码长度：6~16位，不能含有空格 ");

	private String user;
	private String studentid;
	private String name;
	private String password;
	private String password2;
	// 字体
	private Font font = new Font("宋体", Font.BOLD, 40);
	private Font font2 = new Font("宋体", Font.BOLD, 25);
	private Font font3 = new Font("宋体", Font.BOLD, 20);
	private Font font4 = new Font("小篆", Font.ITALIC, 13);
	private Font font5 = new Font("宋体", Font.BOLD, 17);
	// 文本框
	private JTextField field = new JTextField(18);
	private JTextField field2 = new JTextField(18);
	private JTextField field3 = new JTextField(18);
	private JPasswordField field4 = new JPasswordField(18);
	private JPasswordField field5 = new JPasswordField(18);

	// 按钮
	private JButton button = new JButton("注 册");
	private JButton button2 = new JButton("返回");
	// 大小
	private Dimension dimension = new Dimension(350, 40);
	// 面板
	private JPanel jPanel = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JPanel jPanel3 = new JPanel();
	private JPanel jPanel4 = new JPanel();
	private JPanel jPanel5 = new JPanel();
	private JPanel jPanel6 = new JPanel();
	private JPanel jPanel7 = new JPanel();

	// 窗体
	private JFrame frame = new JFrame("注册");

	public Register() {
		// 窗体大小
		frame.setSize(450, 600);
		// 布局为空
		frame.setLayout(null);
		// 居中
		frame.setLocationRelativeTo(null);
		// 改变窗口图标
		Toolkit t = Toolkit.getDefaultToolkit();
		Image image = t.getImage("img\\top.jpg");
		frame.setIconImage(image);

		addassembly();

		transparent();

		addEvent();
		// 改变背景图片
		Icon i = new ImageIcon("img\\register.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 450, 600);
		frame.add(Label);
		// 不可改变大小
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
		jLabel4.setFont(font2);
		jLabel5.setFont(font2);
		jLabel6.setFont(font2);
		jLabel7.setFont(font4);
		jLabel7.setForeground(Color.red);
		
		jLabel.setBounds(170, 30, 150, 60);
		button.setFont(font2);
		field.setFont(font3);
		field2.setFont(font3);
		field3.setFont(font3);
		field4.setFont(font3);
		field5.setFont(font3);
		field.setForeground(Color.blue);
		field2.setForeground(Color.blue);
		field3.setForeground(Color.blue);
		field4.setForeground(Color.blue);
		field5.setForeground(Color.blue);
		// 按钮设置大小
		button.setPreferredSize(dimension);
		button2.setFont(font5);
		button2.setBounds(2, 2, 70, 30);
		button2.setBackground(Color.cyan);
		button2.setOpaque(false);
		// 加入面板
		jPanel.add(button2);
		jPanel.add(jLabel);
		jPanel2.add(jLabel2);
		jPanel2.add(field);
		jPanel3.add(jLabel3);
		jPanel3.add(field2);
		jPanel4.add(jLabel4);
		jPanel4.add(field3);
		jPanel5.add(jLabel5);
		jPanel5.add(field4);
		jPanel5.add(jLabel7);
		jPanel6.add(jLabel6);
		jPanel6.add(field5);
		jPanel7.add(button);
		jPanel.setLayout(null);
		// 面板位置
		jPanel.setBounds(0, 0, 450, 110);
		jPanel2.setBounds(0, 110, 450, 50);
		jPanel3.setBounds(0, 180, 450, 50);
		jPanel4.setBounds(0, 250, 450, 50);
		jPanel5.setBounds(0, 320, 450, 70);
		jPanel6.setBounds(0, 390, 450, 50);
		jPanel7.setBounds(0, 460, 450, 60);
		// 添加到窗体
		frame.add(jPanel);
		frame.add(jPanel2);
		frame.add(jPanel3);
		frame.add(jPanel4);
		frame.add(jPanel5);
		frame.add(jPanel6);
		frame.add(jPanel7);

	}

	private void transparent() {
		// 标签透明
		jLabel.setOpaque(false);
		jLabel2.setOpaque(false);
		jLabel3.setOpaque(false);
		jLabel4.setOpaque(false);
		jLabel5.setOpaque(false);
		jLabel6.setOpaque(false);
		// 文本框透明
		field.setOpaque(false);
		field2.setOpaque(false);
		field3.setOpaque(false);
		field4.setOpaque(false);
		field5.setOpaque(false);
		// 面板透明
		jPanel.setOpaque(false);
		jPanel2.setOpaque(false);
		jPanel3.setOpaque(false);
		jPanel4.setOpaque(false);
		jPanel5.setOpaque(false);
		jPanel6.setOpaque(false);
		jPanel6.setOpaque(false);
		jPanel7.setOpaque(false);
	}

	private void addEvent() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user = field.getText().trim();
				studentid = field2.getText().trim();
				name = field3.getText().trim();
				password = field4.getText().trim();
				password2 = field5.getText().trim();
				if (user.length() == 0) {
					JOptionPane.showMessageDialog(null, "用户名不能为空", "警告", JOptionPane.WARNING_MESSAGE);
					empty();
				} else if (studentid.length() == 0) {
					JOptionPane.showMessageDialog(null, "学号不能为空", "警告", JOptionPane.WARNING_MESSAGE);
					empty();
				} else if (name.length() == 0) {
					JOptionPane.showMessageDialog(null, "姓名不能为空", "警告", JOptionPane.WARNING_MESSAGE);
					empty();
				} else if (password.length() < 6 || password.length() > 12) {
					JOptionPane.showMessageDialog(null, "密码输入不正确", "警告", JOptionPane.WARNING_MESSAGE);
					empty();
				} else if (!(password.equals(password2))) {
					JOptionPane.showMessageDialog(null, "两次输入密码不相同", "警告", JOptionPane.WARNING_MESSAGE);
					empty();
				} else {
					if (Adduser.adduser(user, studentid, name, password)) {
						JOptionPane.showMessageDialog(null, "注册成功");
						//frame.setVisible(false);
						frame.dispose();
						new Land();
					} else {
						empty();
					}

				}
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new Land();
			}
		});
	}

	private void empty() {
		field.setText("");
		field2.setText("");
		field3.setText("");
		field4.setText("");
		field5.setText("");
	}
}
