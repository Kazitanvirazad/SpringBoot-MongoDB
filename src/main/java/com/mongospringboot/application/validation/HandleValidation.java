package com.mongospringboot.application.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mongospringboot.application.util.ResponseObject;

@RestControllerAdvice
public class HandleValidation {
	public ResponseEntity<ResponseObject> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<Map<String, String>> fieldErrorList = new ArrayList<>();
		Map<String, List<Map<String, String>>> errorMap = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			Map<String, String> errors = new HashMap<>();
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put("field_name", fieldName);
			errors.put("field_error_description", errorMessage);
			fieldErrorList.add(errors);
		});

		errorMap.put("fields", fieldErrorList);
		return new ResponseEntity<>(new ResponseObject(true, "Form Field error", errorMap), new HttpHeaders(),
				HttpStatus.BAD_REQUEST);
	}
}
