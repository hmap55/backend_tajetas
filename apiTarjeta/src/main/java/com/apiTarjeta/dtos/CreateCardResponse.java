package com.apiTarjeta.dtos;

public class CreateCardResponse {
	
	private String responseCode;
	
	private String message;
	
	private Integer validationNumber;
	
	private String panCod;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getValidationNumber() {
		return validationNumber;
	}

	public void setValidationNumber(Integer validationNumber) {
		this.validationNumber = validationNumber;
	}

	public String getPanCod() {
		return panCod;
	}

	public void setPanCod(String panCod) {
		this.panCod = panCod;
	}
	
	

}
