package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Category {
	public Category() {
	}
	//添加类别
	public static boolean addcategory(String category) {
		Connection con = ConnectDatabase.connectDB();

		PreparedStatement preSql;

		String sqlStr = "insert into bookcategory values (?)";

		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, category);
			int ok = preSql.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "类别已存在", "警告", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	//修改类别
	public static boolean setcategory(String category,String category2) {
		Connection con = ConnectDatabase.connectDB();
		PreparedStatement preSql;

		String sqlStr = "update bookcategory  set Category = ? where Category = ?";
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, category2);
			preSql.setString(2, category);
			int ok = preSql.executeUpdate();
			con.close();
			if(ok==0) {
				JOptionPane.showMessageDialog(null, "类别不存在", "警告", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "类别不存在", "警告", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
}
