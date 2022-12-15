package com.Menu.Controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Menu.DAO.MenuDAO;
import com.Menu.VO.MenuVO;
import com.util.Action;

public class MenuUpdateFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="Menu/MenuUpdate.jsp";
		int mid = Integer.parseInt(request.getParameter("mid"));
		MenuDAO mdao = MenuDAO.getInstance();
		MenuVO mvo = mdao.selectOneMenu(mid);
		request.setAttribute("Menu", mvo);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
}
