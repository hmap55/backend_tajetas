package com.apiTarjeta.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiTarjeta.entities.Card;

public interface CardRepository extends JpaRepository<Card, BigInteger> {

}
