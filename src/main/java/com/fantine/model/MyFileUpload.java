package com.fantine.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MyFileUpload {
	
	private List<MultipartFile> myFiles;

	public List<MultipartFile> getMyFiles() {
		return myFiles;
	}

	public void setMyFiles(List<MultipartFile> myFiles) {
		this.myFiles = myFiles;
	}
	
	
	
	
	

}
