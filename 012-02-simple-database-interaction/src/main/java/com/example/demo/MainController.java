package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class MainController {
	
	@GetMapping("/index")
	ModelAndView mapUrlToPage() {
		
		ModelAndView modelAndView = new ModelAndView("indexBackendSite");
//		modelAndView.setViewName("indexBackendSite"); // alternative to constructor
		
		
		return modelAndView;
	}

}
