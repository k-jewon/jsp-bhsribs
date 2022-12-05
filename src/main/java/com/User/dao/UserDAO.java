package com.User.dao;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

import com.User.VO.UserVO;
import com.util.DBManager;

public class UserDAO {
	private UserDAO() {}
	
	public static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return instance;
	}
	public int joinUser(UserVO uvo) {
		int result = 0;
		String sql = "insert into user_info values(null,?,?,?,?,0)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, uvo.getName());
			ps.setString(2, uvo.getPhone());
			ps.setString(3, uvo.getEmail());
			ps.setString(4, uvo.getPw());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
		return result;
	}
	
	public UserVO loginUser(String email, String pw) {
		String sql = "select * from user_info where email=? and pw=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO uvo = new UserVO();
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if (rs.next()) {
				uvo.setUid(rs.getInt("uid"));
				uvo.setEmail(rs.getString("email"));
				uvo.setName(rs.getString("name"));
				uvo.setPw(rs.getString("pw"));
				uvo.setPhone(rs.getString("phone"));
				uvo.setAdmin(rs.getInt("admin"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, ps, conn);
		}
		return uvo;
	}
}
