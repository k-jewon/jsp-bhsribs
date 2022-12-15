package com.Book.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Book.VO.BookVO;
import com.util.DBManager;

public class BookDAO {
	private BookDAO() {}
	private static BookDAO instance = new BookDAO();
	public static BookDAO getInstance() {
		return instance;
	}
	public int InsertBook(BookVO bvo) {
		String sql = "insert into booking values (null,?,?,?,?,?)";
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
	public List<BookVO> selectBook(){
		String query = "select * from booking WHERE DATE(DAYS) = DATE_FORMAT(CURDATE(),'%Y-%m-%d')";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookVO bvo = new BookVO();
				bvo.setBid(rs.getInt("bid"));
				bvo.setName(rs.getString("name"));
				bvo.setPhone(rs.getString("phone"));
				bvo.setHowmany(rs.getInt("howmany"));
				bvo.setDays(rs.getString("days"));
				bvo.setContent(rs.getString("content"));
				list.add(bvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, ps, conn);
		}
		return list;
	}
}
