package com.junior.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junior.entity.Auth;
import com.junior.entity.Menu;
import com.junior.entity.Role;
import com.junior.model.AuthForm;
import com.junior.model.Paging;
import com.junior.service.MenuService;
import com.junior.service.RoleService;
import com.junior.util.Constant;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = { "/menu/list/", "/menu/list" })
	public String redirect() {
		return "redirect:/menu/list/1";
	}

	@RequestMapping("/menu/list/{page}")
	public String showList(Model model, @PathVariable("page") int page, @ModelAttribute("searchForm") Menu menu,
			HttpSession session) {
		Paging paging = new Paging(15);
		paging.setIndexPage(page);
		model.addAttribute("pageInfo", paging);
		List<Menu> listMenu = menuService.findAll(menu, paging);
		List<Role> listRole = roleService.findAll(null, null);
		Collections.sort(listRole, (o1, o2) -> o1.getId() - o2.getId());
		for (Menu item : listMenu) {
			// MapAuth(roleid, permission)
			Map<Integer, Integer> mapAuth = new TreeMap<Integer, Integer>();
			for (Role role : listRole) {
				mapAuth.put(role.getId(), 0);
			}
			List<Auth> listAuth = item.getAuths();
			for (Auth auth : listAuth) {
				mapAuth.put(auth.getRole().getId(), auth.getPermisstion());
			}
			item.setMapAuth(mapAuth);
		}

		if (session.getAttribute(Constant.MSG_SUCCESS) != null) {
			model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
			session.removeAttribute(Constant.MSG_SUCCESS);
		}
		if (session.getAttribute(Constant.MSG_ERROR) != null) {
			model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
			session.removeAttribute(Constant.MSG_ERROR);
		}
		
		model.addAttribute("listMenu", listMenu);
		model.addAttribute("listRole", listRole);
		return "menu-list";
	}

	@RequestMapping("/menu/change-status/{id}")
	public String menuChangeStatus(Model model, @PathVariable("id") int id, HttpSession session) {
		try {
			menuService.changeStatus(id);
			session.setAttribute(Constant.MSG_SUCCESS, "Change status success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Change status has error!!!");
		}
		return "redirect:/menu/list";
	}
	
	@RequestMapping("/menu/permission")
	public String menuPermission(Model model) {
		List<Role> listRole = roleService.findAll(null, null);
		List<Menu> listMenu = menuService.findAll(null, null);
		Map<Integer, String> mapRole = new HashMap<>();
		for(Role role : listRole) {
			mapRole.put(role.getId(), role.getRoleName());
		}
		Map<Integer, String> mapMenu = new HashMap<>();
		for(Menu menu : listMenu) {
			mapMenu.put(menu.getId(), menu.getUrl());
		}
		model.addAttribute("mapRole", mapRole);
		model.addAttribute("mapMenu", mapMenu);
		model.addAttribute("modelForm", new AuthForm());
		model.addAttribute("titlePage", "Update Permission");
		return "menu-permission";
	}
	
	@RequestMapping("/menu/update-permission")
	public String menuUpdatePermission(@ModelAttribute("modelForm") AuthForm authForm, HttpSession session) {
		try {
			menuService.updatePermission(authForm.getMenuId(), authForm.getRoleId(), authForm.getPermission());
			session.setAttribute(Constant.MSG_SUCCESS, "Update permission success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Update permission has error!!!");
		}
		return "redirect:/menu/list";
	}
}
