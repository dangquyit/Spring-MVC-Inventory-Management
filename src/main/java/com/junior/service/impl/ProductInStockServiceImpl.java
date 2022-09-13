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

import com.junior.dao.InvoiceDAO;
import com.junior.dao.ProductInStockDAO;
import com.junior.entity.Invoice;
import com.junior.entity.ProductInStock;
import com.junior.model.Paging;
import com.junior.service.ProductInStockService;
import com.junior.util.Constant;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductInStockServiceImpl implements ProductInStockService {
	@Autowired
	ProductInStockDAO<ProductInStock> productInStockDAO;

	@Autowired
	InvoiceDAO<Invoice> invoiceDAO;

	private final static Logger LOGGER = Logger.getLogger(ProductInStockServiceImpl.class);

	@Override
	public List<ProductInStock> findAll(ProductInStock productInStock, Paging paging) {
		LOGGER.info("Find all product in stock");
		StringBuilder queryStr = new StringBuilder(" AND model.quantity > 0");
		Map<String, Object> mapParams = new HashMap<>();
		if (productInStock != null && productInStock.getProductInfo() != null) {
			if (!productInStock.getProductInfo().getCategory().getName().isEmpty()
					&& productInStock.getProductInfo().getCategory().getName() != null) {
				queryStr.append(" AND model.productInfo.category.name LIKE :cateName");
				mapParams.put("cateName", "%" + productInStock.getProductInfo().getCategory().getName() + "%");
			}
			if (productInStock.getProductInfo().getCode() != null
					&& !productInStock.getProductInfo().getCode().isEmpty()) {
				queryStr.append(" AND model.productInfo.code = :code");
				mapParams.put("code", productInStock.getProductInfo().getCode());
			}

			if (productInStock.getProductInfo().getName() != null
					&& !productInStock.getProductInfo().getName().isEmpty()) {
				queryStr.append(" AND model.productInfo.name LIKE :name");
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
		if (invoice.getProductInfo() != null) {
			List<ProductInStock> listProductInStock = productInStockDAO.findByProperty("productInfo.id",
					invoice.getProductInfo().getId());
			LOGGER.info("Id product info: " + invoice.getProductInfo().getId());
			ProductInStock productInStock = null;
			if (!listProductInStock.isEmpty() && listProductInStock != null) {
				productInStock = listProductInStock.get(0);
				LOGGER.info("Update product in stock quantity = " + invoice.getQuantity() + "price = "
						+ invoice.getPrice());
				if (invoice.getType() == Constant.TYPE_GOODS_ISSUES) {
					productInStock.setQuantity(productInStock.getQuantity() - invoice.getQuantity());
				} else {
					productInStock.setQuantity(productInStock.getQuantity() + invoice.getQuantity());
				}

				if (invoice.getType() == Constant.TYPE_GOODS_RECEIPT) {
					productInStock.setPrice(invoice.getPrice());
				}

				productInStock.setUpdateDate(new Timestamp(new Date().getTime()));
				productInStockDAO.update(productInStock);
				return;
			}

			if (invoice.getType() == Constant.TYPE_GOODS_RECEIPT) {
				LOGGER.info("Insert product in stock in db");
				productInStock = new ProductInStock();
				productInStock.setUpdateDate(new Timestamp(new Date().getTime()));
				productInStock.setCreateDate(new Timestamp(new Date().getTime()));
				productInStock.setProductInfo(invoice.getProductInfo());
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
