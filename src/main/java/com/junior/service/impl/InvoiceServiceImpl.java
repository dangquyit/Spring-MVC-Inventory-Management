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
import com.junior.entity.Invoice;
import com.junior.model.Paging;
import com.junior.service.HistoryService;
import com.junior.service.InvoiceService;
import com.junior.service.ProductInStockService;
import com.junior.util.Constant;

@Service
@Transactional(rollbackFor = Exception.class)
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceDAO<Invoice> invoiceDAO;
	@Autowired
	private ProductInStockService productInStockService;
	@Autowired
	private HistoryService historyService;
	private final static Logger LOGGER = Logger.getLogger(InvoiceServiceImpl.class);

	@Override
	public List<Invoice> findAll(Invoice invoice, Paging paging) {
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> mapParams = new HashMap<>();
		if(invoice != null) {
			if(invoice.getType() != 0) {
				queryStr.append(" AND model.type := type");
				mapParams.put("type", invoice.getType());
			}
			if(!invoice.getCode().isEmpty()) {
				queryStr.append(" AND model.code := code");
				mapParams.put("code", invoice.getCode());
			}
			if(invoice.getFromDate() != null) {
				queryStr.append(" AND model.updateDate >= :fromDate");
				mapParams.put("fromDate", new Timestamp(invoice.getFromDate().getTime()));
			}
			if(invoice.getToDate() != null) {
				queryStr.append(" AND model.updateDate <= :toDate");
				mapParams.put("toDate", new Timestamp(invoice.getToDate().getTime()));
			}
		}
		return invoiceDAO.findAll(queryStr.toString(), mapParams, paging);
	}

	@Override
	public Invoice findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Invoice> findByProperty(String property, Object value) {
		LOGGER.info("Find invoice by properties om db");
		return invoiceDAO.findByProperty(property, value);
	}

	@Override
	public void save(Invoice instance) throws Exception {
		LOGGER.info("Save invoice from model to db");
		instance.setActiveFlag(1);
		instance.setCreateDate(new Timestamp(new Date().getTime()));
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		invoiceDAO.save(instance);
		productInStockService.saveOrUpdate(instance);
		historyService.saveHistory(instance, Constant.ACTION_ADD);
	}

	@Override
	public void update(Invoice instance) throws Exception {
		LOGGER.info("Update invoice from model to db");
		instance.setUpdateDate(new Timestamp(new Date().getTime()));
		int originQuantity = invoiceDAO.findById(Invoice.class, instance.getId()).getQuantity();
		Invoice invoice = new Invoice();
		invoice.setQuantity(instance.getQuantity() - originQuantity);
		invoice.setProductInfo(instance.getProductInfo());
		invoice.setPrice(instance.getPrice());
		invoiceDAO.update(instance);
		productInStockService.saveOrUpdate(invoice);
		historyService.saveHistory(instance, Constant.ACTION_EDIT);
	}

	@Override
	public void delete(Invoice instance) throws Exception {
		// TODO Auto-generated method stub

	}

}
