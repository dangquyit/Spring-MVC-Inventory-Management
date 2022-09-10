package com.junior.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.AuthDAO;
import com.junior.entity.Auth;

@Repository
@Transactional(rollbackFor = Exception.class)
public class AuthDAOImpl extends BaseDAOImpl<Auth> implements AuthDAO<Auth>{

	@Override
	public Auth findByMenuIdRoleId(int menuId, int roleId) {
		String hql = " FROM Auth AS model WHERE model.role.id =:roleId AND model.menu.id =:menuId";
		Query<Auth> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("roleId", roleId);
		query.setParameter("menuId", menuId);
		List<Auth> listAuth = query.getResultList();
		if(!listAuth.isEmpty() && listAuth != null) {
			return listAuth.iterator().next();
		}
		return null;
	}

}
