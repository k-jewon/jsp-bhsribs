package com.Menu.Controller;

import com.Menu.Controller.action.MenuListAction;
import com.Menu.Controller.action.MenuListAdminAction;
import com.Menu.Controller.action.MenuWriteAction;
import com.Menu.Controller.action.MenuWriteFormAction;
import com.util.Action;

public class MenuActionFactory {
	private MenuActionFactory() {}
	private static MenuActionFactory instance = new MenuActionFactory();
	public static MenuActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("Menu_list")) {
			action = new MenuListAction();
		}else if(command.equals("Menu_list_admin")) {
			action = new MenuListAdminAction();
		}else if(command.equals("Menu_write_form")) {
			action = new MenuWriteFormAction();
		}else if(command.equals("Menu_write")) {
			action = new MenuWriteAction();
		}
		
		return action;
	}
}
