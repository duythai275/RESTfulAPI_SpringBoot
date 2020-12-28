package HHA.RESTful.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HHA.RESTful.API.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
