package com.apiTarjeta.service.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTarjeta.dtos.CreateCardRequest;
import com.apiTarjeta.dtos.CreateCardResponse;
import com.apiTarjeta.entities.Card;
import com.apiTarjeta.entities.Client;
import com.apiTarjeta.enums.CardStatesEnum;
import com.apiTarjeta.enums.CodCardResponseEnum;
import com.apiTarjeta.repository.ClientRepository;
import com.apiTarjeta.service.CardService;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private ClientRepository clientRepository;


	@Override
	public CreateCardResponse createCard(CreateCardRequest request) {
		
		Client client = this.validateNewClient(request);

		CreateCardResponse response;

		if (this.validateRequest(request)) {
			Card card = new Card(request.getPan(), request.getTipo(),
					new String(CardStatesEnum.CREATED.getDescription()), client);
			client.addCard(card);
			clientRepository.save(client);
			response = new CreateCardResponse(CodCardResponseEnum.EXITO.getCode(),
					CodCardResponseEnum.EXITO.getDescription(), card.getValidNumber(),
					card.getPanEnmascarado(request.getPan()));
		}else {
			response = new CreateCardResponse(CodCardResponseEnum.FALLIDO.getCode(),
					CodCardResponseEnum.FALLIDO.getDescription(), 0,
					StringUtils.leftPad("", 16, "*"));
			
		}

		return response;

	}

	public Boolean validateRequest(CreateCardRequest request) {
		Integer panLength = request.getPan().toString().length();
		Integer phoneLength = request.getPhone().toString().length();
		if (panLength < 16 || panLength > 19)
			return false;
		if (phoneLength != 10)
			return false;

		return true;
	}

	public Client validateNewClient(CreateCardRequest request) {
		
		Optional<Client> clientValidate= clientRepository.findById(request.getClient_id());

		if (!clientValidate.isPresent()) {
			return clientValidate.get();
		}else {
			return new Client(request.getClient_id(), request.getClientName(), request.getClientLastName(),
					request.getPhone());
		}
	}

}
