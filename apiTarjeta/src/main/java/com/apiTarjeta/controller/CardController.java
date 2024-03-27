package com.apiTarjeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiTarjeta.dtos.CreateCardRequest;
import com.apiTarjeta.dtos.CreateCardResponse;
import com.apiTarjeta.service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cardService;

	
	@PostMapping("/create")
	public ResponseEntity<CreateCardResponse> createCard(@RequestBody CreateCardRequest request){
		
		try {
			CreateCardResponse response = cardService.createCard(request);
			return new ResponseEntity<CreateCardResponse>(response, HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
