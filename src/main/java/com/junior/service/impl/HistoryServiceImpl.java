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

import com.junior.dao.HistoryDAO;
import com.junior.entity.History;
import com.junior.entity.Invoice;
import com.junior.model.Paging;
import com.junior.service.HistoryService;

@Service
@Transactional(rollbackFor = Exception.class)
public class HistoryServiceImpl implements HistoryService {
	@Autowired
	private HistoryDAO<History> historyDAO;
	private final static Logger LOGGER = Logger.getLogger(History.class);

	@Override
	public List<History> findAll(History history, Paging paging) {
		LOGGER.info("Find all history");
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> mapParams = new HashMap<>();
		if (history != null) {

			if (history.getProductInfo() != null) {
				if (history.getProductInfo().getCode() != null && !history.getProductInfo().getCode().isEmpty()) {
					queryStr.append(" AND model.productInfo.code = :code");
					mapParams.put("code", history.getProductInfo().getCode());
				}
				if (history.getProductInfo().getCategory().getName() != null
						&& !history.getProductInfo().getCategory().getName().isEmpty()) {
					queryStr.append(" AND model.productInfo.category.name LIKE :category");
					mapParams.put("category", "%" + history.getProductInfo().getCategory().getName() + "%");
				}
			}
			if (history.getActionName() != null && !history.getActionName().isEmpty()) {
				queryStr.append(" AND model.actionName LIKE :actionName");
				mapParams.put("actionName", history.getActionName());
			}

			if (history.getType() != 0) {
				queryStr.append(" AND model.type = :type");
				mapParams.put("type", history.getType());
			}
		}
		return historyDAO.findAll(queryStr.toString(), mapParams, paging);
	}

	@Override
	public History findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<History> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(History instance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(History instance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(History instance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveHistory(Invoice invoice, String action) {
		LOGGER.info("save history from invoice");
		History history = new History();
		history.setCreateDate(new Timestamp(new Date().getTime()));
		history.setUpdateDate(new Timestamp(new Date().getTime()));
		history.setActiveFlag(1);
		history.setProductInfo(invoice.getProductInfo());
		history.setPrice(invoice.getPrice());
		history.setQuantity(invoice.getQuantity());
		history.setType(invoice.getType());
		history.setActionName(action);
		historyDAO.save(history);
		
}

}
