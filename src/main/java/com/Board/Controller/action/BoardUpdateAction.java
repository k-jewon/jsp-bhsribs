package com.Board.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Board.DAO.BoardDAO;

public class BoardUpdateAction implements BoardAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BoardDAO bdao = BoardDAO.getInstance();
		bdao.updateBoard(title, content, bid);
		new BoardListAction().execute(request, response);
	}
}
