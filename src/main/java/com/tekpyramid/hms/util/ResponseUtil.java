package com.tekpyramid.hms.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.ResponseDTO;

public class ResponseUtil {
	
	public static ResponseDTO initReponseDTO() {
		return new ResponseDTO();
	}
	
	public static ResponseEntity<ResponseDTO> getCreateResponse(Object respone) {
		ResponseDTO reponseDto = initReponseDTO();
		reponseDto.setHttpStatus(HttpStatus.CREATED);
		reponseDto.setStatusCode(HttpStatus.CREATED.value());
		reponseDto.setReponse(respone);
		return ResponseEntity.status(reponseDto.getStatusCode()).body(reponseDto);
	}
	
	public static ResponseEntity<ResponseDTO> getOkResponse(Object response) {
        ResponseDTO responseDto = initReponseDTO();
        responseDto.setHttpStatus(HttpStatus.OK);
        responseDto.setStatusCode(HttpStatus.OK.value());
        responseDto.setReponse(response);
        return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
    }

    public static ResponseEntity<ResponseDTO> getBadRequestResponse(Object response) {
        ResponseDTO responseDto = initReponseDTO();
        responseDto.setHttpStatus(HttpStatus.BAD_REQUEST);
        responseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseDto.setReponse(response);
        return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
    }

    public static ResponseEntity<ResponseDTO> getNotFoundResponse(Object response) {
        ResponseDTO responseDto = initReponseDTO();
        responseDto.setHttpStatus(HttpStatus.NOT_FOUND);
        responseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseDto.setReponse(response);
        return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
    }

    public static ResponseEntity<ResponseDTO> getInternalServerErrorResponse(Object response) {
        ResponseDTO responseDto = initReponseDTO();
        responseDto.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        responseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseDto.setReponse(response);
        return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
    }

}
