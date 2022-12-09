package com.User.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.VO.UserVO;
import com.User.dao.UserDAO;
import com.util.Action;

public class JoinAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		UserVO uvo = new UserVO();
		uvo.setName(name);
		uvo.setPhone(phone);
		uvo.setEmail(email);
		uvo.setPw(pw);
		
		String url = "/User/Join.jsp";
		UserDAO uDao = UserDAO.getInstance();
		int result = uDao.joinUser(uvo);
		if(result==1) {
			new LoginFormAction().execute(request, response);
		}else {
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
