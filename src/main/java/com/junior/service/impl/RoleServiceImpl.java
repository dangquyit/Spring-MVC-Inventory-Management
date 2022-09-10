package com.junior.service.impl;

import java.sql.Timestamp;
import java.util.Date;
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
		return roleDAO.findById(Role.class, id);
	}

	@Override
	public List<Role> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		return roleDAO.findByProperty(property, value);
	}

	@Override
	public void save(Role instance) {
		instance.setCreateDate(new Timestamp(new Date().getTime()));
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		instance.setActiveFlag(1);
		roleDAO.save(instance);
	}

	@Override
	public void update(Role instance) {
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		instance.setActiveFlag(1);
		roleDAO.update(instance);
	}

	@Override
	public void delete(Role instance) {
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		instance.setActiveFlag(0);
		roleDAO.update(instance);
	}
}
