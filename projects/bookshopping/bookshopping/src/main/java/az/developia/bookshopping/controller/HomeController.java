package az.developia.bookshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HomeController {

	@GetMapping(path = { "/home", "/" })
	public String showHomePage() {
		return "home";
	}

//	@GetMapping(path = "/home")
//	public  String showHomePage() {
//		return "home";
//	}
}