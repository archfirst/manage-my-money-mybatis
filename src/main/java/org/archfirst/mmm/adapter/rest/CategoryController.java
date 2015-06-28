package org.archfirst.mmm.adapter.rest;

import java.util.List;

import org.archfirst.mmm.adapter.rest.dto.CategoryData;
import org.archfirst.mmm.application.CategoryService;
import org.archfirst.mmm.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public Category createCategory(@RequestBody CategoryData categoryData) {
		return categoryService.createCategory(categoryData.getName());
	}

	// The path variable id is not used
	@RequestMapping(value="/categories/{id}", method=RequestMethod.PUT)
	public Category updateCategory(@RequestBody CategoryData categoryData) {
		return categoryService.updateCategory(categoryData.getId(), categoryData.getName());
	}

    @RequestMapping("/categories/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @RequestMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

	@RequestMapping(value="/categories/{id}", method=RequestMethod.DELETE)
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
	}
}
