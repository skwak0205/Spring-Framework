package com.file.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.file.updown.util.FileValidator;
import com.file.updown.util.UploadFile;


@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) { // BindingResult : request에서 담겨져 오는 값들의 타입과 UploadFile 객체의 타입들과 같은지 비교 확인 / 다르면 오류
		//Validation : 파일이 제대로 전달되었는지 확인
		fileValidator.validate(uploadFile, result);
		
		// 에러가 있으면 다시 upload.jsp로 이동
		if(result.hasErrors()) {
			return "upload";
		}
		
		// MultipartFile : multipart 요청에서 넘어오는 업로드된 파일을 메모리나 디스크에 임시 저장
		MultipartFile file = uploadFile.getMpfile();
		String name = file.getOriginalFilename(); // 업로드된 이미지 파일의 이름
		
		// UploadFile 객체 생성하고, 업로드된 이미지 파일 이름과 내용 넣어줌
		UploadFile fileObj = new UploadFile();
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream(); // 이미지 파일을 읽음
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			System.out.println("업로드 될 실제 경로 : " + path);
			
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdirs();
			}
			
			File newFile = new File(path + "/" + name);
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			while((read = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileObj", fileObj);
		
		return "download";
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		byte[] down = null;
		
		String path;
		try {
			path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			File file = new File(path + "/" + name);
			
			// FileCopyUtils : 파일 및 스트림 복사를 위한 간단한 유틸리티 메소드의 집합체
			// copyToByteArray(File in) : File의 내용을 새로운 byte[]로 복사
			down = FileCopyUtils.copyToByteArray(file);
			
			// 8859_1 : 파일명을 깨지지 않게 처리
			// file encoding 설정
			String filename = new String(file.getName().getBytes(), "8859_1");
			
			// Content-Disposition : HTTP Response Body에 오는 컨텐츠의 성향을 알려주는 속성
			// file download 설정
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
			response.setContentLength(down.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return down;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
