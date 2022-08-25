package com.junior.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.CategoryDAO;
import com.junior.entity.Category;

@Repository
@Transactional(rollbackFor = Exception.class)
public class CategoryDAOImpl extends BaseDAOImpl<Category> implements CategoryDAO<Category>{
	
}
