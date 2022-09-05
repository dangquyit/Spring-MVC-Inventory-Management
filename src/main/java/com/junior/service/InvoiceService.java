package com.junior.service;

import java.util.List;

import com.junior.entity.Invoice;
import com.junior.model.Paging;

public interface InvoiceService {
	public List<Invoice> findAll(Invoice invoice, Paging paging);

	public Invoice findById(int id);

	public List<Invoice> findByProperty(String property, Object value);

	public void save(Invoice instance) throws Exception;

	public void update(Invoice instance) throws Exception;

	public void delete(Invoice instance) throws Exception;

}
