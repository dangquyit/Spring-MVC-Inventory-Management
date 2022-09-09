package com.junior.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.RoleDAO;
import com.junior.entity.Role;
import com.junior.model.Paging;
import com.junior.service.RoleService;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDAO<Role> roleDAO;

	@Override
	public List<Role> findAll(Role role, Paging paging) {
		return roleDAO.findAll(null, null, paging);
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Role instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Role instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Role instance) {
		// TODO Auto-generated method stub

	}
}
