package com.junior.validate;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.junior.entity.Invoice;
import com.junior.service.InvoiceService;

@Component
public class InvoiceValidator implements Validator {
	@Autowired
	private InvoiceService invoiceService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == Invoice.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Invoice invoice = (Invoice) target;
		ValidationUtils.rejectIfEmpty(errors, "code", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "quantity", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "msg.required");
		if (invoice.getCode() != null) {
			List<Invoice> listInvoice = invoiceService.findByProperty("code", invoice.getCode());
			if (listInvoice != null && !listInvoice.isEmpty()) {
				if (invoice.getId() != 0) {
					if (invoice.getId() != listInvoice.get(0).getId()) {
						errors.rejectValue("code", "msg.code.exist");
					}
				}
			}
		}
		if (invoice.getQuantity() <= 0) {
			errors.rejectValue("quantity", "msg.wrong.format");
		}
		
		if (invoice.getPrice() == null || invoice.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
			errors.rejectValue("price", "msg.wrong.format");
		}

		if (invoice.getFromDate() != null && invoice.getToDate() != null) {
			if (invoice.getFromDate().after(invoice.getToDate())) {
				errors.rejectValue("fromDate", "msg.wrong.date");
			}
		}
	}
}
