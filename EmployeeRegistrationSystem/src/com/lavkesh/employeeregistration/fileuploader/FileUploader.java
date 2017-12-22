/**
 * 
 */
package com.lavkesh.employeeregistration.fileuploader;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {
	
	private String firstName;
	
	private String contact;
	
	private String experience;
	
	private MultipartFile multipartfile;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public MultipartFile getMultipartfile() {
		return multipartfile;
	}

	public void setMultipartfile(MultipartFile multipartfile) {
		this.multipartfile = multipartfile;
	}
	
	/**
	 * @return multipartfile
	 */
	public MultipartFile getFile() {
		return multipartfile;
	}

	/**
	 * @param file
	 */
	public void setFile(MultipartFile file) {
		this.multipartfile = file;
	}
}
