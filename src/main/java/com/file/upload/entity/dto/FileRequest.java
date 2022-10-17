package com.file.upload.entity.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileRequest {
	private String des;
	private MultipartFile file;
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
