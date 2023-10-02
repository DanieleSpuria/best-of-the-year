package org.java.app.best;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		String name = "Gertrude";
		model.addAttribute("name", name);
		
		return "index";
	}
}
