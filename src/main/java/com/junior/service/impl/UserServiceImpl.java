package com.junior.service.impl;

import java.io.Serializable;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.UserDAO;
import com.junior.entity.User;
import com.junior.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	final static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO<User> userDAO;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByProperty(String property, Object value) {
		LOGGER.info("Find user by property start");
		return userDAO.findByProperty(property, value);
	}

	@Override
	public void save(User instante) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User instante) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User instante) {
		// TODO Auto-generated method stub

	}
}
