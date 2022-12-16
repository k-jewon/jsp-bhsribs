package com.Board.Controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Board.DAO.BoardDAO;
import com.Board.VO.BoardVO;
import com.util.Action;
import com.util.VO.PageVO;

public class BoardListAdminAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Admin/Admin.jsp";
		String tab = "Board_list_admin";
		String date = request.getParameter("date");
		int pageNum = 1;
		int amount = 10;
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		BoardDAO bdao = BoardDAO.getInstance();
		if(date.equals("day") ) {
			List<BoardVO> list = bdao.getBoardListDay(pageNum, amount);
			request.setAttribute("Board", list);
		}else if(date.equals("month")) {
			List<BoardVO> list = bdao.getBoardListMonth(pageNum, amount);
			request.setAttribute("Board", list);
		}
		
		int total = bdao.getTotal();
		PageVO pvo = new PageVO(pageNum, amount, total);		
		
		request.setAttribute("PageVO", pvo);
		request.setAttribute("Tabs", tab);
		request.setAttribute("Date", date);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
