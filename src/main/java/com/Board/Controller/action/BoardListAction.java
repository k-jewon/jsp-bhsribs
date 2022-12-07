package com.Board.Controller.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Board.DAO.BoardDAO;
import com.Board.VO.BoardVO;
import com.Board.VO.PageVO;

public class BoardListAction implements BoardAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Board/BoardList.jsp";
		int pageNum = 1;
		int amount = 10;
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		BoardDAO bdao = BoardDAO.getInstance();
		
		List<BoardVO> list = bdao.getBoardList(pageNum, amount);
		int total = bdao.getTotal();
		PageVO pvo = new PageVO(pageNum, amount, total);
		
		
		request.setAttribute("PageVO", pvo);
		request.setAttribute("List", list);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
}
