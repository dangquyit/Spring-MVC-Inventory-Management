package com.junior.validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.junior.entity.User;
import com.junior.service.UserService;
@Component
public class LoginValidator implements Validator {
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == User.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "password", "msg.required");
		if (!(user.getUserName() == "" || user.getUserName() == null)
				&& !(user.getPassword() == "" || user.getPassword() == null)) {
			List<User> listUser = userService.findByProperty("userName", user.getUserName());
			if (user != null && !listUser.isEmpty()) {
				if (!user.getPassword().equals(listUser.get(0).getPassword())) {
					errors.rejectValue("password", "msg.wrong.password");
				}
			} else {
				errors.rejectValue("userName", "msg.wrong.username");
			}
		}
	}

}
