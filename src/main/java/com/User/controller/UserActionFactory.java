package com.User.controller;

import com.User.controller.action.JoinAction;
import com.User.controller.action.JoinFormAction;
import com.User.controller.action.LoginAction;
import com.User.controller.action.LoginFormAction;
import com.User.controller.action.LogoutAction;
import com.User.controller.action.UserAction;

public class UserActionFactory {
	private UserActionFactory() {}
	private static UserActionFactory instance = new UserActionFactory();
	
	public static UserActionFactory getInstance() {
		return instance;
	}
	public UserAction getAction(String command) {
		UserAction action = null;
		if(command.equals("Login_form")) {
			action = new LoginFormAction();
		}else if(command.equals("Login")) {
			action = new LoginAction();
		}else if(command.equals("Logout")) {
			action = new LogoutAction();
		}else if(command.equals("Join_form")) {
			action = new JoinFormAction();
		}else if(command.equals("Join")) {
			action = new JoinAction();
		}
		return action;
	}
}
