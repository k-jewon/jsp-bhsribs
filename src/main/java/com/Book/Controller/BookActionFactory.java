package com.Book.Controller;

import com.Book.Controller.action.BookListAction;
import com.Book.Controller.action.BookWriteAction;
import com.Book.Controller.action.BookWriteFormAction;
import com.util.Action;

public class BookActionFactory {
	private BookActionFactory() {}
	
	private static BookActionFactory instance = new BookActionFactory();
	public static BookActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("Book_write_form")) {
			action = new BookWriteFormAction();
		}else if(command.equals("Book_write")) {
			action = new BookWriteAction();
		}else if(command.equals("Book_list")) {
			action = new BookListAction();
		}
		return action;
	}
}
