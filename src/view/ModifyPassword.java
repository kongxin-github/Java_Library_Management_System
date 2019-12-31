package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import database.ConnectDatabase;

/**
 * 修改密码界面
 * 
 * @author K.X
 * 
 */
public class ModifyPassword extends JFrame {
	/*
	 * 两个标签 用户名 一标签 一文本框 旧密码 一标签 一文本框 新密码 一标签 一文本框 确认密码
	 */
	// 面板
	private JPanel jPanel = new JPanel();
	// 标签
	private JLabel jLabel = new JLabel("用 户 名:");
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel3 = new JLabel("原始密码：");
	private JLabel jLabel4 = new JLabel("新 密 码：");
	private JLabel jLabel5 = new JLabel("确认密码：");
	// 文本框
	private JPasswordField field = new JPasswordField(22);
	private JPasswordField field2 = new JPasswordField(22);
	private JPasswordField field3 = new JPasswordField(22);
	// 字体
	private Font font = new Font("宋体", Font.BOLD, 24);
	private Font font1 = new Font("宋体", Font.BOLD, 22);
	// 按钮 修改
	private JButton button = new JButton("修   改");
	private JFrame frame = new JFrame();

	public ModifyPassword(String user) {
		setSize(600, 450);
		// 改变背景图片
		Icon i = new ImageIcon("img\\ah.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 600, 150);

		setTitle("修改密码");
		jLabel2.setText(user);
		jLabel.setFont(font);
		jLabel2.setFont(font);
		jLabel3.setFont(font);
		jLabel4.setFont(font);
		jLabel5.setFont(font);
		field.setFont(font1);
		field2.setFont(font1);
		field3.setFont(font1);
		button.setFont(font1);

		add();

		jLabel.setBounds(120, 170, 150, 30);
		jLabel2.setBounds(260, 170, 300, 30);
		jLabel3.setBounds(120, 210, 150, 30);
		field.setBounds(260, 215, 140, 25);
		jLabel4.setBounds(120, 250, 150, 30);
		field2.setBounds(260, 255, 140, 25);
		jLabel5.setBounds(120, 290, 150, 30);
		field3.setBounds(260, 295, 140, 25);
		button.setBounds(115, 340, 285, 30);

		jPanel.add(jLabel);
		jPanel.add(jLabel2);
		jPanel.add(jLabel3);
		jPanel.add(field);
		jPanel.add(jLabel4);
		jPanel.add(field2);
		jPanel.add(jLabel5);
		jPanel.add(field3);
		jPanel.add(button);
		jPanel.setLayout(null);
		jPanel.setBounds(0, 0, 600, 400);
		jPanel.setOpaque(false);
		add(jPanel);
		add(Label);
		// 不可以改变窗体的大小
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	

	// 比对旧密码
	private boolean comparison(String user, String password) {
		Connection con = ConnectDatabase.connectDB();

		PreparedStatement preSql;
		ResultSet rs;
		String sqlStr = "select * from usertable where user = ?";
		
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, user);
			rs = preSql.executeQuery();
			while (rs.next()) {
				String s = rs.getString(4);
				
				if (s.equals(password)) {
					return true;
				} else {
					return false;
				}
			}
			con.close();
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	// 添加事件
	private void add() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = jLabel2.getText().trim();
				String oldpass = field.getText().trim();
				String newpass = field2.getText().trim();
				String surepass = field3.getText().trim();
				if (comparison(user, oldpass)) {
					if(newpass.length()<6||newpass.length()>16) {
						JOptionPane.showMessageDialog(null, "密码规定6-16位，不能含有空格", "警告", JOptionPane.WARNING_MESSAGE);
						empty();
					}else {
						if (newpass.equals(surepass)) {
							database.ModifyPassword.modifypass(user, newpass);
							JOptionPane.showMessageDialog(null, "修改成功");
	
							JOptionPane.showMessageDialog(null, "请重新登陆");
							dispose();
							frame.dispose();
							new Land();
						}else {
							JOptionPane.showMessageDialog(null, "确认密码不相同", "警告", JOptionPane.WARNING_MESSAGE);
							empty();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "原始密码不正确", "警告", JOptionPane.WARNING_MESSAGE);
					empty();
				}

			}
		});
	}

	private void empty() {
		field.setText("");
		field2.setText("");
		field3.setText("");
	}
}
