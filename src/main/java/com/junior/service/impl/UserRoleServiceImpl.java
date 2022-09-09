package com.junior.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.UserRoleDAO;
import com.junior.entity.UserRole;
import com.junior.service.UserRoleService;

@Service 
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	UserRoleDAO<UserRole> userRoleDAO;
	
	private static final Logger LOGGER = Logger.getLogger(UserRoleServiceImpl.class) ;

	@Override
	public List<UserRole> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRole> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserRole instance) {
		userRoleDAO.save(instance);
	}

	@Override
	public void update(UserRole instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserRole instance) {
		// TODO Auto-generated method stub
		
	}

}
