package com.galaxy.mrjones.stock.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.mrjones.stock.model.StockQuote;

@Transactional
@Repository
public class StockDAO implements IStockDAO {

	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public void addStock(StockQuote stockQuote) {

		System.out.println("Calling  ENTITY Manager to Persist.......");
		entityManager.persist(stockQuote);
		System.out.println("Persist done.......");
	}
}
