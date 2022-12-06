package com.Board.Controller;

import com.Board.Controller.action.BoardAction;
import com.Board.Controller.action.BoardDeleteAction;
import com.Board.Controller.action.BoardListAction;
import com.Board.Controller.action.BoardUpdateAction;
import com.Board.Controller.action.BoardUpdateFormAction;
import com.Board.Controller.action.BoardViewAction;
import com.Board.Controller.action.BoardWriteAction;
import com.Board.Controller.action.BoardWriteFormAction;

public class BoardActionFactory {
	private BoardActionFactory() {}
	private static BoardActionFactory instance = new BoardActionFactory();
	public static BoardActionFactory getInstance() {
		return instance;
	}
	public BoardAction getAction(String command) {
		BoardAction action = null;
		
		if (command.equals("Board_list")) {
			action = new BoardListAction();
		}else if (command.equals("Board_write_form")) {
			action = new BoardWriteFormAction();
		}else if (command.equals("Board_write")) {
			action = new BoardWriteAction();
		}else if (command.equals("Board_view")) {
			action = new BoardViewAction();
		}else if (command.equals("Board_update_form")) {
			action = new BoardUpdateFormAction();
		}else if (command.equals("Board_update")) {
			action = new BoardUpdateAction();
		}else if (command.equals("Board_delete")) {
			action = new BoardDeleteAction();
		}
		
		return action;
	}
}
