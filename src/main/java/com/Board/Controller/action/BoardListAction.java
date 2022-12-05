package com.Board.Controller.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Board.DAO.BoardDAO;
import com.Board.VO.BoardVO;

public class BoardListAction implements BoardAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Board/BoardList.jsp";
		BoardDAO bdao = BoardDAO.getInstance();
		
		ArrayList<BoardVO> boardList = bdao.selectAllBoard();
		
		request.setAttribute("List", boardList);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
}
