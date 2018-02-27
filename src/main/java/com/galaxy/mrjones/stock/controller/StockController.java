package com.galaxy.mrjones.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.etrade.etws.market.QuoteData;
import com.galaxy.mrjones.stock.model.StockQuote;
import com.galaxy.mrjones.stock.service.EtradeGetAccessTokenService;
import com.galaxy.mrjones.stock.service.EtradeGetAuthService;
import com.galaxy.mrjones.stock.service.EtradeGetRequestTokenService;
import com.galaxy.mrjones.stock.service.EtradeGetStockQuoteService;
import com.galaxy.mrjones.stock.service.EtradeParseQuoteService;

@RestController
@RequestMapping("api/v1/")
public class StockController {

	@Autowired
	EtradeGetRequestTokenService etradeGetRequestTokenService;
	@Autowired
	EtradeGetAuthService etradeGetAuthService;
	@Autowired
	EtradeGetAccessTokenService etradeGetAccessTokenService;
	@Autowired
	EtradeGetStockQuoteService etradeGetStockQuote;
	@Autowired
	EtradeParseQuoteService etradeParseQuoteService;
	List<QuoteData> stockList;
	List<StockQuote> stockQuote;
	
	@RequestMapping(value="stocks" , method =RequestMethod.GET)
	public List<StockQuote> SaveQuoteInfo() {
		
		etradeGetRequestTokenService.getRequestToken();
		etradeGetAuthService.getAuth();
		etradeGetAccessTokenService.getAccessToken();
		stockList = etradeGetStockQuote.getStockQuote();
		System.err.println("$$$$$$$$$$stockList.size $$$$$$$$$$$$$:" + stockList.size());
		etradeParseQuoteService.saveStockQuote(stockList);
		stockQuote = etradeParseQuoteService.getStockQuote();
		System.err.println("stockQuote :" + stockQuote);
		return stockQuote;
	
	}
	
	@RequestMapping(value="hello" , method =RequestMethod.GET)
	public String Hellomethod() {
		return "Helo Dilip!";
	}
	
}
