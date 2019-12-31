package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.FindBorrow;
import database.UpdateAdmin;

/**
 * 修改权限界面
 * 
 * @author K.X
 */
public class Permissions extends JFrame {
	
	// 面板
	private JPanel jPanel = new JPanel();
	// 标签
	private JLabel jLabel = new JLabel("用户名：");
	private JLabel jLabel2 = new JLabel("选  项：");
	// 文本框
	private JTextField field = new JTextField(22);	
	// 下拉框
	private JComboBox<String> box = new JComboBox<String>();
	// 字体
	private Font font2 = new Font("宋体", Font.BOLD, 22);
	private Font font3 = new Font("宋体", Font.BOLD, 18);
	// 按钮 修改
	private JButton button = new JButton("确    定");
	
	private String s;

	public Permissions() {
		setSize(400, 450);
		setTitle("修改权限");
		// 改变背景图片
		Icon i = new ImageIcon("img\\ah.jpg");
		JLabel Label = new JLabel(i);
		Label.setBounds(0, 0, 400, 100);

		jLabel.setFont(font2);
		jLabel2.setFont(font2);
		field.setFont(font2);
		button.setFont(font3);

		jLabel.setBounds(50, 150, 100, 30);
		field.setBounds(150, 150, 185, 28);
		
		jLabel2.setBounds(50, 225, 100, 30);
		
		button.setBounds(47, 300, 288, 35);
		// 下拉框
		box.addItem("删除用户");
		box.addItem("更改为用户");
		box.addItem("添加为管理员");
		box.setFont(font3);
		box.setBounds(150, 225, 185, 28);
		// box.setBackground(Color.cyan);
		box.setOpaque(false);

		//添加事件
		addEvent();
		
		jPanel.add(jLabel);
		jPanel.add(field);
		jPanel.add(jLabel2);
		jPanel.add(box);
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

		// 获取下拉列表值
		s = "删除用户";
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					s = (String) e.getItem();
				}
			}
		});

		// 添加确定按钮事件
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = field.getText().trim();
				if(UpdateAdmin.sureuser(user)) {
					if (s.equals("删除用户")) {
						UpdateAdmin.deleteuser(user);
						JOptionPane.showMessageDialog(null, "操作完成");
					} else if (s.equals("更改为用户")) {
						UpdateAdmin.updateuser(user);
						JOptionPane.showMessageDialog(null, "操作完成");
					}else if(s.equals("添加为管理员")) {
						UpdateAdmin.updateadmin(user);
						JOptionPane.showMessageDialog(null, "操作完成");
					}
				}else {
					JOptionPane.showMessageDialog(null, "用户名不存在", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

}
