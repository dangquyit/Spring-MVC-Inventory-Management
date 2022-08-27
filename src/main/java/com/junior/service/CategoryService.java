package com.junior.service;

import java.util.List;

import com.junior.entity.Category;
import com.junior.model.Paging;

public interface CategoryService {
	public List<Category> findAll(Category category, Paging paging);
	
	public Category findById(int id);

	public List<Category> findByProperty(String property, Object value);

	public void save(Category instance) throws Exception;

	public void update(Category instance) throws Exception;

	public void delete(Category instance) throws Exception;
}
