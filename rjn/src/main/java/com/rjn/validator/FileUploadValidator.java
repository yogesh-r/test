package com.rjn.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rjn.bean.FileUploadBean;

public class FileUploadValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return FileUploadBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FileUploadBean file = (FileUploadBean)target;
		if(file.getFile().getSize()==0){
			errors.rejectValue("file", "required.fileUpload");
		}
	}
}