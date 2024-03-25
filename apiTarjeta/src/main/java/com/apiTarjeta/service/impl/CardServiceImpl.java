package com.apiTarjeta.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiTarjeta.dtos.CreateCardRequest;
import com.apiTarjeta.dtos.CreateCardResponse;
import com.apiTarjeta.entities.Card;
import com.apiTarjeta.entities.Client;
import com.apiTarjeta.enums.CardStatesEnum;
import com.apiTarjeta.repository.CardRepository;
import com.apiTarjeta.repository.ClientRepository;
import com.apiTarjeta.service.CardService;


@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	

	@Override
	public CreateCardResponse createCard(CreateCardRequest request) {
		
		Optional<Client> client = clientRepository.findById(request.getClient_id());
		
		CreateCardResponse response = new CreateCardResponse();
		
		if (client.isPresent() && this.validateRequest(request)) {
			Card card = new Card(request.getPan(), request.getTipo(), new String(CardStatesEnum.CREATED.getDescription()), client.get());
			cardRepository.save(card);
			
		}else if (!client.isPresent() && this.validateRequest(request)) {
			Client newClient = new Client(request.getClient_id(), request.getClientName(), 
					  					  request.getClientLastName(), request.getPhone());
			clientRepository.saveAndFlush(newClient);
			
			Card card = new Card(request.getPan(), request.getTipo(), new String(CardStatesEnum.CREATED.getDescription()), newClient);
			cardRepository.save(card);
			
		}
		
		return null;
		
		
	}
	
	public Boolean validateRequest(CreateCardRequest request) {
		Integer panLength = request.getPan().toString().length();
		Integer phoneLength = request.getPhone().toString().length();
		if (panLength < 16 || panLength > 19 ) return false;
		if (phoneLength != 10) return false;
		
		return true;
	}

}
