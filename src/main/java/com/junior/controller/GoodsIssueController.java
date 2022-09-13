package com.junior.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.junior.entity.Invoice;
import com.junior.entity.ProductInStock;
import com.junior.model.Paging;
import com.junior.service.InvoiceService;
import com.junior.service.ProductInStockService;
import com.junior.util.Constant;
import com.junior.util.InvoiceExportReport;
import com.junior.validate.InvoiceValidator;

@Controller
public class GoodsIssueController {
	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	ProductInStockService productInStockService;

	@Autowired
	private InvoiceValidator invoiceValidator;

	private static final Logger LOGGER = Logger.getLogger(GoodsIssueController.class);

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		if (dataBinder.getTarget() == null) {
			return;
		}
		// Custom lai date va chap nhan gia tri null cua timestamp
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dataBinder.registerCustomEditor(Timestamp.class, new CustomDateEditor(sdf, true));
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		if (dataBinder.getTarget().getClass() == Invoice.class) {
			dataBinder.setValidator(invoiceValidator);
		}
	}

	@RequestMapping(value = { "/goods-issue/list", "/goods-issue/list/" })
	public String redirect() {
		return "redirect:/goods-issue/list/1";
	}

	@RequestMapping("/goods-issue/list/{page}")
	public String showInvoiceList(Model model, HttpSession session, @ModelAttribute("searchForm") Invoice invoice,
			@PathVariable(value = "page") int page) {
		Paging paging = new Paging(5);
		paging.setIndexPage(page);
		model.addAttribute("pageInfo", paging);
		invoice.setType(Constant.TYPE_GOODS_ISSUES);
		List<Invoice> listInvoice = invoiceService.findAll(invoice, paging);
		if (session.getAttribute(Constant.MSG_SUCCESS) != null) {
			model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
			session.removeAttribute(Constant.MSG_SUCCESS);
		}
		if (session.getAttribute(Constant.MSG_ERROR) != null) {
			model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
			session.removeAttribute(Constant.MSG_ERROR);
		}
		model.addAttribute("listInvoice", listInvoice);
		return "goods-issue-list";
	}

	@GetMapping("/goods-issue/add")
	public String addInvoice(Model model) {
		model.addAttribute("modelForm", new Invoice());
		model.addAttribute("titlePage", "Add Good Issue");
		model.addAttribute("viewOnly", false);
		model.addAttribute("mapProduct", initMapProductInStock());
		model.addAttribute("viewProduct", false);
		return "goods-issue-action";
	}

	@GetMapping("/goods-issue/edit/{id}")
	public String editInvoice(@PathVariable(name = "id", required = true) int id, Model model) {
		Invoice invoice = invoiceService.findById(id);
		if (invoice != null) {
			invoice.setProductId(invoice.getProductInfo().getId());
			model.addAttribute("titlePage", "Edit Good Issue");
			model.addAttribute("modelForm", invoice);
			model.addAttribute("viewOnly", false);
			model.addAttribute("mapProduct", initMapProductInStock());
			model.addAttribute("viewProduct", true);
			return "goods-issue-action";
		}
		return "redirect:/goods-issue/list";
	}

	@GetMapping("/goods-issue/view/{id}")
	public String viewInvoice(@PathVariable(name = "id", required = true) int id, Model model) {
		Invoice invoice = invoiceService.findById(id);
		if (invoice != null) {
			model.addAttribute("titlePage", "View Good Issue");
			model.addAttribute("modelForm", invoice);
			model.addAttribute("viewOnly", true);
			model.addAttribute("mapProduct", initMapProductInStock());
			model.addAttribute("viewProduct", true);
			return "goods-issue-action";
		}
		return "redirect:/goods-issue/list";
	}

	@PostMapping("/goods-issue/save")
	public String saveInvoice(Model model, @ModelAttribute("modelForm") @Validated Invoice invoice,
			BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			if (invoice.getId() != 0) {
				model.addAttribute("titlePage", "Edit Good Issue");
				model.addAttribute("viewProduct", true);
			} else {
				model.addAttribute("titlePage", "Add Good Issue");
				model.addAttribute("viewProduct", false);
			}
			model.addAttribute("modelForm", invoice);
			model.addAttribute("mapProduct", initMapProductInStock());
			model.addAttribute("viewOnly", false);
			return "goods-issue-action";
		}
		invoice.setType(Constant.TYPE_GOODS_ISSUES);
		if (invoice.getId() != 0) {
			LOGGER.info("Update invoice");
			try {
				System.out.println("Update invoice ne");
				invoiceService.update(invoice);
				session.setAttribute(Constant.MSG_SUCCESS, "Update success !!!");

			} catch (Exception e) {
				session.setAttribute(Constant.MSG_ERROR, "Update has error !!!");
				e.printStackTrace();
			}
		} else {
			LOGGER.info("Save invoice");
			try {
				invoiceService.save(invoice);
				session.setAttribute(Constant.MSG_SUCCESS, "Insert success !!!");
			} catch (Exception e) {
				session.setAttribute(Constant.MSG_ERROR, "Insert has error !!!");
				e.printStackTrace();
			}
		}
		return "redirect:/goods-issue/list";
	}

	@GetMapping("/goods-issue/export")
	public ModelAndView export() {
		ModelAndView modelAndView = new ModelAndView();
		Invoice invoice = new Invoice();
		invoice.setType(Constant.TYPE_GOODS_ISSUES);
		List<Invoice> listInvoice = invoiceService.findAll(invoice, null);
		modelAndView.addObject(Constant.KEY_INVOICE_REPORT, listInvoice);
		modelAndView.setView(new InvoiceExportReport());
		return modelAndView;
	}

	private Map<String, String> initMapProductInStock() {
		List<ProductInStock> listProductInStockService = productInStockService.findAll(null, null);
		Map<String, String> mapProduct = new HashMap<>();
		for (ProductInStock productInStock : listProductInStockService) {
			mapProduct.put(String.valueOf(productInStock.getProductInfo().getId()),
					productInStock.getProductInfo().getName());
		}
		return mapProduct;
	}
}
