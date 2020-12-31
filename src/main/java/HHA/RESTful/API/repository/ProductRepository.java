package HHA.RESTful.API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import HHA.RESTful.API.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value = "SELECT * FROM product WHERE CONCAT(name, code, category) LIKE %:val%", nativeQuery = true)
	List<Product> findAll(@Param("val") String val);
	
}
