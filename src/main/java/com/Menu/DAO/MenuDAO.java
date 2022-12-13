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
}
