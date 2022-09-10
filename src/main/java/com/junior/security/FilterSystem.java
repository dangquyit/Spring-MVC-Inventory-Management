package com.junior.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import com.junior.entity.Auth;
import com.junior.entity.User;
import com.junior.entity.UserRole;
import com.junior.util.Constant;

public class FilterSystem implements HandlerInterceptor {
	public static final Logger LOGGER = Logger.getLogger(FilterSystem.class);

	// Moi url phai di qua ham preHandler truoc roi moi den controller
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.info("Request URL = " + request.getRequestURI());
		User user = (User) request.getSession().getAttribute(Constant.USER_INFO);
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}

		if (user != null) {
			String url = request.getServletPath();
			if (!hasPermission(url, user)) {
				response.sendRedirect(request.getContextPath() + "/access-denied");
				return false;
			}
		}

		return true;
	}

	private boolean hasPermission(String url, User user) {
		if (url.contains("/index") || url.contains("/access-denied") || url.contains("/logout")) {
			return true;
		}
		LOGGER.info("Check url have Permission");
		UserRole userRole = user.getUserRoles().iterator().next();
		List<Auth> listAuth = userRole.getRole().getAuths();
		for (Auth auth : listAuth) {
			if (url.contains(auth.getMenu().getUrl())) {
				return auth.getPermisstion() == 1;
			}
		}
		return false;
	}

}
