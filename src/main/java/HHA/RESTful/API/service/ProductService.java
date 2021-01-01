package HHA.RESTful.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import HHA.RESTful.API.domain.Product;
import HHA.RESTful.API.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public Page<Product> listAllProducts(int pageNumber, String sortField, String filter) {
		Sort sort = Sort.by(sortField);
		sort = sort.ascending();
		Pageable pageable = PageRequest.of(pageNumber - 1, 10, sort);
		if ( filter != null ) {
//			String field = filter.split(":")[0];
//			String operator = filter.split(":")[1];
			String val = filter.split(":")[2];
			return repo.findAll(val, pageable);
		}
		return repo.findAll(pageable);
	}
}
