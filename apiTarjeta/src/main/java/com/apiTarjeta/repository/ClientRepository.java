package com.apiTarjeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiTarjeta.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
