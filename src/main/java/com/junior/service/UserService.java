package com.junior.service;

import java.util.List;

import com.junior.entity.User;

public interface UserService {
	public List<User> findAll();

	public User findById(int id);

	public List<User> findByProperty(String property, Object value);

	public void save(User instante);

	public void update(User instante);

	public void delete(User instante);

}
