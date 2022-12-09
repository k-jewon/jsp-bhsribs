package com.Book.Controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Book.DAO.BookDAO;
import com.Book.VO.BookVO;
import com.util.Action;

public class BookWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String url="Main";
		BookVO bvo = new BookVO();
		bvo.setName(request.getParameter("name"));
		bvo.setPhone(request.getParameter("phone"));
		bvo.setDays(request.getParameter("days"));
		bvo.setContent(request.getParameter("content"));
		bvo.setHowmany(Integer.parseInt(request.getParameter("name")));
		
		BookDAO bdao = BookDAO.getInstance();
		int result = bdao.InsertBook(bvo);
		if(result == 1) {
			url ="Main";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
