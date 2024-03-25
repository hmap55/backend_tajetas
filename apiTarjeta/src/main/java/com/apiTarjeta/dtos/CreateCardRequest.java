package com.apiTarjeta.dtos;

import java.math.BigInteger;

public class CreateCardRequest {
	
	private BigInteger pan;
	
	private String clientName;
	
	private String clientLastName;
	
	private Long client_id;
	
	private String tipo;
	
	private Long phone;

	public BigInteger getPan() {
		return pan;
	}

	public void setPan(BigInteger pan) {
		this.pan = pan;
	}

	

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	

}
