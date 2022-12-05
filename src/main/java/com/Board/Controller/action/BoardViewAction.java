package com.Board.Controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Board.DAO.BoardDAO;
import com.Board.VO.BoardVO;


public class BoardViewAction implements BoardAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/Board/BoardView.jsp";
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BoardDAO bdao = BoardDAO.getInstance();
		BoardVO bvo = bdao.selectBoardByBid(bid);
		request.setAttribute("board", bvo);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
}
