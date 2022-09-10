package com.junior.service;

import java.util.List;

import com.junior.entity.Menu;
import com.junior.model.Paging;

public interface MenuService {
	public List<Menu> findAll(Menu menu, Paging paging);

	public Menu findById(int id);

	public List<Menu> findByProperty(String property, Object value);

	public void save(Menu instance);

	public void update(Menu instance);

	public void delete(Menu instance);
}
