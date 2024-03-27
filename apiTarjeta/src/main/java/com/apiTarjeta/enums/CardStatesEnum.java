package com.apiTarjeta.enums;

public enum CardStatesEnum {
	
	CREATED ("C", 1),
	
	ENROLL ("E", 2);

	private String description;
	
	private Integer code;

	private CardStatesEnum(String description, Integer code) {
		this.description = description;
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	

}
