package com.galaxy.mrjones.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etrade.etws.market.QuoteData;
import com.galaxy.mrjones.stock.external.api.service.MarketQuote;

@Component
public class EtradeGetStockQuoteService {
	
	@Autowired
	MarketQuote quotes;
	
	public List<QuoteData> getStockQuote() {
		List<QuoteData> quoteData =quotes.getQuotes();
		return quoteData;
	}
}
