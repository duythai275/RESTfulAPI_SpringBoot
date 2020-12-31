package HHA.RESTful.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import HHA.RESTful.API.domain.Product;
import HHA.RESTful.API.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Product> list(@Param("filter") String filter) {
		return service.listAllProducts(filter);
	}
}
