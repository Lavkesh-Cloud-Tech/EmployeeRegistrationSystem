package com.lavkesh.employeeregistration.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lavkesh.employeeregistration.fileuploader.FileUploader;

@Component
public class FileUploadValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return FileUploader.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName", "Employee First Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "required.contact", "Contact Number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experience", "required.experience", "Please enter number of years of experience.");
		
		FileUploader fileUploader = (FileUploader) obj;
		String contact = fileUploader.getContact();
		contact = contact != null ? contact.trim() : "";
		if(!StringUtils.isEmpty(contact) && (contact.length() != 10 || !contact.matches("^[0-9]+$"))) {
			errors.rejectValue("contact", "invalid.contact", "Invalid contact number.");
		}
		
		String experience = fileUploader.getExperience();
		experience = experience != null ? experience.trim() : "";
		if(!StringUtils.isEmpty(experience)) {
			if(!experience.matches("^[0-9]+$") || Integer.valueOf(experience) < 0) {
				errors.rejectValue("experience", "invalid.experience", "Invalid number of years of experience.");
			}
		}		
	}

}
