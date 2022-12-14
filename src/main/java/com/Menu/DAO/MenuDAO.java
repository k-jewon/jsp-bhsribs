package com.Menu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Menu.VO.MenuVO;
import com.util.DBManager;

public class MenuDAO {
	private MenuDAO() {
	}

	private static MenuDAO instance = new MenuDAO();

	public static MenuDAO getInstance() {
		return instance;
	}

	// 전체메뉴 검색
	public List<MenuVO> selectMenu() {
		String query = "SELECT * FROM MENU";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MenuVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MenuVO mvo = new MenuVO();
				mvo.setMid(rs.getInt("mid"));
				mvo.setType(rs.getInt("type"));
				mvo.setName(rs.getString("name"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setAddr(rs.getString("addr"));
				mvo.setPrice_100g(rs.getInt("price_100g"));
				mvo.setPictureurl(rs.getString("pictureurl"));
				list.add(mvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, ps, conn);
		}
		return list;
	}

	// 랜덤메뉴 검색
	public List<MenuVO> RandomMenu() {
		String query = "SELECT * FROM MENU ORDER BY RAND() LIMIT 5";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MenuVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MenuVO mvo = new MenuVO();
				mvo.setMid(rs.getInt("mid"));
				mvo.setType(rs.getInt("type"));
				mvo.setName(rs.getString("name"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setAddr(rs.getString("addr"));
				mvo.setPrice_100g(rs.getInt("price_100g"));
				mvo.setPictureurl(rs.getString("pictureurl"));
				list.add(mvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, ps, conn);
		}
		return list;
	}

	// 고기메뉴 검색
	public List<MenuVO> selectMeetMenu() {
		String query = "SELECT * FROM MENU WHERE TYPE=1";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MenuVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MenuVO mvo = new MenuVO();
				mvo.setMid(rs.getInt("mid"));
				mvo.setType(rs.getInt("type"));
				mvo.setName(rs.getString("name"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setAddr(rs.getString("addr"));
				mvo.setPrice_100g(rs.getInt("price_100g"));
				mvo.setPictureurl(rs.getString("pictureurl"));
				list.add(mvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, ps, conn);
		}
		return list;
	}

	// 식사메뉴 검색
	public List<MenuVO> selectMealMenu() {
		String query = "SELECT * FROM MENU WHERE TYPE=2";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MenuVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MenuVO mvo = new MenuVO();
				mvo.setMid(rs.getInt("mid"));
				mvo.setType(rs.getInt("type"));
				mvo.setName(rs.getString("name"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setAddr(rs.getString("addr"));
				mvo.setPictureurl(rs.getString("pictureurl"));
				list.add(mvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, ps, conn);
		}
		return list;
	}

	// 고기메뉴 검색
	public MenuVO selectOneMenu(int mid) {
		String query = "SELECT * FROM MENU WHERE MID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MenuVO mvo = new MenuVO();
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, mid);
			rs = ps.executeQuery();
			while (rs.next()) {
				mvo.setMid(rs.getInt("mid"));
				mvo.setType(rs.getInt("type"));
				mvo.setName(rs.getString("name"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setAddr(rs.getString("addr"));
				mvo.setPrice_100g(rs.getInt("price_100g"));
				mvo.setPictureurl(rs.getString("pictureurl"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, ps, conn);
		}
		return mvo;
	}

	// 메뉴추가
	public void insertMenu(MenuVO mvo) {
		String query = "INSERT INTO MENU (TYPE,NAME,ADDR,PRICE,PRICE_100G,PICTUREURL) VALUES (?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, mvo.getType());
			ps.setString(2, mvo.getName());
			ps.setString(3, mvo.getAddr());
			ps.setInt(4, mvo.getPrice());
			ps.setInt(5, mvo.getPrice_100g());
			ps.setString(6, mvo.getPictureurl());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}

	}

	// 메뉴 수정
	public void updateMenu(MenuVO mvo) {
		String query = "UPDATE MENU SET TYPE=?, PRICE=?, PRICE_100G=?, NAME=?, ADDR=?, PICTUREURL=? WHERE MID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, mvo.getType());
			ps.setInt(2, mvo.getPrice());
			ps.setInt(3, mvo.getPrice_100g());
			ps.setString(4, mvo.getName());
			ps.setString(5, mvo.getAddr());
			ps.setString(6, mvo.getPictureurl());
			ps.setInt(7, mvo.getMid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}

	}

	// 메뉴 삭제
	public void deleteMenu(int mid) {
		String query = "DELETE FROM MENU WHERE MID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, mid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}
	}

}
