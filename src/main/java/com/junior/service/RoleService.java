package com.junior.service;

import java.util.List;

import com.junior.entity.Role;
import com.junior.model.Paging;

public interface RoleService {
	public List<Role> findAll(Role role, Paging paging);

	public Role findById(int id);

	public List<Role> findByProperty(String property, Object value);

	public void save(Role instance);

	public void update(Role instance);

	public void delete(Role instance);
}
