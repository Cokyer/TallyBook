/**
 * 
 */
package com.hunau.dao;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.hunau.util.DbUtil;

/**
 * @author shadow-cxw
 *
 */
public class Ctent2Dao {

	private Connection con = DbUtil.getConn();
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String part;
	private String sql;
	private String command;
	private String years;
	private String months;
	private String days;
	private int sumDay = 0;
	private int sumMonth = 0;
	private int sumYear = 0;

	public List<Integer> contentLs(ActionEvent e, JComboBox<String> year, JComboBox<String> month, JComboBox<String> day,
			JTextField textDay, JTextField textMonth, JTextField textYear, String part) {
		this.part = part;
		command = e.getActionCommand();
		years = (String) year.getSelectedItem();
		months = (String) month.getSelectedItem();
		days = (String) day.getSelectedItem();
		List<Integer> list=new ArrayList();
		if ("查询".equals(command)) {
			this.findDayInfo();
			textDay.setText(String.valueOf(sumDay));
			textMonth.setText(String.valueOf(sumMonth));
			textYear.setText(String.valueOf(sumYear));
			list.add(sumDay);
			list.add(sumMonth);
			list.add(sumYear);
		}
		return list;
	}

	public void findDayInfo() { // 查询日收入/支出
		String datetime = years + "-" + months + "-" + days;
		try {
			sql = "select money from countinfo where (left(date,10)=?) and part=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, datetime);
			stmt.setString(2, part);
			rs = stmt.executeQuery();
			while (rs.next()) {
				sumDay = sumDay + Integer.parseInt(rs.getString("money"));
			}
			// pStatment.executeUpdate();
			this.findMonthInfo(); // 查询月收入/支出
			this.findYearInfo(); // 查询年收入/支出
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.closeConn(con, stmt, rs);
		}
	}

	public void findMonthInfo() { // 查询月收入/支出
		String datetimes = years + "-" + months;
		try {
			sql = "select money from countinfo where (left(date,7)=?) and part =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, datetimes);
			stmt.setString(2, part);
			rs = stmt.executeQuery();
			while (rs.next()) {
				sumMonth = sumMonth + Integer.parseInt(rs.getString("money"));
			}
			// pStatment.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * finally { DbUtil.closeConn(con, stmt, rs); }
			 */
	}

	public void findYearInfo() { // 查询年收入/支出
		String datetimes = years;
		try {
			sql = "select money from countinfo where (left(date,4)=?) and part =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, datetimes);
			stmt.setString(2, part);
			rs = stmt.executeQuery();
			while (rs.next()) {
				sumYear = sumYear + Integer.parseInt(rs.getString("money"));
			}
			// pStatment.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * finally { DbUtil.closeConn(con, stmt, rs); }
			 */
	}
}
