package com.example.demo;

<<<<<<< HEAD
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
=======
public class MainController {
>>>>>>> parent of 0cb8c2c... annotated controller class

}
