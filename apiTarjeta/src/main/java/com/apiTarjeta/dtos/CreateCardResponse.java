package com.apiTarjeta.dtos;

public class CreateCardResponse {
	
	private String responseCode;
	
	private String message;
	
	private Integer validationNumber;
	
	private String panCod;
	
	

	public CreateCardResponse(String responseCode, String message, Integer validationNumber, String panCod) {
		super();
		this.responseCode = responseCode;
		this.message = message;
		this.validationNumber = validationNumber;
		this.panCod = panCod;
	}

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
