package com.tekpyramid.hms.data.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ResponseDTO implements Serializable{
	
	private HttpStatus httpStatus;
	private int statusCode;
	
	@JsonIgnore
	private Object reponse;
}
