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

public class AddCategory extends JFrame{
	// 面板
	private JPanel jPanel = new JPanel();
	// 标签
	private JLabel jLabel = new JLabel("类别名：");
	// 文本框
	private JTextField field = new JTextField(22);
	// 字体
	private Font font2 = new Font("宋体", Font.BOLD, 22);
	private Font font3 = new Font("宋体", Font.BOLD, 18);
	// 按钮 修改
	private JButton button = new JButton("确    定");
	

	public AddCategory() {
		setSize(400, 450);
		setTitle("添加图书类别");
		// 改变背景图片
		Icon i = new ImageIcon("img\\ah.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 400, 100);

		jLabel.setFont(font2);
		field.setFont(font2);
		button.setFont(font3);

		jLabel.setBounds(50, 180, 100, 30);
		field.setBounds(150, 180, 185, 28);
		
		button.setBounds(47, 270, 288, 35);
		

		//添加事件
		addEvent();
		
		jPanel.add(jLabel);
		jPanel.add(field);
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
	
	private void addEvent() {

		// 添加确定按钮事件
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = field.getText().trim();
				if(Category.addcategory(s)) {
					JOptionPane.showMessageDialog(null, "操作完成");
				}
			}
		});
	}

}
