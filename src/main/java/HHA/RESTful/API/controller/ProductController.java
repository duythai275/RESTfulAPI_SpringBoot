package HHA.RESTful.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import HHA.RESTful.API.domain.Product;
import HHA.RESTful.API.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
//	@GetMapping("/products?filter=category:eq:{id}")
	@GetMapping("/productsByCategory/{id}")
	public List<Product> listByCategory(@PathVariable int id) {
		return service.listAllProductsByCategory(id);
	}
	
	@GetMapping("/products")
	public List<Product> list() {
		return service.listAllProducts();
	}
}
