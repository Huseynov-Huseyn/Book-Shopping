package az.developia.bookshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshopping.dao.OrderDAO;
import az.developia.bookshopping.model.Order;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "/rest/orders")
public class OrderRestController {

	@Autowired
	private OrderDAO orderDAO;

	@GetMapping
	public List<Order> findAll() {
		return orderDAO.findAll();
	}

	@PostMapping
	public Order save(@RequestBody Order order) {
		return orderDAO.save(order);
	}

	@GetMapping(path = "/{id}")
	public Order findById(@PathVariable(name = "id") Integer id) {
		return orderDAO.findById(id).get();
	}

	@GetMapping(path = "/{username}")
	public List<Order> findAllByUsername(@PathVariable(name = "username") String username) {
		return orderDAO.findAllByUsername(username);
	}
}