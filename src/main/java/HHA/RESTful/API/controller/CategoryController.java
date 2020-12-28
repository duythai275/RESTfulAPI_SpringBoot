package HHA.RESTful.API.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import HHA.RESTful.API.domain.Category;
import HHA.RESTful.API.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@GetMapping("/categories")
	public List<Category> list() {
		return service.listAllCategories();
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> get(@PathVariable int id) {
		try {
			Category category = service.getCategoryById(id);
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/categories")
	public void add(@RequestBody Category category) {
		service.saveCategory(category);
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<?> update(@RequestBody Category category, @PathVariable int id) {
		try {
			Category existCategory = service.getCategoryById(id);
			category.setId(id);
			service.saveCategory(category);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/categories/{id}")
	public void delete(@PathVariable int id) {
		service.deleteCategory(id);
	}
}
