package HHA.RESTful.API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HHA.RESTful.API.domain.Product;
import HHA.RESTful.API.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAllProductsByCategory(int cateId) {
		return repo.findAllByCategory(cateId);
	}
	
	public List<Product> listAllProducts() {
		return repo.findAll();
	}
}
