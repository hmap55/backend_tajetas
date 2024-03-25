package com.apiTarjeta.service;

import com.apiTarjeta.dtos.CreateCardRequest;
import com.apiTarjeta.dtos.CreateCardResponse;

public interface CardService {
	
	public CreateCardResponse createCard(CreateCardRequest request);

}
