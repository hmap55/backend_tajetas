package com.apiTarjeta.entities;

import java.math.BigInteger;
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
	private Long validNumber;
	
	@Column(name = "card_state")
	private String cardState;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy="card")
	private List<Transaction> transactions;

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

	public Long getValidNumber() {
		return validNumber;
	}

	public void setValidNumber(Long validNumber) {
		this.validNumber = validNumber;
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
	


}
