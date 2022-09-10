package com.junior.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junior.entity.ProductInStock;
import com.junior.model.Paging;
import com.junior.service.ProductInStockService;

@Controller
public class ProductInStockController {
	@Autowired
	ProductInStockService productInStockService;
	
	private static final Logger LOGGER = Logger.getLogger(ProductInStockController.class);
	
	@RequestMapping(value = {"/product-in-stock/list", "/product-in-stock/list/"})
	public String redirect() {
		return "redirect:/product-in-stock/list/1";
	}
	
	@RequestMapping("/product-in-stock/list/{page}")
	public String productInStock(Model model, @PathVariable("page") int page, @ModelAttribute("searchForm") ProductInStock productInStock) {
		LOGGER.info("Show list product in stock");
		Paging paging = new Paging(5);
		paging.setIndexPage(page);
		model.addAttribute("pageInfo", paging);
		List<ProductInStock> listProductInStock = productInStockService.findAll(productInStock, paging);
		model.addAttribute("listProductInStock", listProductInStock);
		return "productInStock-list";
	}
}
