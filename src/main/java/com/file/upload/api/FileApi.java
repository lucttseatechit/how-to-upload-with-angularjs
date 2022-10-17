package com.file.upload.api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.file.upload.entity.File;
import com.file.upload.entity.dto.FileRequest;
import com.file.upload.repository.IFileRepository;

@RestController

public class FileApi {
	@Autowired
	private IFileRepository repository;
	
	@PostMapping("/api/file")
	public ResponseEntity<?> add(@ModelAttribute FileRequest request) throws IllegalStateException, IOException{
		File filesss=new File();
		filesss.setName(request.getDes());
		if (!request.getFile().isEmpty()) {
			String fileName = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
			java.io.File file  = new java.io.File(
					new java.io.File("src\\main\\resources\\static\\imgUpload").getAbsolutePath() + "/" + fileName);
			if (!file.exists()) {
				file.mkdirs();
			}
			request.getFile().transferTo(file);
			filesss.setValue(fileName);
		}
		this.repository.save(filesss);
		return ResponseEntity.ok("ok");
	}
}
