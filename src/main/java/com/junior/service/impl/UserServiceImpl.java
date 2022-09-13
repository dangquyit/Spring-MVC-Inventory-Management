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

import com.junior.dao.UserDAO;
import com.junior.dao.UserRoleDAO;
import com.junior.entity.Role;
import com.junior.entity.User;
import com.junior.entity.UserRole;
import com.junior.model.Paging;
import com.junior.service.UserService;
import com.junior.util.HashtingPassword;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	final static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO<User> userDAO;

	@Autowired
	private UserRoleDAO<UserRole> userRoleDAO;

	@Override
	public List<User> findAll(User user, Paging paging) {
		StringBuilder queryString = new StringBuilder();
		Map<String, Object> mapParams = new HashMap<>();
		if (user != null) {
			if (user.getUserName() != null && !user.getUserName().isEmpty()) {
				queryString.append(" AND model.userName LIKE :userName");
				mapParams.put("userName", "%" + user.getUserName() + "%");
			}
			if (user.getName() != null && !user.getName().isEmpty()) {
				queryString.append(" AND model.name LIKE :name");
				mapParams.put("name", "%" + user.getName() + "%");
			}
			if (user.getEmail() != null && !user.getEmail().isEmpty()) {
				queryString.append(" AND model.email LIKE :email");
				mapParams.put("email", "%" + user.getEmail() + "%");
			}
		}
		return userDAO.findAll(queryString.toString(), mapParams, paging);
//		return userDAO.findAll(null, null, null);
	}

	@Override
	public User findById(int id) {
		return userDAO.findById(User.class, id);
	}

	@Override
	public List<User> findByProperty(String property, Object value) {
		LOGGER.info("Find user by property start");
		return userDAO.findByProperty(property, value);
	}

	@Override
	public void save(User instance) {
		LOGGER.info("Save info Service");
		instance.setActiveFlag(1);
		instance.setCreateDate(new Timestamp(new Date().getTime()));
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		instance.setPassword(HashtingPassword.encrypt(instance.getPassword()));
		userDAO.save(instance);
		UserRole userRole = new UserRole();
		userRole.setActiveFlag(1);
		userRole.setCreateDate(new Timestamp(new Date().getTime()));
		userRole.setUpdateDate(new Timestamp(new Date().getTime()));
		userRole.setUser(instance);
		Role role = new Role();
		role.setId(instance.getRoleId());
		userRole.setRole(role);
		userRoleDAO.save(userRole);
	}

	@Override
	public void update(User instance) {
		LOGGER.info("Update user Service");
		User user = findById(instance.getId());
		if (user != null) {
			UserRole userRole = user.getUserRoles().iterator().next();
			Role role = userRole.getRole();
			role.setId(instance.getRoleId());
			userRole.setRole(role);
			userRole.setUpdateDate(new Timestamp(new Date().getTime()));
			userRoleDAO.update(userRole);
		}
		userDAO.update(instance);
	}

	@Override
	public void delete(User instance) {
		instance.setActiveFlag(0);
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		userDAO.update(instance);
	}
}
