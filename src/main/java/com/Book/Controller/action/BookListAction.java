package com.Book.Controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Book.DAO.BookDAO;
import com.Book.VO.BookVO;
import com.util.Action;
import com.util.VO.PageVO;

public class BookListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Admin/Admin.jsp";
		String tab = "Book_list";

		BookDAO bdao = BookDAO.getInstance();
		List<BookVO> list = bdao.selectBook();

		request.setAttribute("Book", list);
		request.setAttribute("Tabs", tab);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
