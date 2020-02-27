/**
 * 
 */
package com.hunau.dao;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.hunau.util.DbUtil;

/**
 * @author shadow-cxw
 *
 */
public class Ctent5Dao {

	private Connection con = DbUtil.getConn();
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String parts;
	private String sql;
	private String command;
	private String years;
	private String datetime;
	private String months;
	private String days;

	public void contentLs(ActionEvent e, JComboBox<String> year, JComboBox<String> month, JComboBox<String> day,
			JComboBox<String> part) {

		command = e.getActionCommand();
		this.parts = (String) part.getSelectedItem();
		years = (String) year.getSelectedItem();
		months = (String) month.getSelectedItem();
		days = (String) day.getSelectedItem();
		this.panduan();
	}

	public void panduan() {
		if ("所有".equals(parts)) {
			if (days != null) {
				datetime = years + "-" + months + "-" + days;
				sql = "delete from countinfo where (left(date,10)=?)";
				this.deleteInfo2();
			} else if (months != null) {
				datetime = years + "-" + months;
				sql = "delete from countinfo where (left(date,7)=?)";
				this.deleteInfo2();
			} else if (years != null) {
				datetime = years;
				sql = "delete from countinfo where (left(date,4)=?)";
				this.deleteInfo2();
			} else {
				JOptionPane.showMessageDialog(null, "选择日期！", "错误消息", JOptionPane.WARNING_MESSAGE);
			}
		} else if ("收入".equals(parts) || "支出".equals(parts)) {
			if (days != null) {
				datetime = years + "-" + months + "-" + days;
				sql = "delete from countinfo where (left(date,10)=?) and part=?";
				this.deleteInfo1();
			} else if (months != null) {
				datetime = years + "-" + months;
				sql = "delete from countinfo where (left(date,7)=?) and part =?";
				this.deleteInfo1();
			} else if (years != null) {
				datetime = years;
				sql = "delete from countinfo where (left(date,4)=?) and part =?";
				this.deleteInfo1();
			} else {
				JOptionPane.showMessageDialog(null, "选择日期！", "错误消息", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public void deleteInfo1() {
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, datetime);
			stmt.setString(2, parts);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.closeConn(con, stmt, rs);
		}
	}

	public void deleteInfo2() {
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, datetime);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.closeConn(con, stmt, rs);
		}
	}
}
