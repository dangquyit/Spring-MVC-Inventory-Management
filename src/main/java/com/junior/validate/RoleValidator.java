package com.junior.validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.junior.entity.Role;
import com.junior.service.RoleService;

@Component
public class RoleValidator implements Validator {
	@Autowired
	RoleService roleService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == Role.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Role role = (Role) target;
		ValidationUtils.rejectIfEmpty(errors, "roleName", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "description", "msg.required");
		if(role.getRoleName() != null) {
			List<Role>	listRole = roleService.findByProperty("roleName", role.getRoleName());
			if(listRole != null && !listRole.isEmpty()) {
				if(role.getId() != 0) {
					if(role.getId() != listRole.iterator().next().getId()) {
						errors.rejectValue("roleName", "msg.rolename.exist");
					}
				} else {
					errors.rejectValue("roleName", "msg.rolename.exist");
				}
			}
		}
	}

}
