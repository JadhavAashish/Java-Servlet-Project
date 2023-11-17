package org.notice.service;

import java.util.List;

import org.notice.model.CategoryModel;
import org.notice.repository.CategoryRepository;
import org.notice.repository.CategoryRepositoryImpl;

public class CategoryServiceImpl implements CategoryService{

	CategoryRepository cr=new CategoryRepositoryImpl();
	
	@Override
	public boolean isAddCategory(CategoryModel model) {
		return cr.isAddCategory(model);
	}

	@Override
	public List<CategoryModel> getAllCategory() {
		return cr.getAllCategory();
	}

	@Override
	public boolean isDisableCategory(int catId) {
		// TODO Auto-generated method stub
		return cr.isDisableCategory(catId);
	}

	@Override
	public List<CategoryModel> getAllCategoryByName(String name) {
		// TODO Auto-generated method stub
		return cr.getAllCategoryByName(name);
	}

	@Override
	public boolean getUpdated(CategoryModel model) {
		// TODO Auto-generated method stub
		return cr.getUpdated(model);
	}

}
