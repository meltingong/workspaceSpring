package com.itwill.ilhajob.corp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.CorpImageDto;
import com.itwill.ilhajob.corp.service.CorpImageService;
import com.itwill.ilhajob.corp.service.CorpService;

@Controller
public class CorpImageController {

	@Autowired
	private CorpService corpService;
	@Autowired
	private CorpImageService corpImageService;
	
	@ResponseBody
	@PostMapping(value = "/image-upload-ajax")
	public String imageUploadAjax(@RequestParam("images") List<MultipartFile> images, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("sCorpId", 1L); //임시로 아이디 로그인상태
		Long sCorpId =(Long)request.getSession().getAttribute("sCorpId");
		CorpDto corp=corpService.findByCorpId(sCorpId);
		
		String absolutePath="c://final-project-team1-ilhajob//"+corp.getCorpName()+"//";
		File folder = new File(absolutePath);
		if(!folder.exists()) {
			folder.mkdir();
			System.out.println("폴더가 생성되었습니다");
		}else {
			System.out.println("이미 폴더가 존재합니다");
		}
		
		// MultipartFile 배열로 받은 파일을 처리하는 로직
	    for (MultipartFile image : images) {
	        if (!image.isEmpty()) {
	            String fileName = image.getOriginalFilename();
	            // 파일 저장 로직
	            try {
	                byte[] bytes = image.getBytes();
	                Path path = Paths.get(absolutePath + fileName);
	                Files.write(path, bytes);
	                //corpImage create
	                CorpImageDto corpImageDto = CorpImageDto.builder()
	                										.originalFileName(fileName)
	                										.storedFileName(absolutePath + fileName)
	                										.corp(corp)
	                										.build();
	                corpImageService.insertCorpImage(corpImageDto);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		return "success";
	}
}
