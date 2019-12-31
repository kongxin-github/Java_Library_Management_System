package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.Category;

public class ModifyCategory extends JFrame{
	
	// 面板
	private JPanel jPanel = new JPanel();
	// 标签
	private JLabel jLabel = new JLabel("类别名：");
	private JLabel jLabel2 = new JLabel("修改为：");
	// 文本框
	private JTextField field = new JTextField(22);
	private JTextField field2 = new JTextField(22);
	// 字体
	private Font font2 = new Font("宋体", Font.BOLD, 22);
	private Font font3 = new Font("宋体", Font.BOLD, 18);
	// 按钮 修改
	private JButton button = new JButton("确    定");
	

	public ModifyCategory() {
		setSize(400, 450);
		setTitle("修改图书类别");
		// 改变背景图片
		Icon i = new ImageIcon("img\\ah.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 400, 100);

		jLabel.setFont(font2);
		field.setFont(font2);
		jLabel2.setFont(font2);
		field2.setFont(font2);
		button.setFont(font3);

		jLabel.setBounds(50, 150, 100, 30);
		field.setBounds(150, 150, 185, 28);
		jLabel2.setBounds(50, 210, 100, 30);
		field2.setBounds(150, 210, 185, 28);
		button.setBounds(47, 280, 288, 35);
		

		//添加事件
		addEvent();
		// 不可以改变窗体的大小
		setResizable(false);
		jPanel.add(jLabel);
		jPanel.add(field);
		jPanel.add(jLabel2);
		jPanel.add(field2);
		jPanel.add(button);
		jPanel.setLayout(null);
		jPanel.setBounds(0, 0, 600, 400);
		jPanel.setOpaque(false);
		add(jPanel);
		add(Label);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}
	
	private void addEvent() {

		// 添加确定按钮事件
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = field.getText().trim();
				String s2 = field2.getText().trim();
				if(Category.setcategory(s,s2)) {
					JOptionPane.showMessageDialog(null, "操作完成");
				}
			}
		});
	}
}
