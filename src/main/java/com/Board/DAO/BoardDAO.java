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
	//게시물 전체보기
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
//	
//	public ArrayList<BoardVO> getBoardList(int startRow, int pageSize) {
//		String sql = "select * from board order by bid desc limit ?,?";
//		ArrayList<BoardVO> list = new ArrayList<>();
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager.getConnection();
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, startRow-1);
//			ps.setInt(2, pageSize);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				BoardVO bvo = new BoardVO();
//				bvo.setBid(rs.getInt("bid"));
//				bvo.setTitle(rs.getString("title"));
//				bvo.setName(rs.getString("name"));
//				bvo.setContent(rs.getString("content"));
//				bvo.setWrite_date(rs.getDate("write_date"));
//				bvo.setUid(rs.getInt("uid"));
//				list.add(bvo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.close(rs, ps, conn);
//		}
//		return list;
//	}
	//게시물 생성
	public void insertBoard(BoardVO bvo) {
		String sql = "insert into board values(null,?,?,?,now(),?,0)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bvo.getTitle());
			ps.setString(2, bvo.getName());
			ps.setString(3, bvo.getContent());
			ps.setInt(4, bvo.getUid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
	}
	//조회수 증가하는 메소드
		public void updateReadCount(int bid) {
			String sql = "update board set readcount = readcount+1 where bid=?";
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = DBManager.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, bid);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(ps, conn);
			}
		}
	//게시물 보기
	public BoardVO selectBoardByBid(int bid) {
		String sql = "select * from board where bid=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO bvo = new BoardVO();
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			if(rs.next()) {
				bvo.setBid(rs.getInt("bid"));
				bvo.setName(rs.getString("name"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setWrite_date(rs.getDate("write_date"));
				bvo.setUid(rs.getInt("uid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, ps, conn);
		}
		return bvo;
	}
	//게시물 수정
	public void updateBoard(String title, String content, int bid) {
		String sql = "update board set title=?, content=? where bid=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, bid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
	}
	//게시물 삭제
	public void deleteBoard(int bid) {
		String sql = "delete from board where bid=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, conn);
		}
	}
}
