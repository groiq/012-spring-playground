package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Page2Controller {

	@GetMapping("/page2")
	ModelAndView page2() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("page2");
		return modelAndView;
//		return "page2";
		
	}
	
	
}
