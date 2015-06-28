package org.archfirst.mmm.persistence;

import java.util.List;

import org.archfirst.mmm.domain.Category;

public interface CategoryMapper {
	public void createCategory(Category category);
	public void updateCategory(Category category);
	public Category getCategory(int id);
	public List<Category> getCategories();
	public void deleteCategory(int id);
}
