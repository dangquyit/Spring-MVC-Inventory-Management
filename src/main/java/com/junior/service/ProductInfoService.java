package com.junior.service;

import java.util.List;

import com.junior.entity.ProductInfo;
import com.junior.model.Paging;

public interface ProductInfoService {
	public List<ProductInfo> findAll(ProductInfo productInfo, Paging paging);

	public ProductInfo findById(int id);

	public List<ProductInfo> findByProperty(String property, Object value);

	public void save(ProductInfo instante) throws Exception;

	public void update(ProductInfo instante) throws Exception;

	public void delete(ProductInfo instante) throws Exception;
}
