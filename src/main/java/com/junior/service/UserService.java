package com.junior.service;

import java.util.List;

import com.junior.entity.User;
import com.junior.model.Paging;

public interface UserService {
	public List<User> findAll(User user, Paging paging);

	public User findById(int id);

	public List<User> findByProperty(String property, Object value);

	public void save(User instance);

	public void update(User instance);

	public void delete(User instance);

}
