package az.developia.bookshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class OrderController {

	@GetMapping(path = "/orders")
	public String showOrdersPage() {
		return "orders";
	}

}