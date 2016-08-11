package com.wgmf.temporyjob.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionFactory {
	private static final String url="jdbc:oracle:thin:@192.168.5.41:1521:orcl";
	private static final String user = "tscm";
	private static final String password = "tscmadmin";
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败");
		} catch (SQLException e) {
			System.out.println("连接数据库失败");
		}
		return con;
		
	}
}
