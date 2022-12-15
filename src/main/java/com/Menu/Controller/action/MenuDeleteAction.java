package com.Menu.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Menu.DAO.MenuDAO;
import com.util.Action;

public class MenuDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("mid"));
		MenuDAO mdao = MenuDAO.getInstance();
		mdao.deleteMenu(mid);
		new MenuListAdminAction().execute(request, response);
	}
}
