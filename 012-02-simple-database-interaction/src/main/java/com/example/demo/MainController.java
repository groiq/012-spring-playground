package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class MainController {
	
	@GetMapping("/index")
	ModelAndView mapUrlToPage() {
		
		ModelAndView modelAndView = new ModelAndView("indexBackendSide");
		modelAndView.setViewName("indexBackendSide"); // alternative to parametrized constructor
		modelAndView.addObject("title", "some page for practice");
		
		return modelAndView;
		
	}
	

}
