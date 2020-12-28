package HHA.RESTful.API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import HHA.RESTful.API.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value = "SELECT * FROM product WHERE category = ?1", nativeQuery = true)
	List<Product> findAllByCategory(int cateId);
	
}
