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
	
	public List<Product> listAllProducts(String filter) {
		if ( filter != null ) {
//			String field = filter.split(":")[0];
//			String operator = filter.split(":")[1];
			String val = filter.split(":")[2];
			return repo.findAll(val);
		}
		return repo.findAll();
	}
}
