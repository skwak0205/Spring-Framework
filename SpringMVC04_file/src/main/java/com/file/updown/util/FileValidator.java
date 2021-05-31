package com.file.updown.util;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// validator 사용 가능 여부 확인
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UploadFile file = (UploadFile)target;
		
		// 업로드할 파일이 없을 시 에러
		if(file.getMpfile().getSize() == 0) {
			// field에 대한 errorCode를 리턴 / errorCode 없으면 default message 전달
			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
		}
	}
}
