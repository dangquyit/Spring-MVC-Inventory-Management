package com.junior.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.CategoryDAO;
import com.junior.entity.Category;
import com.junior.model.Paging;
import com.junior.service.CategoryService;

@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO<Category> categoryDAO;
	private final static Logger LOGGER = Logger.getLogger(CategoryServiceImpl.class);

	@Override
	public List<Category> findAll(Category category, Paging paging) {
		LOGGER.info("Find all category");
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> mapParams = new HashMap<>();
		if (category.getId() != 0) {
			queryStr.append(" and model.id =:id");
			mapParams.put("id", category.getId());
		}
		if (category.getCode() != null && !category.getCode().isEmpty()) {
			queryStr.append(" and model.code =:code");
			mapParams.put("code", category.getCode());
		}
		if (category.getName() != null && !category.getName().isEmpty()) {
			queryStr.append(" and model.name LIKE :name");
			mapParams.put("name", "%"+category.getName()+"%");
		}
		return categoryDAO.findAll(queryStr.toString(), mapParams, paging);
	}

	@Override
	public Category findById(int id) {
		LOGGER.info("Find category by id");
		return categoryDAO.findById(Category.class, id);
	}

	@Override
	public List<Category> findByProperty(String property, Object value) {
		LOGGER.info("Find category by property = " + property + " value = " + value);
		return categoryDAO.findByProperty(property, value);
	}

	@Override
	public void save(Category instance) throws Exception {
		LOGGER.info("Save category");
		instance.setActiveFlag(1);
		instance.setCreateDate(new Timestamp(new Date().getTime()));
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		categoryDAO.save(instance);
	}

	@Override
	public void update(Category instance) throws Exception {
		LOGGER.info("Update category");
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		categoryDAO.update(instance);
	}

	@Override
	public void delete(Category instance) throws Exception {
		LOGGER.info("Delete category");
		instance.setActiveFlag(0);
		categoryDAO.update(instance);
	}
}
