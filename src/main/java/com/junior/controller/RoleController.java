package com.junior.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junior.entity.Role;
import com.junior.model.Paging;
import com.junior.service.RoleService;
import com.junior.util.Constant;
import com.junior.validate.RoleValidator;

@Controller
public class RoleController {
	@Autowired
	RoleService roleService;
	@Autowired
	private RoleValidator roleValidator;

	private static final Logger LOGGER = Logger.getLogger(RoleController.class);

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		if (dataBinder.getTarget() == null) {
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		dataBinder.registerCustomEditor(Timestamp.class, new CustomDateEditor(sdf, true));
		if (dataBinder.getTarget().getClass() == Role.class) {
			dataBinder.setValidator(roleValidator);
		}
	}

	@RequestMapping(value = { "/role/list", "/role/list/" })
	public String redirec() {
		return "redirect:/role/list/1";
	}

	@RequestMapping(value = { "/role/list/{page}" })
	public String showListRole(Model model, @PathVariable("page") int page, HttpSession session) {
		Paging paging = new Paging(10);
		paging.setIndexPage(page);
		model.addAttribute("pageInfo", paging);
		if (session.getAttribute(Constant.MSG_SUCCESS) != null) {
			model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
			session.removeAttribute(Constant.MSG_SUCCESS);
		}
		if (session.getAttribute(Constant.MSG_ERROR) != null) {
			model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
			session.removeAttribute(Constant.MSG_ERROR);
		}
		List<Role> listRole = roleService.findAll(null, paging);
		model.addAttribute("listRole", listRole);
		return "role-list";
	}

	@RequestMapping(value = { "/role/view/{id}" })
	public String viewRole(Model model, @PathVariable("id") int id) {
		Role role = roleService.findById(id);
		model.addAttribute("modelForm", role);
		model.addAttribute("viewOnly", true);
		model.addAttribute("titlePage", "View Role");
		return "role-action";
	}

	@PostMapping(value = { "/role/save" })
	public String saveRole(Model model, @ModelAttribute("modelForm") @Validated Role role, BindingResult bindingResult,
			HttpSession session) {
		if (bindingResult.hasErrors()) {
			if (role.getId() != 0) {
				model.addAttribute("titlePage", "Edit Role");
			} else {
				model.addAttribute("titlePage", "Add Role");
			}
			model.addAttribute("modelForm", role);
			model.addAttribute("viewOnly", false);
			return "role-action";
		}
		if (role.getId() != 0) {
			LOGGER.info("Update role");
			try {
				roleService.update(role);
				session.setAttribute(Constant.MSG_SUCCESS, "Update success!!!");
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Update has error!!!");
			}
		} else {
			LOGGER.info("Add role");
			try {
				roleService.save(role);
				session.setAttribute(Constant.MSG_SUCCESS, "Insert success!!!");
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Insert has error!!!");
			}
		}
		return "redirect:/role/list/1";
	}

	@RequestMapping("/role/add")
	public String addRole(Model model) {
		model.addAttribute("modelForm", new Role());
		model.addAttribute("titlePage", "Add Role");
		model.addAttribute("viewOnly", false);
		return "role-action";
	}

	@RequestMapping("/role/edit/{id}")
	public String editRole(Model model, @PathVariable("id") int id) {
		Role role = roleService.findById(id);
		model.addAttribute("modelForm", role);
		model.addAttribute("viewOnly", false);
		model.addAttribute("titlePage", "Edit Role");
		return "role-action";
	}

	@RequestMapping("/role/delete/{id}")
	public String deleteRole(Model model, @PathVariable("id") int id) {
		Role role = roleService.findById(id);
		LOGGER.info("Delete role");
		try {
			roleService.delete(role);
			model.addAttribute(Constant.MSG_SUCCESS, "Delete success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(Constant.MSG_ERROR, "Delete has error!!!");
		}
		return "redirec:/role/list/1";
	}
}
