package com.apiTarjeta.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;

@Table(name = "CLIENTS")
@Entity
public class Client {
	
	@Id
	@Column(name="client_id")
	private Long clientId;
	
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	private Long phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Card> cards = new ArrayList<Card>();
	
	public Client() {}
	
	
	public Client(Long clientId, String name, String lastName, Long phone) {
		this.clientId = clientId;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
	}


	public long getClientId() {
		return clientId;
	}


	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	

	public List<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
