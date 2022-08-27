package com.junior.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.ProductInfoDAO;
import com.junior.entity.ProductInfo;
@Repository
@Transactional(rollbackFor = Exception.class)
public class ProductInfoDAOImpl extends BaseDAOImpl<ProductInfo> implements ProductInfoDAO<ProductInfo>{

}
