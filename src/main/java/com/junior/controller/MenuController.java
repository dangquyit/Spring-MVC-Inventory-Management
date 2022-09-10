package com.junior.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junior.entity.Auth;
import com.junior.entity.Menu;
import com.junior.entity.Role;
import com.junior.model.Paging;
import com.junior.service.MenuService;
import com.junior.service.RoleService;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = {"/menu/list/", "/menu/list"})
	public String redirect() {
		return "redirect:/menu/list/1";
	}
	
	@RequestMapping("/menu/list/{page}")
	public String showList(Model model, @PathVariable("page") int page, @ModelAttribute("searchForm") Menu menu) {
		Paging paging = new Paging(7);
		paging.setIndexPage(page);
		model.addAttribute("pageInfo", paging);
		List<Menu> listMenu = menuService.findAll(menu, paging);
		List<Role> listRole = roleService.findAll(null, null);
		Collections.sort(listRole, (o1, o2) -> o1.getId() - o2.getId());
		for(Menu item : listMenu) {
			// MapAuth(roleid, permission)
			Map<Integer, Integer> mapAuth = new TreeMap<Integer, Integer>();
			for(Role role : listRole) {
				mapAuth.put(role.getId(), 0);
			}
			List<Auth> listAuth = item.getAuths();
			for(Auth auth : listAuth) {
				mapAuth.put(auth.getRole().getId(), auth.getPremisstion());
			}
			item.setMapAuth(mapAuth);
		}
		model.addAttribute("listMenu", listMenu);
		model.addAttribute("listRole", listRole);
		return "menu-list";
	}
}
