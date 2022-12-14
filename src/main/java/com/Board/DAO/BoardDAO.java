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
	//게시판 페이징
	public List<BoardVO> getBoardList(int pageNum, int amount){
		List<BoardVO> list = new ArrayList<>();
		String sql = "select * from board order by bid desc limit ?,?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNum-1)*10);
			ps.setInt(2, amount);
			rs=ps.executeQuery();
			while(rs.next()){
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
	//게시판 1일치
		public List<BoardVO> getBoardListDay(int pageNum, int amount){
			List<BoardVO> list = new ArrayList<>();
			String sql = "SELECT * FROM BOARD WHERE DATE(write_date) = DATE_FORMAT(CURDATE(),'%Y-%m-%d') order by readcount desc limit ?,?";
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (pageNum-1)*10);
				ps.setInt(2, amount);
				rs=ps.executeQuery();
				while(rs.next()){
					BoardVO bvo = new BoardVO();
					bvo.setBid(rs.getInt("bid"));
					bvo.setTitle(rs.getString("title"));
					bvo.setName(rs.getString("name"));
					bvo.setContent(rs.getString("content"));
					bvo.setWrite_date(rs.getDate("write_date"));
					bvo.setUid(rs.getInt("uid"));
					bvo.setReadcount(rs.getInt("readcount"));
					list.add(bvo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(rs, ps, conn);
			}
			return list;
		}
		//게시판 1달치
		public List<BoardVO> getBoardListMonth(int pageNum, int amount){
			List<BoardVO> list = new ArrayList<>();
			String query = "SELECT * FROM BOARD WHERE write_date BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH ) AND NOW() ORDER BY READCOUNT DESC limit ?,?";
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				ps = conn.prepareStatement(query);
				ps.setInt(1, (pageNum-1)*10);
				ps.setInt(2, amount);
				rs=ps.executeQuery();
				while(rs.next()){
					BoardVO bvo = new BoardVO();
					bvo.setBid(rs.getInt("bid"));
					bvo.setTitle(rs.getString("title"));
					bvo.setName(rs.getString("name"));
					bvo.setContent(rs.getString("content"));
					bvo.setWrite_date(rs.getDate("write_date"));
					bvo.setUid(rs.getInt("uid"));
					bvo.setReadcount(rs.getInt("readcount"));
					list.add(bvo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(rs, ps, conn);
			}
			return list;
		}
	//게시판 전체글 수
	public int getTotal() {
		int result = 0;
		String sql = "select count(*) as total from board";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, ps, conn);
		}
		return result;
	}
	//게시판 하루글 수
		public int getTotalDay() {
			int result = 0;
			String sql = "select count(*) as total from board WHERE DATE(write_date) = DATE_FORMAT(CURDATE(),'%Y-%m-%d')";
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					result = rs.getInt("total");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(rs, ps, conn);
			}
			return result;
		}
		//게시판 하루글 수
				public int getTotalMonth() {
					int result = 0;
					String sql = "select count(*) as total from board WHERE write_date BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH ) AND NOW()";
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					try {
						conn = DBManager.getConnection();
						ps = conn.prepareStatement(sql);
						rs = ps.executeQuery();
						if(rs.next()) {
							result = rs.getInt("total");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						DBManager.close(rs, ps, conn);
					}
					return result;
				}

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
