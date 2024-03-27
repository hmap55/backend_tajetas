package com.apiTarjeta.entities;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "CARDS")
@Entity
public class Card {
	
	@Id
	private BigInteger pan;
	
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "valid_number")
	private Integer validNumber;
	
	@Column(name = "card_state")
	private String cardState;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy="card")
	private List<Transaction> transactions;
	
	public Card() {}
	
	
	public Card(BigInteger pan, String cardType, String cardState, Client client) {
		this.pan = pan;
		this.cardType = cardType;
		this.cardState = cardState;
		this.setClient(client);
		this.getValidationNumber();
	}

	public BigInteger getPan() {
		return pan;
	}

	public void setPan(BigInteger pan) {
		this.pan = pan;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getValidNumber() {
		return validNumber;
	}

	public String getCardState() {
		return cardState;
	}

	public void setCardState(String cardState) {
		this.cardState = cardState;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	public void getValidationNumber() {
		
		Integer validationNumber = (int) ((Math.random() * 100) + 1);
		this.validNumber = validationNumber;
		
	}
	
	public String getPanEnmascarado(BigInteger pan) {
		String panString = pan.toString();
		String[] characters = new String[panString.length() - 10];
		Arrays.fill(characters, "*");
		return panString.substring(0, 6) + String.join("", characters) + panString.substring(panString.length() - 4);
	}


}
