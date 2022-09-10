package com.junior.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.junior.entity.Auth;
import com.junior.entity.Menu;
import com.junior.entity.Role;
import com.junior.entity.User;
import com.junior.entity.UserRole;
import com.junior.service.UserService;
import com.junior.service.impl.UserServiceImpl;
import com.junior.util.Constant;
import com.junior.validate.LoginValidator;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private LoginValidator loginValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		if (binder.getTarget() == null) {
			return;
		}
		if (binder.getTarget().getClass() == User.class) {
			binder.setValidator(loginValidator);
		}
	}

	@GetMapping("/login")
	public String login(Model mode) {
		mode.addAttribute("loginForm", new User());
		return "login/login";
	}

	@PostMapping("/process-login")
	public String processLogin(Model model, @ModelAttribute("loginForm") @Validated User userForm, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "login/login";
		}
		User user = userService.findByProperty("userName", userForm.getUserName()).get(0);
		UserRole userRole = user.getUserRoles().get(0);
		Role role = userRole.getRole();
		List<Auth> listAuth = role.getAuths();
		List<Menu> listParrentMenu = new ArrayList<>();
		List<Menu> listChildMenu = new ArrayList<>();
		for (Auth auth : listAuth) {
			Menu menu = auth.getMenu();
			if (menu.getParentId() == 0 && menu.getOrderIndex() != -1 && menu.getActiveFlag() == 1
					&& auth.getActiveFlag() == 1 && auth.getPermisstion() == 1) {
				menu.setIdMenu(menu.getUrl().replace("/", "") + "Id");
				listParrentMenu.add(menu);
			} else if (menu.getParentId() != 0 && menu.getOrderIndex() != -1 && menu.getActiveFlag() == 1
					&& auth.getActiveFlag() == 1 && auth.getPermisstion() == 1) {
				menu.setIdMenu(menu.getUrl().replace("/", "") + "Id");
				listChildMenu.add(menu);
			}
		}

		for (Menu menuParrent : listParrentMenu) {
			List<Menu> listChild = new ArrayList<>();
			for (Menu menuChild : listChildMenu) {
				if (menuChild.getParentId() == menuParrent.getId()) {
					listChild.add(menuChild);
				}
			}
			if (!listChild.isEmpty()) {
				menuParrent.setChild(listChild);
			}
		}
		sort(listParrentMenu);
		for (Menu menu : listParrentMenu) {
			sort(menu.getChild());
		}
		session.setAttribute(Constant.MENU_SESSION, listParrentMenu);
		session.setAttribute(Constant.USER_INFO, user);
		return "redirect:/index";
	}

	private void sort(List<Menu> list) {
		Collections.sort(list, new Comparator<Menu>() {

			@Override
			public int compare(Menu o1, Menu o2) {
				// TODO Auto-generated method stub
				return o1.getOrderIndex() - o2.getOrderIndex();
			}

		});
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(Constant.USER_INFO);
		session.removeAttribute(Constant.MENU_SESSION);
		return "redirect:/login";
	}
}
