package com.junior.validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.junior.entity.Category;
import com.junior.service.CategoryService;

@Component
public class CategoryValidator implements Validator {
	@Autowired
	private CategoryService categoryService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == Category.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Category category = (Category) target;
		ValidationUtils.rejectIfEmpty(errors, "code", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "name", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "description", "msg.required");
		if (category.getCode() != null) {
			List<Category> listCategory = categoryService.findByProperty("code", category.getCode().trim());
			if (!listCategory.isEmpty() && listCategory != null) {
				if (category.getId() != 0) {
					if (category.getId() != listCategory.iterator().next().getId()) {
						errors.rejectValue("code", "msg.code.exist");
					}
				} else {
					errors.rejectValue("code", "msg.code.exist");
				}
			}

		}

	}

}
