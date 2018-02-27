package com.galaxy.mrjones.stock.repository;

import com.galaxy.mrjones.stock.model.StockQuote;

public interface IStockDAO {

	void addStock(StockQuote stockQuote);
}