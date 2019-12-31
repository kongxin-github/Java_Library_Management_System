package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Landing {

	public static Boolean test(String user, String password) {

		Connection con = ConnectDatabase.connectDB();

		PreparedStatement preSql;

		ResultSet rs;

		String sqlStr = "select * from usertable where user = ?";
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, user);
			rs = preSql.executeQuery();
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				String password2 = rs.getString(4);
				if (!(password.equals(password2))) {
					JOptionPane.showMessageDialog(null, "密码错误", "警告", JOptionPane.WARNING_MESSAGE);
					return false;
				}
			}
			if(!flag) {
				JOptionPane.showMessageDialog(null, "用户名不存在", "警告", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			con.close();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "用户名不存在", "警告", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	
	//确定是否为管理员
	public static boolean sureadmin(String user) {
		Connection con = ConnectDatabase.connectDB();
		PreparedStatement preSql;
		ResultSet rs;
		String sqlStr = "select * from usertable where user = ?";
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, user);
			rs = preSql.executeQuery();
			while(rs.next()) {
				int admin = rs.getInt(5);
				if (admin==1) {
					return true;
				}else {
					return false;
				}
			}
			con.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
