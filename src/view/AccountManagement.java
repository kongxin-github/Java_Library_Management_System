package view;
/**
 * 用户账户管理界面
 * @author K.X
 * 
 * */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountManagement {
	/*
	 * 标签
	 *
	 * 四个按钮 修改账号 修改密码 借书记录 退出程序
	 * 
	 */
	// 面板
	public JPanel jPanel2 = new JPanel();
	// 标签
	private JLabel jLabel = new JLabel("账户管理");
	// 按钮
	private JButton button = new JButton("修改信息");
	private JButton button2 = new JButton("修改密码");
	private JButton button3 = new JButton("借书记录");
	private JButton button4 = new JButton("退出登陆");
	// 字体
	private Font font = new Font("宋体", Font.BOLD, 60);
	private Font font1 = new Font("宋体", Font.BOLD, 25);

	private String user;
	private JFrame frame;

	public AccountManagement() {
		// 改变背景图片
		Icon i = new ImageIcon("img\\account.jpg");
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
		button.setBounds(150, 250, 250, 50);
		button2.setBounds(150, 310, 250, 50);
		button3.setBounds(150, 370, 250, 50);
		button4.setBounds(150, 430, 250, 50);

		button.setBackground(Color.cyan);
		button2.setBackground(Color.cyan);
		button3.setBackground(Color.cyan);
		button4.setBackground(Color.cyan);

		button.setOpaque(false);
		button2.setOpaque(false);
		button3.setOpaque(false);
		button4.setOpaque(false);
		// 添加事件
		add();
		jPanel2.add(button);
		jPanel2.add(button2);
		jPanel2.add(button3);
		jPanel2.add(button4);
		jPanel2.add(jLabel);
		jPanel2.add(Label);
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	// 添加事件
	private void add() {
		// 修改信息
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ModifyInformation(user);
			}
		});

		// 修改密码
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ModifyPassword password = new ModifyPassword(user);
				password.setFrame(frame);
			}
		});
		
		//借书记录
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BorrowRecords(user);
			}
		});
		
		//退出登陆
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new Land();
			}
		});
	}
	
}
