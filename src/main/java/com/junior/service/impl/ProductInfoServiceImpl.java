package com.junior.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.junior.dao.ProductInfoDAO;
import com.junior.entity.ProductInfo;
import com.junior.model.Paging;
import com.junior.service.ProductInfoService;
import com.junior.util.ConfigLoader;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductInfoServiceImpl implements ProductInfoService {
	@Autowired
	private ProductInfoDAO<ProductInfo> productInfoDAO;
	private final static Logger LOGGER = Logger.getLogger(ProductInfoServiceImpl.class);

	@Override
	public List<ProductInfo> findAll(ProductInfo productInfo, Paging paging) {
		LOGGER.info("Find all Product Info");
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> mapParams = new HashMap<>();
		if(productInfo != null) {
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
	public void save(ProductInfo instance) throws Exception {
		LOGGER.info("Save Product Info");
		long currentTimeMillis = System.currentTimeMillis();
		instance.setActiveFlag(1);
		instance.setCreateDate(new Timestamp(new Date().getTime()));
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		instance.setImgUrl("/upload/" + currentTimeMillis + "_" + instance.getMultipartFile().getOriginalFilename());
		processUploadFile(instance.getMultipartFile(), currentTimeMillis);
		productInfoDAO.save(instance);
	}

	@Override
	public void update(ProductInfo instance) throws Exception {
		LOGGER.info("Update Product Info");
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		if (!instance.getMultipartFile().getOriginalFilename().isEmpty()) {
			long currentTimeMillis = System.currentTimeMillis();
			instance.setImgUrl(
					"/upload/" + currentTimeMillis + "_" + instance.getMultipartFile().getOriginalFilename());
			processUploadFile(instance.getMultipartFile(), currentTimeMillis);
		}
		productInfoDAO.update(instance);
	}

	@Override
	public void delete(ProductInfo instance) throws Exception {
		LOGGER.info("Delete Product Info");
		instance.setActiveFlag(0);
		productInfoDAO.update(instance);
	}

	private void processUploadFile(MultipartFile multipartFile, long currentTimeMillis)
			throws IllegalStateException, IOException {
		if (!multipartFile.getOriginalFilename().isEmpty()) {
			File dir = new File(ConfigLoader.getInstance().getValue("upload.location"));
			if (!dir.exists()) {
				dir.mkdir();
			}
			String fileName = currentTimeMillis + "_" + multipartFile.getOriginalFilename();
			System.out.println("File name in server: " + fileName);
			File file = new File(ConfigLoader.getInstance().getValue("upload.location"), fileName);
			multipartFile.transferTo(file); // coppy file client to server
		}
	}
}
