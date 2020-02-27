/**
 * 
 */
package com.hunau.dao;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.hunau.ui.CalcUi;
import com.hunau.util.DbUtil;

/**
 * @author shadow-cxw
 *
 */
public class Ctent1Dao {

	private Connection con = DbUtil.getConn();
	private PreparedStatement stmt = null;
	private String part = null;

	public void contentLs(ActionEvent e, JTextField text1, JTextField text2, JComboBox<String> selectKind,
			JComboBox<String> selectAc, JRadioButton jrb1, JRadioButton jrb2) {
		String command = e.getActionCommand();
		String money = text1.getText();
		String remark = text2.getText();
		String selectkind = (String) selectKind.getSelectedItem();
		String selectac = (String) selectAc.getSelectedItem();

		if (jrb1.isSelected()) {
			part = "收入";
			if ("计算".equals(command)) {
				new CalcUi();
			} else if ("记账".equals(command)) {
				if (part == null) {
					JOptionPane.showMessageDialog(null, "请选择类型", "错误消息", JOptionPane.WARNING_MESSAGE);
				} else {
					this.insert(part, money, remark, selectkind, selectac);
					JOptionPane.showMessageDialog(null, "增加" + part + "记录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
				}
			}
		} else if (jrb2.isSelected()) {
			part = "支出";
			if ("计算".equals(command)) {
				new CalcUi();
			} else if ("记账".equals(command)) {
				if (part == null) {
					JOptionPane.showMessageDialog(null, "请选择类型", "错误消息", JOptionPane.WARNING_MESSAGE);
				} else {
					this.insert(part, money, remark, selectkind, selectac);
					JOptionPane.showMessageDialog(null, "增加" + part + "记录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}

	public void insert(String part, String money, String remark, String selectkind, String selectac) {
		try {
			stmt = con.prepareStatement(
					"insert into countinfo(part,kind,account,money,date,remark) values(?,?,?,?,now(),?)");
			stmt.setString(1, part);
			stmt.setString(2, selectkind);
			stmt.setString(3, selectac);
			stmt.setString(4, money);
			stmt.setString(5, remark);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
					con = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
