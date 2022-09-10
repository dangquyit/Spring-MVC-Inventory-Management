package com.junior.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.MenuDAO;
import com.junior.entity.Menu;

@Repository
@Transactional(rollbackFor = Exception.class)
public class MenuDAOImpl extends BaseDAOImpl<Menu> implements MenuDAO<Menu> {

}
