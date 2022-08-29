package com.junior.validate;

import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.junior.entity.ProductInfo;
import com.junior.service.ProductInfoService;

@Component
public class ProductInfoValidator implements Validator {
	@Autowired
	private ProductInfoService productInfoService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == ProductInfo.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductInfo productInfo = (ProductInfo) target;
		ValidationUtils.rejectIfEmpty(errors, "code", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "name", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "description", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "multipartFile", "msg.required");
		if (productInfo.getCode() != null) {
			List<ProductInfo> listProductInfo = productInfoService.findByProperty("code", productInfo.getCode().trim());
			if (!listProductInfo.isEmpty() && listProductInfo != null) {
				if (productInfo.getId() != 0) {
					if (productInfo.getId() != listProductInfo.iterator().next().getId()) {
						errors.rejectValue("code", "msg.code.exist");
					}
				} else {
					errors.rejectValue("code", "msg.code.exist");
				}
			}

		}
		if (productInfo.getMultipartFile() != null) {
			String extension = FilenameUtils.getExtension(productInfo.getMultipartFile().getOriginalFilename());
			System.out.println("Extension: " + extension);
			if (!extension.equals("jpg") || !extension.equals("png")) {
				errors.rejectValue("multipartFile", "msg.file.extension.error");
			}
		}
	}
}
