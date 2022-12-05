package com.Board.Controller;

import com.Board.Controller.action.BoardAction;
import com.Board.Controller.action.BoardListAction;

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
		}
		
		return action;
	}
}
