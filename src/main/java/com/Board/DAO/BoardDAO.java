package com.Board.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.Board.VO.BoardVO;
import com.util.DBManager;

public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public ArrayList<BoardVO> selectAllBoard(){
		String sql = "select * from board order by bid desc";
		ArrayList<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBid(rs.getInt("bid"));
				bvo.setTitle(rs.getString("title"));
				bvo.setName(rs.getString("name"));
				bvo.setContent(rs.getString("content"));
				bvo.setWrite_date(rs.getDate("write_date"));
				bvo.setUid(rs.getInt("uid"));
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
