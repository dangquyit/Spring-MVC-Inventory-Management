package com.junior.dao;

import com.junior.entity.Auth;

public interface AuthDAO<E> extends BaseDAO<E> {
	public Auth findByMenuIdRoleId(int menuId, int roleId);
}
