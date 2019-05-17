package com.welfare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UndoController {
	
	@RequestMapping("undo")
	public String undo() {
		return "undo";
	}

}
