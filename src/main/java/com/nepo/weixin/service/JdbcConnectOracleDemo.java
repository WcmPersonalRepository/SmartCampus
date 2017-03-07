package com.nepo.weixin.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JdbcConnectOracleDemo {
	String dbUrl = "jdbc:oracle:thin:@220.178.90.142:1521:orcl";
	String theUser = "elotto";
	String thePW = "elotto";
	static Connection conn = null;
	PreparedStatement pstmt;
	ResultSet rs = null;
	// String sql="insert into test_main values(?,?)";
	String sqlselect = "select name from test_main";
	String sqly = "select vc_code_content from ecp_lottery_open_result where int_lottery_type=3";
	public JdbcConnectOracleDemo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbUrl, theUser, thePW);
			System.out.println(conn);
			// pstmt=conn.prepareStatement(sql);
			// pstmt.setInt(1, 1);
			// pstmt.setString(2, "土地所得");
			// pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sqly);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("vc_code_content"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JdbcConnectOracleDemo JdbcConnectOracleDemoObject = new JdbcConnectOracleDemo();
	}
}
