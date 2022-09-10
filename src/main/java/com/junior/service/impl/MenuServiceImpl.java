package com.junior.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.AuthDAO;
import com.junior.dao.MenuDAO;
import com.junior.dao.RoleDAO;
import com.junior.entity.Auth;
import com.junior.entity.Menu;
import com.junior.entity.Role;
import com.junior.model.Paging;
import com.junior.service.MenuService;

@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDAO<Menu> menuDAO;
	
	@Autowired
	private RoleDAO<Role> roleDAO;
	
	@Autowired
	private AuthDAO<Auth> authDAO;
	
	@Override
	public List<Menu> findAll(Menu menu, Paging paging) {
		StringBuilder queryStr = new StringBuilder();
		queryStr.append(" OR model.activeFlag=0");
		
		Map<String, Object> mapParams = new HashMap<>();
		if (menu != null) {
			if (menu.getUrl() != null && !menu.getUrl().isEmpty()) {
				queryStr.append(" AND model.url LIKE :url");
				mapParams.put("url", "%" + menu.getUrl() + "%");
			}
		}
		return menuDAO.findAll(queryStr.toString(), mapParams, paging);
	}

	@Override
	public Menu findById(int id) {
		return menuDAO.findById(Menu.class, id);
	}

	@Override
	public List<Menu> findByProperty(String property, Object value) {
		return menuDAO.findByProperty(property, value);
	}

	@Override
	public void save(Menu instance) {
		instance.setCreateDate(new Timestamp(new Date().getTime()));
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		instance.setActiveFlag(1);
		menuDAO.save(instance);
	}

	@Override
	public void update(Menu instance) {
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		menuDAO.update(instance);
	}

	@Override
	public void delete(Menu instance) {
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		instance.setActiveFlag(0);
		menuDAO.update(instance);
	}

	@Override
	public void changeStatus(int id) {
		Menu menu = findById(id);
		if(menu != null) {
			menu.setActiveFlag(menu.getActiveFlag() == 1 ? 0 : 1);
			update(menu);
		} else {
			
		}
	}
	
	@Override
	public void updatePermission(int menuId, int roleId, int permission) {
		Auth auth = authDAO.findByMenuIdRoleId(menuId, roleId);
		if(auth != null) {
			auth.setPermisstion(permission);
			auth.setUpdateDate(new Timestamp(new Date().getTime()));
			authDAO.update(auth);
		} else {
			if(permission == 1) {
				auth = new Auth();
				Role role = new Role();
				role.setId(roleId);
				Menu menu = new Menu();
				menu.setId(menuId);
				auth.setRole(role);
				auth.setMenu(menu);
				auth.setActiveFlag(1);
				auth.setPermisstion(1);
				auth.setCreateDate(new Timestamp(new Date().getTime()));
				auth.setUpdateDate(new Timestamp(new Date().getTime()));
				authDAO.save(auth);
			}
		}
	}

}
