package com.Board.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Board.DAO.BoardDAO;
import com.util.Action;

public class BoardDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDAO bdao = BoardDAO.getInstance();
		bdao.deleteBoard(bid);
		new BoardListAction().execute(request, response);
		
	}
}
