package com.junior.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

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
import com.junior.model.Paging;
import com.junior.service.CategoryService;
import com.junior.util.Constant;
import com.junior.validate.CategoryValidator;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryValidator categoryValidator;

	private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		System.out.println("Init Binder in Category");
		if (dataBinder.getTarget() == null) {
			return;
		}
		// Custom lai date va chap nhan gia tri null cua timestamp
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dataBinder.registerCustomEditor(Timestamp.class, new CustomDateEditor(sdf, true));
		if (dataBinder.getTarget().getClass() == Category.class) {
			dataBinder.setValidator(categoryValidator);
		}
	}

	@RequestMapping(value = { "/category/list", "/category/list/" })
	public String redirect() {
		return "redirect:/category/list/1";
	}

	@RequestMapping("/category/list/{page}")
	public String showCategoryList(Model model, HttpSession session, @ModelAttribute("searchForm") Category category,
			@PathVariable(name = "page") int page) {
		Paging paging = new Paging(3);
		model.addAttribute("pageInfo", paging);
		paging.setIndexPage(page);
		List<Category> listCategory = categoryService.findAll(category, paging);
		if (session.getAttribute(Constant.MSG_SUCCESS) != null) {
			model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
			session.removeAttribute(Constant.MSG_SUCCESS);
		}
		if (session.getAttribute(Constant.MSG_ERROR) != null) {
			model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
			session.removeAttribute(Constant.MSG_ERROR);
		}
		model.addAttribute("listCategory", listCategory);
		return "category-list";
	}

	@GetMapping("/category/add")
	public String addCategory(Model model) {
		model.addAttribute("modelForm", new Category());
		model.addAttribute("titlePage", "Add Category");
		model.addAttribute("viewOnly", false);
		return "category-action";
	}

	@GetMapping("/category/edit/{id}")
	public String editCategory(@PathVariable(name = "id", required = true) int id, Model model) {
		Category category = categoryService.findById(id);
		if (category != null) {
			model.addAttribute("titlePage", "Edit Category");
			model.addAttribute("modelForm", category);
			model.addAttribute("viewOnly", false);
			return "category-action";
		}
		return "redirect:/category/list";
	}

	@GetMapping("/category/view/{id}")
	public String viewCategory(@PathVariable(name = "id", required = true) int id, Model model) {
		Category category = categoryService.findById(id);
		if (category != null) {
			model.addAttribute("titlePage", "View Category");
			model.addAttribute("modelForm", category);
			model.addAttribute("viewOnly", true);
			return "category-action";
		}
		return "redirect:/category/list";
	}

	@PostMapping("/category/save")
	public String saveCategory(Model model, @ModelAttribute("modelForm") @Validated Category category,
			BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			if (category.getId() != 0) {
				model.addAttribute("titlePage", "Edit Category");
			} else {
				model.addAttribute("titlePage", "Add Category");
			}
			model.addAttribute("modelForm", category);
			model.addAttribute("viewOnly", false);
			return "category-action";
		}
		if (category.getId() != 0) {
			LOGGER.info("Update category");
			try {
				categoryService.update(category);
				session.setAttribute(Constant.MSG_SUCCESS, "Update success !!!");

			} catch (Exception e) {
				session.setAttribute(Constant.MSG_ERROR, "Update has error !!!");
				e.printStackTrace();
			}
			model.addAttribute("message", "Update success !!!");
		} else {
			LOGGER.info("Save category");
			try {
				categoryService.save(category);
				session.setAttribute(Constant.MSG_SUCCESS, "Insert success !!!");
			} catch (Exception e) {
				session.setAttribute(Constant.MSG_ERROR, "Insert has error !!!");
				e.printStackTrace();
			}
		}
		return "redirect:/category/list";
	}

	@GetMapping("/category/delete/{id}")
	public String deleteCategory(@PathVariable(name = "id", required = true) int id, HttpSession session) {
		Category category = categoryService.findById(id);
		LOGGER.info("Delete category");
		if (category != null) {
			try {
				categoryService.delete(category);
				session.setAttribute(Constant.MSG_SUCCESS, "Delete success !!!");
			} catch (Exception e) {
				session.setAttribute(Constant.MSG_ERROR, "Delete has error !!!");
				e.printStackTrace();
			}
		}
		return "redirect:/category/list";
	}
}
