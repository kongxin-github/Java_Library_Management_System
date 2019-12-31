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
import javax.swing.JTextField;

import database.ConnectDatabase;

/**
 * 修改信息界面
 * @author K.X
 * 
 * */
public class ModifyInformation extends JFrame{
	/*
	 * 两个标签     用户名
	 * 一标签    一文本框     学号
	 * 一标签    一文本框      姓名
	 * */
	//面板
	private JPanel jPanel = new JPanel();
	//标签
	private JLabel jLabel = new JLabel("用户名：");
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel3 = new JLabel("学  号：");
	private JLabel jLabel4 = new JLabel("姓  名：");
	//文本框
	private JTextField field = new JTextField(22);
	private JTextField field2 = new JTextField(22);
	//字体
	private Font font = new Font("宋体", Font.BOLD, 24);
	private Font font1 = new Font("宋体", Font.BOLD, 22);
	//按钮 修改
	private JButton button = new JButton("修改");
	public ModifyInformation(String user) {
		setSize(600, 450);
		// 改变背景图片
		Icon i = new ImageIcon("img\\ah.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 600, 150);
		
		jLabel2.setText(user);
		show(user);
		jLabel.setFont(font);
		jLabel2.setFont(font);
		jLabel3.setFont(font);
		jLabel4.setFont(font);
		field.setFont(font1);
		field2.setFont(font1);
		button.setFont(font1);
		
		
		add();
		
		jLabel.setBounds(150, 180, 100, 30);
		jLabel2.setBounds(260, 180, 300, 30);
		jLabel3.setBounds(150, 230, 100, 30);
		field.setBounds(260, 230, 150, 30);
		jLabel4.setBounds(150, 280, 100, 30);
		field2.setBounds(260, 280, 150, 30);
		button.setBounds(145, 340, 268, 30);
		
		jPanel.add(jLabel);
		jPanel.add(jLabel2);
		jPanel.add(jLabel3);
		jPanel.add(field);
		jPanel.add(jLabel4);
		jPanel.add(field2);
		jPanel.add(button);
		jPanel.setLayout(null);
		jPanel.setBounds(0, 0, 600, 400);
		jPanel.setOpaque(false);
		setTitle("修改信息");
		add(jPanel);
		add(Label);
		// 不可以改变窗体的大小
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}
	
	//获取信息显示
	private void show(String user) {
		Connection con = ConnectDatabase.connectDB();
		PreparedStatement preSql;
		ResultSet rs;
		String sqlStr = "select * from usertable where user = ?";
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, user);
			rs = preSql.executeQuery();
			while (rs.next()) {
				field.setText(rs.getString(2));
				field2.setText(rs.getString(3));
			}
			con.close();
		} catch (SQLException e) {
		}
	}
	
	//修改信息
	private void modify(String user,String studentid,String name) {
		Connection con = ConnectDatabase.connectDB();

		PreparedStatement preSql;

		String sqlStr = "update usertable set studentid=? where user = ?";

		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, studentid);
			preSql.setString(2, user);
			int ok = preSql.executeUpdate();
			
			sqlStr = "update usertable set name=? where user = ?";
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, name);
			preSql.setString(2, user);
			ok = preSql.executeUpdate();
			con.close();
		} catch (SQLException e) {
		}
	}
	
	//添加事件
	private void add() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = jLabel2.getText().trim();
				String studentid = field.getText().trim();
				String name = field2.getText().trim();
				modify(user,studentid,name);
				JOptionPane.showMessageDialog(null, "修改成功");
				dispose();
			}
		});
	}
}
