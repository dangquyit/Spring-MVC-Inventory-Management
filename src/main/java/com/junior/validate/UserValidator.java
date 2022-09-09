package com.junior.validate;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.junior.entity.User;
import com.junior.service.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == User.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "userName", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "password", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "name", "msg.required");

		if (user.getEmail() != null && !user.getEmail().isEmpty()) {
			if(!validateEmail(user.getEmail())) {
				errors.rejectValue("email", "msg.email.not.email");
			}
			List<User> listUserByEmail = userService.findByProperty("email", user.getEmail());
			if (listUserByEmail != null && !listUserByEmail.isEmpty()) {
				if (user.getId() != 0) {
					if (listUserByEmail.iterator().next().getId() != user.getId()) {
						errors.rejectValue("email", "msg.email.exist");
					}
				} else {
					errors.rejectValue("email", "msg.email.exist");
				}

			}
		}

		if (user.getUserName() != null && !user.getUserName().isEmpty()) {
			List<User> listUserByUserName = userService.findByProperty("userName", user.getUserName());
			if (listUserByUserName != null && !listUserByUserName.isEmpty()) {
				if (user.getId() != 0) {
					if (listUserByUserName.iterator().next().getId() != user.getId()) {
						errors.rejectValue("userName", "msg.username.exist");
					}
				} else {
					errors.rejectValue("userName", "msg.username.exist");
				}

			}
		}
	}

	private Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	private boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
