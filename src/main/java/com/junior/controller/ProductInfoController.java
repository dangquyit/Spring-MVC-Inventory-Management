package com.junior.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

import com.junior.entity.Category;
import com.junior.entity.ProductInfo;
import com.junior.model.Paging;
import com.junior.service.CategoryService;
import com.junior.service.ProductInfoService;
import com.junior.util.Constant;
import com.junior.validate.ProductInfoValidator;

@Controller
public class ProductInfoController {
	@Autowired
	private ProductInfoService productInfoService;

	@Autowired
	private ProductInfoValidator productInfoValidator;

	@Autowired
	private CategoryService categoryService;

	private static final Logger LOGGER = Logger.getLogger(ProductInfoController.class);

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		if (dataBinder.getTarget() == null) {
			return;
		}
		// Custom lai date va chap nhan gia tri null cua timestamp
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dataBinder.registerCustomEditor(Timestamp.class, new CustomDateEditor(sdf, true));
		if (dataBinder.getTarget().getClass() == ProductInfo.class) {
			dataBinder.setValidator(productInfoValidator);
		}
	}

	@RequestMapping(value = { "/product-info/list", "/product-info/list/" })
	public String redirect() {
		return "redirect:/product-info/list/1";
	}

	@RequestMapping("/product-info/list/{page}")
	public String showProductInfoList(Model model, HttpSession session,
			@ModelAttribute("searchForm") ProductInfo productInfo, @PathVariable(name = "page") int page) {
		Paging paging = new Paging(2);
		model.addAttribute("pageInfo", paging);
		paging.setIndexPage(page);
		List<ProductInfo> listProductInfo = productInfoService.findAll(productInfo, paging);
		if (session.getAttribute(Constant.MSG_SUCCESS) != null) {
			model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
			session.removeAttribute(Constant.MSG_SUCCESS);
		}
		if (session.getAttribute(Constant.MSG_ERROR) != null) {
			model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
			session.removeAttribute(Constant.MSG_ERROR);
		}
		model.addAttribute("listProductInfo", listProductInfo);
		return "productInfo-list";
	}

	@GetMapping("/product-info/add")
	public String addProductInfo(Model model) {
		LOGGER.info("Product Info controller add");
		model.addAttribute("modelForm", new ProductInfo());
		model.addAttribute("titlePage", "Add product info");
		model.addAttribute("viewOnly", false);

		List<Category> listCategory = categoryService.findAll(null, null);
		Map<String, String> mapCategory = new HashMap<>();
		if(!listCategory.isEmpty()) {
			for (Category category : listCategory) {
				mapCategory.put(String.valueOf(category.getId()), category.getName());
			}
		}
		model.addAttribute("mapCategory", mapCategory);

		return "productInfo-action";
	}

	@GetMapping("/product-info/edit/{id}")
	public String editProductInfo(@PathVariable(name = "id", required = true) int id, Model model) {
		ProductInfo productInfo = productInfoService.findById(id);
		if (productInfo != null) {
			productInfo.setCateId(productInfo.getCategory().getId());
			model.addAttribute("titlePage", "Edit Product Info");
			model.addAttribute("modelForm", productInfo);
			model.addAttribute("viewOnly", false);
			List<Category> listCategory = categoryService.findAll(null, null);
			Map<String, String> mapCategory = new HashMap<>();
			for (Category category : listCategory) {
				mapCategory.put(String.valueOf(category.getId()), category.getName());
			}
			model.addAttribute("mapCategory", mapCategory);
			return "productInfo-action";
		}
		return "redirect:/product-info/list";
	}

	@GetMapping("/product-info/view/{id}")
	public String viewProductInfo(@PathVariable(name = "id", required = true) int id, Model model) {
		ProductInfo productInfo = productInfoService.findById(id);
		if (productInfo != null) {
			model.addAttribute("titlePage", "View product info");
			model.addAttribute("modelForm", productInfo);
			model.addAttribute("viewOnly", true);
			return "productInfo-action";
		}
		return "redirect:/product-info/list";
	}

	@PostMapping("/product-info/save")
	public String saveProductInfo(Model model, @ModelAttribute("modelForm") @Validated ProductInfo productInfo,
			BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			if (productInfo.getId() != 0) {
				model.addAttribute("titlePage", "Edit product info");
			} else {
				model.addAttribute("titlePage", "Add product info");
			}
			model.addAttribute("modelForm", productInfo);
			model.addAttribute("viewOnly", false);
			List<Category> listCategory = categoryService.findAll(null, null);
			Map<String, String> mapCategory = new HashMap<>();
			for (Category category : listCategory) {
				mapCategory.put(String.valueOf(category.getId()), category.getName());
			}
			model.addAttribute("mapCategory", mapCategory);
			return "productInfo-action";
		}
		Category category = new Category();
		category.setId(productInfo.getCateId());
		productInfo.setCategory(category);
		if (productInfo.getId() != 0) {
			LOGGER.info("Update product info");
			try {
				productInfoService.update(productInfo);
				session.setAttribute(Constant.MSG_SUCCESS, "Update success !!!");
				
			} catch (Exception e) {
				session.setAttribute(Constant.MSG_ERROR, "Update has error !!!");
				e.printStackTrace();
			}
			model.addAttribute("message", "Update success !!!");
		} else {
			LOGGER.info("Save product info");
			try {
				productInfoService.save(productInfo);
				session.setAttribute(Constant.MSG_SUCCESS, "Insert success !!!");
			} catch (Exception e) {
				session.setAttribute(Constant.MSG_ERROR, "Insert has error !!!");
				e.printStackTrace();
			}
		}
		return "redirect:/product-info/list";
	}

	@GetMapping("/product-info/delete/{id}")
	public String deleteProductInfo(@PathVariable(name = "id", required = true) int id, HttpSession session) {
		ProductInfo productInfo = productInfoService.findById(id);
		LOGGER.info("Delete product info");
		if (productInfo != null) {
			try {
				productInfoService.delete(productInfo);
				session.setAttribute(Constant.MSG_SUCCESS, "Delete success !!!");
			} catch (Exception e) {
				session.setAttribute(Constant.MSG_ERROR, "Delete has error !!!");
				e.printStackTrace();
			}
		}
		return "redirect:/product-info/list";
	}
}
