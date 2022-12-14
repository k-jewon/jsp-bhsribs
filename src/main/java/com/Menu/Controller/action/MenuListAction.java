package com.Menu.Controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Menu.DAO.MenuDAO;
import com.Menu.VO.MenuVO;
import com.util.Action;

public class MenuListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Menu/MenuList.jsp";
		
		MenuDAO mdao = MenuDAO.getInstance();
		List<MenuVO> Meet = mdao.selectMeetMenu();
		request.setAttribute("Meet", Meet);
		
		List<MenuVO> Meal = mdao.selectMealMenu();
		request.setAttribute("Meal", Meal);
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
}
