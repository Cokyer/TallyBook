/**
 * 
 */
package com.hunau.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hunau.pojo.Count;
import com.hunau.util.DbUtil;

/**
 * @author shadow-cxw
 *
 */
public class CountDao {
	private Connection con = DbUtil.getConn();
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String sql;
	private String part;
	
	public List<Count> contentLs(String parts) {
		this.part=parts;
		return this.findDayInfo();
	}

	public List<Count> findDayInfo() { // 查询日收入/支出
		List<Count>  rows=new ArrayList<Count>();
		try {
			sql = "select part,kind,account,sum(money) as num from countinfo group by part,kind,account Having part = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, part);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Count row=new Count();
				row.setKind((rs.getString("kind")));
				row.setAccount((rs.getString("account")));
				row.setMoney((rs.getInt("num")));
				rows.add(row);
			}
			// pStatment.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.closeConn(con, stmt, rs);
		}
		return  rows;
	}
}
