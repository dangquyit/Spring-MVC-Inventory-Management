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

import com.junior.dao.ProductInStockDAO;
import com.junior.entity.Invoice;
import com.junior.entity.ProductInStock;
import com.junior.model.Paging;
import com.junior.service.ProductInStockService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductInStockServiceImpl implements ProductInStockService {
	@Autowired
	ProductInStockDAO<ProductInStock> productInStockDAO;
	private final static Logger LOGGER = Logger.getLogger(ProductInStockServiceImpl.class);

	@Override
	public List<ProductInStock> findAll(ProductInStock productInStock, Paging paging) {
		LOGGER.info("Find all product in stock");
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> mapParams = new HashMap<>();
		if (productInStock != null && productInStock.getProductInfo() != null) {
			if (!productInStock.getProductInfo().getCategory().getName().isEmpty()
					&& productInStock.getProductInfo().getCategory().getName() != null) {
				queryStr.append(" and model.productInfo.category.name LIKE :cateName");
				mapParams.put("cateName", "%" + productInStock.getProductInfo().getCategory().getName() + "%");
			}
			if (productInStock.getProductInfo().getCode() != null
					&& !productInStock.getProductInfo().getCode().isEmpty()) {
				queryStr.append(" and model.productInfo.code = :code");
				mapParams.put("code", productInStock.getProductInfo().getCode());
			}

			if (productInStock.getProductInfo().getName() != null
					&& !productInStock.getProductInfo().getName().isEmpty()) {
				queryStr.append(" and model.productInfo.name LIKE :name");
				mapParams.put("name", "%" + productInStock.getProductInfo().getName() + "%");
			}
		}
		return productInStockDAO.findAll(queryStr.toString(), mapParams, paging);
	}

	@Override
	public ProductInStock findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductInStock> findByProperty(String property, Object value) {
		LOGGER.info("Find Product In Stock by property = " + property + " value = " + value);
		return productInStockDAO.findByProperty(property, value);
	}

	@Override
	public void save(ProductInStock instance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProductInStock instance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProductInStock instance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(Invoice invoice) {
		LOGGER.info("Save or Update product in stock");
		if(invoice.getProductInfo() != null) {
			List<ProductInStock> listProductInStock = productInStockDAO.findByProperty("productInfo.id", invoice.getProductInfo().getId());
			ProductInStock productInStock = null;
			if(!listProductInStock.isEmpty() && listProductInStock != null) {
				productInStock = new ProductInStock();
				LOGGER.info("Update product in stock quantity = " + invoice.getQuantity() + "price = " + invoice.getPrice());
				if(invoice.getType() == 1 ) {
					productInStock.setPrice(invoice.getPrice());
				}
				productInStock.setQuantity(productInStock.getQuantity() + invoice.getQuantity());
				productInStock.setUpdateDate(new Timestamp(new Date().getTime()));
				productInStockDAO.update(productInStock);
				return;
			}
			
			if(invoice.getType() == 1) {
				LOGGER.info("Insert product in stock in db");
				productInStock = new ProductInStock();
				productInStock.setUpdateDate(new Timestamp(new Date().getTime()));
				productInStock.setCreateDate(new Timestamp(new Date().getTime()));
				productInStock.setId(invoice.getProductInfo().getId());
				productInStock.setActiveFlag(1);
				productInStock.setQuantity(invoice.getQuantity());
				productInStock.setPrice(invoice.getPrice());
				productInStockDAO.save(productInStock);
				return;
			}
		}
		
	}

}
