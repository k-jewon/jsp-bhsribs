package com.Menu.Controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Menu.DAO.MenuDAO;
import com.Menu.VO.MenuVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import com.util.Action;

public class MenuWriteAction implements Action  {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getSession().getServletContext();
		String path = context.getRealPath("images");
		String encType = "UTF-8";
		int maxSize = 500*1024*1024;
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest multi = new MultipartRequest(request, path, maxSize, encType, policy);
		
		int type = Integer.parseInt(multi.getParameter("type"));
		int price = Integer.parseInt(multi.getParameter("price"));
		int price_100g = Integer.parseInt(multi.getParameter("price_100g"));
		String name = multi.getParameter("name");
		String addr = multi.getParameter("addr");
		String pictureurl = multi.getFilesystemName("pictureurl");
		if(type == 2) {
			price_100g = 0;
		}
		
		MenuVO mvo = new MenuVO();
		mvo.setType(type);
		mvo.setName(name);
		mvo.setPrice(price);
		mvo.setPrice_100g(price_100g);
		mvo.setAddr(addr);
		mvo.setPictureurl(pictureurl);
		
		MenuDAO mdao = MenuDAO.getInstance();
		mdao.insertMenu(mvo);
		new MenuListAdminAction().execute(request, response);
		
	}


}
