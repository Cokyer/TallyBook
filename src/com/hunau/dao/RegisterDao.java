/**
 * 
 */
package com.hunau.dao;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hunau.util.DbUtil;

/**
 * @author shadow-cxw
 *
 */
public class RegisterDao {

	private Connection con = DbUtil.getConn();
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public void check(ActionEvent e, JTextField admin, JPasswordField password,JPasswordField passwords,JTextField phone) {
		String command = e.getActionCommand();
		String name = admin.getText();
		String pwd = String.valueOf(password.getPassword());
		String pwds = String.valueOf(passwords.getPassword());
		String telephone = phone.getText();

		if ("注册".equals(command)) {
			if(pwd.equals(pwds)) {
				this.checkUser(name, pwds, telephone);
			}
			else {
				JOptionPane.showMessageDialog(null, "两次输出密码不同！", "错误消息", JOptionPane.WARNING_MESSAGE);
			}
		}
		else {
			admin.setText("");
			password.setText("");
			passwords.setText("");
			phone.setText("");
		}
	}
	
	public void register(String name,String pwd,String telephone) {
		try {
			stmt = con.prepareStatement("insert into loginuser(username,userpwd,phone) values(?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			stmt.setString(3, telephone);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con!=null)
			{
				try {
					con.close();
					con=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void checkUser(String name,String pwd,String telephone) {
		try {
			stmt = con.prepareStatement("select userpwd from loginuser where username= ?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "用户名已存在！", "错误消息", JOptionPane.WARNING_MESSAGE);
			} 
			else {
				this.register(name, pwd, telephone);
				JOptionPane.showMessageDialog(null, "注册成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConn(con, stmt, rs);
		}
	}
}
