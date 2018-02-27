package com.galaxy.mrjones.stock.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import com.galaxy.mrjones.stock.model.StockQuote;
import com.galaxy.mrjones.stock.model.StockSymbol;

public interface StockSymbolRepository extends CrudRepository<StockSymbol, Long> {

	//public List<StockSymbol> findAllSymbols();

	// List<Customer> findByDate(Date date);

	// custom query example and return a stream
	// @Query("select c from Customer c where c.email = :email")
	// Stream<Customer> findByEmailReturnStream(@Param("email") String email);

}