package com.welfare.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class RequestOrderReturn extends OrderReturn {
	  private List<MultipartFile> multiUploadFiles;

	public List<MultipartFile> getMultiUploadFiles() {
		return multiUploadFiles;
	}

	public void setMultiUploadFiles(List<MultipartFile> multiUploadFiles) {
		this.multiUploadFiles = multiUploadFiles;
	}
}
