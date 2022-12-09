package com.Book.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Book.VO.BookVO;
import com.util.DBManager;

public class BookDAO {
	private BookDAO() {}
	private static BookDAO instance = new BookDAO();
	public static BookDAO getInstance() {
		return instance;
	}
	public int InsertBook(BookVO bvo) {
		String sql = "insert into booking value (null,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bvo.getName());
			ps.setString(2, bvo.getPhone());
			ps.setInt(3, bvo.getHowmany());
			ps.setString(4, bvo.getDays());
			ps.setString(5, bvo.getContent());
			ps.executeUpdate();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
		return result;
	}
}
