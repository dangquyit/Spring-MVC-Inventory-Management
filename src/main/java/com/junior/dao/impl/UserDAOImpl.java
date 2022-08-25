package com.junior.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.UserDAO;
import com.junior.entity.User;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO<User> {
	
}
