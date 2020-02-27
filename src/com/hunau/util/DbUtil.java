/**
 * 
 */
package com.hunau.util;

/**
 * @author shadow-cxw
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	
	public final static String DBURL="jdbc:mysql://127.0.0.1:3306/test";
	public final static String DBUSER="root";
	public final static String DBPASSWORD="123456";
	private static Connection conn;
	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*public final static String DBURL="jdbc:sqlserver://localhost:1433;databaseName=test";
	public final static String DBUSER="root";
	public final static String DBPASSWORD="123456";
	private static Connection conn;
	static
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	/**
	 * 获取数据库的连接
	 * @return
	 */
	public static Connection getConn()
	{
		try {
			conn=DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	/*
	 * 关闭数据库连接
	 * */
	public static void closeConn(Connection con, PreparedStatement stmt, ResultSet rs)
	{
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}