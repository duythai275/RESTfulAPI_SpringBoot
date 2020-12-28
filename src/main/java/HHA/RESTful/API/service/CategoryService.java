package HHA.RESTful.API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HHA.RESTful.API.repository.CategoryRepository;
import HHA.RESTful.API.domain.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> listAllCategories() {
		return repo.findAll();
	}
	
	public Category getCategoryById(int id) {
		return repo.findById(id).get();
	}
	
	public void saveCategory(Category category) {
		repo.save(category);
	}
	
	public void deleteCategory(int id) {
		repo.deleteById(id);
	}
}
