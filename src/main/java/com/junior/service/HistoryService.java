package com.junior.service;

import java.util.List;

import com.junior.entity.History;
import com.junior.entity.Invoice;
import com.junior.model.Paging;

public interface HistoryService {
	public List<History> findAll(History history, Paging paging);

	public History findById(int id);

	public List<History> findByProperty(String property, Object value);

	public void save(History instance) throws Exception;

	public void update(History instance) throws Exception;

	public void delete(History instance) throws Exception;
	
	public void saveHistory(Invoice invoice, String action);
}
