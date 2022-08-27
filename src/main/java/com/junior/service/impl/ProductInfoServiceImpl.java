package com.junior.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junior.dao.ProductInfoDAO;
import com.junior.entity.ProductInfo;
import com.junior.model.Paging;
import com.junior.service.ProductInfoService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductInfoServiceImpl implements ProductInfoService{
	@Autowired
	private ProductInfoDAO<ProductInfo> productInfoDAO;
	private final static Logger LOGGER = Logger.getLogger(ProductInfoServiceImpl.class);

	@Override
	public List<ProductInfo> findAll(ProductInfo productInfo, Paging paging) {
		LOGGER.info("Find all Product Info");
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> mapParams = new HashMap<>();
		if (productInfo.getId() != 0) {
			queryStr.append(" and model.id =:id");
			mapParams.put("id", productInfo.getId());
		}
		if (productInfo.getCode() != null && !productInfo.getCode().isEmpty()) {
			queryStr.append(" and model.code =:code");
			mapParams.put("code", productInfo.getCode());
		}
		if (productInfo.getName() != null && !productInfo.getName().isEmpty()) {
			queryStr.append(" and model.name LIKE :name");
			mapParams.put("name", "%" + productInfo.getName() + "%");
		}
		return productInfoDAO.findAll(queryStr.toString(), mapParams, paging);
	}

	@Override
	public ProductInfo findById(int id) {
		LOGGER.info("Find Product Info by id");
		return productInfoDAO.findById(ProductInfo.class, id);
	}

	@Override
	public List<ProductInfo> findByProperty(String property, Object value) {
		LOGGER.info("Find Product Info by property = " + property + " value = " + value);
		return productInfoDAO.findByProperty(property, value);
	}

	@Override
	public void save(ProductInfo instante) throws Exception {
		LOGGER.info("Save Product Info");
		instante.setActiveFlag(1);
		instante.setCreateDate(new Timestamp(new Date().getTime()));
		instante.setUpdateDate(new Timestamp(new Date().getTime()));
		instante.setImgUrl("/upload/" + instante.getMultipartFile().getOriginalFilename());
		productInfoDAO.save(instante);
	}

	@Override
	public void update(ProductInfo instante) throws Exception {
		LOGGER.info("Update Product Info");
		instante.setUpdateDate(new Timestamp(new Date().getTime()));
		productInfoDAO.update(instante);
	}

	@Override
	public void delete(ProductInfo instante) throws Exception {
		LOGGER.info("Delete Product Info");
		instante.setActiveFlag(0);
		productInfoDAO.update(instante);
	}
}
