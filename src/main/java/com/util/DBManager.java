package com.util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:/comp/env/jdbc/Bukhansan_Ribs");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// select를 수행한 후 리소스 해제를 위한 메소드
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs!=null)
			rs.close();
			if(stmt!=null)
			stmt.close();
			if(conn!=null)
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// insert, delete, update를 수행한 후 리소스 해제를 위한 메소드
	public static void close(Statement stmt, Connection conn) {
		try {
			if(stmt!=null)
			stmt.close();
			if(conn!=null)
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
