package com.junior.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.junior.entity.Invoice;

public class InvoiceExportReport extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Invoice> listInvoice = (List<Invoice>) model.get(Constant.KEY_INVOICE_REPORT);
		String fileName = "";
		if (listInvoice.iterator().next().getType() == Constant.TYPE_GOODS_ISSUES) {
			fileName = "danh-sach-xuat-hang.xlsx";
		} else {
			fileName = "danh-sach-nhap-hang.xlsx";
		}
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + "");
		Sheet sheet = workbook.createSheet("data");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("#");
		header.createCell(1).setCellValue("Code");
		header.createCell(2).setCellValue("Quantity");
		header.createCell(3).setCellValue("Price");
		header.createCell(4).setCellValue("Product");
		header.createCell(5).setCellValue("Update date");
		for (int i = 0; i < listInvoice.size(); i++) {
			Invoice invoice = listInvoice.get(i);
			Row row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(i + 1);
			row.createCell(1).setCellValue(invoice.getCode());
			row.createCell(2).setCellValue(invoice.getQuantity());
			row.createCell(3).setCellValue(invoice.getPrice().toString());
			row.createCell(4).setCellValue(invoice.getProductInfo().getName());
			row.createCell(5).setCellValue(DateUtil.dateToString(new Date(invoice.getUpdateDate().getTime())));
		}
	}
}
