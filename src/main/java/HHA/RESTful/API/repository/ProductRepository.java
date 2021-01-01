package HHA.RESTful.API.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import HHA.RESTful.API.domain.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	@Query(value = "SELECT * FROM product WHERE CONCAT(name, code, category) LIKE %:val%", nativeQuery = true)
	Page<Product> findAll(@Param("val") String val, Pageable pageable);
	
}
