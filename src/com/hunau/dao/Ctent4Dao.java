/**
 * 
 */
package com.hunau.dao;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hunau.util.DbUtil;

/**
 * @author shadow-cxw
 *
 */
public class Ctent4Dao {

	private Connection con = DbUtil.getConn();
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String parts;
	private String sql;
	private String command;
	private String datetime;
	private String years;
	private String months;
	private String days;

	public Vector contentLs(ActionEvent e, JComboBox<String> year, JComboBox<String> month, JComboBox<String> day,
			JComboBox<String> part) {

		command = e.getActionCommand();
		this.parts = (String) part.getSelectedItem();
		years = (String) year.getSelectedItem();
		months = (String) month.getSelectedItem();
		days = (String) day.getSelectedItem();
		System.out.print(years);
		return this.panduan();
	}

	public Vector panduan() {
		if ("所有".equals(parts)) {
			if (days != null && months != null && years != null) {
				datetime = years + "-" + months + "-" + days;
				sql = "select * from countinfo where (left(date,10)=?)";
				return this.selectInfo2();
			} else if (months != null && years != null) {
				datetime = years + "-" + months;
				sql = "select * from countinfo where (left(date,7)=?)";
				return this.selectInfo2();
			} else if (years != null) {
				datetime = years;
				sql = "select * from countinfo where (left(date,4)=?)";
				return this.selectInfo2();
			} else {
				JOptionPane.showMessageDialog(null, "选择日期！", "错误消息", JOptionPane.WARNING_MESSAGE);
			}
		} else if ("收入".equals(parts) || "支出".equals(parts)) {
			if (days != null && months != null && years != null) {
				datetime = years + "-" + months + "-" + days;
				sql = "select * from countinfo where (left(date,10)=?) and part=?";
				return this.selectInfo1();
			} else if (months != null && years != null) {
				datetime = years + "-" + months;
				sql = "select * from countinfo where (left(date,7)=?) and part =?";
				return this.selectInfo1();
			} else if (years != null) {
				datetime = years;
				sql = "select * from countinfo where (left(date,4)=?) and part =?";
				return this.selectInfo1();
			} else {
				JOptionPane.showMessageDialog(null, "选择日期！", "错误消息", JOptionPane.WARNING_MESSAGE);
			}
		}
		return null;
	}

	public Vector selectInfo1() { // 查询日收入/支出
		Vector rows = new Vector();
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, datetime);
			stmt.setString(2, parts);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("part"));
				row.add(rs.getString("kind"));
				row.add(rs.getString("account"));
				row.add(rs.getString("money"));
				row.add(rs.getDate("date"));
				row.add(rs.getString("remark"));
				System.out.print(rs.getDate("date"));
				rows.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.closeConn(con, stmt, rs);
		}
		return rows;
	}

	public Vector selectInfo2() { // 查询日收入/支出
		Vector rows = new Vector();
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, datetime);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("part"));
				row.add(rs.getString("kind"));
				row.add(rs.getString("account"));
				row.add(rs.getString("money"));
				row.add(rs.getDate("date"));
				row.add(rs.getString("remark"));
				rows.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.closeConn(con, stmt, rs);
		}
		return rows;
	}
}