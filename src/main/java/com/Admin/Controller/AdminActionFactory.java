package com.Admin.Controller;

import com.Admin.Controller.action.AdminAction;
import com.Admin.Controller.action.AdminPageAction;

public class AdminActionFactory {
	private AdminActionFactory() {}
	private static AdminActionFactory instance = new AdminActionFactory();
	public static AdminActionFactory getInstance() {
		return instance;
	}
	public AdminAction getAction(String command) {
		AdminAction action = null;
		
		if(command.equals("Admin_page")) {
			action = new AdminPageAction();
		}
		
		return action;
	}
}
