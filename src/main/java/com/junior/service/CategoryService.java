package com.junior.service;

import java.util.List;

import com.junior.entity.Category;
import com.junior.model.Paging;

public interface CategoryService {
	public List<Category> findAll(Category category, Paging paging);
	
	public Category findById(int id);

	public List<Category> findByProperty(String property, Object value);

	public void save(Category instante) throws Exception;

	public void update(Category instante) throws Exception;

	public void delete(Category instante) throws Exception;
}
