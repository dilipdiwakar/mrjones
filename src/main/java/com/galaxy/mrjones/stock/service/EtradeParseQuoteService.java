package com.galaxy.mrjones.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etrade.etws.market.QuoteData;
import com.galaxy.mrjones.stock.external.api.service.StoreXmlParserQuotes;
import com.galaxy.mrjones.stock.model.StockQuote;
import com.galaxy.mrjones.stock.model.StockSymbol;
import com.galaxy.mrjones.stock.repository.StockQuoteRepository;

@Component
public class EtradeParseQuoteService {
	
	@Autowired
	StoreXmlParserQuotes parsequotes;
	
	@Autowired
	StockQuoteRepository stockQuoteRepository;
	
	
	public void saveStockQuote(List<QuoteData> stockList) {
		parsequotes.viewParseQuotes(stockList);
		
	}
	
	public List<StockQuote> getStockQuote() {
		//return (List<StockQuote>) stockQuoteRepository.findAll();
		return parsequotes.getStockQuote();
		
	}
}
