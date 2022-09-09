package com.junior.service;

import java.util.List;

import com.junior.entity.UserRole;

public interface UserRoleService {
	public List<UserRole> findAll();

	public UserRole findById(int id);

	public List<UserRole> findByProperty(String property, Object value);

	public void save(UserRole instance);

	public void update(UserRole instance);
	
	public void delete(UserRole instance);
}
