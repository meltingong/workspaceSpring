package com.itwill.ilhajob.exp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ExpController {
	
	@Autowired
	private ExpService expService;
	
}
