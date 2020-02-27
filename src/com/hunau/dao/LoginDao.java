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

import com.hunau.ui.LoginUi;
import com.hunau.ui.MainUi;
import com.hunau.ui.RegisterUi;
import com.hunau.util.DbUtil;

/**
 * @author shadow-cxw
 *
 */
public class LoginDao {

	private Connection con = DbUtil.getConn();
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public void check(ActionEvent e, JTextField admin, JPasswordField password,LoginUi loginUi) {
		String command = e.getActionCommand();
		String name = admin.getText();
		String pwd = String.valueOf(password.getPassword());

		if ("登录".equals(command)) {
			this.login(name, pwd,loginUi);
		} else if ("忘记密码".equals(command)) {
			this.forgetPwd(name);
		}else if("注册".equals(command)){
			this.register();
		}
	}

	public void login(String name, String pwd,LoginUi loginUi) {
		try {
			stmt = con.prepareStatement("select userpwd from loginuser where username= ?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (!rs.next()) {
				JOptionPane.showMessageDialog(null, "用户名不存在！", "错误消息", JOptionPane.WARNING_MESSAGE);
			} 
			else {
				if (rs.getString("userpwd").equals(pwd)) {
					new MainUi();
					loginUi.dispose();
				} else
					JOptionPane.showMessageDialog(null, "密码错误！", "错误消息", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConn(con, stmt, rs);
		}
	}

	public void forgetPwd(String name) {
		try {
			stmt = con.prepareStatement("select userpwd from loginuser where username= ?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (!rs.next()) {
				JOptionPane.showMessageDialog(null, "用户名不存在！", "错误消息", JOptionPane.WARNING_MESSAGE);
			} 
			else {
				JOptionPane.showMessageDialog(null, name+" 的密码是："+rs.getString("userpwd"), "提示消息", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConn(con, stmt, rs);
		}
	}

	public RegisterUi register() {
		RegisterUi re=new RegisterUi();
		return re;
	}
}
