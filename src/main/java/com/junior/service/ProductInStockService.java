package com.junior.service;

import java.util.List;

import com.junior.entity.Invoice;
import com.junior.entity.ProductInStock;
import com.junior.model.Paging;

public interface ProductInStockService {
	public List<ProductInStock> findAll(ProductInStock productInStock, Paging paging);

	public ProductInStock findById(int id);

	public List<ProductInStock> findByProperty(String property, Object value);

	public void save(ProductInStock instance) throws Exception;

	public void update(ProductInStock instance) throws Exception;

	public void delete(ProductInStock instance) throws Exception;
	
	public void saveOrUpdate(Invoice invoice);
}
