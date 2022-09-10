package com.junior.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.MenuDAO;
import com.junior.entity.Menu;
import com.junior.model.Paging;
import com.junior.service.MenuService;

@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDAO<Menu> menuDAO;

	@Override
	public List<Menu> findAll(Menu menu, Paging paging) {
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> mapParams = new HashMap<>();
		if (menu != null) {
			if (menu.getUrl() != null && !menu.getUrl().isEmpty()) {
				queryStr.append(" AND model.url LIKE :url");
				mapParams.put("url", "%" + menu.getUrl() + "%");
			}
		}
		return menuDAO.findAll(queryStr.toString(), mapParams, paging);
	}

	@Override
	public Menu findById(int id) {
		return menuDAO.findById(Menu.class, id);
	}

	@Override
	public List<Menu> findByProperty(String property, Object value) {
		return menuDAO.findByProperty(property, value);
	}

	@Override
	public void save(Menu instance) {
	}

	@Override
	public void update(Menu instance) {
	}

	@Override
	public void delete(Menu instance) {
	}

}
