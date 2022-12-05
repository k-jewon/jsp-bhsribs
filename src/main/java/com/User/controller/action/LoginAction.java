package com.User.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.VO.UserVO;
import com.User.dao.UserDAO;

public class LoginAction implements UserAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String url="User/Login.jsp";
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		UserDAO udao = UserDAO.getInstance();
		UserVO uvo = udao.loginUser(email, pw);
		
		if(uvo!=null) {
			url = "index.jsp";
			session.setAttribute("loginUser", uvo);
		}else {
			request.setAttribute("message", "로그인에 실패하였습니다 \n 로그인정보를 다시 확인해주세요");
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
