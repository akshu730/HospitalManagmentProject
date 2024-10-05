package com.ty.hospital_management.hospital_app.response;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	T data;
	String message;
	int value;
}
