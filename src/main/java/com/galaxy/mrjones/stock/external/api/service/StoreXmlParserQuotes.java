package com.galaxy.mrjones.stock.external.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etrade.etws.market.QuoteData;
import com.galaxy.mrjones.stock.base.AbstractBase;
import com.galaxy.mrjones.stock.model.StockQuote;
import com.galaxy.mrjones.stock.repository.IStockDAO;
import com.galaxy.mrjones.stock.repository.StockQuoteRepository;
import com.galaxy.mrjones.stock.repository.StockSymbolRepository;

@Component
public class StoreXmlParserQuotes extends AbstractBase{

	//@Autowired
	//private IStockDAO stockDAO;
	
	@Autowired
	private StockQuoteRepository stockQuoteRepository;
	List<StockQuote> list = new ArrayList<StockQuote>();
	
	public void viewParseQuotes(List<QuoteData> quoteData){
			System.out.println("quoteData.size()......." + quoteData.size());
		for (int i = 0; i < quoteData.size(); i++) {
				
				System.out.println("Calling  DAO.......");
				//stockDAO.addStock(new StockQuote(quoteData.get(i).getProduct().getSymbol(),quoteData.get(i).getAll().getCompanyName(),quoteData.get(i).getAll().getOpen(),quoteData.get(i).getAll().getChgClosePrcn(),quoteData.get(i).getAll().getHigh(),quoteData.get(i).getAll().getLow(),quoteData.get(i).getAll().getPrevClose(),quoteData.get(i).getAll().getTodayClose()));
				stockQuoteRepository.save(new StockQuote(quoteData.get(i).getProduct().getSymbol(),quoteData.get(i).getAll().getCompanyName(),quoteData.get(i).getAll().getOpen(),quoteData.get(i).getAll().getChgClosePrcn(),quoteData.get(i).getAll().getHigh(),quoteData.get(i).getAll().getLow(),quoteData.get(i).getAll().getPrevClose(),quoteData.get(i).getAll().getTodayClose()));
		}
	}

	
	public List<StockQuote> getStockQuote() {
		 for (StockQuote stockQuote : stockQuoteRepository.findAll()) {
	            System.out.println("THIS IS DILIP PRINTING "+stockQuote);
	            
				list.add(stockQuote);
		  }
		 return list;
	}
	
}