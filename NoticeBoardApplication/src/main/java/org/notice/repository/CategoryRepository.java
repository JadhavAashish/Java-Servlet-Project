package org.notice.repository;

import java.util.List;

import org.notice.model.CategoryModel;

public interface CategoryRepository {
	
	public boolean isAddCategory(CategoryModel model);
	
	public List<CategoryModel> getAllCategory();
	
	public List<CategoryModel> getAllCategoryByName(String name);
	
	public boolean isDisableCategory(int catId);
	
	public boolean getUpdated(CategoryModel model);

}
