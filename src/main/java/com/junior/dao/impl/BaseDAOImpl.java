package com.junior.dao.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.BaseDAO;
import com.junior.model.Paging;

@Repository
@Transactional(rollbackFor = Exception.class)
public class BaseDAOImpl<E> implements BaseDAO<E> {
	final static Logger LOGGER = Logger.getLogger(BaseDAOImpl.class);
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<E> findAll(String queryStr, Map<String, Object> mapParams, Paging paging) {
		LOGGER.info("Find all record from db");
		StringBuilder sql = new StringBuilder();
		StringBuilder countSql = new StringBuilder();
		countSql.append(" SELECT COUNT(*) FROM ").append(getGenericName())
				.append(" AS model WHERE model.activeFlag = 1");
		sql.append(" FROM ").append(getGenericName()).append(" AS model WHERE model.activeFlag=1");
		System.out.println("Generic name: "+getGenericName());
		if (queryStr != null && !queryStr.isEmpty()) {
			sql.append(queryStr);
			countSql.append(queryStr);
		}
		Query<E> query = sessionFactory.getCurrentSession().createQuery(sql.toString());
		Query<E> queryCount = sessionFactory.getCurrentSession().createQuery(countSql.toString());
		if (mapParams != null && !mapParams.isEmpty()) {
			for (String key : mapParams.keySet()) {
				query.setParameter(key, mapParams.get(key));
				queryCount.setParameter(key, mapParams.get(key));
			}
		}
		if (paging != null) {
			query.setFirstResult(paging.getOffset()); // same FROM model WHERE model.activeFlag = 1 limit 0, 10;
			query.setMaxResults(paging.getRecordPerPage());
			long totalRecords = (long) queryCount.uniqueResult();
			paging.setTotalRows(totalRecords);
		}
		return query.list();
	}

	@Override
	public E findById(Class<E> e, Serializable id) {
		LOGGER.info("Find by ID");
		return sessionFactory.getCurrentSession().get(e, id);
	}

	@Override
	public List<E> findByProperty(String property, Object value) {
		LOGGER.info("Find by Property");
		StringBuilder sql = new StringBuilder("");
		sql.append(" FROM ").append(getGenericName()).append(" AS model WHERE model.activeFlag=1 AND model.")
				.append(property).append("=:value");
		Query<E> query = sessionFactory.getCurrentSession().createQuery(sql.toString());
		query.setParameter("value", value);
		LOGGER.info("SQL find by property: " + sql);
		return query.getResultList();
	}

	@Override
	public void save(E instance) {
		LOGGER.info("Save instance");
		sessionFactory.getCurrentSession().save(instance);
	}

	@Override
	public void update(E instance) {
		LOGGER.info("Update instance");
		sessionFactory.getCurrentSession().merge(instance);
	}

	public String getGenericName() {
		String s = getClass().getGenericSuperclass().toString();
		Pattern pattern = Pattern.compile("\\<(.*?)\\>");
		Matcher m = pattern.matcher(s);
		String generic = "null";
		if (m.find()) {
			generic = m.group(1);
		}
		return generic;
	}

}
