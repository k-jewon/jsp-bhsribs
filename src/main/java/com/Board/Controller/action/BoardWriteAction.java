package com.Board.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Board.DAO.BoardDAO;
import com.Board.VO.BoardVO;

public class BoardWriteAction implements BoardAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO bvo = new BoardVO();
		bvo.setTitle(request.getParameter("title"));
		bvo.setName(request.getParameter("name"));
		bvo.setContent(request.getParameter("content"));
		bvo.setUid(Integer.parseInt(request.getParameter("uid")));
		
		BoardDAO bdao = BoardDAO.getInstance();
		bdao.insertBoard(bvo);
		new BoardListAction().execute(request, response);
		
	}
}
