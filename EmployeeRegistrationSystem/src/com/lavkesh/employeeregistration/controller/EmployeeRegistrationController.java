/**
 *
 */
package com.lavkesh.employeeregistration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lavkesh.employeeregistration.fileuploader.FileUploader;
import com.lavkesh.employeeregistration.validator.FileUploadValidator;

/**
 * This is the controller class which gets inputs from jsp and send back the
 * response to jsp
 */
@Controller
public class EmployeeRegistrationController {
	
	@Autowired
	private FileUploadValidator fileUploadValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(fileUploadValidator);
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public ModelAndView goToRegistration() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fileupload");
		
		FileUploader fileUploader = new FileUploader();
		mv.addObject("command", fileUploader);
		
		return mv;
	}
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public String uploadResume(@Valid @ModelAttribute("command") FileUploader fileUploader, BindingResult errors, Model model) {
		boolean hasErrors = errors.hasErrors();
		if(hasErrors) {
			return "fileupload";
		}
		
		MultipartFile multipartfile = fileUploader.getMultipartfile();
		if(multipartfile.isEmpty()) {
			return "error";
		}
		
		String originalFilename = multipartfile.getOriginalFilename();
		model.addAttribute("fileName", originalFilename);
		return "success";
	}

}