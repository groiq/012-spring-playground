package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MainController {

	@GetMapping("/index")
	String index() {
		return "index";
	}

}
