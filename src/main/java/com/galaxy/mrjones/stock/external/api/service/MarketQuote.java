package com.galaxy.mrjones.stock.external.api.service;

import java.io.IOException;
import com.etrade.etws.market.DetailFlag;
import com.etrade.etws.market.QuoteData;
import com.etrade.etws.market.QuoteResponse;
import com.etrade.etws.sdk.client.MarketClient;
import com.etrade.etws.sdk.common.ETWSException;
import com.galaxy.mrjones.stock.base.AbstractBase;
import com.galaxy.mrjones.stock.model.StockSymbol;
import com.galaxy.mrjones.stock.repository.StockSymbolRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarketQuote extends AbstractBase{

    @Autowired
    StockSymbolRepository stockSymbolRepository;
    
	public List<QuoteData> getQuotes(){
		QuoteResponse response=null;
		AbstractBase base = AbstractBase.getrequest();	
		ArrayList<String> list = new ArrayList<String>();
		MarketClient quote = new MarketClient(base.request);
		
		  for (StockSymbol stockSymbol : stockSymbolRepository.findAll()) {
	            System.out.println(stockSymbol.getSymbol());
	            list.add(stockSymbol.getSymbol());
		  }

		
		System.out.print("+++++++++++++++++++++++++++++++++++++++++" +list.get(0));

		System.out.print("+++++++++++++++++++++++++++++++++++++++++" +list.get(1));

		System.out.print("+++++++++++++++++++++++++++++++++++++++++" +list.get(2));
		List<QuoteData> quoteData = null;
		try {
			response = quote.getQuote(list, true, DetailFlag.ALL);
			quoteData = response.getQuoteData();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ETWSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quoteData;

	}

}





